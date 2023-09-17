package unidade00g;



public class BubbleSort {
    public static void main(String[] args) {
        

        MyIO.println("Digite o tamanho do array: ");
        int n = MyIO.readInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            MyIO.println("Digite o elemento " + (i + 1) + ": ");
            array[i] = MyIO.readInt();
        }

        bubbleSort(array);

        MyIO.println("Array ordenado:");
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }

        
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Troca os elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
