package unidade00g;



public class NumerosParesDivisiveisPorTres {

     public static void main(String[] args) {
        

        int n = MyIO.readInt();
        int[] array = new int[n];

        int countPares = 0;
        int countDivisiveisPorTres = 0;

        for (int i = 0; i < n; i++) {
            array[i] = MyIO.readInt();

            if (array[i] % 2 == 0) {
                countPares++;
            }

            if (array[i] % 3 == 0) {
                countDivisiveisPorTres++;
            }
        }

        MyIO.println(countPares);
        MyIO.println(countDivisiveisPorTres);

     
    }
    
}
