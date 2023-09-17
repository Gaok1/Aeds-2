package unidade00g;

import java.util.Scanner;

public class PrimeiroA {

       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        int posicao = -1;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == 'A' || palavra.charAt(i) == 'a') {
                posicao = i;
                break;  // Use 'break' para sair do loop assim que encontrar a primeira ocorrência
            }
        }

        if (posicao != -1) {
            System.out.println("Primeira ocorrência da letra A: " + posicao);
        } else {
            System.out.println("A letra A não foi encontrada na palavra.");
        }

        scanner.close();
    }
    
}
