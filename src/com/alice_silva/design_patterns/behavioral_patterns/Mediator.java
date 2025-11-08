package com.alice_silva.design_patterns.behavioral_patterns;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Implementar o  padrão Mediator simulando o funcionamento de uma pizzaria.
 * Nenhum componente (Garçom, Cozinha, Forno, Caixa e Entrega) pode se comunicar 
 * diretamente.
 * 
 * Toda comunicação deve passar pela classe PizzariaCentral, que atuará como o mediator.
 * A PizzariaCentral deve: receber pedidos do garçom, gerenciar a fila de operações, 
 * dar prioridade a pedidos marcados como urgentes, encaminhar cada etapa do pedido 
 * ao próximo componente (Cozinha → Forno → Caixa → Entrega), garantir que apenas uma 
 * etapa seja processada por vez.
 * 
 * Cada componente: envia eventos apenas para a PizzariaCentral, nunca chama métodos de outro componente diretamente.
 * 
 * Demonstre o funcionamento criando três pedidos, incluindo um pedido urgente que deve furar a fila.
 */

interface PizzaMediator {
    void registrar(Componente componente);
    void receberPedido(Pedido pedido);
    void processarPedidos();
    void enviarMensagem(String mensagem);
}

class PizzariaCentral implements PizzaMediator{
    private List<Componente> componentes = new LinkedList<>();
    private Queue<Pedido> filaPedidos = new PriorityQueue<>(
        Comparator
            .comparing((Pedido p) -> p.isUrgente())
            .reversed()
    );

    @Override
    public void registrar(Componente componente) {
        componentes.add(componente);
        componente.setMediator(this);
    }

    @Override
    public void receberPedido(Pedido pedido) {
        filaPedidos.add(pedido);
        enviarMensagem("Novo pedido recebido: " + pedido);
    }

    // processar pedidos por ordem de prioridade
    @Override
    public void processarPedidos(){
        while (!filaPedidos.isEmpty()) {
            Pedido pedidoAtual = filaPedidos.poll();
            System.out.println("\n");
            enviarMensagem("Iniciando processamento de " + pedidoAtual);

            // simula cada etapa
            processarEtapa("Garçom", "Pedido anotado para " + pedidoAtual.getCliente());
            processarEtapa("Cozinha", "Preparando a pizza...");
            processarEtapa("Forno", "Assando a pizza...");
            processarEtapa("Caixa", "Registrando pagamento...");
            processarEtapa("Entrega", "Enviando pedido para o cliente...");

            enviarMensagem("Pedido finalizado: " + pedidoAtual);
            System.out.println("------------------------------------");
        }
    }

    private void processarEtapa(String componente, String mensagem) {
        enviarMensagem("[" + componente + "] " + mensagem);
    }

    @Override
    public void enviarMensagem(String msg){
        System.out.printf("[Central] %s\n", msg);
    }

}

// Componente abstrato =========================================
class Componente {
    protected PizzariaCentral mediator;
    private String nome;

    public Componente(String nome) {
        this.nome = nome;
    }

    public void setMediator(PizzariaCentral mediator) {
        this.mediator = mediator;
    }

    public String getNome() {
        return nome;
    }
}

// Componentes (Garçom, Cozinha, Forno, Caixa e Entrega)=========

class Garcom extends Componente{
    public Garcom() {
        super("garcom");
    }

    public void criarPedido(String cliente, boolean urgente) {
        Pedido pedido = new Pedido(cliente, urgente);
        mediator.receberPedido(pedido);
    }
}
class Cozinha extends Componente{
    public Cozinha() {
        super("cozinha");
    }
}
class Forno extends Componente{
    public Forno() {
        super("forno");
    }
}
class Caixa extends Componente{
    public Caixa() {
        super("caixa");
    }
}
class Entrega extends Componente{
    public Entrega() {
        super("entrega");
    }
}


// Classe Pedido ==============================================

class Pedido {
    private static int contador = 1;
    private int codigo;
    private String cliente;
    private boolean urgente;

    public Pedido(String cliente, boolean urgente) {
        this.codigo = contador++;
        this.cliente = cliente;
        this.urgente = urgente;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Pedido #" + codigo + " (" + cliente + (urgente ? ", URGENTE" : "") + ")";
    }
}

// ========================
// Uso do padrão Mediator
// ========================
class Mediator {
    public static void main(String[] args) {
        PizzariaCentral pizzaria = new PizzariaCentral();

        // Registrar componentes
        Garcom garcom = new Garcom();
        Cozinha cozinha = new Cozinha();
        Forno forno = new Forno();
        Caixa caixa = new Caixa();
        Entrega entrega = new Entrega();

        pizzaria.registrar(garcom);
        pizzaria.registrar(cozinha);
        pizzaria.registrar(forno);
        pizzaria.registrar(caixa);
        pizzaria.registrar(entrega);

        // Criar pedidos
        garcom.criarPedido("Alice", false);
        garcom.criarPedido("Bruno", true); 
        garcom.criarPedido("Carla", false);

        pizzaria.processarPedidos();

    }
}
