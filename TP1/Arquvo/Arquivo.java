import java.io.RandomAccessFile;
import java.text.DecimalFormat;

public class Arquivo {
    public static void main(String[] args) throws Exception {

        // Leitura do número de valores a serem lidos

        int n = MyIO.readInt();

        // Abre o arquivo para escrita
        RandomAccessFile raf = new RandomAccessFile("valores.txt", "rw");

        // Leitura e escrita dos valores
        for (int i = 0; i < n; i++) {
            double valor = MyIO.readDouble();
            raf.writeDouble(valor);
        }

        // Fecha o arquivo
        raf.close();

        // Reabre o arquivo para leitura
        raf = new RandomAccessFile("valores.txt", "r");

        // Cria um formatação para o  double (3 casas decimais);
        DecimalFormat df = new DecimalFormat("#.###"); 

        // Formata o valor double para ter no máximo três casas decimais
       
        // Faz a leitura de trás para frente
        for (int i = n - 1; i >= 0; i--) {

            raf.seek(i * 8); // 8 bytes por double
            double valor = raf.readDouble();
             String valorFormatado = df.format(valor);  // aplica em uma String o valor em no maximo 3 casa decimais
            MyIO.println(valorFormatado);
        }

        // Fecha o arquivo novamente
        raf.close();

    }

}
