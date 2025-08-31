package creational_patterns.abstract_factory;

public class AbstractDarkUIFactory implements AbstractUIFactory{
    @Override
    public Button createButton() {
        return new ButtonDark();
    }

    @Override
    public Checkbox createCheckbox() {
        return new CheckboxDark();
    }
}
