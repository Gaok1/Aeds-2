package unidade00f;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo de origem: ");
        String nomeArquivoOrigem = scanner.nextLine();

        System.out.print("Digite o nome do arquivo de destino: ");
        String nomeArquivoDestino = scanner.nextLine();

        try {
            File arquivoOrigem = new File(nomeArquivoOrigem);
            File arquivoDestino = new File(nomeArquivoDestino);

            Scanner arquivoScanner = new Scanner(arquivoOrigem);
            FileWriter escrevedor = new FileWriter(arquivoDestino);

            while (arquivoScanner.hasNextLine()) {
                String linha = arquivoScanner.nextLine();
                escrevedor.write(linha + "\n");
            }

            arquivoScanner.close();
            escrevedor.close();
            System.out.println("Conteúdo copiado com sucesso!");

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro ao copiar o conteúdo.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
