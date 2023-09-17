package unidade00g;

public class condicionais {
    public static void main(String[] args) {

        System.out.println("Digite o primeiro número: ");
        int numero1 = MyIO.readInt();

        System.out.println("Digite o segundo número: ");
         int numero2 = MyIO.readInt();

        if (numero1 > 45 || numero2 > 45) {
            int soma = numero1 + numero2;
            System.out.println("Soma dos números: " + soma);
        } else if (numero1 > 20 && numero2 > 20) {
            int subtracao = Math.max(numero1, numero2) - Math.min(numero1, numero2);
            System.out.println("Subtração dos números: " + subtracao);
        } else if ((numero1 < 10 && numero2 != 0) || (numero2 < 10 && numero1 != 0)) {
            double divisao = (double) Math.max(numero1, numero2) / Math.min(numero1, numero2);
            System.out.println("Divisão dos números: " + divisao);
        } else {
            System.out.println("Assembly's");
        }

    }

}
