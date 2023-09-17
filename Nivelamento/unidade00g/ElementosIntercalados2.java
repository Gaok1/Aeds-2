package unidade00g;

import java.util.Scanner;

public class ElementosIntercalados2 {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor de N: ");
        int n = scanner.nextInt();

        System.out.println("Digite o valor de M: ");
        int m = scanner.nextInt();
        
        int[] vetor1 = new int[n];
        int[] vetor2 = new int[m];

        System.out.println("Digite os elementos do primeiro vetor:");
        for (int i = 0; i < n; i++) {
            vetor1[i] = scanner.nextInt();
        }

        System.out.println("Digite os elementos do segundo vetor:");
        for (int i = 0; i < m; i++) {
            vetor2[i] = scanner.nextInt();
        }

        System.out.println("Elementos intercalados:");
        int i = 0, j = 0;
        while (i < n && j < m) {
            System.out.print(vetor1[i] + " " + vetor2[j] + " ");
            i++;
            j++;
        }

        // Caso um dos vetores tenha mais elementos que o outro
        while (i < n) {
            System.out.print(vetor1[i] + " ");
            i++;
        }

        while (j < m) {
            System.out.print(vetor2[j] + " ");
            j++;
        }

        scanner.close();
    }
    
}
