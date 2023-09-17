package unidade00g;

import java.util.Scanner;

public class VerificaDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean apenasDigitos = true;

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                apenasDigitos = false;
                break;
            }
        }

        if (apenasDigitos) {
            System.out.println("A string é composta apenas por dígitos.");
        } else {
            System.out.println("A string não é composta apenas por dígitos.");
        }

        scanner.close();
    }

    
}
