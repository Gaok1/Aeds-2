import java.io.File;

public class printDiretorio {
    public static void main(String[] args) {
        // Substitua "caminho/do/diretorio" pelo caminho do diretório que deseja listar.
        String diretorio =System.getProperty("user.dir");

        File pasta = new File(diretorio);

        // Verifica se o caminho especificado é um diretório válido.
        if (pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        System.out.println(arquivo.getName());
                    }
                }
            } else {
                System.out.println("O diretório está vazio.");
            }
        } else {
            System.out.println("Caminho especificado não é um diretório válido.");
        }
    }
}
