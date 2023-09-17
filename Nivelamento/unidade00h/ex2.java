package unidade00h;

public class ex2 {
    // o algoritmo reproduz a multiplicação de x por y com base na soma recursiva em
    // y vezes de x;
    public static int mult(int x, int y) {
        int m = x;

        if (y == 1) {
            return x;
        } else {
            return m += mult(x, y - 1);
        }

    }

    public static void main(String[] args) {
        MyIO.println(mult(5, 5));

    }

}
