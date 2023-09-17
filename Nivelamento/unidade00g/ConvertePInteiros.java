package unidade00g;

import java.util.Scanner;

public class ConvertePInteiros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int numero = Integer.parseInt(input);
            System.out.println("Número inteiro: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Não foi possível converter a string para um número inteiro.");
        }

        scanner.close();
    }
    
}
