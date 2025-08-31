package creational_patterns.abstract_factory;

public class ButtonDark implements Button{
    @Override
    public void render(){
        System.out.println("[Dark Button] Renderizado com tema escuro"); 
    }
}