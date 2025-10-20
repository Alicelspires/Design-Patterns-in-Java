package com.alice_silva.design_patterns.structural_patterns;

/*
 * Uma locadora de veículos mantém milhares de carros em seu sistema.
 * Cada carro possui informações únicas como placa e proprietário,
 * mas compartilha características comuns, como modelo, cor e fabricante.
 * Para economizar memória e evitar a criação repetida de objetos com os
 * mesmos dados, implemente o padrão GoF Flyweight
 */

import java.util.HashMap;
import java.util.Map;

class TipoCarro {
    private String modelo;
    private String cor;
    private String fabricante;

    public TipoCarro (String modelo, String cor, String fabricante){
        this.modelo = modelo;
        this.cor = cor;
        this.fabricante = fabricante;
    }

    public void showDetails(String placa, String proprietario){
        System.out.printf("Carro [placa: %s, proprietario: %s],\nTipo: %s, %s (%s)\n\n", placa, proprietario, this.cor, this.modelo, this.fabricante);
    }
}

class Carro {
    private final String placa;
    private final String proprietario;
    private final TipoCarro tipo;

    public Carro(String placa, String proprietario, TipoCarro tipo) {
        this.placa = placa;
        this.proprietario = proprietario;
        this.tipo = tipo;
    }

    public void show() {
        tipo.showDetails(placa, proprietario);
    }
}

class TipoCarroFactory {
    private static Map<String, TipoCarro> tipos = new HashMap<>();

    public TipoCarro getTipo(String modelo, String cor, String fabricante) {
        String key = String.format("%s-%s-%s", modelo, cor, fabricante);

        if (!tipos.containsKey(key)) {
            tipos.put(key, new TipoCarro(modelo, cor, fabricante));
        }

        return tipos.get(key);
    }
}

public class Flyweight {
    public static void main(String[] args) {

        TipoCarro fuscaAzul = new TipoCarroFactory()
            .getTipo("Fusca", "Azul", "Volkswagen");

        TipoCarro fuscaBranco = new TipoCarroFactory()  
            .getTipo("Fusca", "Branco", "Volkswagen");

        TipoCarro fuscaAzul2 = new TipoCarroFactory()
            .getTipo("Fusca", "Azul", "Volkswagen");

        Carro c1 = new Carro("AAA-1111", "João", fuscaAzul);
        Carro c2 = new Carro("BBB-2222", "Maria", fuscaAzul2);
        Carro c3 = new Carro("CCC-3333", "Pedro", fuscaBranco);

        c1.show();
        c2.show();
        c3.show();
    }
}