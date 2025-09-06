package creational_patterns.prototype;

/*
 * Um sistema de templates de documentos (contratos, relatórios).
 * Em vez de criar tudo do zero sempre que precisa, você clona um modelo existente e só ajusta algumas partes.
 */

public class Prototype {
    public static void main(String[] args) {
        Report report1 = new Report("Alice", "Relatório financeiro", "Dados");
        Contract contract1 = new Contract("Alice", "Empresa Prototype", "Clausulas iniciais do projeto");

        Report reportCopy = report1.clone();
        reportCopy.setTitle("Relatório Financeiro (Revisado)");
        reportCopy.setContent("Dados atualizados do Q1");
        reportCopy.newVersion();
        reportCopy.show();

        Contract contractCopy = contract1.clone();
        contractCopy.setCompany("Empresa Prototype");
        contractCopy.setClauses("Clausulas atualizadas 2025");
        contractCopy.newVersion();
        contractCopy.show();
    }
}
