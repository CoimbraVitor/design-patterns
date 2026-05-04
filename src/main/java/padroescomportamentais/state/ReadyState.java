package padroescomportamentais.state;

public class ReadyState implements OrderState {

    @Override
    public void next(BurgerOrder order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is ready for pickup.");
    }
}
