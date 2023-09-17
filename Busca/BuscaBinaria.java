package Busca;

public class BuscaBinaria {
    
    public static boolean buscar(int[] array, int x){
        boolean ordenado = false;
        int dir = array.length - 1,esq = 0;

        while(esq<=dir)
        {
            int meio = (esq+dir)/2;
            if(array[meio] == x){
                return true;
            }else{
                if(x>meio){
                    esq = meio+1;
                }else{
                    dir = meio-1;
                }
            }

        }

        return ordenado;

    }


    public static void main(String args[]){

        // int array preenchido ate 20
        int[] array = new int[20];
        for(int i = 0; i<20;i++){
            array[i] = i;
        }

        // for que verifica se todos os numeros de 0 a 19 estao no array
        int count = 0;
        for(int i = 0; i<20;i++){
            System.out.println(buscar(array, i));
            count++;

        }
        System.out.println("\n\n\n"+count);



    }

}
