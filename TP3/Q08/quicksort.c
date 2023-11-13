#include <stdio.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>

void quickSort(int array[], int esq, int dir){
    int i = esq;
    int j = dir;
    int pivo = array[(esq+dir)/2];

    while(i<=j){
        while(array[i] < pivo){
            i++;
        }
        while(array[j] > pivo){
            j--;
        }
      
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;j--;   
    }
    if(i<dir){
        quickSort(array,i,dir);
    }
    if(j>esq){
        quickSort(array,esq,j);
    }
}




void chamarQuicksort(int array[]){
    int esq = 0;
    int dir = 9;
    quickSort(array,esq,dir);
}

int main(void){

    srand(time(NULL));
    int array[10];
    for(int i = 0; i<10;i++){
        array[i] = rand()%100;
    }
    chamarQuicksort(array);
    for(int i = 0; i<10;i++){
        printf("%d ", array[i]);
    }
    puts("");

    return 0;
}