package padroescriacao.abstractFactory.factories;

import padroescriacao.abstractFactory.buttons.Button;
import padroescriacao.abstractFactory.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}