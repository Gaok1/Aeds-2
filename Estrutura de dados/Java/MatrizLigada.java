import javax.swing.*;
import java.awt.*;




public class MatrizLigada extends JPanel {


    class Node {
    protected int valor;
    protected Node cima;
    protected Node baixo;
    protected Node esq;
    protected Node dir;

    Node() {

    }

    Node(int valor) {
        this.valor = valor;
    }

    // getters
    public Node getCima() {
        return cima;
    }

    public Node getBaixo() {
        return baixo;
    }

    public Node getEsq() {
        return esq;
    }

    public Node getDir() {
        return dir;
    }

    public int getValor() {
        return valor;
    }

    // setters
    public void setCima(Node cima) {
        this.cima = cima;
    }

    public void setBaixo(Node baixo) {
        this.baixo = baixo;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
    int linhas;
    int colunas;
    Node inicio; // posicao 0x0 na matriz






    MatrizLigada() {

    }

    public void gerarMatriz(int linhas, int colunas) {
        preencher();
    }

    MatrizLigada(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        preencher();
    }

    MatrizLigada(int linhas, int colunas, int valor) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.inicio = new Node(valor);
        preencher();
    }

    protected void criarLinhas() {
        Node temp = inicio;
        for (int i = 1; i < linhas; i++) {
            Node novo = new Node(1);
            temp.setBaixo(novo);
            novo.setCima(temp);
            temp = novo;
        }
    }

    public void preencher() {
        if (inicio == null) {
            inicio = new Node(3);
        }
        criarLinhas();
        Node C1 = inicio;
        Node C2 = inicio.getBaixo();
        for (int i = 1; i < linhas; i++) {
            C1.setBaixo(C2);
            C2.setCima(C1);
            criarColunas(C1, C2);
            C1 = C2;
            C2 = C2.getBaixo();
        }
    }

    protected void criarColunas(Node C1, Node C2) { // C1 é acima de C2
        for (int i = 1; i < colunas; i++) {
            Node nextC1;
            Node nextC2 = new Node(1);
            if (C1.getDir() != null) { // já fez direcionamento nessa linha
                nextC1 = C1.getDir();
            } else { // linha precisa de direcionamento
                nextC1 = new Node(1);
                C1.setDir(nextC1);
                nextC1.setEsq(C1);
            }
            nextC1.setBaixo(nextC2);
            C2.setDir(nextC2);
            nextC2.setEsq(C2);
            nextC2.setCima(nextC1);
            C1 = nextC1;
            C2 = nextC2;
        }
    }
    public void print() {
        Node linhaTemp = inicio;
        Node ColunaTemp;
        for (; linhaTemp != null; linhaTemp = linhaTemp.getBaixo()) {
            ColunaTemp = linhaTemp;
            for (; ColunaTemp != null; ColunaTemp = ColunaTemp.getDir()) {
                System.out.print(ColunaTemp.getValor() + " ");
            }
            System.out.println();
        }
    }
    public void printarDiagonal(){
        Node temp = inicio;
        while(true){
            System.out.print(temp.valor+" ");

            temp = temp.baixo;
            if(temp == null){
                break;
            }
            temp = temp.dir;
        }
        System.out.println();
    }

    public void printarDiagonalInversa(){
        Node temp = inicio;
        while (temp.getDir() != null) {
            temp = temp.getDir();
        }
        while(true){
            System.out.print(temp.getValor() +" ");
            if(temp.getBaixo()== null){
                break;
            }
            temp = temp.getBaixo().getEsq();
        }
        System.out.println();
    }

    public void setPos(int linhax, int colunax, int x) { // indice de vetor
        Node elemento = inicio;
          for (int i = 0; i < colunax; i++) {
            elemento = elemento.getDir();
        }

        for (int i = 0; i < linhax; i++) {
            elemento = elemento.getBaixo();
        }
        elemento.setValor(x);
        System.out.println();
        print();
    }

    public static void main(String args[]) {
        MatrizLigada matriz = new MatrizLigada(4,4);
        matriz.print();
       
       for(int i = 0; i<matriz.linhas; i++){
           for(int j = 0; j<matriz.colunas; j++){
               matriz.setPos(i, j, i+j);
           }
       }
        
        matriz.printarDiagonal();
        matriz.printarDiagonalInversa();
       matriz.initGUI("Matriz completa");

    }


    

    public void initGUI(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharMatriz(g);
    }

    private void desenharMatriz(Graphics g) {
        Node linhaTemp = inicio;
        Node colunaTemp;

        int cellSize = 30; // Adjust the cell size as needed
        int x = 50, y = 50; // Initial position

        for (int i = 0; i < linhas; i++) {
            colunaTemp = linhaTemp;
            for (int j = 0; j < colunas; j++) {
                g.drawRect(x, y, cellSize, cellSize);
                g.drawString(Integer.toString(colunaTemp.getValor()), x + 10, y + 20);
                colunaTemp = colunaTemp.getDir();
                x += cellSize; // Move to the next column
            }
            x = 50; // Reset X for the next row
            y += cellSize; // Move to the next row
            linhaTemp = linhaTemp.getBaixo();
        }
    }
    

}
