#include <stdio.h>
#include <stdlib.h>

int main()
{
    // Leitura do número de valores a serem lidos
    int n;
    scanf("%d", &n);

    // Abre o arquivo para escrita
    FILE *file = fopen("valores.txt", "wb");

    // Leitura e escrita dos valores
    for (int i = 0; i < n; i++)
    {
        double valor;
        scanf("%lf", &valor);
        fwrite(&valor, 8, 1, file);
    }

    // Fecha o arquivo
    fclose(file);

    // Reabre o arquivo para leitura
    file = fopen("valores.txt", "rb");

    // Faz a leitura de trás para frente
    for (int i = n - 1; i >= 0; i--)
    {
        fseek(file, i * 8, SEEK_SET);

        double valor;
        fread(&valor, 8, 1, file);

        int casasDecimais = 0;
        // calculo das casas decimais
        double temp = valor - (int)valor;
        while (temp > 0 && casasDecimais < 3)
        {
            temp *= 10;
            casasDecimais++;
            temp -= (int)temp;
        }

        printf("%.*lf\n", casasDecimais, valor);
    }

    // Fecha o arquivo novamente
    fclose(file);

    return 0;
}
