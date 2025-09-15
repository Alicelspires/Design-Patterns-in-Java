package structural_patterns.adapter;

/*
 * Um sistema de pagamentos online que só entende uma interface 
 * de processamento de pagamento. Mas há uma necessidade do uso 
 * de uma API externa que só trabalha com PayPalAPI.
 * 
 * Portanto criamos um adapter que permita o uso do PayPalAPI 
 * dentro do sistema, sem mudar o código já existente.
 */

public class Adapter {
    public static void main(String[] args) {
        PaymentProcessor pagamento01 = new PaymenteAdapter(new PayPalAPI());

        System.out.println("====== PAGAMENTOS ======");
        pagamento01.paymentProcessor(30.00);
        pagamento01.paymentProcessor(109.00);
        
    }
}


