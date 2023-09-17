package unidade00g;

public class MostrarElementos {

    public static void main(String[] args) {
        int[] vetor = {10, 5, 8, 2, 8};

        MyIO.println("Elementos do array:");
        for (int i = 0; i < vetor.length; i++) {
            MyIO.println(vetor[i]);
        }
    
}

}