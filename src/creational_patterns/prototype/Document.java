package creational_patterns.prototype;

import java.time.LocalDateTime;

// Definindo o que todos os documentos terão ao ser feito uma copia
public abstract class Document {
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
