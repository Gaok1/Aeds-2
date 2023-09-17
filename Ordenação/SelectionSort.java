import java.util.Random;

class SelectionSort {
    public static void swap(int[] array, int bubble, int j) {
        int aux = array[bubble];
        array[bubble] = array[j];
        array[j] = aux;
    }

    public static void ordendar(int[] array) { // Método que organiza array com base no Selection Sort
        int tamanho = array.length - 1;
        int p = array[tamanho]; 
  

        for (int i = 0; i <= tamanho; i++) { // Loop externo para controlar as passagens
            p = tamanho;
            // Loop interno para comparar e trocar elementos
            for (int j = tamanho; j >= i; j--) { // Loop interno para comparar e trocar elementos

                if (array[j] < array[p]) { // Verifica se o elemento atual é maior que o próximo
                    // Troca os elementos
                    p = j;

                }

            }

            swap(array, p, i); //3 atribuições
        }
    }

    public static void main(String[] args) {
 
        //array de 20 elementos
        int[] array = new int[50];
        Random rand = new Random(); // Objeto para gerar números aleatórios

        for (int i = 0; i < 50; i++) {
            array[i] = rand.nextInt(100); // Gera números aleatórios de 0 a 99 (você pode ajustar o limite)
        }
        System.out.println("\n\n=====Array desordenado: =====\n\n");
        for (int elemento : array) {    
            System.out.print(elemento + " ");
        }
        System.out.println("\n\n=====Array ordenado: =====\n\n");

        ordendar(array);
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }
}
