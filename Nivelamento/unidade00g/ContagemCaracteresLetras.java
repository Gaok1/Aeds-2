package unidade00g;

import java.util.Scanner;

public class ContagemCaracteresLetras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palavra = scanner.nextLine();

        int total = palavra.length();
        int letras = 0;
        int naoLetras = 0;
        int vogais = 0;

        for (int i = 0; i < total; i++) {
            char c = Character.toLowerCase(palavra.charAt(i));
            if (Character.isLetter(c)) {
                letras++;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vogais++;
                }
            } else {
                naoLetras++;
            }
        }

        System.out.println(total);
        System.out.println(letras);
        System.out.println(naoLetras);
        System.out.println(vogais);
        System.out.println(letras - vogais);

        scanner.close();
    }
}
