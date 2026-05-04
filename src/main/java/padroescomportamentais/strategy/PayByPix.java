package padroescomportamentais.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByPix implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String pixKey;
    private boolean confirmed;

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter your PIX key (email/phone/random key): ");
            pixKey = READER.readLine();

            System.out.print("Confirm payment via PIX? (yes/no): ");
            String confirmation = READER.readLine();

            confirmed = confirmation.equalsIgnoreCase("yes");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (confirmed) {
            System.out.println("Paying " + paymentAmount + " using PIX.");
            return true;
        } else {
            System.out.println("PIX payment not confirmed.");
            return false;
        }
    }
}
