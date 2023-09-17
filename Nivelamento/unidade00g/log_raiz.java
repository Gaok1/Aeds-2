package unidade00g;


public class log_raiz {

    public static void main(String[] args) {
        double numero1 = MyIO.readDouble();

        double numero2 = MyIO.readDouble();

        double menorNumero = Math.min(numero1, numero2);
        double maiorNumero = Math.max(numero1, numero2);

        double raizCubica = Math.cbrt(menorNumero);
        double logaritmo = Math.log(menorNumero) / Math.log(maiorNumero);

        MyIO.println("Raiz cúbica do menor número: " + raizCubica);
        MyIO.println("Logaritmo do menor número na base do maior: " + logaritmo);
    }    
}
