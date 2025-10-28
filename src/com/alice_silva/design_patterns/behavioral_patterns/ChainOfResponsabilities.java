package com.alice_silva.design_patterns.behavioral_patterns;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ValidacaoHandler {
    protected ValidacaoHandler next;

    public ValidacaoHandler setNext(ValidacaoHandler next) {
        this.next = next;
        return next;
    }

    public abstract void setLogs(List<String> team, String user, String email, String senha);
}

class ValidadorEmail extends ValidacaoHandler {
    @Override
    public void setLogs(List<String> team, String user, String email, String senha) {
        System.out.println("Validando email...");
        if (email.contains("@")) {
            System.out.println(">>> Formato de Email Válido");
            if (next != null) next.setLogs(team, user, email, senha);
        } else {
            System.out.println("!!! Email não está no formato válido, inclua um \"@\"");
        }
    }
}

class ValidadorSenha extends ValidacaoHandler {
    @Override
    public void setLogs(List<String> team, String user, String email, String senha) {
        System.out.println("Validando senha...");

        boolean hasUpperCase = senha.matches(".*[A-Z].*");
        boolean hasNumber = senha.matches(".*\\d.*");
        boolean hasLength = senha.length() >= 8;

        if (hasUpperCase && hasNumber && hasLength) {
            System.out.println(">>> Formato de Senha Válido");
            if (next != null) next.setLogs(team, user, email, senha);
        } else {
            System.out.println("!!! Senha não está no formato válido, a senha deve ter:\n" +
                    " - Letras maiúsculas;\n" +
                    " - Números;\n" +
                    " - Mínimo 8 caracteres.");
        }
    }
}

class ValidadorUsername extends ValidacaoHandler {
    @Override
    public void setLogs(List<String> team, String user, String email, String senha) {
        System.out.println("Validando username...");
        if (!team.contains(user)) {
            System.out.println(">>> Log confirmado com sucesso!");
        } else {
            System.out.println("!!! Usuário já existe, crie outro");
        }
    }
}

public class ChainOfResponsabilities {
    public static void main(String[] args) {
        ValidadorEmail validadorEmail = new ValidadorEmail();
        ValidadorSenha validadorSenha = new ValidadorSenha();
        ValidadorUsername validadorUsername = new ValidadorUsername();

        validadorEmail.setNext(validadorSenha).setNext(validadorUsername);

        List<String> teamCompanyLog = List.of("clara", "roberto", "john");

        validadorEmail.setLogs(teamCompanyLog, "alice", "alice@", "1234Abcd");
        System.out.println("====================");
        validadorEmail.setLogs(teamCompanyLog, "e", "e@", "123abcd");
        System.out.println("====================");
        validadorEmail.setLogs(teamCompanyLog, "clara", "clara@", "1234aBcd");
    }
}
