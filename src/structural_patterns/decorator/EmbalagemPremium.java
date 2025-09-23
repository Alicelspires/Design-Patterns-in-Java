package structural_patterns.decorator;

public class EmbalagemPremium extends FreteDecorator{
    public EmbalagemPremium(Frete frete) {
        super(frete);
    }

    @Override
    public double calcularPreco() {
        return super.calcularPreco() + 20;
    }
}
