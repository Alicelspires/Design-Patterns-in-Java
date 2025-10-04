package com.alice_silva.design_patterns.structural_patterns;

/*
 * Uma aplicação antiga de pagamentos utiliza a interface pagar(valor). 
 * No entanto, a nova biblioteca de pagamento fornece apenas o método 
 * processarPagamento(valor, moeda).
 * Implemente o padrão GoF Adapter em JavaScript para compatibilizar o 
 * código legado com a nova biblioteca, permitindo que a aplicação antiga 
 * continue funcionando sem modificações.
 */

// Client Interface ============

interface OldPayment {
    public void payment(double valor);
}

// Adapter ======================

class PaymentAdapter implements OldPayment{
    private NewPayment payment;

    public PaymentAdapter(NewPayment x){
        this.payment = x;
    }

    @Override
    public void payment(double valor){
        this.payment.paymentProcessor(valor, "BRL");
        System.out.println("Pagamento finalizado com sucesso!\n");
    }
}

// Service =======================

class NewPayment {
    public void paymentProcessor(double valor, String moeda){
        System.out.printf("Pagamento de R$ %.2f [%s] realizado com o novo sistema.\n", valor, moeda);
    }
}

// ======================================
// USING THE PATTERN - ADAPTER
// ======================================
 
class Adapter {
    public static void main(String[] args) {
        OldPayment pagamento = new PaymentAdapter(new NewPayment());
        pagamento.payment(150.75);
    }
}