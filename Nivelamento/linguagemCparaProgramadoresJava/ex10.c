#include <stdio.h>

int main()
{
    int n;

    scanf("%d", &n);

    int numero, i = 0;
    while (i < n)
    {
        scanf("%d", &numero);
        i++;
    }

    while (i > 0)
    {
        printf("%d\n", numero);
        i--;
    }

    return 0;
}
