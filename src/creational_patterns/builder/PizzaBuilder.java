package creational_patterns.builder;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
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
