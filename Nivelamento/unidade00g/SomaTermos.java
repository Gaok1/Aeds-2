package unidade00g;

public class SomaTermos {
    public static void main(String[] args) {

        MyIO.println("Digite a quantidade de números: ");
        int n = MyIO.readInt();

        int soma = 0;

        for (int i = 0; 2 * i + 1 < n; i++) {
            MyIO.println("Digite o " + (i + 1) + "º número: ");
            int termo1 = MyIO.readInt();
            int termo2 = MyIO.readInt();

            soma += termo1 + termo2;
        }

        MyIO.println("Soma: " + soma);

    }

}
