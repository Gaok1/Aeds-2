package Arvore;

public class ListaCadeado {
    Node atual;


    ListaCadeado(){
    
    }

    ListaCadeado(int valor){ //inicializando com Node
        atual = new Node(valor);
    }


    void AddNode(int value){
       if(atual == null){//primeiro no adicionado a lista
        System.out.println("criando Node");
        atual = new Node(value);
        
        
       }else{
        //setando o novo atual e defininindo o proximo do anterior
        Node newNode = new Node(value,atual); // atual é mandado como antecessor
        atual.sucessor = newNode; //o node criado é mandado como sucessor
        atual = newNode;
        

       }

    }

    void RemoveNode(){ // removendo estilo pilha
        if(atual.antecessor == null){
            atual = null;   
        }else{
            atual = atual.antecessor;
            atual.sucessor = null;         
        }

    }
    void RemoveNode(int valor, Node node){
        if(valor == node.valor){//encontrou o valor procurado para RemoveNode
            if(node.sucessor==null){ // remove o ultimo
                RemoveNode();
            }else{
                if(node.antecessor != null){
                    node.antecessor.sucessor = node.sucessor;
    
                }
                
                    node.sucessor.antecessor = node.antecessor;
            }
                
                
        }else if(node.antecessor == null){
            System.out.println("Valor não encontrado");
            return;

        }else{
            RemoveNode(valor, node.antecessor);
        }
    }


    void RemoveNode(int valor){
        RemoveNode(valor, atual);
    }


    void print(Node node){
        if(node.antecessor == null){
            System.out.print(node.valor + " ");
            return;
        }else{
            print(node.antecessor);
            System.out.print(node.valor + " ");
        }

    }

    void print(){
        System.out.println("======Printando=====");
        print(atual);
        System.out.println("\n");
    }

    



    public static void main(String[] args) {
        ListaCadeado lista = new ListaCadeado();

        for(int i = 0 ; i<=5;i++){
            lista.AddNode(i);
        }
        lista.RemoveNode(5 );

        lista.print();

        lista.RemoveNode(1);
        lista.print();
        lista.RemoveNode(0);
        lista.RemoveNode(10);
        lista.RemoveNode(4);
        lista.print();
    }
}



