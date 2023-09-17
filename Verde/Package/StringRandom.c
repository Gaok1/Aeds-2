#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

char LetraRandom()
{
    char randomChar = (char)(rand() % 26 + 'a');        // gera caracter aleatorio e o retorna
    return randomChar;
}

void strRandomRecursiva(char *array, char Creferencia, char Ctroca, int index)
{
    if (index >= strlen(array))
    { // condiçao de parada
        return;
    }
    if (array[index] == Creferencia)
    {
        array[index] = Ctroca;     // atribuiçao com a letra alatorioa                                
    }
    strRandomRecursiva(array, Creferencia, Ctroca, index + 1);  //recursao
    
}

int strRandom(char *array)
{
    char Crefernecia = LetraRandom(), Ctroca = LetraRandom();

    strRandomRecursiva(array, Crefernecia, Ctroca, 0);  //chama a funçao recursiva com os parametros de letras
}

int main()
{
    srand(57);

    while (true)
    {

        char array[400];

        scanf(" %[^\n]", array);

        if (strcmp(array, "FIM") == 0)
        {
            break;
        }

        


        printf("%s\n",array);

      
    }

    return 0;
}
