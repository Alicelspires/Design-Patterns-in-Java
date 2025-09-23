package structural_patterns.decorator;

public class EntregaExpressa extends FreteDecorator{
    public EntregaExpressa(Frete frete) {
        super(frete);
    }

    @Override
    public double calcularPreco() {
        return super.calcularPreco() + 20;
    }
}
