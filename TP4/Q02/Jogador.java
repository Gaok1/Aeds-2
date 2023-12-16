import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
class Node{
        int key;
        Node esq;
        Node dir;
        SubNode root;
     

        Node(int x){
            this.key = x;
        }

    }

 class SubNode{
        String Nome;
        SubNode esq;
        SubNode dir;

        SubNode(String x){
            Nome = x;
        }
    }


class Arvore{
   
    
    //atributos:
    private Node root;    
    
    //construtor:
    Arvore(){
        CriarArvore();
    }
    //metodos
    private void CriarArvore(){
        int array[] = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10,12,14};
        for(int e:array){
         root  =  inserirNode(e);
        }
        
    }
    private Node inserirNode(int x){
        return inserirNode(root, x);
    }
    private Node inserirNode(Node root, int key){
        if(root == null){
        root = new Node(key);
        }
        if(key < root.key){
            root.esq = inserirNode(root.esq, key);
        }else if(key > root.key){
            root.dir = inserirNode(root.dir, key);
        }
        return root;
    }
    public void inserir(Jogador x){
        inserir(x, root);
    }
    public void inserir(Jogador x, Node tmp){
        int key = x.getAltura()%15;
        if(tmp.key == key){
            tmp.root = inserirSubNode(x, tmp.root);
        }else if(key < tmp.key){ //
            inserir(x,tmp.esq);
        }else if(key > tmp.key){
            inserir(x,tmp.dir);
        }
    }
    private SubNode inserirSubNode(Jogador x, SubNode tmp){
        if(tmp == null){
            return new SubNode(x.getNome());
        }else if(x.getNome().compareTo(tmp.Nome) < 0){
           tmp.esq= inserirSubNode(x, tmp.esq);
        }else if(x.getNome().compareTo(tmp.Nome) > 0){
            tmp.dir = inserirSubNode(x, tmp.dir);
        }
        return tmp;
    }

     public void pesquisarJogador(Jogador jogador) {
        if(jogador == null){
            return;
        }
        boolean encontrado = false;
        System.out.print("raiz" + " ");
        encontrado = buscar(jogador, root, encontrado);
        if (!encontrado) {
            System.out.println("NAO");
        } else {
            System.out.println("SIM");
        }
    }

    private boolean buscar(Jogador jogador, Node node, boolean encontrado) {
      
        if (node != null && !encontrado) {
            encontrado = buscarSubarvore(jogador.getNome(), node.root, encontrado);
            if (!encontrado) {
                System.out.print("esq" + " ");
                encontrado = buscar(jogador, node.esq, encontrado);

                System.out.print("dir" + " ");
                encontrado = buscar(jogador, node.dir, encontrado);
            }
        }
        return encontrado;
    
    }

    private boolean buscarSubarvore(String nome, SubNode nodeSub, boolean encontrado) {
        if (!encontrado && nodeSub != null) {
            if (nodeSub.Nome.equals(nome)) {
                encontrado = true;
                return encontrado;
            }
           
            System.out.print("ESQ" + " ");
            encontrado = buscarSubarvore(nome, nodeSub.esq, encontrado);

            System.out.print("DIR" + " ");
            encontrado = buscarSubarvore(nome, nodeSub.dir, encontrado);

            return encontrado;
        }
        return encontrado;
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
        for (int i = 0; i < array.length; i++) {
            if (array[i].getId() == id) {
                return array[i];
            }
        }
        return null;
    }

    public static Jogador GetJogadorByName(String nome, Jogador array[]) {
        if (nome != null ) {
            for (int i = 0; i < array.length; i++) {
                if(array[i] == null){
                    return null;
                }
                if (array[i].getNome().equals(nome)) {
                    return array[i];
                }
            }
        }
        return null;
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

        Arvore tree = new Arvore();
        // 7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12 e 14.

        while (true) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            } else {
                int id = Integer.parseInt(entrada);
                tree.inserir(time[id]);
            }
        }

        while (true) {
            String entrada = MyIO.readLine();
            if (entrada.equals("FIM")) {
                break;
            }
            Jogador temp = GetJogadorByName(entrada, time);
            tree.pesquisarJogador(temp);
        }

    }
}
