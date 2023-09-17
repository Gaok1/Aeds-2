package unidade00g;

public class NotasUniversidade {

    public static void main(String[] args) {
       
       MyIO.println("Digite a nota máxima N: ");
        double notaMaxima = MyIO.readDouble();

        double somaNotas = 0;
        int alunosAbaixoMedia = 0;
        int alunosConceitoA = 0;
        int contador = 0;

        while (contador < 20) {
           MyIO.println("Digite a nota do aluno " + (contador + 1) + ": ");
            double nota = MyIO.readDouble();;

            if (nota < 0 || nota > notaMaxima) {
               MyIO.println("Nota inválida. Digite novamente: ");
                continue;
            }

            somaNotas += nota;

            if (nota < 0.6 * notaMaxima) {
                alunosAbaixoMedia++;
            }

            if (nota >= 0.9 * notaMaxima) {
                alunosConceitoA++;
            }

            contador++;
        }

        double mediaTurma = somaNotas / 20;
       

        MyIO.println("Media da turma: " + mediaTurma);
        MyIO.println("Alunos abaixo da media da universidade: " + alunosAbaixoMedia);
        MyIO.println("Alunos com conceito A: " + alunosConceitoA);

    }
    
}
