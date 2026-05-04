package padroescomportamentais.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class BurgerOrderTest {

    // Helper para capturar saída do System.out
    private String captureOutput(Runnable action) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));

        try {
            action.run();
        } finally {
            System.setOut(original);
        }

        return output.toString();
    }

    @Test
    void shouldStartInCreatedState() {
        BurgerOrder order = new BurgerOrder();

        String output = captureOutput(order::printStatus);

        assertTrue(output.contains("Order created"));
    }

    @Test
    void shouldTransitionFromCreatedToPreparing() {
        BurgerOrder order = new BurgerOrder();

        order.nextState();

        String output = captureOutput(order::printStatus);

        assertTrue(output.contains("being prepared"));
    }

    @Test
    void shouldTransitionFromPreparingToReady() {
        BurgerOrder order = new BurgerOrder();

        order.nextState(); // Created -> Preparing
        order.nextState(); // Preparing -> Ready

        String output = captureOutput(order::printStatus);

        assertTrue(output.contains("ready"));
    }

    @Test
    void shouldTransitionFromReadyToDelivered() {
        BurgerOrder order = new BurgerOrder();

        order.nextState(); // Created
        order.nextState(); // Preparing
        order.nextState(); // Ready -> Delivered

        String output = captureOutput(order::printStatus);

        assertTrue(output.contains("delivered"));
    }

    @Test
    void shouldNotChangeStateAfterDelivered() {
        BurgerOrder order = new BurgerOrder();

        // Vai até o estado final
        order.nextState();
        order.nextState();
        order.nextState();

        String before = captureOutput(order::printStatus);

        order.nextState(); // tentativa de avançar além do final

        String after = captureOutput(order::printStatus);

        assertEquals(before, after);
    }

    @Test
    void shouldPrintMessageWhenTryingToAdvanceAfterDelivered() {
        BurgerOrder order = new BurgerOrder();

        // chegar no estado final
        order.nextState();
        order.nextState();
        order.nextState();

        String output = captureOutput(order::nextState);

        assertTrue(output.contains("already delivered"));
    }
}
