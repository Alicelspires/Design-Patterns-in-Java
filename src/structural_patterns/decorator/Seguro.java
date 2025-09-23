package structural_patterns.decorator;

class FreteSeguro extends FreteDecorator{
    public FreteSeguro(Frete frete) {
        super(frete);
    }

    @Override
    public double calcularPreco() {
        return super.calcularPreco() + 20;
    }
}
