package creational_patterns.factory_method;

import java.util.LinkedList;
import java.util.List;

/*
 * Classe abstrata que irá criar metodos gerais para uma Factory e metodos abstratos
 * para implementação de cada Factory especializada
 */

public abstract class ReportImportFactory {
    public void importer(String content){
        validate(content);
        Parser parserDoc = createParser();
        String dados = parserDoc.parse(content);
        save(dados);
    }

    public void validate(String content){
        if(content == null || content.isBlank()) throw new IllegalArgumentException("Vazio");
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
