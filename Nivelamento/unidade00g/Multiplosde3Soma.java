package unidade00g;

import java.util.Scanner;

public class Multiplosde3Soma {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de números: ");
        int n = scanner.nextInt();
        
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        int soma = 0;
        for (int i = 0; i < n; i++) {
            if (numeros[i] % 3 == 0) {
                soma += numeros[i];
            }
        }

        System.out.println("A soma dos múltiplos de três é: " + soma);

        scanner.close();
    }
}
