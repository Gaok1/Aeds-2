
import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class Lista {
    class Node {
        Node prox;
        Node ant;
        Jogador Valor;

        Node(Jogador x) {
            Valor = x;
            prox = ant = null;
        }

    }

    Node primeiro;
    Node ultimo;

    Lista() {
        primeiro = ultimo = null;
    }

    Node VenhaAoMundo(Jogador x) {
        return new Node(x);
    }

    public void inserir(Jogador x) {
        if (primeiro == null) {
            primeiro = ultimo = VenhaAoMundo(x);
        } else {
            Node temp = ultimo.prox = VenhaAoMundo(x); // temp apenas para facilitar leitura e entendimento do codigo
            temp.ant = ultimo;
            ultimo = temp;
        }
    }

    public void imprimirLista() {
        Node temp = primeiro;
        while (temp != null) {
            Jogador.imprimir(temp.Valor);
            temp = temp.prox;
        }
    }

    public int tamanho() {
        int count = 0;
        Node temp = primeiro;
        while (temp != null) {
            count++;
            temp = temp.prox;
        }
        return count;
    }

    public Jogador[] parseArray() {
        Jogador array[] = new Jogador[this.tamanho()];
        Node temp = primeiro;
        int i = 0;
        while (temp != null) {
            array[i] = temp.Valor;
            i++;
            temp = temp.prox;
        }
        return array;

    }

    public static Lista arrayToList(Jogador array[]) {
        Lista lista = new Lista();
        for (int i = 0; i < array.length; i++) {
            lista.inserir(array[i]);
        }
        return lista;
    }

    public void QuickSort() {
        Jogador array[] = this.parseArray();
        QuickSort(array, 0, tamanho() - 1);
        Lista temp = arrayToList(array);
        this.primeiro = temp.primeiro;
        this.ultimo = temp.ultimo;
    }

    public int compare(Jogador vet[], int i, Jogador pivot) {
        int result = vet[i].getEstadoNascimento().compareTo(pivot.getEstadoNascimento());
        if (result != 0) {
            return result;
        }
        return vet[i].getNome().compareTo(pivot.getNome());
    }

    public void QuickSort(Jogador array[], int esq, int dir) {
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array.length; j++){
                if(compare(array, i, array[j]) < 0){
                    Jogador temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
       /* int i = esq, j = dir;
        Jogador pivo = array[(dir + esq) / 2];

        while (i < j) {
            while (compare(array, i, pivo) < 0){
                i++;
            }
            while (compare(array, j,pivo) > 0){
                j--;
            }

            Jogador temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        if(i<dir){
            QuickSort(array, i, dir);
        }

        if(j>esq){
            QuickSort(array, esq, j);
        }*/

    }
}

public class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

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
    public static void imprimir(Jogador J) {
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

    public static Jogador getJogadorByID(int id, Jogador array[]) {
        return array[id];
    }

    public static void main(String[] args) throws Exception {

        File arquivo = new File("/tmp/players.csv"); // Substitua pelo caminho do seu arquivo CSV
        Jogador time[] = new Jogador[3923];

        try (RandomAccessFile raf = new RandomAccessFile(arquivo, "r")) {
            raf.readLine(); // Pula a primeira linha

            String linha;
            int i = 0;
            // Lê as linhas E instancia os objetos
            while ((linha = raf.readLine()) != null) {
                String[] array = handleString(linha);

                Jogador jogador = new Jogador();
                jogador.setId(Integer.parseInt(array[0]));
                jogador.setNome(array[1]);
                jogador.setAltura(Integer.parseInt(array[2]));
                jogador.setPeso(Integer.parseInt(array[3]));
                jogador.setUniversidade(array[4]);
                jogador.setAnoNascimento(Integer.parseInt(array[5]));
                jogador.setCidadeNascimento(array[6]);
                jogador.setEstadoNascimento(array[7]);

                time[i] = jogador;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Lista lista = new Lista();

        while (true) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int id = Integer.parseInt(entrada);
                lista.inserir(time[id]);
            }
        }
        lista.QuickSort();
        lista.imprimirLista();

    }
}
