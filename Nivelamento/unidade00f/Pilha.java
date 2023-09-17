package unidade00f;
public class Pilha {

    private int tamanho;
    private int[] elementos;
    private int topo;

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        this.elementos = new int[tamanho];
        this.topo = -1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == tamanho - 1;
    }

    public void empilhar(int elemento) {
        if (!estaCheia()) {
            topo++;
            elementos[topo] = elemento;
        } else {
            System.out.println("A pilha ta cheia.");
        }
    }

    public int desempilhar() {
        if (!estaVazia()) {
            int elemento = elementos[topo];
            topo--;
            return elemento;
        } else {
            System.out.println("A pilha ta vazia.");
            return -1;
        }
    }

    public void listar() {
        if (!estaVazia()) {
            System.out.println("Elementos da pilha:");
            for (int i = topo; i >= 0; i--) {
                System.out.println(elementos[i]);
            }
        } else {
            System.out.println("A pilha ta vazia.");
        }
    }
}

