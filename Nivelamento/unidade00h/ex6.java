package unidade00h;

public class ex6 {
    public static void main(String[] args) {
        String texto = "Hello World";
        int qtdCaracteres = func(texto);
        MyIO.println("Quantidade de caracteres não vogais e não consoantes maiúsculas: " + qtdCaracteres);
    }

    static int func(String s) {
        return contarCaracteres(s, 0);
    }

    static int contarCaracteres(String s, int i) {
        int cont = 0;
        if (i < s.length()) {
            char c = s.charAt(i);
            if (!isVogal(c) && !consoMaiuscula(c)) {
                cont++;
            }
            cont += contarCaracteres(s, i + 1);
        }
        return cont;
    }

    static boolean isVogal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static boolean consoMaiuscula(char c) {
        return Character.isUpperCase(c) && !isVogal(c);
    }
}
