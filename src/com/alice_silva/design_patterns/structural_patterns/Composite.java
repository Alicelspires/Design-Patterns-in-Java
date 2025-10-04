package com.alice_silva.design_patterns.structural_patterns;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Uma rede de restaurantes deseja modelar seu cardápio digital. O cardápio deve 
 * conter produtos simples (como Hambúrguer, Refrigerante e Sobremesa) e também combos, 
 * que podem agrupar tanto produtos simples quanto outros combos.
 * O restaurante deseja poder calcular o preço total de cada combo ou produto de 
 * forma uniforme, sem precisar diferenciar se é um item simples ou um combo.
*/

// Component ====================

interface Item {
    public String getNome();
    public Double getPreco();
}

// Folha =======================

class Produto implements Item{
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public Double getPreco() {
        return this.preco;
    }
}

// Composite =====================

class Combo implements Item{
    private String nomeCombo;
    private List<Item> combo = new ArrayList<>();

    public Combo(String nomeCombo){
        this.nomeCombo = nomeCombo;
    }

    @Override   
    public String getNome() {
        return this.nomeCombo;
    }

    @Override
    public Double getPreco() {
        return this.combo.stream()
            .mapToDouble(item -> item.getPreco())
            .sum();
    }

    public List<Item> getItens() {
        return this.combo;
    }

    public Combo adicionar(Item item){
        this.combo.add(item);
        return this;
    }

    public String remover(Item itemFind){
        Boolean findItem = this.combo.removeIf(item -> item == itemFind);
        String removedItem = findItem == false ? 
            "Item do combo não encontrado" : 
            "Item removido do combo com sucesso!";
        return removedItem;
    }
}

// Para organização do pedido ==========

class Pedido {
    private Map<String, String> cliente;
    private Combo comboPedido;

    public Pedido(Map<String, String>  cliente, Combo combo){
        this.cliente = cliente;
        this.comboPedido = combo;
    }

    public Double obterTotal(){
        return this.comboPedido.getPreco();
    }

    public String getResumo(){
        String itens = this.comboPedido.getItens().stream()
            .map(item -> String.format("\t - %s (R$ %.2f)", item.getNome(), item.getPreco()))
            .collect(Collectors.joining("\n"));

        return String.format(
            """
            Cliente: %s
            Itens pedidos:
            %s
            Total: R$ %.2f
            """, 
            cliente.get("nome"),
            itens,
            obterTotal()
        );
    }
}

// ======================================
// USING THE PATTERN - COMPOSITE
// ======================================

class Composite{
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