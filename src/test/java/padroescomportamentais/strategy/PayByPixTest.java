package padroescomportamentais.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayByPixTest {

    @Test
    void shouldFailWhenNotConfirmed() {
        PayByPix pix = new PayByPix();

        boolean result = pix.pay(100);

        assertFalse(result);
    }

    @Test
    void shouldPaySuccessfullyWhenConfirmed() {
        PayByPix pix = new PayByPix();

        try {
            var field = PayByPix.class.getDeclaredField("confirmed");
            field.setAccessible(true);
            field.set(pix, true);
        } catch (Exception e) {
            fail(e);
        }

        boolean result = pix.pay(100);

        assertTrue(result);
    }
}
