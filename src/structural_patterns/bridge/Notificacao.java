package structural_patterns.bridge;

public abstract class Notificacao {
    protected CanalDeEnvio canal;

    public Notificacao(CanalDeEnvio canal){
        this.canal = canal;
    }

    abstract void enviarNotificacao(String mensagem);
}
