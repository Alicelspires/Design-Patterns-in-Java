package structural_patterns.decorator;

public abstract class FreteDecorator implements Frete {
    protected Frete frete;

    public FreteDecorator(Frete frete) {
        this.frete = frete;
    }

    @Override
    public double calcularPreco() {
        return frete.calcularPreco();
    }
    
}
