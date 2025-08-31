package structural_patterns.facade;

import structural_patterns.facade.subsistema_externo_cep.CepAPI;
import structural_patterns.facade.subsistema_externo_crm.CrmService;

public class Facade {
    public void migrarCliente(String nome, String cep){
       String cidade = CepAPI.getInstance().recuperarCidade(cep);
       String estado = CepAPI.getInstance().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, estado, cidade);
    }
}
