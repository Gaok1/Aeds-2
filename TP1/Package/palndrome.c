#include <stdio.h>
#include <stdlib.h>

int palindromo(char *frase)
{
    int tamanho = 0;
    while(frase[tamanho] !='\0'){ // funçao para calcular o tamanho da frase utilizando atribuiçao unitaria ate encontrar o fim da frase (\0)
        tamanho++;

    }

    int j = tamanho - 1; // variavel para ser usada como parametro do ultimo caractere da frase;

    for (int i = 0; i < tamanho; i++) // checará os caracteres invertidos com o da frase original, assim identificando o palindromo
    {

        if (frase[i] != frase[j-i])
        {
            return 0;
        }
    }
    return 1;
}



int main(void)
{
    char frase[500] = "teste";

    while (strcmp(frase,"FIM") != 0) // TENTATIVA DE CORREÇAO DO VERDE QUE FICA DANDO ERRO, PODE SER POR CAUSA DO WHILE(TRUE)
    {
        scanf(" %[^\n]", frase); // scanf para ler até o caractere \n

        if(strcmp(frase,"FIM") == 0){ // funçao que retorna a diferença de frases convertendo seus caracteres em numeros, se retornar 0 para FIM então deve parar
            return 0;
        }

        if (palindromo(frase)) // SE PALINDROMO for true então irá pritar SIM
        {
            printf("SIM\n");
        }
        else // contrário, printara NAO
        {
            printf("NAO\n");
        }
    }

    return 0;
}