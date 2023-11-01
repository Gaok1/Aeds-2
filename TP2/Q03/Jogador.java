
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static int[] PesquisaSequencial(Jogador[] array, String nome, int id) {
        int comp = 0;
        int resp = 0;
        if (id == -1) {
            for (int i = 0; i < array.length; i++) {
                comp++;
                if (array[i].getNome().equals(nome)) {
                    resp = 1;
                    i = array.length;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                comp++;
                if (array[i].getId() == id) {
                    resp = 1;
                    i = array.length;
                }
            }
        }

        int[] retorno = new int[2];
        retorno[0] = resp;
        retorno[1] = comp;
        return retorno;
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

    public static void Documentar(long tempoDeExecucao, int numeroDeComparacoes) throws Exception {
        String matricula = "1441283"; // Substitua com sua matrícula
        long diferencadetempo = System.currentTimeMillis() - tempoDeExecucao;

        String caminhoDoArquivoDeLog = "C:\\Users\\Gaok1\\Desktop\\PUC\\Aeds 2\\TP2\\Java\\matricula_sequencial.txt";
        FileWriter logEscritor = new FileWriter(caminhoDoArquivoDeLog);
        BufferedWriter bufferLogEscritor = new BufferedWriter(logEscritor);

        // Escreva as informações de log separadas por tabulação
        bufferLogEscritor.write(matricula + "\t" + diferencadetempo + "\t" + numeroDeComparacoes);

        // Feche o BufferedWriter do arquivo de log
        bufferLogEscritor.close();

    }

    public static void main(String[] args) throws Exception {
        long tempoDeExecucao = System.currentTimeMillis(); // Tempo atual em milissegundos
        File arquivo = new File("/tmp/players.csv"); // Substitua pelo caminho do seu arquivo CSV
        Jogador time[] = new Jogador[3922];

        try (RandomAccessFile raf = new RandomAccessFile(arquivo, "r")) {
            raf.readLine(); // Pula a primeira linha

            String linha;
            int i = 0;

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
        Jogador pesquisa[] = new Jogador[400];

        for (int i = 0; true; i++) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int aux = Integer.parseInt(entrada);
                pesquisa[i] = time[aux];
            }

        }

        // realloc
        pesquisa = Realloc(pesquisa);

        int comp = 0;
        // pesquisar no array
     
      
        while (true) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int resp[] = new int[2];
                resp = PesquisaSequencial(pesquisa, entrada, -1);
                comp += resp[1];
                if (resp[0] == 1) {
                    MyIO.println("SIM");
                } else {
                    MyIO.println("NAO");
                }
            }
        }

        Documentar(tempoDeExecucao, comp);

    }

}
