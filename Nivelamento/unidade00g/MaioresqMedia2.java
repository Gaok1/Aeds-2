package unidade00g;


public class MaioresqMedia2 {
    
    public static void main(String[] args) {
        

        MyIO.println("Digite a quantidade de números: ");
        int n = MyIO.readInt();

        int[] numeros = new int[n];
        int soma = 0;

        for (int i = 0; i < n; i++) {
            MyIO.println("Digite o número " + (i + 1) + ": ");
            numeros[i] = MyIO.readInt();
            soma += numeros[i];
        }

        double media = (double) soma / n;

        MyIO.println("A média dos valores é: " + media);
        MyIO.println("Números maiores que a média:");

        for (int i = 0; i < n; i++) {
            if (numeros[i] > media) {
                MyIO.println(numeros[i]);
            }
        }

        
    }
}
