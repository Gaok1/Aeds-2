package unidade00g;

import java.util.Scanner;

public class ExemploString {
 

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char caractere = scanner.next().charAt(0);

        int contador = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == caractere) {
                contador++;
            }
        }

        System.out.println(contador);

        scanner.close();
    }

}
