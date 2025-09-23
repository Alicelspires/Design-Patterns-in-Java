package structural_patterns.decorator;

// Decorator
public class FreteBasico implements Frete{
    private double peso;

    public FreteBasico(double peso) {
        this.peso = peso;
    }

    @Override
    public double calcularPreco() {
        return peso * 5;
    }
}
