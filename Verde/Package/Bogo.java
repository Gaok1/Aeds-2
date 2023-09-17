import java.util.Arrays;
import java.util.Random;

public class Bogo {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1,0, 3, 9, 5,11};
        long count = 0;
        while (!isSorted(array)) {
            count++;
            shuffleArray(array);
            System.out.println("Array talvez ordenado: " + Arrays.toString(array));
        }
        
        System.out.println("Array ordenado: " + Arrays.toString(array));
        MyIO.println("Número de embaralhamentos: " + count);
    }
    
    // Função para verificar se o array está ordenado
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    // Função para embaralhar o array
    public static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
