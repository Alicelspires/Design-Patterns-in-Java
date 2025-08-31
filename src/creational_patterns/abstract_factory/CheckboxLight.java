package creational_patterns.abstract_factory;

public class CheckboxLight implements Checkbox{
    @Override
    public void render(){
        System.out.println("[Light Checkbox] Renderizado com tema claro"); 
    }
}
