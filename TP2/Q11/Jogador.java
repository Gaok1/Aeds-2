
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
    public static int numeroDeComparacoes = 0;
    public static int numeroDeMovimentacoes = 0;
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
                numeroDeComparacoes += 2;
                break;

            } else if (String1.charAt(i) > String2.charAt(i)) {
                numeroDeComparacoes += 4;
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

    public static void inserction(Jogador[] array, int n) {
        for (int i = 0; i < n; i++) {
          int menor = i;
          for (int j = i+1; j < n; j++) {
            if (array[menor].getNome().compareTo(array[j].getNome()) > 0) {
              menor = j;
            }
          }
          swap(menor, i, array);
        }
      }
    
    
      public static void countingsort(Jogador[] array, int n) {
         int maior = array[0].getAltura();
            for (int i = 1; i < n; i++) {
            if (array[i].getAltura() > maior) {
                maior = array[i].getAltura();
            }
            }

        int[] count = new int[maior + 1];

       
    
       
        for (int i = 0; i < n; i++) {
            count[array[i].getAltura()]++;
        }
        // Atualize o array de contagem para representar a posição correta de cada elemento
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

         Jogador[] ordenado = new Jogador[n];

    
        for (int i = n - 1; i >= 0; i--) {
            int altura = array[i].getAltura();
            ordenado[count[altura] - 1] = array[i];
            count[altura]--;
        }
    
        
        
        System.arraycopy(ordenado, 0, array, 0, n);
        }
    

    public static void Documentar() throws Exception {
        String matricula = "1441283"; // Substitua com sua matrícula
        long Tempo = System.currentTimeMillis() - tempoDeExecucao;

        String caminhoDoArquivoDeLog = "C:\\Users\\Gaok1\\Desktop\\PUC\\Aeds 2\\TP2\\Java\\matrícula_insercao.txt";
        FileWriter logEscritor = new FileWriter(caminhoDoArquivoDeLog);
        BufferedWriter bufferLogEscritor = new BufferedWriter(logEscritor);

        // Escreva as informações de log separadas por tabulação
        bufferLogEscritor.write(matricula + "\t" + Tempo + "\t" + numeroDeComparacoes);

        // Feche o BufferedWriter do arquivo de log
        bufferLogEscritor.close();

    }

    public static void main(String[] args) throws Exception {
        tempoDeExecucao = System.currentTimeMillis(); // Tempo atual em milissegundos
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
        Jogador pesquisa[] = new Jogador[1000];

        for (int i = 0; true; i++) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int aux = Integer.parseInt(entrada);
                pesquisa[i] = time[aux];
            }

        }
    
        pesquisa = Realloc(pesquisa);
        inserction(pesquisa, pesquisa.length);
        countingsort(pesquisa, pesquisa.length);
        
        // imprimir
        for (int i = 0; i < pesquisa.length; i++) {
            pesquisa[i].imprimir(pesquisa[i]);
        }

        Documentar();

    }

}

