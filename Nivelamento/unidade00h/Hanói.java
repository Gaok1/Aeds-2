package unidade00h;

public class Hanói {

    

    public static void main(String[] args) {
        int numPinos = 5;
        Hanoi(numPinos, "local-1", "local-3", "local-2");
    }

    static void Hanoi(int n, String origem, String destino, String meio) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }

        Hanoi(n - 1, origem, meio, destino);
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
        Hanoi(n - 1, meio, destino, origem);
    }
}
    

