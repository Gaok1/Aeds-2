package unidade00g;



public class SomadePares {

    public static void main(String[] args) {

        

        System.out.println("Digite o tamanho do array: ");
        int n = MyIO.readInt();

        if (n % 2 == 0) {
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Digite o elemento " + (i + 1) + ": ");
                array[i] = MyIO.readInt();
            }

            System.out.println("Soma dos pares de elementos:");
            for (int i = 0; i < n; i += 2) {
                if (i + 1 < n) {
                    int soma = array[i] + array[i + 1];
                    System.out.println("Soma do " + (i + 1) + "º e " + (i + 2) + "º elemento: " + soma);
                }
            }
        } else {
            System.out.println(" N não é par.");
        }

      
    }

}
