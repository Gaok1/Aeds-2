import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class lerfile {  
    public static void main(String[] args) {
        String caminhoArquivo = "/home/u1384017/verde-correcao/pendente/tmp/35283/Insercao.java";

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            StringBuilder conteudo = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("");
            }

            System.out.print(conteudo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
