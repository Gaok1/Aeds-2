import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; // Certifique-se de importar este MouseEvent
import java.util.*;



public class Arvore {
    private class Node {
        int valor;
        Node esq;
        Node dir;
        int x; // Adicione coordenada x
        int y; // Adicione coordenada y

       
    public Node(int valor) {
        this.valor = valor;
        esq = null;
        dir = null;
        x = 0; // Inicialize a coordenada x
        y = 0; // Inicialize a coordenada y
    }

        public int getValor() {
            return valor;
        }

        public boolean hasdir() {
            return (dir != null);
        }

        public boolean hasesq() {
            return (esq != null);
        }
        
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

    

    private Node root = null;

    Arvore() {
        root = null;
    }

    Arvore(int valor) {
        setRoot(valor);
    }

    public void setRoot(int valor) {
        if (valor == -1) {
            this.root = null;
            System.out.println("matando arvore pela raiz :D");
            return;
        }

        System.out.println("inserindo raiz");
        this.root = new Node(valor);
    }

    public Node getMaior(Node x) {
        if (x.dir == null) {
            return x;
        }
        return getMaior(x.dir);
    }

    public Node getMenor(Node x) {
        if (x.esq == null) {
            return x;
        }
        return getMenor(x.esq);
    }

    public Node getPai(Node x) {
        Node temp = this.root;
        while (temp.esq != x && temp.dir != x) {
            if (x.getValor() < temp.getValor()) {
                temp = temp.esq;
            } else {
                temp = temp.dir;
            }
        }
        return temp;
    }

    public void inserir(int valor) {
        if (this.root == null) {
            setRoot(valor);
            return;
        }
        Node temp = root;
        while (true) {

            if (valor < temp.getValor()) {
                if (temp.hasesq()) {
                    temp = temp.esq;
                } else if(temp.getValor() != valor) {
                    temp.esq = new Node(valor);
                    System.out.println("inserido na esquerda");
                    return;
                }else{
                     System.out.println("valor ja existe");
                    return;
                }
            } else {
                if (temp.hasdir()) {
                    temp = temp.dir;
                } else if(temp.getValor() != valor){
                    temp.dir = new Node(valor);
                    System.out.println("inserido na direita");
                    return;
                }else{
                    System.out.println("valor ja existe");
                    return;}
            }
        }

    }

    public void remover(int valor) {
        Node temp = this.root;

        remover(valor, temp);
    }

    public void remover(int valor, Node temp) {
        if (temp.getValor() == valor) {
            System.out.println("achou o valor :" + valor);
            if (valor == temp.getValor()) {
                if (temp.hasdir()) { // achar o menor da direita
                    Node menor = getMenor(temp.dir);
                    if (menor == temp.dir) {
                        temp.valor = menor.valor;
                        temp.dir = menor.dir;
                    } else {
                        temp.valor = menor.valor;
                        Node pai = getPai(menor);
                        pai.esq = null;
                    }
                } else if (temp.hasesq()) { // achar o maior da esquerda
                    Node maior = getMaior(temp.esq);
                    if (maior == temp.esq) {
                        temp.valor = maior.valor;
                        temp.esq = maior.esq;
                    } else {
                        Node pai = getPai(maior);
                        temp.valor = maior.valor;
                        pai.dir = null;
                    }
                } else {
                    if (temp == this.root) { // root
                        this.root = null;
                    }
                    else {
                        Node pai = getPai(temp);
                        if (pai.esq == temp) {
                            pai.esq = null;
                        } else {
                            pai.dir = null;
                        }
                    }
                }
                return;
            }
        }
        if (valor < temp.getValor() && temp.hasesq()) {
            remover(valor, temp.esq);
        } else if (valor > temp.getValor() && temp.hasdir()) {
            remover(valor, temp.dir);
        }
        return;

    }

    public void printar() {
        System.out.println("\n");
        printar(this.root);
        System.out.println("\n");
    }

    public void printar(Node temp) {
        if (temp.hasesq()) {
            printar(temp.esq);
        }
        System.out.print(" " + temp.getValor());
        if (temp.hasdir()) {
            printar(temp.dir);
        }

    }

    public void desenharArvore() {
        JFrame frame = new JFrame("Árvore Binária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        DesenhoArvore panel = new DesenhoArvore(this.root);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        Arvore tree = new Arvore(10);
        Random rand = new Random();
        int repet = rand.nextInt(15) + 10;
        for (int i = 0; i < repet; i++) {
            tree.inserir(rand.nextInt(100));
        }
        tree.printar();

         SwingUtilities.invokeLater(() -> {
            tree.desenharArvore();
        });

        while (true) {
            System.out.println("digite o numero que deve ser retirao da arvore");
            int x = Integer.parseInt(System.console().readLine());
            tree.remover(x);
             SwingUtilities.invokeLater(() -> {
            tree.desenharArvore();
        });
        }

       

    }

   public class DesenhoArvore extends JPanel {
    private Node raiz;
    private Point mousePressedPoint;

    DesenhoArvore(Node raiz) {
        this.raiz = raiz;

        addMouseListener(new MouseAdapter() {
      
            public void mousePressed(MouseEvent e) {
                mousePressedPoint = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
           
            public void mouseDragged(MouseEvent e) {
                if (mousePressedPoint != null) {
                    int dx = e.getX() - mousePressedPoint.x;
                    int dy = e.getY() - mousePressedPoint.y;
                    mousePressedPoint = e.getPoint();
                    // Atualize as coordenadas dos nós da árvore com dx e dy para mover a tela.
                    // Redesenhe a árvore com as novas coordenadas.
                    atualizarCoordenadasArvore(raiz, dx, dy);
                    repaint(); // Redesenhe a tela
                }
            }
        });

        addMouseListener(new MouseAdapter() {
          
            public void mouseReleased(MouseEvent e) {
                mousePressedPoint = null;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharArvore(g, getWidth() / 2, 30, raiz, getWidth() / 4);
    }

    private void desenharArvore(Graphics g, int x, int y, Node node, int xOffset) {
        if (node == null) {
            return;
        }

        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(Integer.toString(node.getValor()), x - 5, y + 5);

        if (node.hasesq()) {
            int newX = x - xOffset;
            int newY = y + 60;
            g.drawLine(x, y + 15, newX, newY - 15);
            desenharArvore(g, newX, newY, node.esq, xOffset / 2);
        }

        if (node.hasdir()) {
            int newX = x + xOffset;
            int newY = y + 60;
            g.drawLine(x, y + 15, newX, newY - 15);
            desenharArvore(g, newX, newY, node.dir, xOffset / 2);
        }
    }

    private void atualizarCoordenadasArvore(Node node, int dx, int dy) {
        if (node == null) {
            return;
        }

        node.setX(node.getX() + dx);
        node.setY(node.getY() + dy);

        if (node.hasesq()) {
            atualizarCoordenadasArvore(node.esq, dx, dy);
        }

        if (node.hasdir()) {
            atualizarCoordenadasArvore(node.dir, dx, dy);
        }
    }
}
}

