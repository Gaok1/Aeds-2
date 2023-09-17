package unidade00g;


public class MaioresqMedia {
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

        MyIO.println("media: " + media);
        MyIO.println("maiores q media");

        for (int i = 0; i < n; i++) {
            if (numeros[i] > media) {
                MyIO.println(numeros[i]);
            }
        }

        
    }
}

//sim, N foi lido do teclado e criou n variaveis, que foram preenchidas com o readint();


/*  Se fizermos a leitura de todos os valores e adicionarmos cada valor 
em uma nova variável, perderemos os valores lidos e não poderemos 
mostrar aqueles que forem maiores que a média */
    // sim, pois o valor seria perdido a cada lida, a não ser que você atribuisse o valor lido em uma nova variavel tipo int soma;
    // valor soma += valorLido; count++;
    // ai divide a soma pelo count++;