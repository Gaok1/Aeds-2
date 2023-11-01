#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM_STRING 100

typedef struct {
    int id, altura, peso, anoNascimento;
    char nome[TAM_STRING], universidade[TAM_STRING], cidadeNascimento[TAM_STRING], estadoNascimento[TAM_STRING];
} Jogador;

void inicializarJogador(Jogador *jogador) {
    jogador->id = jogador->altura = jogador->peso = jogador->anoNascimento = 0;
    strcpy(jogador->nome, "");
    strcpy(jogador->universidade, "");
    strcpy(jogador->cidadeNascimento, "");
    strcpy(jogador->estadoNascimento, "");
}

void setId(Jogador *jogador, int id) {
    if (id >= 0) {
        jogador->id = id;
    } else {
        jogador->id = 0;
    }
}

void setAltura(Jogador *jogador, int altura) {
    if (altura >= 0) {
        jogador->altura = altura;
    } else {
        jogador->altura = 0;
    }
}

void setPeso(Jogador *jogador, int peso) {
    if (peso >= 0) {
        jogador->peso = peso;
    } else {
        jogador->peso = 0;
    }
}

void setAno(Jogador *jogador, int anoNascimento) {
    if (anoNascimento >= 1900 && anoNascimento <= 2023) {
        jogador->anoNascimento = anoNascimento;
    } else {
        jogador->anoNascimento = 2000;
    }
}

void setNome(Jogador *jogador, const char *nome) {
    if (strlen(nome) >= 2) {
        strcpy(jogador->nome, nome);
    } else {
        strcpy(jogador->nome, "");
    }
}

void setUniversidade(Jogador *jogador, const char *universidade) {
    if (strlen(universidade) > 5) {
        strcpy(jogador->universidade, universidade);
    } else {
        strcpy(jogador->universidade, "");
    }
}

void setCidade(Jogador *jogador, const char *cidadeNascimento) {
    if (strlen(cidadeNascimento) >= 3) {
        strcpy(jogador->cidadeNascimento, cidadeNascimento);
    } else {
        strcpy(jogador->cidadeNascimento, "");
    }
}

void setEstado(Jogador *jogador, const char *estadoNascimento) {
    if (strlen(estadoNascimento) >= 3) {
        strcpy(jogador->estadoNascimento, estadoNascimento);
    } else {
        strcpy(jogador->estadoNascimento, "");
    }
}

// Procedimento que imprime os atributos de um jogador
void imprimirJogador(Jogador jogador) {
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
           jogador.id, jogador.nome, jogador.altura, jogador.peso,
           jogador.anoNascimento, jogador.universidade, jogador.cidadeNascimento,
           jogador.estadoNascimento);
}

void lerJogador(Jogador *jogador) {
    scanf("%d", &jogador->id);
    scanf("%s", jogador->nome);
    scanf("%d", &jogador->altura);
    scanf("%d", &jogador->peso);
    scanf("%d", &jogador->anoNascimento);
    scanf("%s", jogador->universidade);
    scanf("%s", jogador->cidadeNascimento);
    scanf("%s", jogador->estadoNascimento);
}

void swap(Jogador *array, int i, int j) {
    Jogador temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

void quicksortRec(Jogador *array, int esq, int dir) {
    int i = esq, j = dir;
    char pivo[TAM_STRING];
    strcpy(pivo, array[(dir + esq) / 2].estadoNascimento);

    while (i <= j) {
        while (strcmp(array[i].estadoNascimento, pivo) < 0)
            i++;
        while (strcmp(array[j].estadoNascimento, pivo) > 0)
            j--;

        if (i <= j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }
    if (esq < j)
        quicksortRec(array, esq, j);
    if (i < dir)
        quicksortRec(array, i, dir);
}

void quicksort(Jogador *array, int n) {
    quicksortRec(array, 0, n - 1);
}

Jogador preencheVetor(const char *csvFile, int idDesejado) {
    FILE *file = fopen(csvFile, "r");
    if (file == NULL) {
        perror("Erro ao abrir o arquivo");
        exit(EXIT_FAILURE);
    }

    char line[TAM_STRING];
    int firstLine = 1;
    Jogador jogador;
    inicializarJogador(&jogador);

    while (fgets(line, sizeof(line), file) != NULL) {
        if (firstLine) {
            firstLine = 0;
            continue;
        }
        int id;
        char nome[TAM_STRING], universidade[TAM_STRING], cidadeNascimento[TAM_STRING], estadoNascimento[TAM_STRING];
        int altura, peso, anoNascimento;
        sscanf(line, "%d,%99[^,],%d,%d,%99[^,],%d,%99[^,],%99[^\n]",
               &id, nome, &altura, &peso, universidade, &anoNascimento, cidadeNascimento, estadoNascimento);

        if (id == idDesejado) {
            jogador.id = id;
            jogador.altura = altura;
            jogador.peso = peso;
            jogador.anoNascimento = anoNascimento;
            strcpy(jogador.nome, nome);
            strcpy(jogador.universidade, universidade);
            strcpy(jogador.cidadeNascimento, cidadeNascimento);
            strcpy(jogador.estadoNascimento, estadoNascimento);
        }
    }
    fclose(file);
    return jogador;
}

int main() {
    char csvFile[] = "/../tmp/players.csv";
    int idDesejado = 0, i = 0;
    Jogador *jogadores = (Jogador *)malloc(sizeof(Jogador) * 150);

    for (int k = 0; k < 150; k++) {
        inicializarJogador(&jogadores[k]);
    }

    while (1) {
        char idDesejadoStr[TAM_STRING];
        scanf("%s", idDesejadoStr);

        if (strcmp(idDesejadoStr, "FIM") == 0) {
            break;
        }
        if (sscanf(idDesejadoStr, "%d", &idDesejado) != 1) {
            continue;
        }
        Jogador jogador = preencheVetor(csvFile, idDesejado);

        if (jogador.id != 0) {
            jogadores[i] = jogador;
            i++;
        }
    }

    quicksort(jogadores, i);

    for (int j = 0; j < i; j++) {
        imprimirJogador(jogadores[j]);
    }

    free(jogadores);
    return 0;
}
