#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// aleatorizar func
void aleatorizar(int *array, int n)
{
    if (n > 1)
    {
        int i;
        for (i = 0; i < n - 1; i++)
        {
            int j = i + rand() / (RAND_MAX / (n - i) + 1);
            int t = array[j];
            array[j] = array[i];
            array[i] = t;
        }
    }
}

void ShellSort(int *array, int size)
{

    int h = size / 2;
    while (h >= 1)
    {

        for (int i = h; i < size; i++)
        {
            int temp = array[i];
            int j;
            for (j = i; j >= h && array[j - h] > temp; j -= h)
            {
                array[j] = array[j - h];
            }
            array[j] = temp;
        }

        h = h / 2;
    }
}



    int main()
    {

        // aray de 10 elementos preenchidos
        int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        aleatorizar(array, 10);
        for (int i = 0; i < 10; i++)
        {
            printf("%d ", array[i]);
        }
        ShellSort(array, 10);
        puts("ordenado\n\n");

        for (int i = 0; i < 10; i++)
        {
            printf("%d ", array[i]);
        }

        return 0;
    }