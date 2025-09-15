package structural_patterns.bridge;

public class Agendada extends Notificacao{

    public Agendada(CanalDeEnvio canal){
        super(canal);
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[Agendada]");
        canal.envio(mensagem);
    }
}
