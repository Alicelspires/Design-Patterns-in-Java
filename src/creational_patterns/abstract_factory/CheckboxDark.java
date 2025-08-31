package creational_patterns.abstract_factory;

public class CheckboxDark implements Checkbox{
    @Override
    public void render(){
        System.out.println("[Dark Checkbox] Renderizado com tema escuro"); 
    }
}
