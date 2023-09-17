package unidade00g;

public class BandoZe {
     public static void main(String[] args) {
        

        MyIO.println("Digite o salário bruto: ");
        double salarioBruto = MyIO.readDouble();

        MyIO.println("Digite o valor da prestação: ");
        double prestacao = MyIO.readDouble();

        double limitePrestacao = salarioBruto * 0.4; 

        if (prestacao <= limitePrestacao) {
            MyIO.println("Empréstimo concedido");
        } else {
             MyIO.println("Empréstimo não concedido");
        }

        
    }
}
