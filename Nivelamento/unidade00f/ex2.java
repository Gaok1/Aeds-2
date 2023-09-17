package unidade00f;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     

        System.out.print("Digite a frase a ser salva: ");
        String frase = scanner.nextLine();

        try {
            FileWriter escrevedor = new FileWriter("teste.txt");
            escrevedor.write(frase);
            escrevedor.close();
            System.out.println("Frase salva com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a frase no arquivo.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
