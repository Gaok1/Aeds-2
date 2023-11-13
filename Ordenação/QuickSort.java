public class QuickSort {
    
    public static void QuickSort(int array[], int esq, int dir){

        int pivo = array[(esq + dir) / 2];
        int i = esq;
        int j = dir;
        while(i<j){
            while(array[i] < pivo){
                i++;
            }

            while(array[j]>pivo){
                j--;
            }
               int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;j--;
            
        }

        if(i<dir){
            QuickSort(array, i, dir);
        }

        if(j>esq){
            QuickSort(array, esq, j);
        }
    }



    public static void main(String[] args) {
        int[] array = { 5, 3, 2, 4, 7, 1, 0, 6 };
        QuickSort(array, 0, array.length - 1);
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }



}
