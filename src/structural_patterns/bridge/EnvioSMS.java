package structural_patterns.bridge;

public class EnvioSMS implements CanalDeEnvio{

    public void envio(String mensagem){
        System.out.println("Enviando SMS :" + mensagem + "\n");
    }
}
