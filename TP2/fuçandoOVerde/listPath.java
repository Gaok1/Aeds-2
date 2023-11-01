import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class listPath {

    public static void funcPrintFile(String diretorioAtual, String buffername,String total) throws Exception {

    
        String path = diretorioAtual + "/" + buffername;
        System.out.println("/n"+path+"/n");
        BufferedReader leitor = new BufferedReader(new FileReader(path));
        String linha = "";
        while ((linha = leitor.readLine()) != null) {
            total += linha + "/n";
            System.out.print(linha + "/n");
        }
    }

    public static void main(String[] args) throws Exception {
        String diretorioAtual = System.getProperty("user.dir");
        File diretorioRaiz = new File(diretorioAtual);
        File[] arquivos = diretorioRaiz.listFiles();

        for (File arquivo : arquivos) {
            System.out.println("/n" + arquivo.getName());
        }
        String buffername = "";
        String total = "";

        for (int i = 0; i < arquivos.length; i++) {
            String nome = arquivos[i].getName();
            for (int j = 0; j < nome.length(); j++) {
              
                if (nome.charAt(j) == '.' && j != 0) {
                    buffername = nome;
                    funcPrintFile(diretorioAtual, buffername, total);

                }
            }
        }
        System.out.print(total);

    }
}
