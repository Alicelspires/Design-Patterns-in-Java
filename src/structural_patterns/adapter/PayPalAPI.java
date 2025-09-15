package structural_patterns.adapter;

// API externa que precisa do adpatador (classe que será adaptada)

public class PayPalAPI {
    public void faturaPagamento(double valor){
        System.out.printf("Pagamento de R$ %.2f , efetuada pelo serviço PayPal\n", valor);
    }
}
