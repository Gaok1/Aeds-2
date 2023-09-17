import java.lang.reflect.Array;

/**
 * InserctionSort
 */
public class InserctionSort {

    public static void sort(int[] array) { // primerio elemento N O , compara com todos
        int aux = -1;

        for (int i = 1; i < array.length; i++) {
            aux = array[i];

            for (int j = i - 1; j >= 0; j--) {

                if (aux < array[j]) {
                    array[j + 1] = array[j];

                } else {
                    array[j+1] = aux;
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        int array[] = {1,4,2,5,7,59,1,0};
        sort(array);
        //printar array
        for(int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}