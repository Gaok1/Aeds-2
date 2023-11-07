import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class Pilha {
    private Node Topo;

 

    public Node getUlitmo() {
        return Topo;
    }

 

    public void setTopo(Node x) {
        this.Topo = x;
    }

  

    public void inserir(Jogador x) {
       if(Topo == null){
        Topo = new Node(x);
        return;
       }
       Node newnode = new Node(x);
       newnode.setProx(Topo);
       Topo = newnode;
    }

 

    public void remover() {
        if (Topo != null) {
            Node temp = Topo;
            Topo = Topo.getProx();
            System.out.println("(R) "+temp.getValue().getNome());
        }
       
    }

  

    public void imprimirPilha() {
        Node temp = Topo;
        
        int i = 0;
        while (temp != null) {
            temp =temp.getProx();
            i++;
        }
        int size = i;
        temp = Topo;
        Jogador array[] = new Jogador[size];
        for(int j = 0;j<size;j++,temp = temp.getProx()){
            array[j] = temp.getValue();
        }
        i=0;
        for(int j = size-1;j>=0;j--, i++){
            
            Jogador.imprimir(array[j],i);
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
   static void corrigirpriinpubin(String nomeArquivo){
        
          try {
            
            FileWriter fileWriter = new FileWriter(nomeArquivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            
            bufferedWriter.newLine();//adicinando nova linha na entrada

        
            bufferedWriter.close();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  

    public static void main(String[] args) throws Exception {
        corrigirpriinpubin("pub.in");
        corrigirpriinpubin("pri.in");
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

       
        Pilha Pilha = new Pilha();

        while (true) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int id = Integer.parseInt(entrada);
                Pilha.inserir(time[id]);
                
            }
        }

    
        
        int repet = MyIO.readInt();   
        for(int i = 0; i<repet; i++){
            String entrada = MyIO.readString();

        if (entrada.equals("I")) {
                int id = MyIO.readInt();
                Jogador temp = getJogadorByID(id, time);
                Pilha.inserir(temp);
            } 
            else if (entrada.equals("R")) {
                Pilha.remover();
            } 
            
        }
        Pilha.imprimirPilha();

    }
}
