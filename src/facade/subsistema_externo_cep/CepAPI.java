package facade.subsistema_externo_cep;

public class CepAPI {
    private static CepAPI instacia = new CepAPI();
    
    private CepAPI(){
        super();
    }

    public static CepAPI getInstance(){
        return instacia;
    }

    public String recuperarCidade(String cep){
        return "São Bernardo do Campo";
    }

    public String recuperarEstado(String cep){
        return "SP";
    }
}
