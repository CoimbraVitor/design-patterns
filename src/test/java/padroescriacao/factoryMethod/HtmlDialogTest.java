package padroescriacao.factoryMethod;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import padroescriacao.factoryMethod.buttons.Button;
import padroescriacao.factoryMethod.buttons.HtmlButton;
import padroescriacao.factoryMethod.factory.Dialog;
import padroescriacao.factoryMethod.factory.HtmlDialog;

class HtmlDialogTest {

    @Test
    void shouldCreateHtmlButton() {
        Dialog dialog = new HtmlDialog();

        Button button = dialog.createButton();

        assertNotNull(button);
        assertTrue(button instanceof HtmlButton);
    }

    @Test
    void shouldRenderHtmlButtonWithoutErrors() {
        Dialog dialog = new HtmlDialog();

        Button button = dialog.createButton();

        assertDoesNotThrow(button::render);
    }

    @Test
    void shouldHandleOnClickWithoutErrors() {
        Dialog dialog = new HtmlDialog();

        Button button = dialog.createButton();

        assertDoesNotThrow(button::onClick);
    }

    @Test
    void shouldRenderWindowWithoutErrors() {
        Dialog dialog = new HtmlDialog();

        assertDoesNotThrow(dialog::renderWindow);
    }
}
