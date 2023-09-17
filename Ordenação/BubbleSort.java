class BubbleSort {
    static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    static void sortaa(int array[]) {
      
       
        for(int i = 0;i<array.length/2;i++){ 
    
        

        for(int j = i; j<array.length-i-1;j++){
            if(array[j] >array[j+1] ){
                swap(array, j, j+1);
            }    
        }


     
        for(int j = array.length - i-1; j >i ;j--){
              if(array[j] < array[j-1] ){
               swap(array, j, j-1);
            } 
        }
    }

    }


    
     static boolean BinarySearch(int array[], double x){
        boolean resp = false;

        int esq = 0, dir = array.length-1;
        while(esq<=dir){
            int meio = (esq+dir) / 2;
            if(x==array[meio]){
                return true;
            }else if(x<meio){
                dir = meio-1;
            }else{
                esq = meio+1;
            }
        }
   



        return resp;
    }
        

        
    

    public static void main(String[] args) {
        int array[] = { 1, 34, 6, 7832, 5, 0,4567, 1, 123, 34, 78, 9, 9, 65, 4256, 478 };
        sortaa(array);
        
        //printar array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println(BinarySearch(array, 478));

      

    }
}