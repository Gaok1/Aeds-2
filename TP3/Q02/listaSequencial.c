#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct
    Jogador
{
    int id;
    char nome[100];
    char altura[100];
    char peso[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;
int tamanho = 0;

Jogador clone(Jogador *jogador)
{
    Jogador novo = *jogador;

    return novo;
}
void ler(Jogador *j, char *frase) {}

void imprimir(Jogador jogador, int pos)
{

    
    int altura = atoi(jogador.altura);
    int peso = atoi(jogador.peso);
    int anoNascimento = atoi(jogador.anoNascimento);

    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos, jogador.nome,
           altura, peso, anoNascimento, jogador.universidade,
           jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *tratarFrase(char *frase)
{
    char data[] = "nao informado";
    char *newfrase = malloc(sizeof(char) * 200);
    if (newfrase == NULL)
    {

        return NULL;
    }

    strcpy(newfrase, "");

    for (int i = 0; frase[i] != '\0'; i++)
    {
        if (frase[i] == ',' && frase[i + 1] == ',')
        {
            strcat(newfrase, ",");
            strcat(newfrase, data);
        }
        else if (frase[i] == ',' && frase[i + 2] == '\0')
        {
            strcat(newfrase, ",");
            strcat(newfrase, data);
        }
        else
        {
            char temp[2] = {frase[i], '\0'};
            strcat(newfrase, temp);
        }
    }

    return newfrase;
}

void adcionarPlayer(Jogador *player, char tokens[8][100])
{

    player->id = atoi(tokens[0]);

    strcpy(player->nome, tokens[1]);
    strcpy(player->altura, tokens[2]);
    strcpy(player->peso, tokens[3]);
    strcpy(player->universidade, tokens[4]);
    strcpy(player->anoNascimento, tokens[5]);
    strcpy(player->cidadeNascimento, tokens[6]);
    strcpy(player->estadoNascimento, tokens[7]);
}

void split(const char *str, char delimiter, char tokens[8][100])
{

    int linha = 0;
    int index = 0;
    while (linha < 8)
    {
        int i = 0;
        while (1)
        {

            if (str[index] == delimiter || str[index] == '\0' || str[index] == '\n')
            {
                tokens[linha][i] = '\0';
                break;
            }

            tokens[linha][i] = str[index];
            i++;
            index++;
        }

        index++;
        linha++;
    }
}

void trocar(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main()
{
    long start = clock();
    char leraq[600];

    Jogador time[3922];

    FILE *arq = fopen("/tmp/players.csv", "r");

    fgets(leraq, sizeof(leraq), arq);

    for (int i = 0; fgets(leraq, 600, arq) != NULL; i++)
    {
        char *frase = tratarFrase(leraq);

        char dados[8][100];
        split(frase, ',', dados);
        free(frase);

        adcionarPlayer(&time[i], dados);
    }

    Jogador *lista;
    lista = malloc(sizeof(Jogador) * 1000);
    int size = 0;

    for (int i = 0; 1; i++)
    {
        size = i;
        char entrada[100];
        scanf("%s", entrada);
        if (strcmp(entrada, "FIM") == 0)
        {
            break;
        }
        else
        {
            int id = atoi(entrada);
            tamanho++;
            lista[i] = clone(&time[id]);
        }
    }

    int quantidade;
    scanf("%d", &quantidade);
    for (int i = 0; i < quantidade; i++)
    {
        char entrada[10];
        scanf("%s", entrada);

        if (strcmp(entrada, "II") == 0)
        {
            int id;
            scanf("%d", &id);

            inserirInicio(time[id], lista);
        }
        else if (strcmp(entrada, "IF") == 0)
        {
            int id;
            scanf("%d", &id);

            inserirFinal(time[id], lista);
        }
        else if (strcmp(entrada, "I*") == 0)
        {
            int pos, id;
            scanf("%d %d", &pos, &id);

            inserir(pos, time[id], lista);
        }
        else if (strcmp(entrada, "RI") == 0)
        {
            removerInicio(lista);
        }
        else if (strcmp(entrada, "RF") == 0)
        {
            removerFinal(lista);
        }
        else if (strcmp(entrada, "R*") == 0)
        {
            int pos;
            scanf("%d", &pos);
            remover(pos, lista);
        }
    }

    for (int i = 0; i < tamanho; i++)
    {
        imprimir(lista[i], i);
    }

    fclose(arq);
    return 0;
}

void inserirInicio(Jogador J, Jogador array[])
{
    for (int i = tamanho; i > 0; i--)
    {
        array[i] = array[i - 1];
    }
    array[0] = J;
    tamanho++;
}

void inserirFinal(Jogador J, Jogador array[])
{
    array[tamanho] = J;
    tamanho++;
}

void inserir(int posicao, Jogador J, Jogador array[])
{
    for (int i = tamanho; i > posicao; i--)
    {
        array[i] = array[i - 1];
    }
    array[posicao] = J;
    tamanho++;
}

void removerInicio(Jogador array[])
{
    Jogador temp = array[0];
    for (int i = 0; i < tamanho - 1; i++)
    {
        array[i] = array[i + 1];
    }
    tamanho--;
    printf("(R) %s\n", temp.nome);
}

void removerFinal(Jogador array[])
{
    Jogador temp = array[tamanho - 1];
    array[tamanho - 1] = (Jogador){0, "", 0, 0, "", 0, "", ""};
    tamanho--;
    printf("(R) %s\n", temp.nome);
}

void remover(int pos, Jogador array[])
{
    Jogador temp = array[pos];
    for (int i = pos; i < tamanho - 1; i++)
    {
        array[i] = array[i + 1];
    }
    array[tamanho - 1] = (Jogador){0, "", 0, 0, "", 0, "", ""};
    tamanho--;
    printf("(R) %s\n", temp.nome);
}