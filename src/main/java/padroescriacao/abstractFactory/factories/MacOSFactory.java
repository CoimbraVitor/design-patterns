package padroescriacao.abstractFactory.factories;

import padroescriacao.abstractFactory.buttons.Button;
import padroescriacao.abstractFactory.buttons.MacOSButton;
import padroescriacao.abstractFactory.checkboxes.Checkbox;
import padroescriacao.abstractFactory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
