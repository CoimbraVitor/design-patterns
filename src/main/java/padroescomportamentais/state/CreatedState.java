package padroescomportamentais.state;

public class CreatedState implements OrderState {

    @Override
    public void next(BurgerOrder order) {
        order.setState(new PreparingState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order created. Waiting to be prepared.");
    }
}
