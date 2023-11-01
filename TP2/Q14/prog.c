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

Jogador clone(Jogador *jogador)
{
  Jogador novo = *jogador;

  return novo;
}
void ler(Jogador *j, char *frase) {}

void imprimir(Jogador jogador)
{
  
  int id = jogador.id;
  int altura = atoi(jogador.altura);
  int peso = atoi(jogador.peso);
  int anoNascimento = atoi(jogador.anoNascimento);

  printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", id, jogador.nome,
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

  
  Jogador *busca;
  busca = malloc(sizeof(Jogador) * 1000);
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
      busca[i] = clone(&time[id]);
    }
  }

  realloc(busca, sizeof(Jogador) * size);

 ;

  for (int i = 0; i < size; i++)
  {
    imprimir(busca[i]);
  }

  fclose(arq);
  return 0;
}