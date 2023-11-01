import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
// conjunto de comandos: list, cd,cd.., mkdir, rmdir, rm, pwd, clear, exit

class main {

    public static void main(String[] args) {
        String diretorio = System.getProperty("user.dir");
        String comando = "";
       
        File diretorioAtual = new File(diretorio);

        while (true) {

             System.out.println("Diretorio atual: " + diretorioAtual.getAbsolutePath() );

            comando = Read();
            if (comando.equals("exit")) {
                break;
            } else if (comando.equals("list")) {
                list(diretorioAtual);
            } else if (comando.equals("cd..")) {
                diretorioAtual = returnPath(diretorioAtual);
            }else if(comando.equals("cd" )){
                diretorioAtual = returnPath(diretorioAtual);
            }

        }

    }

    public static String Read() {
        Scanner sc = new Scanner(System.in);
        String comando = sc.nextLine();
        return comando;
    }

    public static File returnPath(File Diretorio) {
        String diretorioanterior = Diretorio.getParent();

       return new File(diretorioanterior);
    }

    public static void list(File Diretorio) {
        File[] arquivos = Diretorio.listFiles();
        for (File arquivo : arquivos) {
            if (arquivo.isDirectory()) {
                System.out.println("Diretorio: " + arquivo.getName());
            } else {
                System.out.println("Arquivo: " + arquivo.getName());
            }
        }
    }
}
