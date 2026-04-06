package padroescriacao.abstractFactory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import padroescriacao.abstractFactory.buttons.Button;
import padroescriacao.abstractFactory.buttons.WindowsButton;
import padroescriacao.abstractFactory.checkboxes.Checkbox;
import padroescriacao.abstractFactory.checkboxes.WindowsCheckbox;
import padroescriacao.abstractFactory.factories.GUIFactory;
import padroescriacao.abstractFactory.factories.WindowsFactory;

class WindowsFactoryTest {

    @Test
    void shouldCreateWindowsButton() {
        GUIFactory factory = new WindowsFactory();

        Button button = factory.createButton();

        assertNotNull(button);
        assertTrue(button instanceof WindowsButton);
    }

    @Test
    void shouldCreateWindowsCheckbox() {
        GUIFactory factory = new WindowsFactory();

        Checkbox checkbox = factory.createCheckbox();

        assertNotNull(checkbox);
        assertTrue(checkbox instanceof WindowsCheckbox);
    }

    @Test
    void shouldReturnConsistentWindowsFamily() {
        GUIFactory factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        assertTrue(button instanceof WindowsButton);
        assertTrue(checkbox instanceof WindowsCheckbox);
    }

    @Test
    void shouldPaintWindowsButtonWithoutErrors() {
        GUIFactory factory = new WindowsFactory();

        Button button = factory.createButton();

        assertDoesNotThrow(button::paint);
    }

    @Test
    void shouldPaintWindowsCheckboxWithoutErrors() {
        GUIFactory factory = new WindowsFactory();

        Checkbox checkbox = factory.createCheckbox();

        assertDoesNotThrow(checkbox::paint);
    }
}
