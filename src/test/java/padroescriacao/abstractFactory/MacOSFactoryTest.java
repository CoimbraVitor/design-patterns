package padroescriacao.abstractFactory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import padroescriacao.abstractFactory.buttons.Button;
import padroescriacao.abstractFactory.buttons.MacOSButton;
import padroescriacao.abstractFactory.checkboxes.Checkbox;
import padroescriacao.abstractFactory.checkboxes.MacOSCheckbox;
import padroescriacao.abstractFactory.factories.GUIFactory;
import padroescriacao.abstractFactory.factories.MacOSFactory;

class MacOSFactoryTest {

    @Test
    void shouldCreateMacOSButton() {
        GUIFactory factory = new MacOSFactory();

        Button button = factory.createButton();

        assertNotNull(button);
        assertTrue(button instanceof MacOSButton);
    }

    @Test
    void shouldCreateMacOSCheckbox() {
        GUIFactory factory = new MacOSFactory();

        Checkbox checkbox = factory.createCheckbox();

        assertNotNull(checkbox);
        assertTrue(checkbox instanceof MacOSCheckbox);
    }

    @Test
    void shouldReturnConsistentMacOSFamily() {
        GUIFactory factory = new MacOSFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertTrue(button instanceof MacOSButton);
        assertTrue(checkbox instanceof MacOSCheckbox);
    }

    @Test
    void shouldPaintMacOSButtonWithoutErrors() {
        GUIFactory factory = new MacOSFactory();

        Button button = factory.createButton();

        assertDoesNotThrow(button::paint);
    }

    @Test
    void shouldPaintMacOSCheckboxWithoutErrors() {
        GUIFactory factory = new MacOSFactory();

        Checkbox checkbox = factory.createCheckbox();

        assertDoesNotThrow(checkbox::paint);
    }
}
