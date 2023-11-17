

public class Lista {
    public class Node{
        int valor;
        Node anterior;
        Node prox;
        Node(int x){
            this.valor = x;
        }
        public int getValor() {
            return valor;
        }
        public void setValor(int valor) {
            this.valor = valor;
        }
        public Node getAnterior() {
            return anterior;
        }
        public void setAnterior(Node anterior) {
            this.anterior = anterior;
        }
        public Node getProx() {
            return prox;
        }
        public void setProx(Node prox) {
            this.prox = prox;
        }
    }
    Node inicio;
    Node fim;

    public void inserir(int x){
        if( inicio == null){
            this.fim = this.inicio = new Node(x);
            return;
        }

        Node temp = new Node(x);
        temp.anterior = this.fim;
        this.fim.prox = temp;
        this.fim = temp;
        return;

    }

    public void removerFim(){
         if( inicio == null){
            return;
        }else if(inicio == fim){
            inicio = fim = null;
        }
        Node temp = this.fim.anterior;
        this.fim = temp;
        temp.prox = null;
    }
    public static void quicksort(Node esq, Node dir){
        Node i = esq;
        Node j = dir;
        int pivot = dir.valor;
   
        while(true) {
            while (i.valor < pivot) {
                i = i.prox;
                if(i.prox == j){
                    break;
                }
            }
            while (j.valor > pivot) {
                j = j.anterior;
                if(j.anterior == i){
                    break;
                }
            }
            if(i.valor <= j.valor){
                int temp = i.valor;
                i.valor = j.valor;
                j.valor = temp;
                i = i.prox;
                j = j.anterior;
                if(i.prox == j || j.anterior == i){
                    break;
                }
            }
        }
        if(i!=dir ){
            quicksort( i, dir);
        }
        if(j!=esq){
            quicksort(esq,j);
        }

    }

    public static void quicksort(Lista lista){
        quicksort( lista.inicio, lista.fim);
    }


    public static void main(String args[]){
        Lista lista = new Lista();

        for(int i = 0; i<10; i++){
            lista.inserir((int)(Math.random()*100));
        }

        Node temp = lista.inicio;

        for(int i = 0; i<9; i++, temp = temp.prox){
           System.out.print(temp.valor + " ");
        }
        System.out.println("\n QUICKSORT:\n");
        quicksort(lista);

        temp = lista.inicio;
         for(int i = 0; i<9; i++, temp = temp.prox){
           System.out.print(temp.valor + " ");
        }

    }
}
