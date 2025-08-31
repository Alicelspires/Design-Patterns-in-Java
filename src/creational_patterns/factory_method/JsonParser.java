package creational_patterns.factory_method;

/*
 * Classe que implementa a interface Parser para 
 * a criação do seu contéudo relacionado especifico
 */

public class JsonParser implements Parser{
    @Override
    public String parse(String content){
        return "Parsing JSON content:\n"+ content;
    }
}
