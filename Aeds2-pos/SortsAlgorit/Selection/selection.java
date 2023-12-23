import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * selection
 */
/*
 * 1. selection sort
 * 
 */
public class selection {
    static final int MAX = 22000000;
    static int arr[];
    static int tamanho;
    static int movimentacoes = 0;
    static long comparacoes = 0;
    static long tempoGeracao;
    static long tempoOrdenacao;

    public static void gerarArray() {
        //contar tempo
        long tempoInicial = System.currentTimeMillis();
        int n = MAX;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * MAX);
        }
        tempoGeracao = System.currentTimeMillis() - tempoInicial;
        System.out.println("Tamanho do array: " + arr.length);
        System.out.println("Array desordenado: ");
        
    }

    public static void imprimirArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void imprimirDados() {
        System.out.println();
        System.out.println("Selection SORT");
        System.out.println("Tempo de geração: " + tempoGeracao + "ms");
        System.out.println("Tempo de ordenação: " + tempoOrdenacao + "ms");
        System.out.println("Tamanho do array: " + arr.length);
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public static void Selection() {
        Long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int menorIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[menorIndex] > arr[j]) { // j é menor que o menorIndex
                    menorIndex = j;
                    movimentacoes++;
                }
                comparacoes++;
            }
            int aux = arr[menorIndex];
            arr[menorIndex] = arr[i];
            arr[i] = aux;
            movimentacoes+=3;
        }
        tempoOrdenacao = (System.currentTimeMillis() - tempoInicial);
    }

   public static void escreverEmArquivo(String nomeArquivo) {
        // Obtém uma instância do NumberFormat para a formatação
        NumberFormat formatador = NumberFormat.getInstance();
        formatador.setGroupingUsed(true); // Ativa a formatação com grupos

        String conteudo = "Selection SORT\n" +
                "Tempo de geração: " + formatador.format(tempoGeracao) + "ms\n" +
                "Tempo de ordenação: " + formatador.format(tempoOrdenacao) + "ms\n" +
                "Comparacoes: " + formatador.format(comparacoes) + "\n" +
                "Movimentacoes: " + formatador.format(movimentacoes) + "\n" +
                "Tamanho do array: " + formatador.format(arr.length) + "\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        gerarArray();
        System.out.println();
        Selection();
        System.out.println("Array ordenado: ");
        imprimirDados();
        escreverEmArquivo("selection.txt");

    }
}