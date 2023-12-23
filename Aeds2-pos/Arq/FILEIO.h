#ifndef FILEIO_H
#define FILEIO_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdarg.h>

// Função para ler uma linha específica de um arquivo
char* fReadln(int linha, const char* nomeArquivo);

// Função para escrever dados em um arquivo
void fWrite(const char* nomeArquivo, const char* formato, ...);

// Função para substituir uma linha específica em um arquivo
void fReplaceln(const char* nomeArquivo, int linha, const char* formato, ...);

char* fReadln(int linha, const char* nomeArquivo) {
    FILE* arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo para leitura");
        return NULL;
    }

    char buffer[256]; // Tamanho arbitrário, ajuste conforme necessário
    char* linhaLida = NULL;
    size_t contadorLinhas = 0;

    while (fgets(buffer, sizeof(buffer), arquivo) != NULL) {
        if (++contadorLinhas == linha) {
            // Encontrou a linha desejada
            linhaLida = strdup(buffer);
            break;
        }
    }

    fclose(arquivo);

    return linhaLida;
}

void fWrite(const char* nomeArquivo, const char* formato, ...) {
    strcat(formato, "\n"); // Adicionar uma quebra de linha ao final da string
    FILE* arquivo = fopen(nomeArquivo, "a");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo para escrita");
        exit(EXIT_FAILURE);
    }

    va_list args;
    va_start(args, formato);
    vfprintf(arquivo, formato, args);
    va_end(args);

    fclose(arquivo);
}

void fReplaceln(const char* nomeArquivo, int linha, const char* formato, ...) {
    FILE* arquivoOriginal = fopen(nomeArquivo, "r");
    if (arquivoOriginal == NULL) {
        perror("Erro ao abrir o arquivo original para leitura");
        exit(EXIT_FAILURE);
    }

    // Criar um arquivo temporário para armazenar as linhas modificadas
    char nomeTemporario[] = "temporarioXXXXXX";
    int arquivoTemporario = mkstemp(nomeTemporario);

    FILE* arquivoTemp = fdopen(arquivoTemporario, "w");
    if (arquivoTemp == NULL) {
        perror("Erro ao criar arquivo temporário");
        fclose(arquivoOriginal);
        exit(EXIT_FAILURE);
    }

    char buffer[256]; // Tamanho arbitrário, ajuste conforme necessário
    size_t contadorLinhas = 0;

    va_list args;
    va_start(args, formato);

    while (fgets(buffer, sizeof(buffer), arquivoOriginal) != NULL) {
        if (++contadorLinhas == linha) {
            // Substituir a linha desejada
            vfprintf(arquivoTemp, formato, args);
            fprintf(arquivoTemp, "\n");
        } else {
            // Manter as outras linhas inalteradas
            fprintf(arquivoTemp, "%s", buffer);
        }
    }

    va_end(args);
    fclose(arquivoOriginal);
    fclose(arquivoTemp);

    // Substituir o arquivo original pelo temporário
    remove(nomeArquivo);
    rename(nomeTemporario, nomeArquivo);
}

#endif // FILEIO_H
