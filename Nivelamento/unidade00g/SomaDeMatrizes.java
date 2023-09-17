package unidade00g;

import java.util.Scanner;

public class SomaDeMatrizes {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de linhas e colunas: ");
        int l = scanner.nextInt();
        int c = scanner.nextInt();

        int[][] matriz1 = new int[l][c];
        int[][] matriz2 = new int[l][c];

        System.out.println("Digite os elementos da primeira matriz:");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Digite os elementos da segunda matriz:");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz2[i][j] = scanner.nextInt();
            }
        }

        int[][] matrizResultado = new int[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        System.out.println("Matriz resultante da soma:");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrizResultado[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
    
}
