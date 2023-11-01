
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Scanner;

class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;
    public static int comp = 0;
    public static int mov = 0;
    public static long tempoDeExecucao = 0;

    Jogador() {

    }

    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento,
            String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getPeso() {
        return this.peso;
    }

    public String getUniversidade() {
        return this.universidade;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    public String getCidadeNascimento() {
        return this.cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return this.estadoNascimento;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    // clone
    public Jogador clone(Jogador J) {
        Jogador clonado = new Jogador();
        clonado.id = J.id;
        clonado.nome = J.nome;
        clonado.altura = J.altura;
        clonado.peso = J.peso;
        clonado.universidade = J.universidade;
        clonado.anoNascimento = J.anoNascimento;
        clonado.cidadeNascimento = J.cidadeNascimento;
        clonado.estadoNascimento = J.estadoNascimento;
        return clonado;

    }

    // [3670 ## Peyton Siva ## 183 ## 83 ## 1990 ## University of Louisville ##
    // Seattle ## Washington]
    public void imprimir(Jogador J) {
        MyIO.println("[" + J.getId() + " ## " + J.getNome() + " ## " + J.getAltura() + " ## " + J.getPeso() + " ## "
                + J.getAnoNascimento() + " ## " + J.getUniversidade() + " ## " + J.getCidadeNascimento() + " ## "
                + J.getEstadoNascimento() + "]");
    }

    public Jogador ler(Jogador J) {
        int aux = MyIO.readInt();
        J.setId(aux);
        String aux2 = MyIO.readLine();
        J.setNome(aux2);
        aux = MyIO.readInt();
        J.setAltura(aux);
        aux = MyIO.readInt();
        J.setPeso(aux);
        aux2 = MyIO.readLine();
        J.setUniversidade(aux2);
        aux = MyIO.readInt();
        J.setAnoNascimento(aux);
        aux2 = MyIO.readLine();
        J.setCidadeNascimento(aux2);
        aux2 = MyIO.readLine();
        J.setEstadoNascimento(aux2);
        return J;
    }

    public static String[] handleString(String csv) {
        String novaString = "";
        int countV = 0;
        for (int i = 0; i < csv.length(); i++) {
            if (csv.charAt(i) == ',' && i + 1 < csv.length() && csv.charAt(i + 1) == ',') {
                novaString += ",nao informado";

            } else if (csv.charAt(i) == ',' && i == csv.length() - 1) {
                novaString += ",nao informado";

            } else {
                novaString += csv.charAt(i);
            }
        }

        csv = novaString;

        return csv.split(",");
    }

    public static boolean OrdemAlfabetica(String String1, String String2) {
        boolean resposta = false;
        int i = 0;
        for (; i < String1.length() && i < String2.length(); i++) {
            if (String1.charAt(i) < String2.charAt(i)) {
                resposta = true;
                comp += 2;
                break;

            } else if (String1.charAt(i) > String2.charAt(i)) {
                comp += 4;
                resposta = false;
                break;
            }
        }

        return resposta;

    }

    public static Jogador[] Realloc(Jogador[] array) {
        int tamanho = 0;
        for (int i = 0; i < array.length && array[i] != null; i++) {
            tamanho++;
        }
        Jogador[] novoArray = new Jogador[tamanho];
        for (int i = 0; i < novoArray.length; i++) {
            novoArray[i] = array[i];
        }
        array = novoArray;
        return array;
    }

    public static void swap(int i, int j, Jogador[] array) {
        Jogador temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(Jogador[] array) { // sort
        int n = array.length;
        Merge(array, 0, n - 1);
    }

    public static void Merge(Jogador[] vetor, int esq, int dir) {
        comp++;
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            Merge(vetor, esq, meio);
            Merge(vetor, meio + 1, dir);
            Intercalar(vetor, esq, meio, dir);
        }
    }

    public static void Intercalar(Jogador[] vetor, int esq, int meio, int dir) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        Jogador[] a1 = new Jogador[n1];
        Jogador[] a2 = new Jogador[n2];

        for (int i = 0; i < n1; i++) {
            mov++;
            a1[i] = vetor[esq + i];
        }
        for (int j = 0; j < n2; j++) {
            mov++;
            a2[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0, k = esq;

        while (i < n1 && j < n2) {
            comp += 3;
            if (a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) < 0) {
                vetor[k] = a1[i];
                i++;
            } else if (a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) == 0
                    && a1[i].getNome().compareTo(a2[j].getNome()) < 0) {
                vetor[k] = a1[i];
                i++;
            } else {
                vetor[k] = a2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            mov++;
            vetor[k] = a1[i];
            i++;
            k++;
        }

        while (j < n2) {
            mov++;
            vetor[k] = a2[j];
            j++;
            k++;
        }
    }

    public static void Documentar() throws Exception {
        String matricula = "1441283"; // Substitua com sua matrícula
        long Tempo = System.currentTimeMillis() - tempoDeExecucao;

        String caminhoDoArquivoDeLog = "tmp/1441283matrícula_insercao.txt";
        FileWriter logEscritor = new FileWriter(caminhoDoArquivoDeLog);
        BufferedWriter bufferLogEscritor = new BufferedWriter(logEscritor);

        // Escreva as informações de log separadas por tabulação
        bufferLogEscritor.write(matricula + "\t" + Tempo + "\t" + comp + "\t" + mov);

        // Feche o BufferedWriter do arquivo de log
        bufferLogEscritor.close();

    }

   

    public static void main(String[] args) throws Exception {

    }

}
