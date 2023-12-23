import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

class TreeSort {

    static int MAX = 22000000;
    static Arvore arvore = new Arvore();
    static long tempoGeracao;
    static long tempoOrdenacao;
    static long comparacoes = 0;
    static long movimentacoes = 0;

    public static void gerarArvore() {
        for (int i = 0; i < MAX; i++) {
            arvore.inserir((int) (Math.random() * MAX));
        }
    }


    public static void imprimirDados() {

        System.out.println("TREE SORT");
        System.out.println("Tempo de geração: " + tempoGeracao + "ms");
        System.out.println("Tempo de ordenação: " + tempoOrdenacao + "ms");
        System.out.println("Comparacoes: " + comparacoes);
        System.out.println("Movimentacoes: " + movimentacoes);
        System.out.println("Tamanho do array: " + MAX);
    }

    public static void escreverEmArquivo(String nomeArquivo) {
        // Formatar os números para incluir pontos a cada três casas decimais
        DecimalFormat formatador = new DecimalFormat("#,###");

        String conteudo = "TREE SORT\n" +
                "Tempo de geração: " + formatador.format(tempoGeracao) + "ms\n" +
                "Tempo de ordenação: " + formatador.format(tempoOrdenacao) + "ms\n" +
                "Comparacoes: " + formatador.format(comparacoes) + "\n" +
                "Movimentacoes: " + formatador.format(movimentacoes) + "\n" +
                "Tamanho do array: " + formatador.format(MAX) + "\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long tempogeracaoInicial = System.currentTimeMillis();

        
        gerarArvore();
        
        tempoGeracao = System.currentTimeMillis() - tempogeracaoInicial;

        long inicio = System.currentTimeMillis();
        tempoOrdenacao = System.currentTimeMillis() - inicio;

        comparacoes += arvore.comparacoes;
        movimentacoes += arvore.movimentacoes;
        System.out.println("Array ordenado:");
        System.out.println();
        escreverEmArquivo("TREESORTDADOS.TXT");
    }
}

class Arvore {

    public static class Node {

        int valor;
        Node esquerda;
        Node direita;

        public Node(int valor) {
            this.valor = valor;
            esquerda = null;
            direita = null;
        }
    }

    Node raiz;
    long comparacoes = 0;
    long movimentacoes = 0;
    int indice = 0;

    public Arvore() {
        raiz = null;
    }

    public int[] toArray() {
        int[] arr = new int[TreeSort.MAX];
        toArray(raiz, arr);
        return arr;
    }

    public void toArray(Node node, int[] arr) {
        if (node == null) {
            comparacoes++; // comparaçao do if
            return;
        }
        comparacoes++;// comparaçao do if
        toArray(node.esquerda, arr);
        arr[indice] = node.valor;
        movimentacoes++;
        indice++;
        toArray(node.direita, arr);
    }

    public void imprimir() {
        imprimir(raiz);
    }

    public void imprimir(Node node) {
        if (node == null) {
            return;
        }
        imprimir(node.esquerda);
        System.out.print(node.valor + ";");

        imprimir(node.direita);
    }

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
        } else {
            inserir(raiz, valor);
        }
    }

    public void inserir(Node node, int valor) {
        if (valor < node.valor) {
            comparacoes++;
            if (node.esquerda != null) {
                inserir(node.esquerda, valor);
            } else {
                node.esquerda = new Node(valor);
                movimentacoes++;
            }
            comparacoes++;
        } else {
            if (node.direita != null) {
                inserir(node.direita, valor);
            } else {
                node.direita = new Node(valor);
                movimentacoes++;
            }
            comparacoes++;
        }
    }
}
