package structural_patterns.composite;

import java.util.Map;
import java.util.stream.Collectors;

public class Pedido {
    private Map<String, String> cliente;
    private Combo comboPedido;

    public Pedido(Map<String, String>  cliente, Combo combo){
        this.cliente = cliente;
        this.comboPedido = combo;
    }

    public Double obterTotal(){
        return this.comboPedido.getPreco();
    }

    public String getResumo(){
        String itens = this.comboPedido.getItens().stream()
            .map(item -> String.format("\t - %s (R$ %.2f)", item.getNome(), item.getPreco()))
            .collect(Collectors.joining("\n"));

        return String.format(
            """
            Cliente: %s
            Itens pedidos:
            %s
            Total: R$ %.2f
            """, 
            cliente.get("nome"),
            itens,
            obterTotal()
        );
    }
}
