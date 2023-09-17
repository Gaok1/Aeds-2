package unidade00g;


public class CalcularNotasAlunos {

      public static void main(String[] args) {
        

        int quantidadeAlunos = 5;
        double[] notas = new double[quantidadeAlunos];
        double soma = 0;
        double menorNota = Double.MAX_VALUE;

        for (int i = 0; i < quantidadeAlunos; i++) {
            MyIO.println("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = MyIO.readDouble();

            soma += notas[i];

            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }
        }

        double media = soma / quantidadeAlunos;

        MyIO.println("Soma das notas: " + soma);
        MyIO.println("Média das notas: " + media);
        MyIO.println("Menor nota: " + menorNota);

      
    }
    
}

