
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.text.Document;

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

 

    public static Jogador[] realloc(Jogador[] vetor){
        int size = 0;
        for(int i = 0; i<vetor.length;i++){
            if(vetor[i]==null){
                break;
            }else{
                size++;
            }
        }
        Jogador newvet[] = new Jogador[size];
        for(int i = 0; i<size;i++){
            newvet[i] = vetor[i];
        }
        vetor = newvet;
        return newvet;

    }
    public static void SelectionSort(Jogador[] vetor, int comp[]) {
        int k = 10; // seleçao parcial
        for (int i = 0; i < vetor.length - 1; i++) {
            comp[0]++;
            int indiceMenor = i;
            
            for (int j = i + 1; j < vetor.length; j++) {
                comp[0] += 2;
            
                if (vetor[j].nome.compareTo(vetor[indiceMenor].nome) < 0) {
                    indiceMenor = j;
                }
            }
            
    
            if (indiceMenor != i) {
                Jogador temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
            }
            if(k==0){
                break;
            }
            k--;
        }
    }
    
      public static void Documentar(long tempoDeExecucao, int numeroDeComparacoes) throws Exception {
        String matricula = "1441283"; // Substitua com sua matrícula
        long diferencadetempo = System.currentTimeMillis() - tempoDeExecucao;

        String caminhoDoArquivoDeLog = "/tmp/1441283_sequencial.txt";
        FileWriter logEscritor = new FileWriter(caminhoDoArquivoDeLog);
        BufferedWriter bufferLogEscritor = new BufferedWriter(logEscritor);

        // Escreva as informações de log separadas por tabulação
        bufferLogEscritor.write(matricula + "\t" + diferencadetempo + "\t" + numeroDeComparacoes);

        // Feche o BufferedWriter do arquivo de log
        bufferLogEscritor.close();

    }

    public static void main(String[] args) throws Exception {
        int comp[] = new int[1];

        long inicio = System.currentTimeMillis();
        File arquivo = new File("/tmp/players.csv"); // Substitua pelo caminho do seu arquivo CSV
        Jogador time[] = new Jogador[4000];

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

        Jogador[] ordenado = new Jogador[1500];

        for (int i = 0; true; i++) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int id = Integer.parseInt(entrada);
                ordenado[i] = time[id];
            }

        }

        ordenado = realloc(ordenado);
        SelectionSort(ordenado,comp);

        for(int i = 0; i<10;i++){
            ordenado[i].imprimir(ordenado[i]);
        }
        Documentar(inicio, comp[0]);
    }

}
