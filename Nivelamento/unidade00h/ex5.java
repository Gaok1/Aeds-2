package unidade00h;

public class ex5 {
    public static void main(String[] args) {
        String palavra = "Hello World";
        int quantidadeVogais = contarVogais(palavra);
        System.out.println(quantidadeVogais);
    }

    static int contarVogais(String s) {
        return contarVogais(s, 0);
    }

    static int contarVogais(String s, int i) {
        int cont = 0;
        if (i < s.length()) {
            char c = Character.toLowerCase(s.charAt(i)); // Convertendo para minúscula para facilitar a comparação
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cont++;
            }
            cont += contarVogais(s, i + 1);
        }
        return cont;
    }
}
