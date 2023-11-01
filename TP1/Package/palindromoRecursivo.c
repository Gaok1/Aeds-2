#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool igual(char frase[]) {
    if (strcmp("FIM", frase) == 0) {
        return true;
    } else {
        return false;
    }
}

bool PalindromoRecursivo(int index, int reverseIndex, char array[]) {
    if (index >= reverseIndex) {
        puts("SIM");
        return true;
    }

    if (array[index] == array[reverseIndex]) {
        return PalindromoRecursivo(index + 1, reverseIndex - 1, array);
    } else {
        puts("NAO");
        return false;
    }
}

bool Palindromo(char *array) {
    int tamanho = strlen(array);
    return PalindromoRecursivo(0, tamanho - 1, array);
}

int main(void) {
    while (true) {
        char array[500];
        scanf(" %[^\n]", array);  // Adicionei um espaço antes de %[^\n] para consumir o newline pendente.

        if (igual(array)) {
            break;
        }

        Palindromo(array);
    }

    return 0;
}
