package unidade00l;

import java.util.Random;

public class Lixao {

    public static void main(String[] args) {
        Random random = new Random();

        Retangulo array[] = new Retangulo[2];

        for (int i = 0; i < 2; i++) {
            array[i] = new Retangulo(random.nextInt(100), random.nextInt(100));
        }

        for (int i = 0; i < 2; i++) {
            MyIO.println("-------------------------");
            Retangulo retangulo = array[i];
            MyIO.println("Retangulo " + (i + 1));
            MyIO.println("Base: " + retangulo.getBase());
            MyIO.println("Altura: " + retangulo.getAltura());
            MyIO.println("Diagonal: " + retangulo.getDiagonal());
            MyIO.println("Perimetro: " + retangulo.getPerimetro());
            MyIO.println("-------------------------");
        }

    }
}
