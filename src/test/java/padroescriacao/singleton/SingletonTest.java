package padroescriacao.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void shouldReturnSameInstance() {
        Singleton instance1 = Singleton.getInstance("first");
        Singleton instance2 = Singleton.getInstance("second");

        assertSame(instance1, instance2);
    }

    @Test
    void shouldKeepValueFromFirstInitialization() {
        Singleton instance1 = Singleton.getInstance("first");
        Singleton instance2 = Singleton.getInstance("second");

        assertEquals(instance1.value, instance2.value);
    }

    @Test
    void shouldNotOverrideValueOnSubsequentCalls() {
        Singleton instance1 = Singleton.getInstance("initial");
        Singleton instance2 = Singleton.getInstance("new");

        assertNotEquals("new", instance2.value);
    }

    @Test
    void shouldHaveNonNullInstance() {
        Singleton instance = Singleton.getInstance("value");

        assertNotNull(instance);
    }

    @Test
    void shouldShareStateAcrossCalls() {
        Singleton instance1 = Singleton.getInstance("start");
        instance1.value = "changed";

        Singleton instance2 = Singleton.getInstance("another");

        assertEquals("changed", instance2.value);
    }
}