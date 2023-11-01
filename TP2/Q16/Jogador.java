import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Jogador {
    public static void main(String[] args) {
        String caminho = "../33998/Q04.c"; // Caminho para o arquivo

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(caminho));
            String linha;
            String total ="";

            while ((linha = leitor.readLine()) != null) {
                total += linha;
            }
            System.out.println(total);

            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler o arquivo.");
        }
    }
}
