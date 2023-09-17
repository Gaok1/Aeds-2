package unidade00g;

import java.util.Scanner;

public class éPalindromo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        boolean resp = true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                resp = false;
                break;  // Use 'break' para sair do loop assim que encontrar um caractere diferente
            }
        }

        System.out.println(resp);

        scanner.close();
    }
    
}
