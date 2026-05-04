package padroescomportamentais.state;

public class BurgerOrder {
    private OrderState state;

    public BurgerOrder() {
        this.state = new CreatedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
