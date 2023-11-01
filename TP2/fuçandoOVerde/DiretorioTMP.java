import java.io.File;

public class DiretorioTMP {
    public static void listarDiretorios(File diretorio, String diretorioAlvo) {
        if (diretorio.isDirectory()) {
            System.out.print("Listando diretório: " + diretorio.getAbsolutePath() + "/n");
            File[] arquivos = diretorio.listFiles();
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    System.out.print("Arquivo ou Pasta: " + arquivo.getName() + "/n");
                    if (arquivo.isDirectory()) {
                        listarDiretorios(arquivo, diretorioAlvo);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String diretorioAlvo = "/home/u1384017/verde-correcao/pendente/tmp/";
        File diretorioRaiz = new File(diretorioAlvo);

        if (diretorioRaiz.exists()) {
            System.out.print("Listando diretório atual: " + diretorioRaiz.getAbsolutePath() + "/n");
            listarDiretorios(diretorioRaiz, diretorioAlvo);
        } else {
            System.out.print("O diretório não existe./n");
        }
    }
}
