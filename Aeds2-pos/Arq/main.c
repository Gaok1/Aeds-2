#include "IO.h"
#include "FILEIO.h"
#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char *nomeFIle = askln("digite o nome do arquivo");
    println("Digite as linhas do texto, digite FIM para terminar");
    int i = 1;

    while (true)
    {
        char *texto = askln("Digite a linha %d", i++);
        if (strcmp(texto, "FIM") == 0)
        {
            break;
        }
        fWrite(nomeFIle, texto);
    }
    char resp = askChar("Digite R para substituir uma palavra ou qualquer outra tecla para sair");
    if(resp == 'R'){
        int linha = askInt("Digite a linha que deve ser substituida");
        char *substituta = askln("Digite a frase substituta");
        fReplaceln(nomeFIle, linha, substituta);
    }
    return 0;
}