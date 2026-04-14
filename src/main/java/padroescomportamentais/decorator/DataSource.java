package padroescomportamentais.decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}
