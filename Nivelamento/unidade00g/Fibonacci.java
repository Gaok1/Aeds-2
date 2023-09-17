package unidade00g;


public class Fibonacci {

      public static void main(String[] args) {
   
       MyIO.println("Digite um número inteiro n: ");
        int n = MyIO.readInt();

        int termoAnterior = 0;
        int termoAtual = 1;
        int contador = 2;

        while (contador <= n) {
            int proximoTermo = termoAnterior + termoAtual;
            termoAnterior = termoAtual;
            termoAtual = proximoTermo;
            contador++;
        }

       MyIO.println( termoAtual);

    }
    
}
