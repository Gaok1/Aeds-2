#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdarg.h>
// leitura
#ifndef IO_H
#define IO_H
// leitura em console #1
char readChar();     // le um char do console ate um espaço ou um \n, \t ou EOF
char *readln();    // le uma linha inteira do console
int readInt();       // le um inteiro do console ate um espaço ou um \n, \t ou EOF 
float readFloat();   // le um float do console ate um espaço ou um \n, \t ou EOF 
double readDouble(); // le um double do console ate um espaço ou um \n, \t ou EOF 
char *readString();  // le uma string do console ate um espaço ou um \n, \t ou EOF 

// escrita em console #2
void print(const char *format, ...);   // escreve uma string no console
void println(const char *format, ...); // escreve uma string no console e \n

// escrita seguida de leitura em console #3
char askChar(const char *question, ...);     // escreve uma string no console e le uma linha inteira do console
int askInt(const char *question, ...);       // escreve uma string no console e le um inteiro do console ate um espaço ou um \n ou \t
float askFloat(const char *question, ...);   // escreve uma string no console e le um float do console ate um espaço ou um \n ou \t
double askDouble(const char *question, ...); // escreve uma string no console e le um double do console ate um espaço ou um \n ou \t
char *askString(const char *question, ...);  // escreve uma string no console e le uma string do console ate um espaço ou um \n ou \t
char *askln(const char *question, ...);      // escreve uma string no console e le uma linha inteira do console

// #1
char readChar()
{
    int buffer = getchar();
    while (buffer == '\n' || buffer == ' ' || buffer == '\t')
    {
        buffer = getchar();
    }
    if (buffer == EOF)
        return '\0';
    return (char)buffer;
}

