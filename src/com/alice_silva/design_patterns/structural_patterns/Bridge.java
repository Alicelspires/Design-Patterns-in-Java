package com.alice_silva.design_patterns.structural_patterns;

/*
 * Uma empresa deseja criar um sistema para controlar dispositivos 
 * eletrônicos, como TVs e Rádios, por meio de controles remotos. 
 * Existem dois tipos de controles: um Controle Simples, que apenas 
 * liga/desliga e ajusta o volume, e um Controle Avançado, que além 
 * dessas funções permite silenciar o dispositivo.
 * Implemente uma solução utilizando o padrão Bridge, garantindo que 
 * qualquer controle possa operar qualquer dispositivo sem precisar 
 * criar subclasses específicas.
 */

// Abstraction ===================

abstract class Remote{
    protected Device dispositivo;

    public Remote(Device dispositivo) {
        this.dispositivo = dispositivo;
    }

    public abstract void ligar();
    public abstract void desligar();
    public abstract void ajustarVolume(int volume);
} 

// Refined Abstraction 1 ==========

class SimpleRemote extends Remote {
    public SimpleRemote(Device dispositivo) {
        super(dispositivo);
    }

    public void ligar() {
        dispositivo.setLigar();
    }

    public void desligar() {
        dispositivo.setDesligar();
    }

    public void ajustarVolume(int volume) {
        dispositivo.setVolume(volume);
    }
}

// Refined Abstraction 2 ===========

class AdvancedRemote extends Remote {
    public AdvancedRemote(Device dispositivo) {
        super(dispositivo);
    }

    public void ligar() {
        System.out.println("Controle avançado: ligando dispositivo...");
        dispositivo.setLigar();
    }

    public void desligar() {
        System.out.println("Controle avançado: desligando dispositivo...");
        dispositivo.setDesligar();
    }

    public void ajustarVolume(int volume) {
        System.out.println("Controle avançado: ajustando volume...");
        dispositivo.setVolume(volume);
    }

    public void silenciar() {
        System.out.println("Controle avançado: silenciando...");
        dispositivo.setVolume(0);
    }
}

// Implementation ===================

interface Device {
    void setLigar();
    void setDesligar();
    void setVolume(int volume);
}

// Concrete Implementation 1 ========

class TV implements Device {
    private int volume = 10;
    private boolean ligado = false;

    public void setLigar() {
        ligado = true;
        System.out.println("TV ligada.");
    }

    public void setDesligar() {
        ligado = false;
        System.out.println("TV desligada.");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume da TV ajustado para " + volume);
    }
}

// Concrete Implementation 2 =========

class Radio implements Device {
    private int volume = 5;
    private boolean ligado = false;

    public void setLigar() {
        ligado = true;
        System.out.println("Rádio ligado.");
    }

    public void setDesligar() {
        ligado = false;
        System.out.println("Rádio desligado.");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume do Rádio ajustado para " + volume);
    }
}

// ======================================
// USING THE PATTERN - BRIDGE
// ======================================

class Bridge {
    public static void main(String[] args) {
        Remote controleSimplesTV = new SimpleRemote(new TV());
        Remote controleSimplesRadio = new SimpleRemote(new Radio());
        controleSimplesTV.ligar();
        controleSimplesRadio.desligar();

        AdvancedRemote controleAvancadoTV = new AdvancedRemote(new TV());
        AdvancedRemote controleAvancadoRadio = new AdvancedRemote(new Radio());
        controleAvancadoTV.silenciar();
        controleAvancadoRadio.ajustarVolume(10);
    }
}
