package structural_patterns.decorator;

/*
 * Uma empresa de e-commerce deseja implementar um sistema de cálculo de 
 * frete para seus pedidos. Cada pedido pode ter um frete básico calculado pelo peso do pacote.
 * No entanto, dependendo das condições, podem ser aplicadas taxas adicionais:
 * Entrega expressa → aumenta o frete em 50%.
 * Seguro → adiciona um valor fixo para cobrir perdas ou danos.
 * Embalagem premium → adiciona custo extra pela embalagem especial.
 * O sistema deve permitir que essas taxas adicionais sejam aplicadas 
 * de forma dinâmica e combinável, sem alterar a classe principal de cálculo de frete.
*/

public class Decorator{
    public static void main(String[] args) {
        Frete frete = new FreteBasico(10);
        System.out.println("Frete básico: R$ " + frete.calcularPreco());

        frete = new EntregaExpressa(frete);
        System.out.println("Frete expresso: R$ " + frete.calcularPreco());

        frete = new FreteSeguro(frete);
        System.out.println("Seguro: R$ " + frete.calcularPreco());

        frete = new EmbalagemPremium(frete);
        System.out.println("Embalagem premium: R$ " + frete.calcularPreco());
    }
}