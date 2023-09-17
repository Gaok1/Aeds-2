package unidade00g;


public class InteirosImpares {
    
        public static void main(String[] args) {
        

       MyIO.println("Digite um número inteiro N: ");
        int n = MyIO.readInt();

        int contador = 0;
        int numero = 1;

       MyIO.println("Os primeiros " + n + " números ímpares são:");

        while (contador < n) {
            if (numero % 2 != 0) {
                MyIO.print(numero + " ");
                contador++;
            }
            numero++;
        }

        


    }
}
