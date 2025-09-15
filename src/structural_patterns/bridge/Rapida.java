package structural_patterns.bridge;

public class Rapida extends Notificacao{

    public Rapida(CanalDeEnvio canal){
        super(canal);
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[Rapida]");
        canal.envio(mensagem);
    }
}
