package padroescomportamentais.observer;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

import padroescomportamentais.observer.listeners.EventListener;
import padroescomportamentais.observer.publisher.EventManager;

import static org.junit.jupiter.api.Assertions.*;

class EventManagerTest {

    @Test
    void shouldNotifySubscribedListener() {
        EventManager manager = new EventManager("open");

        AtomicBoolean called = new AtomicBoolean(false);

        EventListener listener = (eventType, file) -> {
            if (eventType.equals("open")) {
                called.set(true);
            }
        };

        manager.subscribe("open", listener);
        manager.notify("open", new File("test.txt"));

        assertTrue(called.get());
    }

    @Test
    void shouldNotNotifyUnsubscribedListener() {
        EventManager manager = new EventManager("open");

        AtomicBoolean called = new AtomicBoolean(false);

        EventListener listener = (eventType, file) -> called.set(true);

        manager.subscribe("open", listener);
        manager.unsubscribe("open", listener);

        manager.notify("open", new File("test.txt"));

        assertFalse(called.get());
    }
}
