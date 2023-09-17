/*  Faça um programa que leia n números inteiros, armazene-os em um 
arquivo, leia-os do arquivo e mostre-os na tela*/
#include <stdio.h>

int main() {
    int n;

   
    
    scanf("%d", &n);

    
    FILE *arquivo = fopen("arquivoC.txt", "w");
    

   
    for (int i = 0; i < n; i++) {
        int num;
        printf("Digite o numero %d: ", i + 1);
        scanf("%d", &num);
        fprintf(arquivo, "%d\n", num);
    }

    
    fclose(arquivo);

    
 

   
    while (!feof(arquivo)) {
        int num;
        if (fscanf(arquivo, "%d\n", &num) == 1) {
            printf("%d\n", num);
        }
    }

  
    fclose(arquivo);

    return 0;
}
