#include <stdio.h>

    void troca(int*a, int*b){
        int aux = *a;
        *a=*b;
        *b = aux;
    }


int OrdenarQuick(int esq, int dir, int *arr){
    int pivot = arr[(esq + dir) / 2]; // Valor do pivô, não o índice
    while(esq<=dir){
        while(arr[esq] < pivot){
            esq++;
        }
        while(arr[dir] > pivot){
            dir++;
        }
        if(esq<=dir){
            troca(&arr[esq],&arr[dir]);
            esq++;
            dir++;
        }
        
    }

    return pivot;
}


void QuickSort(int* array,int esq, int dir){
   
    if(esq<dir){
    int pivot = OrdenarQuick( esq,dir,array);
    QuickSort(array, esq, pivot-1);
    QuickSort(array, pivot, dir); 
    }
    
}



int main(int argc, char const *argv[])
{
    int array[] = {1,6,4,6,78,2,56,8,345,347,1230};
    int size = (sizeof(array)/ sizeof(int)) - 1;
    //printar
    for(int i = 0; i < size; i++){
        printf("%d ",array[i]);
    }

    QuickSort(array,0,size);

    printf("\n");
    //printar
    for(int i = 0; i < size; i++){
        printf("%d ",array[i]);
    }
    return 0;
}
