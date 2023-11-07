package ListaCadeado;
class Quick {

    public static void troca(int array[],int i, int j ){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
   
    
    public static void quicksort(int array[], int esq, int dir){
        int i = esq;
        int j = dir;
        int pivo = (esq+dir)/2;
        int pivot = array[pivo];
        while(i<=j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if(i<=j){
                troca(array,i,j);
                i++;
                j--;
            }
        }
        if(i<dir ){
            quicksort(array, i, dir);
        }
        if(j>esq){
            quicksort(array,esq,j);
        }

        
    }

    public static void quicksort(int array[]){
        quicksort(array, 0, array.length-1);
    };

    public static void main(String args[]){
        int array[] = new int[20];
        //preenche o array com valores aleatorios

        for(int i=0; i<array.length; i++){
            array[i] = (int)(Math.random()*100);
        }

         for(int i=0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }

        System.out.print("\n");
        quicksort(array);
         for(int i=0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }
    }
}
