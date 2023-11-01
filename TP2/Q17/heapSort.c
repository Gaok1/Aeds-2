#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct Jogador
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

void swap(Jogador *a, Jogador *b)
{
  Jogador temp = *a;
  *a = *b;
  *b = temp;
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
void heapify(Jogador *arr, int n, int i)
{
  int maior = i;
  int esq = 2 * i + 1;
  int dir = 2 * i + 2;

  // If the esq child is larger than the root
  if (esq < n && atoi(arr[esq].altura) > atoi(arr[maior].altura) || (esq < n && atoi(arr[esq].altura) == atoi(arr[maior].altura) && strcmp(arr[esq].nome, arr[maior].nome) > 0))
    maior = esq;

  // If the dir child is larger than the maior so far
  if (dir < n && atoi(arr[dir].altura) > atoi(arr[maior].altura) || (dir < n && atoi(arr[dir].altura) == atoi(arr[maior].altura) && (strcmp(arr[dir].nome, arr[maior].nome) > 0)))
    maior = dir;

  // If the maior is not the root, swap and recursively heapify the affected subtree
  if (maior != i)
  {
    swap(&arr[i], &arr[maior]);
    heapify(arr, n, maior);
  }
}



// Função principal do HeapSort
void HeapSort(Jogador *array, int n) {
    // Construir o heap (reorganizar o array)
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }

    // Extrair elementos do heap um por um
    for (int i = n - 1; i > 0; i--) {
        swap(&array[0], &array[i]);
        heapify(array, i, 0);
    }
}




void Documentar(long time, int comp)
{
  FILE *arq = fopen("1441283_radixsort.txt", "w");
  long tempo = clock() - time;
  fprintf(arq, "Matricula: 1441283\tTempo de execução: %li\tComparacoes: %d",
          tempo, comp);
  fclose(arq);
}

int main()
{
  long start = clock();
  char leraq[600];

  Jogador time[3922];

  FILE *arq = fopen("/tmp/playersAtualizado.csv", "r");

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


  HeapSort(busca, size);

  for (int i = 0; i < 10; i++) // k = 10
  {
    imprimir(busca[i]);
  }
  free(busca);

  fclose(arq);
  return 0;
}