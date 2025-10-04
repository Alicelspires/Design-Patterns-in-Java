package com.alice_silva.design_patterns.creational_patterns;

/*
 * Cenário: “Temas de UI (Claro/Escuro)”
 * É preciso renderizar UI com componentes compatíveis entre si. 
 * Um tema deve fornecer Button e Checkbox do mesmo estilo.
 */

// Factories ====================

interface AbstractUIFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}

class AbstractDarkUIFactory implements AbstractUIFactory{
    @Override
    public Button createButton() {
        return new ButtonDark();
    }

    @Override
    public Checkbox createCheckbox() {
        return new CheckboxDark();
    }
}

class AbstractLightUIFactory implements AbstractUIFactory{
    @Override
    public Button createButton() {
        return new ButtonLight();
    }

    @Override
    public Checkbox createCheckbox() {
        return new CheckboxLight();
    }
}

// Buttons ====================

interface Button { 
    void render(); 
}

class ButtonDark implements Button{
    @Override
    public void render(){
        System.out.println("[Dark Button] Renderizado com tema escuro"); 
    }
}

class ButtonLight implements Button{
    @Override
    public void render(){
        System.out.println("[Light Button] Renderizado com tema claro"); 
    }
}

// Checkbox ===================

interface Checkbox {
    void render();
}

class CheckboxDark implements Checkbox{
    @Override
    public void render(){
        System.out.println("[Dark Checkbox] Renderizado com tema escuro"); 
    }
}

class CheckboxLight implements Checkbox{
    @Override
    public void render(){
        System.out.println("[Light Checkbox] Renderizado com tema claro"); 
    }
}

// ======================================
// USING THE PATTERN - ABSTRACT FACTORY
// ======================================

class AbstractFactory {
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
