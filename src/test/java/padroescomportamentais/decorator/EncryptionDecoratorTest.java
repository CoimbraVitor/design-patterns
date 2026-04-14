package padroescomportamentais.decorator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncryptionDecoratorTest {

    @Test
    void shouldEncryptAndDecryptDataCorrectly() {
        DataSource source = new FileDataSource("test_enc.txt");
        DataSource encrypted = new EncryptionDecorator(source);

        encrypted.writeData("secret");
        String result = encrypted.readData();

        assertEquals("secret", result);
    }

    @Test
    void shouldStoreEncryptedDataDifferentFromOriginal() {
        DataSource source = new FileDataSource("test_enc2.txt");
        DataSource encrypted = new EncryptionDecorator(source);

        encrypted.writeData("data");

        String raw = source.readData();

        assertNotEquals("data", raw);
    }
}
