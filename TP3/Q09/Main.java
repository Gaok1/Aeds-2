import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {
        String diretorio = "/home/u1384017/verde-correcao/dir";
        String nomeArquivo = "arquivo.txt";
        long tamanhoEmBytes = (long) (10.88 * 1024 * 1024 * 1024); // 10.88 GB em bytes

        try {
            criarDiretorio(diretorio);
            alocaArquivo(diretorio, nomeArquivo, tamanhoEmBytes);
            System.out.println("Arquivo alocado com sucesso em: " + diretorio);
        } catch (IOException e) {
            System.err.println("Erro ao alocar o arquivo: " + e.getMessage());
        }
    }

    private static void criarDiretorio(String diretorio) throws IOException {
        File dir = new File(diretorio);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Diretório criado em: " + diretorio);
            } else {
                throw new IOException("Falha ao criar o diretório: " + diretorio);
            }
        }
    }

    private static void alocaArquivo(String diretorio, String nomeArquivo, long tamanhoEmBytes) throws IOException {
        Path arquivoPath = Path.of(diretorio, nomeArquivo);
        Files.write(arquivoPath, new byte[0], StandardOpenOption.CREATE);
        Files.write(arquivoPath, new byte[(int) tamanhoEmBytes], StandardOpenOption.APPEND);
    }
}
