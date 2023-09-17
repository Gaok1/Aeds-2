#include <stdio.h>
#include <stdlib.h>

// Struct typedef
typedef struct FilaCircular FilaCircular;

struct FilaCircular {
    int primeiro, ultimo;
    int tamanho;
    int *vetor;
};

void inicializar(FilaCircular *fila, int tamanho) {
    fila->primeiro = 0;
    fila->tamanho = tamanho + 1;
    fila->ultimo = 0;
    fila->vetor = (int *)malloc(sizeof(int) * fila->tamanho);
}

int inserir(FilaCircular *fila, int valor) {
    if ((fila->ultimo + 1) % fila->tamanho == fila->primeiro) {
        printf("\nFila cheia, nao eh possivel inserir\n");
        return 0; // Retorna 0 para indicar falha na inserção
    } else {
        fila->vetor[fila->ultimo] = valor;
        fila->ultimo = (fila->ultimo + 1) % fila->tamanho;
        return 1; // Retorna 1 para indicar inserção bem-sucedida
    }
}

void remover(FilaCircular *fila) {
    printf("Removendo\n");
    if (fila->primeiro == fila->ultimo) {
        printf("Fila vazia, nao e possivel remover\n");
    } else {
        fila->primeiro = (fila->primeiro + 1) % fila->tamanho;
    }
}

void imprimir(FilaCircular fila) {
    if (fila.primeiro == fila.ultimo) {
        printf("Fila vazia, nao eh possivel imprimir\n");
        return;
    }
    for (int i = fila.primeiro; i != fila.ultimo; i = (i + 1) % fila.tamanho) {
        printf("%d ", fila.vetor[i]);
    }
    printf("\n");
}

int main() {
    printf("Fila Circular\n");

    FilaCircular filaTeste;
    inicializar(&filaTeste, 10); // Tamanho 11

    // Inserir 10 elementos
    for (int i = 0; i < 10; i++) {
        inserir(&filaTeste, i);
    }

    // Remover 5 elementos
    for (int i = 0; i < 5; i++) {
        remover(&filaTeste);
    }

    // Inserir 8 elementos
    for (int i = 10; i < 18; i++) {
        inserir(&filaTeste, i);
    }

    imprimir(filaTeste);

    // Libere a memória alocada para o vetor
    free(filaTeste.vetor);

    return 0;
}
