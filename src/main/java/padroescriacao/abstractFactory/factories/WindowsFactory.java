package padroescriacao.abstractFactory.factories;

import padroescriacao.abstractFactory.buttons.Button;
import padroescriacao.abstractFactory.buttons.WindowsButton;
import padroescriacao.abstractFactory.checkboxes.Checkbox;
import padroescriacao.abstractFactory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
