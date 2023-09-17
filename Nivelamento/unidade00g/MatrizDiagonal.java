package unidade00g;

import java.util.Scanner;

public class MatrizDiagonal {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor de N: ");
        int n = scanner.nextInt();
        
        int[][] matriz = new int[n][n];

        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Diagonal principal:");
        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println();

        System.out.println("Diagonal secundária:");
        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][n - i - 1] + " ");
        }
        System.out.println();

        scanner.close();
    }
    
}
