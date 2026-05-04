package padroescomportamentais.strategy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class PayByCreditCardTest {

    @Test
    void shouldFailWhenCardIsNull() {
        PayByCreditCard strategy = new PayByCreditCard();

        boolean result = strategy.pay(100);

        assertFalse(result);
    }

    @Test
    void shouldPaySuccessfullyWhenCardExists() {
        PayByCreditCard strategy = new PayByCreditCard();

        try {
            var field = PayByCreditCard.class.getDeclaredField("card");
            field.setAccessible(true);
            field.set(strategy, new CreditCard("1234", "12/30", "123"));
        } catch (Exception e) {
            fail(e);
        }

        boolean result = strategy.pay(100);

        assertTrue(result);
    }
}
