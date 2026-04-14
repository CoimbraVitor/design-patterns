package padroescomportamentais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressionDecoratorTest {

    @Test
    void shouldCompressAndDecompressDataCorrectly() {
        DataSource source = new FileDataSource("test_comp.txt");
        DataSource compressed = new CompressionDecorator(source);

        compressed.writeData("some long text to compress");
        String result = compressed.readData();

        assertEquals("some long text to compress", result);
    }

    @Test
    void shouldStoreCompressedDataDifferentFromOriginal() {
        DataSource source = new FileDataSource("test_comp2.txt");
        DataSource compressed = new CompressionDecorator(source);

        compressed.writeData("data");

        String raw = source.readData();

        assertNotEquals("data", raw);
    }
}
