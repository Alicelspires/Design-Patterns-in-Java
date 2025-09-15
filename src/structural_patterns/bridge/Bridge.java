package structural_patterns.bridge;

/*
 * Cenário:
 * Implementar um sistema de notificações (Email, SMS, etc.).
 * E separar a forma de envio (ex.: envio rápido, envio agendado) da mensagem em si.
 * 
 * A abstração (Notificação) deve ser independente da implementação (Canal de envio).
 */

public class Bridge {
    public static void main(String[] args) {
        CanalDeEnvio sms = new EnvioSMS();
        CanalDeEnvio email = new EnvioEmail();

        Notificacao notif01 = new Rapida(sms);
        Notificacao notif02 = new Agendada(sms);
        
        Notificacao notif03 = new Rapida(email);
        Notificacao notif04 = new Agendada(email);

        notif01.enviarNotificacao("Bem vindo ao sistema");
        notif02.enviarNotificacao("Seu código de verificação é 1234");
        notif03.enviarNotificacao("Novidades de design patterns em breve");
        notif04.enviarNotificacao("Novas atualizações no sistema");
    }
}
