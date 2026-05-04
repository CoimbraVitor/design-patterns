package padroescomportamentais.state;

public class PreparingState implements OrderState {

    @Override
    public void next(BurgerOrder order) {
        order.setState(new ReadyState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is being prepared.");
    }
}
