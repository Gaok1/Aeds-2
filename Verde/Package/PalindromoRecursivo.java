import java.util.Scanner;

public class PalindromoRecursivo {



    static boolean isPalidromeRecursivo(String frase, int index, int reverseindex) {// metodo que checa se a frase é um
                                                                                   // palindromo

        if (index >= reverseindex) {// caso base
            MyIO.println("SIM");
            return true;
        } else {
            if (frase.charAt(index) == frase.charAt(reverseindex)) {// caso recursivo
                isPalidromeRecursivo(frase, index + 1, reverseindex - 1);
                return true;
            } else {
                MyIO.println("NAO");
                return false;
            }

        }
    }

    static boolean isPalindrome(String str) {// metodo que chama o recursivo e printa o resultado

        if (isPalidromeRecursivo(str, 0, str.length() - 1)) {
            return true;
        } else {
            return false;
        }

    }

    static boolean igual(String frase) { // veririca tamanho e caracter por caracter para ver se é igual a FIM

        if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = MyIO.readLine();
            if (igual(input)) {
                break;
            }

           isPalindrome(input);
        }

        scanner.close();
    }
}
