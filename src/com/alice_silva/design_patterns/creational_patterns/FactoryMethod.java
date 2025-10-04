package com.alice_silva.design_patterns.creational_patterns;

import java.util.LinkedList;
import java.util.List;


/*
 * Cenário: “Importadores de Relatório”
 * Há um fluxo genérico de importação (validar → parsear → salvar). 
 * O formato de arquivo varia (JSON, CSV). Cada subtipo escolhe o parser adequado.
 * 
 * Criar um creator com o método template que chama um factory method criarParser().
 * Cada subtipo fornece o produto (parser) correto.
 */



// Creator ====================

// Classe abstrata que irá criar metodos concretos para 
// uma Factory e metodos abstratos para implementação de 
// cada Factory especializada

abstract class ReportImportFactory {
    public void importer(String content){
        Parser parserDoc = createParser();
        String dados = parserDoc.parse(content);
        save(dados);
    }

    public void save(String content){
        List<String> saveDocsParser = new LinkedList<>();
        saveDocsParser.add(content);

        System.out.println("\n===== Conteúdos Salvos =====\n");
        for(String item : saveDocsParser){
            System.out.println("Documento :");
            System.out.println("--------------------------");
            System.out.println(item);
            System.out.println("--------------------------\n");
        }
    }

    public abstract Parser createParser();
}

/*
 * Subclasse de ReportImportFactory que irá implementar 
 * o metodo abstrato createParser() baseada em seu formato 
 * especifico, juntamente chamando a classe JsonParser() 
 * para receber o conteudo relacionado a ele
 */

class FactoryJSON extends ReportImportFactory{
    public Parser createParser(){
        return new JsonParser();
    }
}

/*
 * Subclasse de ReportImportFactory que irá implementar 
 * o metodo abstrato createParser() baseada em seu formato 
 * especifico, juntamente chamando a classe CsvParser() 
 * para receber o conteudo relacionado a ele
 */

class FactoryCSV extends ReportImportFactory{
    public Parser createParser(){
        return new CsvParser();
    }
}


// Product =======================

// Interface para as variações de formatos de Parser
interface Parser {
    String parse(String content);
}

// Classe que implementa a interface Parser para 
// a criação do seu contéudo relacionado especifico

class JsonParser implements Parser{
    @Override
    public String parse(String content){
        return "Parsing JSON content:\n"+ content;
    }
}

/*
 * Classe que implementa a interface Parser para 
 * a criação do seu contéudo relacionado especifico
 */

class CsvParser implements Parser{
    @Override
    public String parse(String content){
        return "Parsing CSV content:\n" + content;
    }
}

// ======================================
// USING THE PATTERN - FACTORY METHOD
// ======================================

class FactoryMethod {
    public static void main(String[] args) {
        ReportImportFactory doc1 = new FactoryJSON();
        doc1.importer("{ \"nome\": \"Alice\", \"idade\" : 20}");
        doc1.importer("{ \"nome\": \"John\", \"idade\" : 78}");

        ReportImportFactory doc2 = new FactoryCSV();
        doc2.importer("nome,idade\nAlice,20\nJonh,34");
        doc2.importer("nome,idade\nAlice,20\nJonh,34");
    }
}
