package unidade00g;


public class ExercicioWhile {

    public static void main(String[] args) {
       
        
        double somaNotas = 0;

        for (int i = 1; i <= 5; i++) {
            
            double nota = MyIO.readDouble();

            somaNotas += nota;
        }

        double media = somaNotas / 5;

       MyIO.println("A media  eh: " + media);

    }
    
}
