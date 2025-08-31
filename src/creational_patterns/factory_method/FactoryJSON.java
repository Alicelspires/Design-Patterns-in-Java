package creational_patterns.factory_method;

/*
 * Subclasse de ReportImportFactory que irá implementar 
 * o metodo abstrato createParser() baseada em seu formato 
 * especifico, juntamente chamando a classe JsonParser() 
 * para receber o conteudo relacionado a ele
 */

public class FactoryJSON extends ReportImportFactory{
    public Parser createParser(){
        return new JsonParser();
    }
}
