package com.alice_silva.design_patterns.creational_patterns;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.print.Doc;

/*
 * Um sistema de templates de documentos (contratos, relatórios).
 * Em vez de criar tudo do zero sempre que precisa, você clona um 
 * modelo existente e só ajusta algumas partes.
 */


// Prototype ====================

// Definindo o que todos os documentos terão ao ser feito uma copia
abstract class Document {
    protected String name;
    protected LocalDateTime creationData;
    protected int version;

    public Document(String name) {
        this.name = name;
        this.creationData = LocalDateTime.now();
        this.version = 1;
    }

    public void newVersion() {
        this.version++;
        this.creationData = LocalDateTime.now();
    }

    public abstract Document clone();
    public abstract void show();

    protected void generalInfo() {
        System.out.println("Autor: " + name);
        System.out.println("Data criação: " + creationData);
        System.out.println("Versão: " + version);
    }
}

// Concrete Prototype 1 =====================

class Contract extends Document{
    private String company;
    private String clauses;

    public Contract(String name, String company, String clauses){
        super(name);
        this.company = company;
        this.clauses = clauses;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setClauses(String clauses) {
        this.clauses = clauses;
    }

    @Override
    public Contract clone(){
        Contract copy = new Contract(this.name, this.company, this.clauses);
        copy.version = this.version;
        return copy;
    }

    @Override
    public void show(){
        System.out.println("\nContract ================================");
        generalInfo();
        System.out.println("Company: " + company);
        System.out.println("Clauses: " + clauses);
    }
}

// Concrete Prototype 2 ====================

class Report extends Document{
    private String title;
    private String content;

    public Report(String name, String title, String content){
        super(name);
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Report clone(){
        Report copy = new Report(this.name, this.title, this.content);
        copy.version = this.version;
        return copy;
    }

    @Override
    public void show(){
        System.out.println("\nReport ================================");
        generalInfo();
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}

// Document Registry ===================

class DocumentRegistry {
    private Map<String, Document> prototypeDocs = new HashMap<>();

    public void registry(String key, Document proto){
        prototypeDocs.put(key, proto);
    }

    public Document createClone(String key){
        Document p = prototypeDocs.get(key);
        return (p != null) ? p.clone() : null;
    }
}

// ======================================
// USING THE PATTERN - PROTOTYPE
// ======================================

public class Prototype {
    public static void main(String[] args) {
        Report report1 = new Report("Alice", "Relatório financeiro", "Dados");
        Contract contract1 = new Contract("Alice", "Empresa Prototype", "Clausulas iniciais do projeto");

        Report reportCopy = report1.clone();
        reportCopy.setTitle("Relatório Financeiro (Revisado)");
        reportCopy.setContent("Dados atualizados do Q1");
        reportCopy.newVersion();
        reportCopy.show();

        Contract contractCopy = contract1.clone();
        contractCopy.setCompany("Empresa Prototype");
        contractCopy.setClauses("Clausulas atualizadas 2025");
        contractCopy.newVersion();
        contractCopy.show();


        // Ou utilizando Document Registry

        DocumentRegistry docReport1 = new DocumentRegistry();
        docReport1.registry("Report with registry", report1);
        // clonando
        Document docReport2 = docReport1.createClone("Report with registry");
        docReport2.show();
    }
}
