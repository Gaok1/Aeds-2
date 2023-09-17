#include <stdio.h>
#include <stdbool.h>

// encontrar Maior numero e Menor numero no array;
void MaiorMenor(int array[10], int Maior, int Menor){
 Maior = -10000;
 Menor = 10000;
    for(int i = 0; i <10; i++){
        if(Maior < array[i]){
            Maior = array[i];
        }
        if(Menor > array[i]){
            Menor = array[i];
        }
    }
     printf("%d %d", Maior, Menor);
  
}



int main(){
    int array[10] = {-1,21,3,6,8,10,22,9,30};
    int Maior,Menor;


    MaiorMenor(array,Maior, Menor);

   
   

    return 0;
}