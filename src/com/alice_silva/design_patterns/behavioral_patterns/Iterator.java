package com.alice_silva.design_patterns.behavioral_patterns;

/*
 * Implemente um sistema para uma biblioteca digital utilizando o padrão 
 * Iterator (Iterador).
 * 
 * O sistema deve permitir percorrer uma coleção de livros sem expor sua 
 * estrutura interna, possibilitando que diferentes formas de iteração
 * sejam criadas (por exemplo, listar todos os livros ou apenas os de um 
 * gênero específico).
 * 
 * Cada livro deve possuir informações como título, autor e gênero.
 * O cliente deve conseguir iterar sobre os livros usando o iterador sem 
 * precisar saber como os dados estão armazenados.
 */

import java.util.ArrayList;
import java.util.List;


// Iterator Interface

interface IteratorLivro {
    boolean hasNext();
    Livro next();
}


// Concrete Iterator

class BibliotecaIterator implements IteratorLivro {
    private List<Livro> livros;
    private int index = 0;

    public BibliotecaIterator(List<Livro> livros) {
        this.livros = livros;
    }

    public boolean hasNext() {
        return index < livros.size();
    }

    public Livro next() {
        return livros.get(index++);
    }
}


// Aggregate Interface

interface ColecaoLivros {
    IteratorLivro criarIterator();
}


// Concrete Aggregate

class Biblioteca implements ColecaoLivros {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    @Override
    public IteratorLivro criarIterator() {
        return new BibliotecaIterator(livros);
    }
}


// Classe Livro (Elemento simples)

class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibirDetalhes() {
        System.out.println(" - " + titulo + " - " + autor);
    }
}

// Cliente

class Cliente {
    public void imprimir(IteratorLivro iterator, String colecao) {
        System.out.printf("========== %s ==========\n", colecao);
        while (iterator.hasNext()) {
            iterator.next().exibirDetalhes();
        }
    }
}

// ===============================
// Uso do padrão Iterator
// ===============================
class Iterator {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
        biblioteca.adicionarLivro(new Livro("Quarto de Despejo", "Carolina Maria de Jesus"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));

        IteratorLivro iterator = biblioteca.criarIterator();

        Cliente imprimir = new Cliente();
        imprimir.imprimir(iterator, "Livros Populares");
    }
}
