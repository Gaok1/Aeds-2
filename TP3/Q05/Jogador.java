
import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class Lista {
    private Node ultimo;
    private Node primeiro;

    public Node getUlitmo() {
        return ultimo;
    }

    public Node getprimeiro() {
        return primeiro;
    }

    public void setprimeiro(Node x) {
        this.primeiro = x;
    }

    public void setUltimo(Node x) {
        this.ultimo = x;
    }

    public void inserirInicio(Jogador x) {

        if (primeiro == null) {
            primeiro = new Node(x);
            return;
        }
        Node temp = new Node(x);
        temp.setProx(primeiro);
        primeiro = temp;

    }

    public void inserirFinal(Jogador x) {
        if (primeiro == null) {
            primeiro = ultimo = new Node(x);
        }else{
            
        ultimo.setProx(new Node(x));
        ultimo = ultimo.getProx();
        }


    }

    public void inserir(int pos, Jogador x) {
        Node temp = primeiro;
        for (int i = 1; i < pos; i++) { // para no anterior ao index
            if (temp == null)
                return;

            temp = temp.getProx();
        }
        Node port = temp.prox;
        temp.setProx(new Node(x));
        temp.getProx().setProx(port);

    }

    public void removerInicio() {
        if (primeiro != null){

         System.out.println("(R) " + primeiro.getValue().getNome());
        primeiro = primeiro.prox;
        }
    }

    public void removerFinal() {
        if (ultimo != null) {
            System.out.println("(R) " + ultimo.getValue().getNome());
            if (primeiro == ultimo) {
                ultimo = primeiro = null;
                return;
            }
                Node temp = primeiro;
                while (temp.prox != ultimo) {
                    temp = temp.prox;
                }
                ultimo = temp;
                temp.setProx(null);
        }
    }

    public void remover(int pos){
        Node temp = primeiro;
        
        for(int i = 1; i<pos; i++){
            temp = temp.prox;
        }
        System.out.println("(R) " + temp.getProx().getValue().getNome());
        temp.setProx(temp.getProx().getProx());
    }

    public void imprimirLista() {
        Node temp = primeiro;
        int i = 0;
        while (temp != null) {

            Jogador.imprimir(temp.getValue(), i);
            temp =temp.getProx();
            i++;
        }
    }

}

class Node {
    Jogador value;
    Node prox;

    Node(Jogador x) {
        this.value = x;
    }

    public Node getProx() {
        return this.prox;
    }

    public void setProx(Node x) {
        this.prox = x;
    }

    public Jogador getValue() {
        return this.value;
    }

    public void setValue(Jogador x) {
        this.value = x;
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
    public static int tamanho = 0;

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
    public static void imprimir(Jogador J, int pos) {

        MyIO.println("[" + pos + "]" + " ## " + J.getNome() + " ## " + J.getAltura() + " ## " + J.getPeso() + " ## "
                + J.getAnoNascimento() + " ## " + J.getUniversidade() + " ## " + J.getCidadeNascimento() + " ## "
                + J.getEstadoNascimento() + " ##");
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
                lista.inserirFinal(time[id]);
                tamanho++;
            }
        }

        
        int repet = MyIO.readInt();   
        for(int i = 0; i<repet; i++){
            String entrada = MyIO.readString();

            if (entrada.equals("II")) { // ==================Inserções
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                lista.inserirInicio(temp);

            } else if (entrada.equals("IF")) {
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                lista.inserirFinal(temp);

            } else if (entrada.equals("I*")) {
                int pos = MyIO.readInt();
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                lista.inserir(pos, temp);
            } //
            else if (entrada.equals("RI")) { // ==================Remoções
                lista.removerInicio();

            } else if (entrada.equals("RF")) {
                lista.removerFinal();

            } else if (entrada.equals("R*")) {
                int pos = MyIO.readInt();
                lista.remover(pos);
            }
            
        }
        lista.imprimirLista();

    }
}
