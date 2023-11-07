
public class FilaCircular {
    int[] vetor = {8,9,10, 0, 1,2,3,4,5,6,7};

    int inicio = 4, fim = 3;

    FilaCircular() {
        
    }

    public boolean buscaBinaria(int x) {
        int inc, fin;
        inc = inicio;
        fin = fim-1;
        int distancia = 0;

            for(int i = inc; i!= fim ; i=(i+1)%11){
                distancia++;
               
            }
            distancia++;
            
            int count = 0;

        while( count !=2 ){

            distancia = distancia/2;  
            if(distancia == 0){
                count++;
                distancia++;
            }

            int index = (inc+distancia) %11;

            if(vetor[index] ==x || vetor[inc] ==x || vetor[fin] == x){
                return true;
                
            }else if(vetor[index] > x){
                // lindando com a subtração para evitar index negativo
                if(fin - distancia <0){
                    int neg = distancia - fin; // calcula as posiçoes ate o inicio do array (momento de dar a volta)
                    fin = 11 - neg; //array number (not index) - a distancia que ainda tem q andar
                
                }else{
                     fin = (fin - distancia)%11;
                }
               

            }else{
                inc = (inc + distancia)%11;
            }
            
        }



        return false; // Não encontrou o elemento, retorna falso
    }


    public void OrdenarPorSelecao(){
        int index;
        int elementos = 0;

        for(;vetor[(inicio+elementos)%11]!=fim ; ){
            
            elementos++;
        }
        for(int i = inicio; (i+1%11) != fim; i = (i+1)%11 ){

            index = (fim-1)%11;

            int count0 = 0;

            for(int j = fim-1; j != (i); j = (j-1) %11){
                if(j==0){
                    count0++;
                    if(j<=0 && count0 > 0){
                        j = 10;
                        count0 = 0;
                    }
                }
                if(vetor[j] < vetor[index]){
                    index= j;
                }
            }
            //swap de indice fim-1 com index
            int aux = vetor[fim-1];
            vetor[fim-1] = vetor[index];
            vetor[index] = aux;

        }
    }

    public void inserir(int x) {

        if ((fim + 1) % 11 != inicio) { // fila está vazia
            vetor[fim] = x;
            fim = (fim + 1) % 11;

        } else { // fila cheia
            System.out.println("fila cheia");
        }

    }

    public int remover() {
        if (fim == inicio) {
            System.out.println("lista vazia! Não há o que remover");
            return 0;

        } else {
            int x = vetor[inicio];
            vetor[inicio] = 0;
            inicio = (inicio + 1) % 11;
            return x;
        }

    }

    public void printar() {
        if (fim == inicio) {
            System.out.println("Lista vazia!");
        }
        for (int i = inicio; ((i+1) % 11) != inicio; i = (i + 1) % 11) {

            System.out.println(" " + vetor[i]);

        }
    }

    public static void main(String args[]) {
        FilaCircular fila = new FilaCircular();
        fila.buscaBinaria(1);
       
       
    


        // for que testa busca binaria de 0 a 11
         for (int i = 0; i < 11; i++) {
            System.out.println("busca binaria de " + i + " = " + fila.buscaBinaria(i));
        }  


    }

}
