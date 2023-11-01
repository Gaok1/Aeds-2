
import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
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
        
        MyIO.println("[" + pos +"]"+ " ## " + J.getNome() + " ## " + J.getAltura() + " ## " + J.getPeso() + " ## "
                + J.getAnoNascimento() + " ## " + J.getUniversidade() + " ## " + J.getCidadeNascimento() + " ## "
                + J.getEstadoNascimento()+ " ##" );
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

    public static void inserirInicio(Jogador J, Jogador array[]) {
        for (int i = tamanho; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = J;
        tamanho++;
    }

    public static void InserirFinal(Jogador J, Jogador array[]) {
        array[tamanho] = J;
        tamanho++;
    }

    public static void inserir(int posicao, Jogador J, Jogador arraay[]) {
        for (int i = tamanho; i > posicao; i--) {
            arraay[i] = arraay[i - 1];
        }
        arraay[posicao] = J;
        tamanho++;
    }

    public static void removerInicio(Jogador array[]) {
        Jogador temp = array[0];
        for (int i = 0; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        MyIO.println("(R) " + temp.getNome());

    }

    public static void removerFinal(Jogador array[]) {
        Jogador temp = array[tamanho - 1];
        array[tamanho - 1] = null;
        tamanho--;
        MyIO.println("(R) " + temp.getNome());
    }

    public static void remover(int pos, Jogador array[]) {
        Jogador temp = array[pos];
        for (int i = pos; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        array[tamanho - 1] = null;
        tamanho--;
        MyIO.println("(R) " + temp.getNome());
    }

    public static Jogador getJogadorByID(int id, Jogador array[]) {
        return array[id];
    }

    public static void imprimirArray(Jogador array[]) {
        Jogador temp = array[0];
        int i = 0;
        while (temp != null) {
            
            imprimir(temp,i);
            i++;
            temp = array[i];
        }
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

        Jogador[] lista = new Jogador[2000];

        for (int i = 0; true; i++) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
               
                break;
            } else {
                int id = Integer.parseInt(entrada);
                lista[i] = time[id];
                tamanho++;
            }
        }
   
        
        int repet = MyIO.readInt();   
        for(int i = 0; i<repet; i++){
            String entrada = MyIO.readString();

            if (entrada.equals("II")) { // ==================Inserções
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                inserirInicio(temp, lista);

            } else if (entrada.equals("IF")) {
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                InserirFinal(temp, lista);

            } else if (entrada.equals("I*")) {
                int pos = MyIO.readInt();
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                inserir(pos, temp, lista);
            } //
            else if (entrada.equals("RI")) { // ==================Remoções
                removerInicio(lista);

            } else if (entrada.equals("RF")) {
                removerFinal(lista);

            } else if (entrada.equals("R*")) {
                int pos = MyIO.readInt();
                remover(pos, lista);
            }
            
        }
        imprimirArray(lista);

    }
}
