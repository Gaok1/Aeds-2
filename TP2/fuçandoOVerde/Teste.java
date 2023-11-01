import java.io.File;

public class Teste {
    public static void listarDiretorios(File diretorio, int nivel) {
        if (diretorio.isDirectory()) {
            System.out.print("Entrando no diretório: " + diretorio.getName() + "/n");
            File[] arquivos = diretorio.listFiles();
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isDirectory()) {
                        // Imprimir informações apenas para diretórios
                        System.out.print("Diretório: " + arquivo.getName() + "/n");
                        // Recursivamente listar subdiretórios
                        listarDiretorios(arquivo, nivel + 1);
                    }
                }
            }
            System.out.print("Saindo do diretório: " + diretorio.getName() + "/n");
        }
    }

    public static void main(String[] args) {    
        String diretorioInicial = System.getProperty("user.dir");
        File diretorioRaiz = new File(diretorioInicial);

        listarDiretoriosRecursivamente(diretorioRaiz, "/home/u1384017/verde-correcao");
    }

    public static void listarDiretoriosRecursivamente(File diretorio, String diretorioAlvo) {
        if (diretorio != null && !diretorio.getAbsolutePath().equals(diretorioAlvo)) {
            listarDiretorios(diretorio, 0);
            File diretorioPai = diretorio.getParentFile();
            if (diretorioPai != null) {
                listarDiretoriosRecursivamente(diretorioPai, diretorioAlvo);
            }
        }
    }
}
