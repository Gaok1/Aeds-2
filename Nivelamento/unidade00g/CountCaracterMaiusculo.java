package unidade00g;

import java.util.Scanner;

public class CountCaracterMaiusculo {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        int totalCaracteres = palavra.length();
        int maiusculos = 0;

        for (int i = 0; i < totalCaracteres; i++) {
            if (Character.isUpperCase(palavra.charAt(i))) {
                maiusculos++;
            }
        }

        System.out.println("Número de caracteres: " + totalCaracteres);
        System.out.println("Número de caracteres maiúsculos: " + maiusculos);

        scanner.close();
    }
}
