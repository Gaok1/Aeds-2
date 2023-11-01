import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class modifica {
    public static void main(String[] args) {
        String nomeArquivo1 = "pri.out";
        String nomeArquivo2 = "pub.out";

        try {
            // Cria os arquivos
            BufferedWriter arquivo1 = new BufferedWriter(new FileWriter(nomeArquivo1));
            BufferedWriter arquivo2 = new BufferedWriter(new FileWriter(nomeArquivo2));

            // Escreve o número 2 nos arquivos
            arquivo1.write("2");
            arquivo2.write("2");

            // Fecha os arquivos
            arquivo1.close();
            arquivo2.close();

            System.out.println("2");

            // Lista e imprime os nomes de arquivos no diretório
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }
}
