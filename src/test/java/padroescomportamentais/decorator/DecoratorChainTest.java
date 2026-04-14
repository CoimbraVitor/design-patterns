package padroescomportamentais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorChainTest {

    @Test
    void shouldWorkWithMultipleDecorators() {
        DataSource source = new FileDataSource("test_chain.txt");

        DataSource decorated = new CompressionDecorator(
                                new EncryptionDecorator(source));

        decorated.writeData("very secret data");
        String result = decorated.readData();

        assertEquals("very secret data", result);
    }

    @Test
    void shouldStoreEncodedDataInFile() {
        DataSource source = new FileDataSource("test_chain2.txt");

        DataSource decorated = new CompressionDecorator(
                                new EncryptionDecorator(source));

        decorated.writeData("data");

        String raw = source.readData();

        assertNotEquals("data", raw);
    }
}
