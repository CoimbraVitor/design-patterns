package padroescomportamentais.state;

public class DeliveredState implements OrderState {

    @Override
    public void next(BurgerOrder order) {
        System.out.println("Order already delivered. No further state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order delivered to customer.");
    }
}
