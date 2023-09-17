//  Indica a posição atual de leitura/escrita no arquivo

#include <stdio.h>

int main() {
    int n;

    printf("Digite a quantidade de numeros: ");
    scanf("%d", &n);

    FILE *arquivo = fopen("arquivoC.txt", "w");
   

    for (int i = 0; i < n; i++) {
        int num;
        printf("Digite o numero %d: ", i + 1);
        scanf("%d", &num);
        fprintf(arquivo, "%d\n", num);
    }

    // Obtém a posição atual de escrita no arquivo
    long posicaoEscrita = ftell(arquivo);
    printf("Posicao de escrita: %ld\n", posicaoEscrita);

    fclose(arquivo);

    arquivo = fopen("arquivoC.txt", "r");
    

    printf("\nNumeros lidos do arquivo:\n");
    while (!feof(arquivo)) {
        int num;
        if (fscanf(arquivo, "%d\n", &num) == 1) {
            printf("%d\n", num);
        }
    }

    // Obtém a posição atual de leitura no arquivo
    long posicaoLeitura = ftell(arquivo);
    printf("Posicao de leitura: %ld\n", posicaoLeitura);

    fclose(arquivo);

    return 0;
}
