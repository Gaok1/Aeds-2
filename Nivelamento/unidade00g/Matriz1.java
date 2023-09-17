package unidade00g;

import java.util.Scanner;

public class Matriz1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de linhas (L): ");
        int l = scanner.nextInt();

        System.out.println("Digite o número de colunas (C): ");
        int c = scanner.nextInt();

        int[][] matriz = new int[l][c];

        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matriz em formato de grid:");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
    
}
