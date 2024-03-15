
public class RedBlack { // fazer uma redBlackTree
    
    class Node {
        Jogador value;
        Node esq;
        Node dir;
        boolean cor; // true para ser irmao de alguem preto e false para ser irmao de alguem vermelho

        Node(Jogador x) {
            this.value = x;
            this.esq = null;
            this.dir = null;
            this.cor = false;
        }

        Node(Jogador x, boolean cor) {
            this.value = x;
            this.esq = null;
            this.dir = null;
            this.cor = cor;
        }

        public boolean IsNoTipo4() {
            return (this.esq != null && this.dir != null && this.esq.cor == true && this.dir.cor == true);
            // vai ser tipo 4 quando o no tiver dois filhos vermelhos
        }

    }

    RedBlack() {
        this.root = null; // raiz da arvore, na redblack sempre será preta na white black sempre sera
                          // branca (false)
    }

    private Node root;

    public void imprimir() {
        imprimir(this.root);
    }

    public void inserir(Jogador x) {
        validarInsercao(x);
    }

    private boolean isRaiz(Node no) {
        return no == this.root;
    }

    private void fragmentarNoTipo4(Node no) {
        if (no.IsNoTipo4()) { // se for tipo 4
            no.cor = true; // vai ficar vermelho
            no.esq.cor = no.dir.cor = false; // filho esquerdo vai ficar preto
            // a fragmentaçao envolve o no subir (vira gemeo do pai) e seus gemeos se tornam
            // seus filhos
        }
    }

    private void validarInsercao(Jogador jogador) { // Inserir os 3 primeiros na mãozita
        if (this.root == null) {
            // Se a árvore estiver vazia, cria um novo nó raiz
            this.root = new Node(jogador);
            this.root.cor = false; // Define a cor do nó raiz como branco
        } else if (this.root.esq == null && this.root.dir == null) { // arvore com 1 elemento
            if (jogador.getNome().compareTo(this.root.value.getNome()) < 0) { // se o jogador for menor que a raiz
                this.root.esq = new Node(jogador,false); // vai ser filho esquerdo
            } else {
                this.root.dir = new Node(jogador,false); // vai ser filho direito
              
            }
        } else if (this.root.esq == null) {// arvore com 2 elementos (raiz e a direita)

            if (jogador.getNome().compareTo(this.root.value.getNome()) < 0) { // se o jogador for menor que a raiz
                this.root.esq = new Node(jogador,false); // vai ser filho esquerdo
            } else {
                if (jogador.getNome().compareTo(this.root.dir.value.getNome()) < 0) { // se o jogador for menor que o
                                                                                      // filho direito
                    this.root.esq = new Node(this.root.value,false); // filho esquerdo recebe o jogador
                    this.root.value = jogador; // raiz recebe o jogador
                } else { // arvore direta para a direita(novo no é maior q filho da direita q é maior q a
                         // raiz)
                    this.root.esq = new Node(this.root.value,false);
                    this.root.value = this.root.dir.value;
                    this.root.dir.value = jogador;
                }
            }
            this.root.esq.cor = false;
        } else if (this.root.dir == null) { // 2 elemetos (raiz, esquerda)
            if (jogador.getNome().compareTo(this.root.value.getNome()) > 0) {
                this.root.dir = new Node(jogador,false);
            } else {
                if (jogador.getNome().compareTo(this.root.esq.value.getNome()) > 0) {// joelho para a esquerda
                    this.root.dir = new Node(this.root.value,false);
                    this.root.value = jogador;

                } else { // balanceamento simples (esq,esq,esq);
                    this.root.dir = new Node(this.root.value,false);
                    this.root.value = this.root.esq.value;
                    this.root.esq.value = jogador;
                }
            }
        } else {// 3 ou mais elementos
            inserir(null, null, null, this.root, jogador);
        }
        this.root.cor = false;

    }

