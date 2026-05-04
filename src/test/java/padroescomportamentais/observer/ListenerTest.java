package padroescomportamentais.observer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import padroescomportamentais.observer.listeners.EmailNotificationListener;
import padroescomportamentais.observer.listeners.LogOpenListener;

class ListenerTest {

    @Test
    void shouldPrintEmailNotification() {
        EmailNotificationListener listener = new EmailNotificationListener("test@email.com");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        listener.update("open", new File("file.txt"));

        assertTrue(output.toString().contains("Email to test@email.com"));
    }

    @Test
    void shouldPrintLogNotification() {
        LogOpenListener listener = new LogOpenListener("log.txt");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        listener.update("save", new File("file.txt"));

        assertTrue(output.toString().contains("Save to log"));
    }
}
