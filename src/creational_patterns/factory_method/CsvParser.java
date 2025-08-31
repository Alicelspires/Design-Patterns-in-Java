package creational_patterns.factory_method;

/*
 * Classe que implementa a interface Parser para 
 * a criação do seu contéudo relacionado especifico
 */

public class CsvParser implements Parser{
    @Override
    public String parse(String content){
        return "Parsing CSV content:\n" + content;
    }
}
