package structural_patterns.bridge;

public class EnvioEmail implements CanalDeEnvio{
    public void envio(String mensagem){
        System.out.println("Enviando E-mail: "+ mensagem + "\n");
    }
}
