import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;


public class StalinSort {

    static final int MAX = 220000000;
    static int arr[];
    static int tamanho;
    static int movimentacoes = 0;
    static long comparacoes = 0;
    static long tempoGeracao;
    static long tempoOrdenacao;

    public static void gerarArray() {
        // contar tempo
        long tempoInicial = System.currentTimeMillis();
        arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
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
        System.out.println("STALINSORT");
        System.out.println("Tempo de geração: " + tempoGeracao + "ms");
        System.out.println("Tempo de ordenação: " + tempoOrdenacao + "ms");
        System.out.println("Tamanho do array: " + arr.length);
        System.out.println("Movimentações: " + movimentacoes);
        System.out.println("Comparações: " + comparacoes);
    }

    public static void stalinSort() {
        int i = 0;
        int j = 0;
        long tempoInicial = System.currentTimeMillis();
        while (j < arr.length) {
            comparacoes++;
            if (i == 0 || arr[i - 1] <= arr[j]) {
                arr[i] = arr[j];
                i++;
                j++;
                movimentacoes+=3;
            } else {
                movimentacoes++;
                j++;
            }
        }
        tempoOrdenacao = System.currentTimeMillis() - tempoInicial;
        // Redefinir o tamanho do array após a ordenação
        arr = Arrays.copyOf(arr, i); // i é o tamanho do array após a ordenação
        //arrays.copyOf copia o array para um novo array com o tamanho especificado
    }

    public static void escreverEmArquivo(String nomeArquivo) {
        // Obter uma instância do NumberFormat para a formatação
        NumberFormat formatador = NumberFormat.getInstance();
        formatador.setGroupingUsed(true); // Ativar a formatação com grupos

        // Usar DecimalFormat para formatar com três casas decimais
        DecimalFormat formatoDecimal = new DecimalFormat("#.###");

        String conteudo = "STALINSORT\n" +
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
        stalinSort();
        System.out.println("Array ordenado: ");
        imprimirDados();
        escreverEmArquivo("StalinSort.txt");
    }
}
