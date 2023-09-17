package unidade00g;


public class MenorElemento {

    public static void main(String[] args) {
        

        MyIO.println("Digite o tamanho do array: ");
        int n = MyIO.readInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            MyIO.println("Digite o elemento " + (i + 1) + ": ");
            array[i] = MyIO.readInt();
        }

        int menor = array[0];
        int posicaoMenor = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] < menor) {
                menor = array[i];
                posicaoMenor = i+1;
            }
        }

        MyIO.println("O menor elemento do array está na posição: " + posicaoMenor);

    
    }
    
}
