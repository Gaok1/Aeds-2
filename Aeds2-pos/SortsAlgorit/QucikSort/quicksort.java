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
public class quicksort {
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
        System.out.println("Qucik SORT");
        System.out.println("Tempo de geração: " + tempoGeracao + "ms");
        System.out.println("Tempo de ordenação: " + tempoOrdenacao + "ms");
        System.out.println("Tamanho do array: " + arr.length);
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public static void QuickSort() {
        Long tempoInicial = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        tempoOrdenacao = System.currentTimeMillis() - tempoInicial;
    }
    public static void quickSort(int arr[], int inicio, int fim) {
        if (inicio < fim) {
            int p = particao(arr, inicio, fim);
            quickSort(arr, inicio, p - 1);
            quickSort(arr, p + 1, fim);
        }
    }
    public static int particao(int arr[], int inicio, int fim) {
        int pivo = arr[fim];
        int i = (inicio - 1);
        for (int j = inicio; j < fim; j++) {
            comparacoes++;
            if (arr[j] <= pivo) {
                i++;
                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
                movimentacoes+=3;
            }
        }
        int aux = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = aux;
        movimentacoes+=3;
        return i + 1;
    }
    

    public static void escreverEmArquivo(String nomeArquivo) {
        // Obtém uma instância do NumberFormat para a formatação
        NumberFormat formatador = NumberFormat.getInstance();
        formatador.setGroupingUsed(true); // Ativa a formatação com grupos

        String conteudo = "Quick SORT\n" +
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
        QuickSort();
        System.out.println("Array ordenado: ");
        escreverEmArquivo("QuickSort.txt");

    }
}