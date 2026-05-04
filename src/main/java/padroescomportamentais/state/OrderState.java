package padroescomportamentais.state;

public interface OrderState {
    void next(BurgerOrder order);
    void printStatus();
}
