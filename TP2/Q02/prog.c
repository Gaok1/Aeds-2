#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Jogador // id,Player,height,weight,collage,born,birth_city,birth_state
{
    char id[100];
    char nome[100];
    char altura[100];
    char peso[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

Jogador clone(Jogador *jogador)
{
    Jogador novo = *jogador;

    return novo;
}
void ler(Jogador *j, char *frase)
{
}

void imprimir(Jogador jogador)
{
    // id,Player,height,weight,born,collage,birth_city,birth_state
    int id = atoi(jogador.id);
    int altura = atoi(jogador.altura);
    int peso = atoi(jogador.peso);
    int anoNascimento = atoi(jogador.anoNascimento);

    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", id, jogador.nome, altura, peso, anoNascimento, jogador.universidade, jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *tratarFrase(char *frase)
{
    char data[] = "nao informado";
    char *newfrase = malloc(sizeof(char) * 200); // Aloque memória suficiente
    if (newfrase == NULL)
    {
        // Tratamento de erro na alocação de memória
        return NULL;
    }

    strcpy(newfrase, ""); // Inicialize newfrase como uma string vazia

    for (int i = 0; frase[i] != '\0'; i++)
    {
        if (frase[i] == ',' && frase[i + 1] == ',')
        {
            strcat(newfrase, ","); //+=
            strcat(newfrase, data);
        }
        else if (frase[i] == ',' && frase[i + 2] == '\0')
        {
            strcat(newfrase, ",");
            strcat(newfrase, data);
        }
        else
        {
            char temp[2] = {frase[i], '\0'}; // Converta o caractere em uma string
            strcat(newfrase, temp);
        }
    }

    return newfrase;
}

void adcionarPlayer(Jogador *player, char tokens[8][100])
{
    strcpy(player->id, tokens[0]);

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

int main()
{

    char leraq[600];

    Jogador time[3922];
    // arquivo

    FILE *arq = fopen("/tmp/players.csv", "r");

    fgets(leraq, sizeof(leraq), arq);

    int i = 0;
    while (fgets(leraq, 600, arq) != NULL)
    {
        char *frase = tratarFrase(leraq);

        char dados[8][100];
        split(frase, ',', dados);
        free(frase);

        adcionarPlayer(&time[i], dados);

        i++;
    }
    while (1)
    {
        char entrada[100];
        scanf("%s", entrada);
        if (strcmp(entrada, "FIM") == 0)
        {
            break;
        }
        else
        {
            int identrada = atoi(entrada);

            imprimir(time[identrada]);
        }
    }

fclose(arq);
return 0;

}