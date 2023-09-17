package unidade00g;

import java.util.Scanner;

public class MediasElementosLinhaMatriz {
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

        System.out.println("Média dos elementos por linha:");
        for (int i = 0; i < linhas; i++) {
            int somaLinha = 0;
            for (int j = 0; j < colunas; j++) {
                somaLinha += matriz[i][j];
            }
            double mediaLinha = (double) somaLinha / colunas;
            System.out.println("Linha " + (i + 1) + ": " + mediaLinha);
        }

        scanner.close();
    }
}
