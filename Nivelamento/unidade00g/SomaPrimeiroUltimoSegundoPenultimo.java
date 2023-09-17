package unidade00g;

import java.util.Scanner;

public class SomaPrimeiroUltimoSegundoPenultimo {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de números: ");
        int n = scanner.nextInt();
        
        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Somas:");
        for (int i = 0; i < n / 2; i++) {
            int soma = numeros[i] + numeros[n - i - 1];
            System.out.println("Soma do " + (i + 1) + "º e " + (n - i) + "º número: " + soma);
        }

        scanner.close();
    }
    
}
