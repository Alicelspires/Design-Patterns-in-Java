package creational_patterns.factory_method;

/*
 * Subclasse de ReportImportFactory que irá implementar 
 * o metodo abstrato createParser() baseada em seu formato 
 * especifico, juntamente chamando a classe CsvParser() 
 * para receber o conteudo relacionado a ele
 */

public class FactoryCSV extends ReportImportFactory{
    public Parser createParser(){
        return new CsvParser();
    }
}