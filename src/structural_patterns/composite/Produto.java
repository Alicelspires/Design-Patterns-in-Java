package structural_patterns.composite;

public class Produto implements Item{
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
