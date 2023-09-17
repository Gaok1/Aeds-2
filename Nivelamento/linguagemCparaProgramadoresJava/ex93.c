/* Após uma leitura/escrita o cabeçote se desloca em uma unidade em 
direção ao final do arquivo
*/

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
        
        // Desloca o cabeçote de escrita em direção ao final do arquivo
        fseek(arquivo, 0, SEEK_CUR);
    }

    fclose(arquivo);

    arquivo = fopen("arquivoC.txt", "r");
  

    printf("\nNumeros lidos do arquivo:\n");
    while (!feof(arquivo)) {
        int num;
        if (fscanf(arquivo, "%d\n", &num) == 1) {
            printf("%d\n", num);
            
            // Desloca o cabeçote de leitura em direção ao final do arquivo
            fseek(arquivo, 0, SEEK_CUR);
        }
    }

    fclose(arquivo);

    return 0;
}
