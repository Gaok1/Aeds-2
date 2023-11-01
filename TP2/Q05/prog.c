#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

Jogador clone(Jogador *jogador) {
  Jogador novo = *jogador;

  return novo;
}
void ler(Jogador *j, char *frase) {}

void imprimir(Jogador jogador) {
  // id,Player,height,weight,born,collage,birth_city,birth_state
  int id = jogador.id;
  int altura = atoi(jogador.altura);
  int peso = atoi(jogador.peso);
  int anoNascimento = atoi(jogador.anoNascimento);

  printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", id, jogador.nome,
         altura, peso, anoNascimento, jogador.universidade,
         jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *tratarFrase(char *frase) {
  char data[] = "nao informado";
  char *newfrase = malloc(sizeof(char) * 200); // Aloque memória suficiente
  if (newfrase == NULL) {
    // Tratamento de erro na alocação de memória
    return NULL;
  }

  strcpy(newfrase, ""); // Inicialize newfrase como uma string vazia

  for (int i = 0; frase[i] != '\0'; i++) {
    if (frase[i] == ',' && frase[i + 1] == ',') {
      strcat(newfrase, ","); //+=
      strcat(newfrase, data);
    } else if (frase[i] == ',' && frase[i + 2] == '\0') {
      strcat(newfrase, ",");
      strcat(newfrase, data);
    } else {
      char temp[2] = {frase[i], '\0'}; // Converta o caractere em uma string
      strcat(newfrase, temp);
    }
  }

  return newfrase;
}

void adcionarPlayer(Jogador *player, char tokens[8][100]) {

  player->id = atoi(tokens[0]);

  strcpy(player->nome, tokens[1]);
  strcpy(player->altura, tokens[2]);
  strcpy(player->peso, tokens[3]);
  strcpy(player->universidade, tokens[4]);
  strcpy(player->anoNascimento, tokens[5]);
  strcpy(player->cidadeNascimento, tokens[6]);
  strcpy(player->estadoNascimento, tokens[7]);
}

void split(const char *str, char delimiter, char tokens[8][100]) {

  int linha = 0;
  int index = 0;
  while (linha < 8) {
    int i = 0;
    while (1) {

      if (str[index] == delimiter || str[index] == '\0' || str[index] == '\n') {
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
int OrdemAlfabetica(char *frase1,
                    char *frase2) { // retorna true se a frase 1 for antecessora
  for (int i = 0; frase1[i] != '\0' && frase2[i] != '\0'; i++) {
    if (frase1[i] < frase2[i]) {
      return 1;
    } else if (frase1[i] > frase2[i]) {
      return 0;
    }
  }
  return 2; // sao iguais
}

// fazer funcao recursiva

void SelectionRecursivo(Jogador *array, int tamanho, int i, int *comp,
                        int *mov) {

  // organizar por nome (Não alfabetico)

  //   for (int i = 0; i < tamanho-1; i++) {
  if (i >= tamanho) {
    return;
  }

  int j = i + 1;
  *mov = *mov + 1;
  ;
  *comp = *comp + 1;
  ;

  while (j < tamanho) {
    if (OrdemAlfabetica(array[j].nome, array[i].nome)) {
      *mov = *mov + 3;
      Jogador temp = array[j];
      array[j] = array[i];
      array[i] = temp;
    }
    *comp = *comp + (tamanho - j);
    j++;
  }
  i++;
  SelectionRecursivo(array, tamanho, i, comp, mov);
  return;

  //}
}

void SelectionSort(Jogador *array, int tamanho, int *comp, int *mov) {
  SelectionRecursivo(array, tamanho, 0, comp, mov);
}

void Documentar(long time, int *comp, int *mov) {
  FILE *arq = fopen("matrícula_selecaoRecursiva.txt", "w");
  long tempo = clock() - time;
  fprintf(arq,
          "Matricula: 1441283\tTempo de execução: %lfs\tComparacoes:   "
          "%d\tmovimentações:%d",
          tempo, *comp, *mov);
}

int main() {
  long start = clock();
  char leraq[600];

  Jogador time[3922];

  FILE *arq = fopen("tmp/players.csv", "r");

  fgets(leraq, sizeof(leraq), arq);

  for (int i = 0; fgets(leraq, 600, arq) != NULL; i++) {
    char *frase = tratarFrase(leraq);

    char dados[8][100];
    split(frase, ',', dados);
    free(frase);

    adcionarPlayer(&time[i], dados);
  }

  // ler os ids e colocar em um array
  Jogador *busca;
  busca = malloc(sizeof(Jogador) * 100);
  int size = 0;

  for (int i = 0; 1; i++) {
    size = i;
    char entrada[100];
    scanf("%s", entrada);
    if (strcmp(entrada, "FIM") == 0) {
      break;
    } else {
      int id = atoi(entrada);
      busca[i] = clone(&time[id]);
    }
  }

  realloc(busca, sizeof(Jogador) * size);
  int comp = 0;
  int mov = 0;
  SelectionSort(busca, size, &comp, &mov);

  for (int i = 0; i < size; i++) {
    imprimir(busca[i]);
  }

  Documentar(start, &comp, &mov);
  fclose(arq);

  return 0;
}