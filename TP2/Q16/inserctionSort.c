#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

void inserctionSortParcial(int* array, int size, int k){

    for(int i = 1;i<k;i++){
        int temp = array[i];
        int j;
        for(j = i-1; j>=0 && temp < array[j]; j--){
        array[j+1] = array[j];
        }
        array[j+1] = temp;

    }
}

int* randomArray(int size){
    int* array = malloc(sizeof(int)*size);
    srand(time(NULL));
    for(int i = 0; i < size; i++){
        array[i] = rand()%100;
    }
    return array;
}

int main(){
    int *array;
    int size = 25;
    array = randomArray(size);
    puts("=====ARRAY=====");

    for(int i = 0; i < size; i++){
        printf("%d ", array[i]);
    }

    int k =10;

    inserctionSortParcial(array, size, 10);

    puts("\n=====ARRAY ORDENADO=====");

    for(int i = 0; i < size; i++){
        printf("%d ", array[i]);
    }

    return 0;
}