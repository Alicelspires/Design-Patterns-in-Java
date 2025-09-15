package structural_patterns.adapter;

public class PaymenteAdapter implements PaymentProcessor{
    private PayPalAPI payment;

    public PaymenteAdapter(PayPalAPI x){
        this.payment = x;
    }

    @Override
    public void paymentProcessor(double valor){
        this.payment.faturaPagamento(valor);
        System.out.println("Pagamento finalizado com sucesso!\n");
    }
}
