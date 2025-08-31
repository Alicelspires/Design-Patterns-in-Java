package creational_patterns.builder;

/*
 * Cenário: “Montador de Pizza”
 * Você precisa montar pizzas com vários opcionais (tamanho, massa, molho, borda, sabor). Algumas coisas são
 * obrigatórias, outras opcionais.
 */

public class Builder {
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
