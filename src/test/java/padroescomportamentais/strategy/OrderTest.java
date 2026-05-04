package padroescomportamentais.strategy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void shouldProcessOrderWithMockStrategy() {
        Order order = new Order();
        order.setTotalCost(200);

        PayStrategy mockStrategy = new PayStrategy() {
            @Override
            public boolean pay(int paymentAmount) {
                return paymentAmount == 200;
            }

            @Override
            public void collectPaymentDetails() {
            }
        };

        order.processOrder(mockStrategy);

        boolean result = mockStrategy.pay(order.getTotalCost());

        assertTrue(result);
    }

    @Test
    void shouldCloseOrderAfterSuccessfulPayment() {
        Order order = new Order();
        order.setTotalCost(150);

        PayStrategy strategy = new PayStrategy() {
            @Override
            public boolean pay(int paymentAmount) {
                return true;
            }

            @Override
            public void collectPaymentDetails() {
            }
        };

        order.processOrder(strategy);

        if (strategy.pay(order.getTotalCost())) {
            order.setClosed();
        }

        assertTrue(order.isClosed());
    }
}
