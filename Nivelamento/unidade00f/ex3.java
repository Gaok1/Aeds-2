package unidade00f;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        

        try {
            File arquivo = new File("teste.txt");
            Scanner arquivoScanner = new Scanner(arquivo);

            System.out.println("Conteúdo do arquivo em letras maiúsculas:");
            while (arquivoScanner.hasNextLine()) {
                String linha = arquivoScanner.nextLine();
                String linhaMaiuscula = linha.toUpperCase();
                System.out.println(linhaMaiuscula);
            }

            arquivoScanner.close();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }

        scanner.close();
    }
}


