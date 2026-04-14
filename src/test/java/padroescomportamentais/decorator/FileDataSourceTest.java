package padroescomportamentais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileDataSourceTest {

    @Test
    void shouldWriteAndReadDataCorrectly() {
        DataSource source = new FileDataSource("test.txt");

        source.writeData("hello world");
        String result = source.readData();

        assertEquals("hello world", result);
    }
}
