package unidade00g;

public class Maior {
    public static void main(String[] args) {

        int maior = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o número " + (i + 1) + ": ");
            int numero = MyIO.readInt();

            if (numero > maior) {
                maior = numero;
            }
        }

        System.out.println(maior);

    }
}