char *readln() {
    int bufferSize = 64; // Tamanho inicial do buffer
    int index = 0;
    char *string = (char *)malloc(bufferSize * sizeof(char));

    if (string == NULL) {
        fprintf(stderr, "Erro na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }

    int buffer;
    while (1) {
        buffer = getchar();

        if (index == 0 && (buffer == '\n' || buffer == ' ' || buffer == '\t'))
            continue; // Ignora os primeiros \n ou buffer \n

        if ((char)buffer == '\n' || buffer == EOF) {
            string[index] = '\0';
            break;
        }

        // Redimensiona o buffer se necessário
        if (index == bufferSize - 1) {
            bufferSize *= 2;
            char *temp = (char *)realloc(string, bufferSize * sizeof(char));

            if (temp == NULL) {
                fprintf(stderr, "Erro na realocação de memória.\n");
                free(string);
                exit(EXIT_FAILURE);
            }

            string = temp;
        }

        string[index++] = (char)buffer;
    }

    return string;
}


int readInt()
{
    int bufferSize = 64; // Tamanho inicial do buffer
    int index = 0;
    char *string = (char *)malloc(bufferSize * sizeof(char));

    if (string == NULL)
    {
        fprintf(stderr, "Erro na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }

    int buffer;
    while (1)
    {
        buffer = getchar();
        if (index == 0 && (buffer == '\n' || buffer == ' ' || buffer == '\t'))
            continue; // ignora os primeiro \n ou buffer \n

        if (buffer == '\n' || buffer == EOF || buffer == ' ' || buffer == '\t')
        {
            string[index] = '\0';
            break;
        }

        string[index] = (char)buffer;
        index++;

        // Redimensiona o buffer se necessário
        if (index == bufferSize - 1)
        {
            bufferSize *= 2;
            string = (char *)realloc(string, bufferSize * sizeof(char));

            if (string == NULL)
            {
                fprintf(stderr, "Erro na realocação de memória.\n");
                exit(EXIT_FAILURE);
            }
        }
    }

    int number = atoi(string);
    free(string);
    return number;
}

double readDouble() {
    int buffer;
    int bufferSize = 64; // Tamanho inicial do buffer
    int index = 0;
    char *string = (char *)malloc(bufferSize * sizeof(char));

    if (string == NULL) {
        fprintf(stderr, "Erro na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }

    while (1) {
        buffer = getchar();

        if (index == 0 && (buffer == '\n' || buffer == ' ' || buffer == '\t'))
            continue; // Ignora os primeiros \n ou buffer \n

        if (buffer == '\n' || buffer == EOF || buffer == ' ' || buffer == '\t') {
            string[index] = '\0';
            break;
        }

        string[index++] = (char)buffer;
    }

    // Converte a string para double
    char *endptr;
    double number = strtod(string, &endptr);

    // Verifica se a conversão foi bem-sucedida
    if (*endptr != '\0' && *endptr != '\n') {
        fprintf(stderr, "Entrada inválida. Não foi possível converter para um número de ponto flutuante.\n");
        free(string);
        return -1.0; // Retorna um valor especial para indicar erro
    }
    free(string);
    return number;
}

float readFloat()
{
    int buffer;
    int bufferSize = 64; // Tamanho inicial do buffer
    int index = 0;
    char *string = (char *)malloc(bufferSize * sizeof(char));
    while (1)
    {
        buffer = getchar();
        if(index == 0 && (buffer == '\n' || buffer == ' ' || buffer == '\t'))
            continue; // ignora os primeiro \n ou buffer \n

        if (buffer == '\n' || buffer == EOF || buffer == ' ' || buffer == '\t')
        {
            string[index] = '\0';
            break;
        }
        string[index++] = (char)buffer;
    }
    float number = atof(string);
    free(string);
    return number;
}

long readLong() {
    int buffer;
    int bufferSize = 64; // Tamanho inicial do buffer
    int index = 0;
    char *string = (char *)malloc(bufferSize * sizeof(char));

    if (string == NULL) {
        fprintf(stderr, "Erro na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }

    while (1) {
        buffer = getchar();

        if (index == 0 && (buffer == '\n' || buffer == ' ' || buffer == '\t'))
            continue; // Ignora os primeiros \n ou buffer \n

        if (buffer == '\n' || buffer == EOF || buffer == ' ' || buffer == '\t') {
            string[index] = '\0';
            break;
        }       

        string[index++] = (char)buffer;
    }
    // Utiliza strtol para converter a string para long
    char *endptr;
    long number = strtol(string, &endptr, 10);

    // Verifica se a conversão foi bem-sucedida
    if (*endptr != '\0' && *endptr != '\n') {
        fprintf(stderr, "Entrada inválida. Não foi possível converter para um número inteiro.\n");
        free(string);
        return -1; // Retorna um valor especial para indicar erro
    }

    free(string);
    return number;
}


char *readString() {
    int buffer;
    int bufferSize = 64; // Tamanho inicial do buffer
    int index = 0;
    char *string = (char *)malloc(bufferSize * sizeof(char));

    if (string == NULL) {
        fprintf(stderr, "Erro na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }

    while (1) {
        buffer = getchar();

        if (index == 0 && (buffer == '\n' || buffer == ' ' || buffer == '\t'))
            continue; // Ignora os primeiros \n ou buffer \n

        if ((char)buffer == '\n' || buffer == EOF || buffer == ' ' || buffer == '\t') {
            string[index] = '\0';
            break;
        }

        // Redimensiona o buffer se necessário
        if (index == bufferSize - 1) {
            bufferSize *= 2;
            char *temp = (char *)realloc(string, bufferSize * sizeof(char));

            if (temp == NULL) {
                fprintf(stderr, "Erro na realocação de memória.\n");
                free(string);
                exit(EXIT_FAILURE);
            }

            string = temp;
        }

        string[index++] = (char)buffer;
    }

    return string;
}


// #2
void print(const char *format, ...)
{
    va_list args;
    va_start(args, format);
    vprintf(format, args);
    va_end(args);
}
void println(const char *format, ...)
{
    va_list args;
    va_start(args, format);
    vprintf(format, args);
    va_end(args);
    printf("\n");
}

// #3
char askChar(const char *question, ...)
{
    println(question);
    char buffer = readChar();
    return buffer;
}
int askInt(const char *question, ...)
{
    println(question);
    int buffer = readInt();
    return buffer;
}
long askLong(const char *question, ...)
{
    println(question);
    long buffer = readLong();
    return buffer;
}
float askFloat(const char *question, ...)
{
    println(question);
    float buffer = readFloat();
    return buffer;
}
double askDouble(const char *question, ...)
{
    println(question);
    double buffer = readDouble();
    return buffer;
}
char *askString(const char *question, ...)
{
    println(question);
    char *buffer = readString();
    return buffer;
}
char *askln(const char *question, ...)
{
    println(question);
    char *buffer = readln();
    return buffer;
}


#endif