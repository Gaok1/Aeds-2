import java.io.File;

public class Q16 {
    public static void main(String[] args) {
        // Obtém o diretório de execução do programa
        String diretorioAtual = System.getProperty("user.dir");

        // Cria um objeto File para representar o diretório atual
        File diretorioAtualFile = new File(diretorioAtual);

        // Verifica se o diretório atual existe
        if (diretorioAtualFile.exists() && diretorioAtualFile.isDirectory()) {
            System.out.print("Arquivos e pastas no diretório atual: /n");
            listarArquivosEPastasRecursivamente(diretorioAtualFile);

            // Obtém o diretório pai
            File diretorioPai = diretorioAtualFile.getParentFile();

            if (diretorioPai != null) {
                System.out.print("/nArquivos e pastas no diretório pai: /n");
                listarArquivosEPastasRecursivamente(diretorioPai);
            }
        } else {
            System.err.println("Diretório não encontrado.");
        }
    }

    private static void listarArquivosEPastasRecursivamente(File diretorio) {
        File[] arquivosEPastas = diretorio.listFiles();
        if (arquivosEPastas != null) {
            for (File arquivoOuPasta : arquivosEPastas) {
                if (arquivoOuPasta.isFile()) {
                    System.out.print("Arquivo: " + arquivoOuPasta.getName() + " /n");
                } else if (arquivoOuPasta.isDirectory()) {
                    System.out.print("Entrando na pasta: " + arquivoOuPasta.getName() + " /n");
                    listarArquivosEPastasRecursivamente(arquivoOuPasta);
                    System.out.print("Saindo da pasta: " + arquivoOuPasta.getName() + " /n");
                }
            }
        }
    }
}
