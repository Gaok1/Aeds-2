#include <stdio.h>

// Função para trocar dois elementos de um array
void trocar(int* a, int * b){
    int aux = *a;
    *a = *b;
    *b = aux;
}
int OrganizarQuick(int esq, int dir, int* arr) {
    int Pivot = arr[(esq + dir) / 2]; // Valor do pivô, não o índice

    while (esq <= dir) {
        while (arr[esq] < Pivot) {//percorre ate achar um valor maior que o pivot
            esq++;
        }
        while (arr[dir] > Pivot) { //percorre ate achar um valor menor que o pivot
            dir--;
        }
        if (esq <= dir) { //se o valor da esquerda for menor que o da direita, troca
            trocar(&arr[esq], &arr[dir]);
            esq++;
            dir--;
        }
    }

    return esq; // Retorna o índice do pivô
}

void OrdenarQuick(int esq, int dir, int* arr){
    if(esq < dir){
        int pivo = OrganizarQuick(esq, dir, arr);
        OrdenarQuick(esq, pivo - 1, arr);
        OrdenarQuick(pivo + 1, dir, arr);
    }
}

int main() {
    int arr[] = {3, 6, 8, 10, 1, 2, 1};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Array original:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    quicksort(arr, 0, n - 1);

    printf("\nArray ordenado:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
