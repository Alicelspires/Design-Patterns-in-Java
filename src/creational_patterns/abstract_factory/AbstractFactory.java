package creational_patterns.abstract_factory;

/*
 * Cenário: “Temas de UI (Claro/Escuro)”
 * É preciso renderizar UI com componentes compatíveis entre si. 
 * Um tema deve fornecer Button e Checkbox do mesmo estilo.
 */

public class AbstractFactory {
    public static void main(String[] args) {
        AbstractUIFactory darkFactory = new AbstractDarkUIFactory();
        AbstractUIFactory lightFactory = new AbstractLightUIFactory();

        System.out.println("\n=== Criando UI com tema ESCURO ===");
        Button darkButton = darkFactory.createButton();
        Checkbox darkCheckbox = darkFactory.createCheckbox();
        darkButton.render();
        darkCheckbox.render();

        System.out.println("\n=== Criando UI com tema CLARO ===");
        Button lightButton = lightFactory.createButton();
        Checkbox lightCheckbox = lightFactory.createCheckbox();
        lightButton.render();
        lightCheckbox.render();
    }
}
