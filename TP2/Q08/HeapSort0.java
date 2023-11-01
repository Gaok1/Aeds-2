public class HeapSort0 {
    public static void swap(int array[], int index1, int index2) {
        int aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;

    }

    public static int GetMaiorFilho(int pai, int arr[], int size) {

        if (size / 2 == pai || arr[pai * 2] > arr[(pai * 2) + 1]) {// so tem um filho ou fiho 1 é maior que filho 2
            return pai * 2;
        } else {
            return (pai * 2) + 1;
        }
    }

    public static void ReconstruirHeap(int[] array, int size) { // tam é o valor ajustavel
      
        int i = 1;
        while (i <= (size / 2) ) {
            int filho = GetMaiorFilho(i, array, size);
            if (array[filho] > array[i]) {
                swap(array, i, filho);
                i = filho;
            }else{
               i = size;
            }
        
        }

    }

    public static void heapSort(int[] arr, int size) {
        for (int i = 2; i <= size; i++) {
            ConstruirHeap(arr, i);
        }
        
        int tam = size;

        while (tam > 1) {
            swap(arr, tam--, 1);
            ReconstruirHeap(arr, tam);
        }

    }

    public static void ConstruirHeap(int[] array, int j) {
        for (int i = j; i > 1; i = i / 2) {
            if (array[i] > array[i / 2]) {
                swap(array, i, i / 2);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 4, 10, 3, 1, 5, 11, 2 };
        System.out.println("Array original:");
        printArray(arr);

        heapSort(arr, arr.length - 1);

        System.out.println("Array ordenado:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
