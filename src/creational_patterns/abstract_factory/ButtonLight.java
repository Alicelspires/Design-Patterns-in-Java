package creational_patterns.abstract_factory;

public class ButtonLight implements Button{
    @Override
    public void render(){
        System.out.println("[Light Button] Renderizado com tema claro"); 
    }
}
