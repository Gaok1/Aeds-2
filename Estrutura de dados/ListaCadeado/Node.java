    package ListaCadeado;

    public class Node {
        Node sucessor;
        Node antecessor;
        
        int valor;

        Node(int value){
            this.valor = value;
        }

        Node(int x,Node antecessor){
            this.valor = x;
            this.antecessor = antecessor;
        }

    }
