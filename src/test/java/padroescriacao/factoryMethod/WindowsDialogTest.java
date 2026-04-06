package padroescriacao.factoryMethod;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import padroescriacao.factoryMethod.buttons.Button;
import padroescriacao.factoryMethod.buttons.WindowsButton;
import padroescriacao.factoryMethod.factory.Dialog;
import padroescriacao.factoryMethod.factory.WindowsDialog;

class WindowsDialogTest {

    @Test
    void shouldCreateWindowsButton() {
        Dialog dialog = new WindowsDialog();

        Button button = dialog.createButton();

        assertNotNull(button);
        assertTrue(button instanceof WindowsButton);
    }

    @Test
    void shouldInitializeWindowsButtonOnClick() {
        Dialog dialog = new WindowsDialog();

        WindowsButton button = (WindowsButton) dialog.createButton();

        assertDoesNotThrow(button::onClick);
    }

    @Test
    void shouldRenderWindowsButtonWithoutErrors() {
        Dialog dialog = new WindowsDialog();

        WindowsButton button = (WindowsButton) dialog.createButton();

        assertDoesNotThrow(button::render);
    }

    @Test
    void shouldRenderWindowWithoutErrors() {
        Dialog dialog = new WindowsDialog();

        assertDoesNotThrow(dialog::renderWindow);
    }
}
