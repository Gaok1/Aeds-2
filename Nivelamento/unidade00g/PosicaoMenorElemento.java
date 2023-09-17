package unidade00g;
  import java.util.Scanner;

public class PosicaoMenorElemento {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int posicaoMenor = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] < array[posicaoMenor]) {
                posicaoMenor = i;
            }
        }

        System.out.println(posicaoMenor);

        scanner.close();
    }
}

    

