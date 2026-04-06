package padroescriacao.factoryMethod.factory;

import padroescriacao.factoryMethod.buttons.Button;
import padroescriacao.factoryMethod.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
