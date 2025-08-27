package facade;

import facade.subsistema_externo_cep.CepAPI;
import facade.subsistema_externo_crm.CrmService;

public class Facade {
    public void migrarCliente(String nome, String cep){
       String cidade = CepAPI.getInstance().recuperarCidade(cep);
       String estado = CepAPI.getInstance().recuperarEstado(cep);

        CrmService.gravarCliente(nome, cep, estado, cidade);
    }
}
