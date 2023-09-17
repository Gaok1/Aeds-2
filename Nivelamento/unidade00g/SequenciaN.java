package unidade00g;


public class SequenciaN {
    public static void main(String[] args) {
       

        MyIO.println("Digite um número inteiro N: ");
        int n = MyIO.readInt();

        int numero = 1;
        int x = 4;

        MyIO.println("Os primeiros " + n + " números da sequência são:");

        for (int i = 0; i < n; i++) {
            MyIO.print(numero + " ");
            numero += x;
            x += 4;
        }

        
    }
}
