
package ListaCadeado;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Teste {
    public static void main(String[] args) {
        long tamanhoDesejado = 1024L * 1024 * 1024; // 1 GB em bytes

        try {
            RandomAccessFile file = new RandomAccessFile("4510.bin", "rw");
            file.setLength(tamanhoDesejado); 
            file.close();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