    private void inserir(Node bisavo, Node avo, Node pai, Node i, Jogador jogador) { // apenas é chamado quando tem 3 ou mais elementos
        if (i == null) { // inserçao do No
            i = new Node(jogador, true);
            if (jogador.getNome().compareTo(pai.value.getNome()) < 0) { // atribuiçao do pai
                pai.esq = i;
            } else {// atribuiçao do pai
                pai.dir = i;
            }
            if (pai.cor) {
                Balancear(bisavo, avo, pai, i);
            }
        } else {
            if (i.IsNoTipo4()) { //se tipo 4, deve fragmentar
                fragmentarNoTipo4(i);
                if (isRaiz(i)) { //raiz nao é gemea de ninguem
                    i.cor = false;
                }
                if(pai!=null){ //com as fragmentaçoes, os filhos da raiz podem ser tornar gemeos. ai fragmenta dnv
                    if (pai.cor == true) {
                    Balancear(bisavo, avo, pai, i);
                }
            }
                }
                
            if (jogador.getNome().compareTo(i.value.getNome()) < 0) {
                inserir(avo, pai, i, i.esq, jogador);
            } else if (jogador.getNome().compareTo(i.value.getNome()) > 0) {
                inserir(avo, pai, i, i.dir, jogador);
            } else {
                // nao insere;
            }
        }

    }

    private void Balancear(Node bisavo, Node avo, Node pai, Node i){
        if(pai.cor == true){
            if(pai.value.getNome().compareTo(avo.value.getNome()) > 0){//pai na direita
                if(i.value.getNome().compareTo(pai.value.getNome()) > 0){ //rotacao simples para esquerda
                    avo = rotacaoEsq(avo);
                }else{//rotacao dir esq (joelho para direita)
                    avo = rotacaoDirEsq(avo);
                }
            }else{//pai na esquerda
                if(i.value.getNome().compareTo(pai.value.getNome()) < 0){ //rotaçao simples para direita
                    avo = rotacaoDir(avo);
                }else{ //rotaçao esq dir (joelho para esquerda)
                    avo = rotacaoEsqDir(avo);
                }
            }
            if(bisavo == null){
                this.root = avo;
            }else if(avo.value.getNome().compareTo(bisavo.value.getNome()) < 0){
                bisavo.esq = avo;
            }else{
                bisavo.dir = avo;
            }
            avo.cor = false;
            avo.dir.cor= avo.esq.cor = true;
        }//else nao balanceia
    }

    private Node rotacaoDir(Node avo){
        Node aux = avo.esq;
        avo.esq = aux.dir;
        aux.dir = avo;
        return aux;
    }
    private Node rotacaoEsq(Node avo){
        Node aux = avo.dir;
        avo.dir = aux.esq;
        aux.esq = avo;
        return aux;
    }

    private Node rotacaoEsqDir(Node avo){
        avo.esq = rotacaoEsq(avo.esq);
        avo = rotacaoDir(avo);
        return avo;
    }
    private Node rotacaoDirEsq(Node avo){
        avo.dir = rotacaoDir(avo.dir);
        avo = rotacaoEsq(avo);
        return avo;
    }
    public void imprimir(Node temp) {
        if (temp != null) {
            imprimir(temp.esq);
            System.out.println(temp.value.getNome());
            imprimir(temp.dir);
        }
    }

    public void pesquisar(String x) {
        System.out.print(x + " raiz");
        pesquisar(this.root, x);

    }

    public void pesquisar(Node temp, String x) {

        if (temp == null) {
            System.out.print(" NAO\n");
            return;
        }
        if (temp.value.getNome().equals(x)) {
            System.out.print(" SIM\n");

        } else if (x.compareTo(temp.value.getNome()) < 0) {
            System.out.print(" esq");
            pesquisar(temp.esq, x);

        } else {
            System.out.print(" dir");
            pesquisar(temp.dir, x);
        }

    }
}


class Jogador{
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador(){
        this.nome = "";
        this.altura = 0;
        this.peso = 0;
        this.universidade = "";
        this.anoNascimento = 0;
        this.cidadeNascimento = "";
        this.estadoNascimento = "";
    }
    public Jogador(String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    public int getAltura(){
        return this.altura;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }
    public int getPeso(){
        return this.peso;
    }
    public void setUniversidade(String universidade){
        this.universidade = universidade;
    }
    public String getUniversidade(){
        return this.universidade;
    }
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }
    public int getAnoNascimento(){
        return this.anoNascimento;
    }
    public void setCidadeNascimento(String cidadeNascimento){
        this.cidadeNascimento = cidadeNascimento;
    }
    public String getCidadeNascimento(){
        return this.cidadeNascimento;
    }
    public void setEstadoNascimento(String estadoNascimento){
        this.estadoNascimento = estadoNascimento;
    }
    public String getEstadoNascimento(){
        return this.estadoNascimento;
    }

}