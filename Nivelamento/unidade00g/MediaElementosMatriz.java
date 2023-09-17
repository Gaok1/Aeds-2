package unidade00g;

import java.util.Scanner;

public class MediaElementosMatriz {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de linhas: ");
        int linhas = scanner.nextInt();

        System.out.println("Digite o número de colunas: ");
        int colunas = scanner.nextInt();
        
        int[][] matriz = new int[linhas][colunas];

        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        int soma = 0;
        int totalElementos = linhas * colunas;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                soma += matriz[i][j];
            }
        }

        double media = (double) soma / totalElementos;
        System.out.println("A média dos elementos é: " + media);

        scanner.close();
    }
    
}
