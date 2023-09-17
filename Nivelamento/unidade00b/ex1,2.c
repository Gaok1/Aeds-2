
#include <stdio.h>
#include <stdbool.h>

// encontrar numero no array ordenado de forma crescente e retornar true ou false//;
bool func(int array[10], int x)
{

    if (array[4] >= x)
    {
        for (int i = 4; i >= 0; i--)
        {
            if (array[i] == x)
            {
                return true;
            }
        }
    }
    else
    {
        for (int i = 4; i < 10; i++)
        {
            if (array[i] == x)
            {
                return true;
            }
        }
    }

    return false;
}

int main()
{
    int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int num;
    scanf("%d", &num);
    if (func(array, num))
    {
        puts("sim");
    }
    else
    {
        puts("nao");
    }

    return 0;
}