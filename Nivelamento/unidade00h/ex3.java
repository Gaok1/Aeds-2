package unidade00h;

public class ex3 {

    public static int maior(int vet[], int n) {
        return maior(vet, n, 0);
    }
    
    public static int maior(int vet[], int n, int i) {
        int resp;
        
        if (i == n - 1) {
            resp = vet[n - 1];
        } else {
            resp = maior(vet, n, i + 1);
            if (resp < vet[i]) {
                resp = vet[i];
            }
        }
        
        return resp;
    }
    

    public static void main(String[] args){

        int[] array = {1,2,10,4,5,9};

        MyIO.println(maior(array, 6));

    }
    
}
