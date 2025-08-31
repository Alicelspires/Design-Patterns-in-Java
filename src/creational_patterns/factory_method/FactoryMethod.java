package creational_patterns.factory_method;

/*
 * Cenário: “Importadores de Relatório”
 * Você tem um fluxo genérico de importação (validar → parsear → salvar). 
 * O formato de arquivo varia (JSON, CSV). Cada subtipo escolhe o parser adequado.
 * 
 * Criar um creator com o método template que chama um factory method criarParser().
 * Cada subtipo fornece o produto (parser) correto.
 */

public class FactoryMethod {
    public static void main(String[] args) {
        ReportImportFactory doc1 = new FactoryJSON();
        doc1.importer("{ \"nome\": \"Alice\", \"idade\" : 20}");
        doc1.importer("{ \"nome\": \"Alice\", \"idade\" : 20}");

        ReportImportFactory doc2 = new FactoryJSON();
        doc2.importer("nome,idade\nAlice,20\nJonh,34");
    }
}
