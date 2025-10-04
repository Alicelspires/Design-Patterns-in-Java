package com.alice_silva.design_patterns.structural_patterns;

// Subsistema 1 - CRM ===============
class CrmService {

    private CrmService() {
        super();
    }

    public static void gravarCliente(String nome, String cep, String estado, String cidade) {
        System.out.println("Cliente salvo no sistema de CRM:");
        System.out.println("Nome: " + nome);
        System.out.println("CEP: " + cep);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
    }
}

// Subsistema 2 - API de CEP ======== (Singleton)
class CepAPI {
    private static CepAPI instancia = new CepAPI();

    private CepAPI() {
        super();
    }

    public static CepAPI getInstance() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        return "São Bernardo do Campo";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}

// Facade =======================
public class Facade {

    public void migrarCliente(String nome, String cep) {
        String cidade = CepAPI.getInstance().recuperarCidade(cep);
        String estado = CepAPI.getInstance().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, estado, cidade);
    }
}

// ======================================
// USING THE PATTERN - Facade
// ======================================

class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.migrarCliente("Alice Silva", "09876-543");
    }
}
