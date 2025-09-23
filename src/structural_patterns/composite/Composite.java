package structural_patterns.composite;

import java.util.Map;

/*
 * Uma rede de restaurantes deseja modelar seu cardápio digital. O cardápio deve 
 * conter produtos simples (como Hambúrguer, Refrigerante e Sobremesa) e também combos, 
 * que podem agrupar tanto produtos simples quanto outros combos.
 * O restaurante deseja poder calcular o preço total de cada combo ou produto de 
 * forma uniforme, sem precisar diferenciar se é um item simples ou um combo.
*/

public class Composite{
    public static void main(String[] args) {

        // CARDAPIO =====================
            // Lanches
        Item HamburguerDuplo = new Produto("X - Duplo Burger", 32.50);
        Item HotDog = new Produto("Cachorro Quente Especial", 18.90);
        Item PizzaCalabresa = new Produto("Pizza de Calabresa (Grande)", 45.00);

            // Bebidas
        Item SucoLaranja = new Produto("Suco Natural de Laranja (500ml)", 12.00);
        Item Agua = new Produto("Água Mineral (500ml)", 4.50);
        Item Cerveja = new Produto("Cerveja Artesanal (Long Neck)", 15.00);

            // Sobremesas
        Item Pudim = new Produto("Pudim de Leite", 14.90);
        Item Tiramisu = new Produto("Tiramisu", 22.00);
        Item Brownie = new Produto("Brownie com Sorvete", 19.90);


        // COMBOS ========================
        Combo comboMedio = new Combo("Combo Medio")
            .adicionar(PizzaCalabresa)
            .adicionar(SucoLaranja)
            .adicionar(Pudim);

        Combo comboSimples = new Combo("Combo Simples")
            .adicionar(HotDog)
            .adicionar(Agua)
            .adicionar(Brownie);

        Combo megaCombo = new Combo("Mega Combo")
            .adicionar(comboMedio)
            .adicionar(comboSimples)
            .adicionar(HamburguerDuplo)
            .adicionar(Cerveja)
            .adicionar(Tiramisu);

        // PEDIDO =======================

        System.out.println("======== RESUMO DO PEDIDO ========");

        Pedido pedido = new Pedido(
            Map.of(
                "nome", "Alice",
                "email", "alsp@g",
                "sms", "11 98090-8090",
                "whatsapp", "11 98090-8090"
            ),
            megaCombo
        );

        System.out.println(megaCombo.getNome() + "\n" + pedido.getResumo());
    }
}