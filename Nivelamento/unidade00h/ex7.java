package unidade00h;

public class ex7 {

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        ordenarArray(array);
        
       MyIO.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    static void ordenarArray(int[] arr) {
        ordenarArray(arr, 0);
    }

    static void ordenarArray(int[] arr, int index) {
        if (index < arr.length - 1) {
            int minIndex = encontrarIndiceMinimo(arr, index, index + 1);
            if (minIndex != index) {
                trocarElementos(arr, index, minIndex);
            }
            ordenarArray(arr, index + 1);
        }
    }

    static int encontrarIndiceMinimo(int[] arr, int minIndex, int currentIndex) {
        if (currentIndex < arr.length) {
            if (arr[currentIndex] < arr[minIndex]) {
                minIndex = currentIndex;
            }
            return encontrarIndiceMinimo(arr, minIndex, currentIndex + 1);
        }
        return minIndex;
    }

    static void trocarElementos(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
