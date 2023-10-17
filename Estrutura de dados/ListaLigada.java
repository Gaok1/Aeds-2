class Node {
    public Node prox;
    int valor;

    public Node(int valor) {
        this.valor = valor;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }

    public Node getProx() {
        return this.prox;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}

class ListaLigada {
    public Node inicio;
    public Node fim;
    public int tamanho = 0;

    public static void main(String[] args) {
        // tester fila
        int valores[] = new int[8];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = i;
        }

        ListaLigada fila = new ListaLigada(valores);
        fila.printar();
        System.out.println();
        fila.inserirFim(10);
        fila.inserirInicio(0);
        fila.inserirPos(11, 1);
        fila.printar();
        fila.inverter();
        System.out.println();
        fila.printar();
    }

    ListaLigada() {

    }

    ListaLigada(int valor) {
        Node novo = new Node(valor);
        inicio = fim = novo;
    }

    ListaLigada(int valores[]) {
        Node novo = new Node(valores[0]);
        inicio = fim = novo;
        tamanho++;

        for (int i = 1; i < valores.length; i++) {
            novo = new Node(valores[i]);

            fim.setProx(novo);
            fim = novo;
            tamanho++;
        }
    }

    public void inverter() { //Autoria : Luis Phillip Lemos Martins
        
        Node temp1, temp2; // Variáveis temporárias para trocar nós
    
        temp2 = fim; // Inicializa temp2 com o nó final da lista.
        while (inicio.getProx() != null) { // Verifica se a lista não está totalmente invertida.
            temp1 = inicio;
            while (temp1.getProx() != temp2) {
                temp1 = temp1.getProx(); // Percorre a lista até o nó anterior a temp2.
            }
    
            temp2.setProx(temp1); // Atualiza a referência do próximo nó de temp2 para apontar para temp1.
            temp2 = temp2.getProx(); // Move temp2 para o próximo nó.
            if (temp1 == inicio) {
                temp1.setProx(null); // Se temp1 é o início e o temp 2 é seu proximo, atualiza seu próximo como nulo.
            }
        }
    
        // Troca o início e o fim da lista para finalizar a inversão.
        Node passe = inicio;
        inicio = fim;
        fim = passe;
        return;
    }
    

    public void printar() {
        print(inicio);
    }

    protected void print(Node nop) {

        if (nop == null) {
            return;
        }

        System.out.print(nop.valor + " ");
        print(nop.getProx());

    }

    public void inserirFim(int valor) {
        tamanho++;
        if (inicio == null) {
            inicio = fim = new Node(valor);
            return;
        }
        Node novo = new Node(valor);
        fim.setProx(novo);
        fim = novo;
    }

    public void inserirInicio(int valor) {
        if (inicio == null) {
            inicio = fim = new Node(valor);
            return;
        }
        tamanho++;
        Node temp = new Node(valor);
        temp.prox = inicio;
        inicio = temp;
    }

    public void inserirPos(int pos, int valor) { // pos de inicio é 1
        tamanho++;
        if (pos == 0 || pos == 1) {
            inserirInicio(valor);
            return;
        } else if (pos == tamanho + 1) {
            inserirFim(valor);
            return;
        }

        Node temp = inicio;
        for (int i = 1; temp.prox != null; i++, temp = temp.getProx()) {
            if (i + 1 == pos) {
                Node novo = new Node(valor);
                novo.setProx(temp.getProx());
                temp.setProx(novo);
            }
        }

    }

    public Node removerInicio() {

        if (inicio == null) {
            return null;
        }

        tamanho--;
        Node temp = inicio;
        inicio = inicio.getProx();
        return temp;

    }

    public Node removerFinal() {
        if (inicio == null) {
            return null;
        }
        tamanho--;
        Node temp = inicio.getProx();
        while (temp.prox != fim) { // ate chegar na posiao anterior do fim;
            temp = temp.getProx();
        }
        fim = temp; // fim agora apontará para seu anterior;
        temp = temp.getProx(); // temp agora é fim (prestes a ser removido)
        fim.setProx(null); // fim foi removido
        return temp; // retornando a ultima referencia do Node;
    }

    public Node remover(int posicao) { // primeiro = indice 1
        if (tamanho == 1 || tamanho == 0) {
            return removerInicio();
        } else if (tamanho == posicao) {
            return removerFinal();
        }
        Node temp = inicio;
        for (int i = 0; temp != null && temp.getProx() != null; temp = temp.getProx(), i++) {

            if (i + 1 == posicao && temp.getProx() != fim) {
                Node retorno = temp.getProx();
                temp = temp.getProx().getProx();
                tamanho--;
                return retorno;
            }

        }
        return null;
    }

}