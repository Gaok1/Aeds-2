#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct
    Jogador // id,Player,height,weight,collage,born,birth_city,birth_state
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
  // id,Player,height,weight,born,collage,birth_city,birth_state
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

// Função para encontrar o pivô e rearranjar o array

// Função QuickSort
int getMax(Jogador arr[], int n) {
    Jogador max = arr[0].id;
    for (int i = 1; i < n; i++) {
        if (arr[i].id > max.id) {
            max = arr[i];
        }
    }
    return max;
}

// Função para realizar o counting sort com base no dígito específico (exp)
void countingSort(Jogador arr[], int size, int exp) {
    //ordenar por ID
    Jogador output[n];
    Jogador count[10] = {0};

    // Conta a ocorrência de cada dígito no dígito atual
    for (int i = 0; i < n; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    // Atualiza o array de contagem para conter as posições corretas
    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    // Constrói o array de saída
    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    // Copia o array de saída ordenado de volta para o array original
    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

// Função para ordenar o array usando o algoritmo Radix Sort
void radixSort(Jogador arr[], int size) {
    int max = getMax(arr, size);

    // Realiza a classificação para cada dígito, começando pelo dígito menos significativo
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSort(arr, n, exp);
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

  // ler os ids e colocar em um array
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

  RadixSort(busca, size);

  for (int i = 0; i < size; i++)
  {
    imprimir(busca[i]);
  }

  fclose(arq);
  return 0;
}