package creational_patterns.abstract_factory;

public class AbstractLightUIFactory implements AbstractUIFactory{
    @Override
    public Button createButton() {
        return new ButtonLight();
    }

    @Override
    public Checkbox createCheckbox() {
        return new CheckboxLight();
    }
}
