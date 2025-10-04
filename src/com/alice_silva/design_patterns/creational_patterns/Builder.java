package com.alice_silva.design_patterns.creational_patterns;


import java.util.ArrayList;
import java.util.List;

/*
 * Cenário: “Montador de Pizza”
 * Você precisa montar pizzas com vários opcionais (tamanho, massa, molho, borda, sabor). Algumas coisas são
 * obrigatórias, outras opcionais.
 */

class PizzaBuilder {
    protected String tamanho;
    protected String massa;
    protected String molho = "tomate";
    protected List<String> sabor = new ArrayList<>();
    protected boolean bordaRecheada = false;

    public PizzaBuilder addMassa(String tipo) {
        this.massa = tipo;
        return this;
    }
    public PizzaBuilder addTamanho(String tamanho) {
        this.tamanho = tamanho;
        return this;
    }
    public PizzaBuilder addMolho(String molho) { 
        this.molho = molho; 
        return this;
    }
    public PizzaBuilder addSabor(String sabor) { 
        this.sabor.add(sabor);
        return this;
    }
    public PizzaBuilder addBordaRecheada(boolean r) { 
        this.bordaRecheada = r; 
        return this;
    }

    public Pizza build(){ 
        return new Pizza(this); 
    }
}

class Pizza {
    private String tamanho;     
    private String massa;       
    private String molho;          
    private List<String> sabor; 
    private boolean bordaRecheada; 

    public Pizza(PizzaBuilder pizza){
        this.tamanho = pizza.tamanho;
        this.massa = pizza.massa;
        this.molho = pizza.molho;
        this.sabor = new ArrayList<>(pizza.sabor);
        this.bordaRecheada = pizza.bordaRecheada;
    }

    public void showDetails() {
        System.out.println("\n=== Detalhes da Pizza ===");
        System.out.println("Tamanho       : " + this.tamanho);
        System.out.println("Massa         : " + this.massa);
        System.out.println("Molho         : " + this.molho);
        System.out.println("Sabores       : " + this.sabor);
        System.out.println("Borda recheada: " + (this.bordaRecheada ? "Sim" : "Não"));
        System.out.println("==========================\n");
    }
}

// ======================================
// USING THE PATTERN - BUILDER
// ======================================

class Builder {
    public static void main(String[] args) {

        PizzaBuilder p = new PizzaBuilder();

        Pizza pizzaTradicional = p
                .addMolho("tomate rústico")
                .addSabor("mussarela")
                .addSabor("manjericao")
                .addTamanho("grande")
                .addBordaRecheada(true)
                .addMassa("fina")
                .build();

        pizzaTradicional.showDetails();
    }
}
