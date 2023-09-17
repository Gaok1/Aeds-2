public class Pesquisador {
    private int seed = 1; // quantidade de resultados 1 por padrão
    private Dado[] entrada; // dados a serem pesquisados

    Pesquisador() {
        // Construtor vazio
    }

    Pesquisador(int seed) {
        this.seed = seed;
    }

    private int getValue(String frase) {
        int soma = 0;
        for (int i = 0; i < frase.length(); i++) {
            soma += (int) frase.charAt(i);
        }
        return soma;
    }

    private int maiorSemelhante(int value1, int value2, int target) {
        int teste1 = Math.abs(value1 - target);
        int teste2 = Math.abs(value2 - target);

        if (teste1 < teste2) {
            return value1;
        } else {
            return value2;
        }
    }

    private void troca(Dado[] entrada, int indice1, int indice2) {
        Dado aux = entrada[indice1];
        entrada[indice1] = entrada[indice2];
        entrada[indice2] = aux;
    }

    public String[] pesquisar(Dado[] entrada, String target) {
        int tValue = getValue(target);

        String[] results = new String[seed];

        for (int j = 0; j < seed; j++) {
            int semelhante = entrada[j].getValor();
            int indiceSemelhante = j;

            for (int i = j + 1; i < entrada.length; i++) {
                int proximo = entrada[i].getValor();
                if (maiorSemelhante(semelhante, proximo, tValue) == proximo) {
                    semelhante = proximo;
                    indiceSemelhante = i;
                }
            }

            results[j] = entrada[indiceSemelhante].getFrase();
            troca(entrada, j, indiceSemelhante);
        }

        return results;
    }

    public void setSeed(int x) {
        this.seed = x;
    }

    public int getSeed() {
        return this.seed;
    }
}
