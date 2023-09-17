package unidade00g;

import java.util.Scanner;

public class ElementosIntercalados {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor de N: ");
        int n = scanner.nextInt();
        
        int[] vetor1 = new int[n];
        int[] vetor2 = new int[n];

        System.out.println("Digite os elementos do primeiro vetor:");
        for (int i = 0; i < n; i++) {
            vetor1[i] = scanner.nextInt();
        }

        System.out.println("Digite os elementos do segundo vetor:");
        for (int i = 0; i < n; i++) {
            vetor2[i] = scanner.nextInt();
        }

        System.out.println("Elementos intercalados:");
        for (int i = 0; i < n; i++) {
            System.out.print(vetor1[i] + " " + vetor2[i] + " ");
        }

        scanner.close();
    }
    
}
