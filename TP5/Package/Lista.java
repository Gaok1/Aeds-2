package Package;

class Lista {
    private int[] vetor;
    private int n = 0;

    Lista() {
        this.vetor = new int[10];
    }

    Lista(int x) {
        this.vetor = new int[x];
    }

    public void inserirInicio(int x) {
        if (vetor.length > n) {
            if (n == 0) {
                this.vetor[0] = x;
            } else {
                for (int i = n - 1; i >= 0; i--) { // move elementos para tras
                    this.vetor[i + 1] = this.vetor[i];
                }
                this.vetor[0] = x;
            }
            n++;
        } else {
            System.out.println("\n lista cheia, impossivel adicionar elemento");
        }

    }

    public void inserir(int valor, int posicao) {
        posicao = posicao - 1;

        if (vetor.length > n && posicao >= 0 && posicao <= n) {

            for (int i = n - 1; i >= posicao; i--) {
                this.vetor[i + 1] = this.vetor[i];
            }
            this.vetor[posicao] = valor;
            n++;

        } else {
            System.out.println("\n Posiçao maior que a capacidade da lista");
        }

    }

    public void inserirFim(int x) {
        if (vetor.length > n) {
            this.vetor[n] = x;
            n++;
        } else {
            System.out.println("\n lista cheia, impossivel adicionar elemento");
        }

    }

    public void removerFim() {
        this.vetor[n - 1] = 0;
        n--;
    }

    public void remover(int posicao) {
        if (vetor.length > n && posicao >= 0 && posicao <= n) {

            posicao = posicao - 1; // ajustando ao index

            this.vetor[posicao] = 0;

            for (int i = posicao; i < n ; i++) {
                this.vetor[i] = this.vetor[i+1];
            }
            n--;


        } else {
            System.out.println("não");
        }
    }

    public void removerInicio() {
        this.vetor[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            this.vetor[i] = this.vetor[i + 1];
        }
        this.vetor[n - 1] = 0;
        n--;
    }

    public int[] getLista() {
        System.out.println("valor de n é :" + this.n);
        return vetor;

    }

}