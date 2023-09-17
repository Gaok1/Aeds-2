#include <stdio.h>

int main()
{
    int n;
    scanf("%d", &n);

    int numero, soma;
    int i = 1, j = n;

    while (i <= j)
    {

        scanf("%d", &numero);

        if (i == j)
        {
            soma = numero; // Se houver apenas um número, a soma será ele mesmo
        }

        if (i < j)
        {
            soma = numero + j;
            j--;
        }

        printf("Soma do %d numero com o %d numero reverso: %d\n", i, j, soma);
        i++;
    }

    return 0;
}
