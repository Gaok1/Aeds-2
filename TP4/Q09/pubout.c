#include <stdio.h>

int main() {
    // Caminho do arquivo
    const char *caminhoArquivo = "pub.in";

    // Abrir o arquivo em modo de leitura
    FILE *arquivo = fopen(caminhoArquivo, "r");

    // Verificar se o arquivo foi aberto com sucesso
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    // Ler o conteúdo do arquivo e imprimir substituindo quebras de linha por ';'
    int caractere;
    while ((caractere = fgetc(arquivo)) != EOF) {
        // Substituir quebras de linha por ';'
        if (caractere == '\n') {
            putchar(';');
        } else {
            putchar(caractere);
        }
    }

    // Fechar o arquivo
    fclose(arquivo);

    return 0;
}
