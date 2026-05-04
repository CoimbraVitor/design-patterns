package padroescomportamentais.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;
import padroescomportamentais.observer.editor.Editor;
import padroescomportamentais.observer.listeners.EventListener;

class EditorTest {

    static class TestListener implements EventListener {
        boolean wasCalled = false;
        String event;

        @Override
        public void update(String eventType, File file) {
            wasCalled = true;
            event = eventType;
        }
    }

    @Test
    void shouldTriggerOpenEvent() {
        Editor editor = new Editor();
        TestListener listener = new TestListener();

        editor.events.subscribe("open", listener);

        editor.openFile("file.txt");

        assertTrue(listener.wasCalled);
        assertEquals("open", listener.event);
    }

    @Test
    void shouldTriggerSaveEvent() throws Exception {
        Editor editor = new Editor();
        TestListener listener = new TestListener();

        editor.events.subscribe("save", listener);

        editor.openFile("file.txt");
        editor.saveFile();

        assertTrue(listener.wasCalled);
        assertEquals("save", listener.event);
    }

    @Test
    void shouldThrowExceptionWhenSavingWithoutFile() {
        Editor editor = new Editor();

        Exception exception = assertThrows(Exception.class, editor::saveFile);

        assertEquals("Please open a file first.", exception.getMessage());
    }
}