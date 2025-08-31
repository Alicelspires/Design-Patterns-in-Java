package creational_patterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
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
