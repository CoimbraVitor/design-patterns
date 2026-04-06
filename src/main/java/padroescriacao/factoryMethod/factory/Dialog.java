package padroescriacao.factoryMethod.factory;

import padroescriacao.factoryMethod.buttons.Button;

public abstract class Dialog {

    public void renderWindow() {
        // ... other code ...

        Button okButton = createButton();
        okButton.render();
    }


    public abstract Button createButton();
}