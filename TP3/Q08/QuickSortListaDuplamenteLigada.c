#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

typedef struct Jogador {
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

  int altura = atoi(jogador.altura);
  int peso = atoi(jogador.peso);
  int anoNascimento = atoi(jogador.anoNascimento);

  printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", jogador.id,
         jogador.nome, altura, peso, anoNascimento, jogador.universidade,
         jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *tratarFrase(char *frase) {
  char data[] = "nao informado";
  char *newfrase = malloc(sizeof(char) * 200);
  if (newfrase == NULL) {

    return NULL;
  }

  strcpy(newfrase, "");

  for (int i = 0; frase[i] != '\0'; i++) {
    if (frase[i] == ',' && frase[i + 1] == ',') {
      strcat(newfrase, ",");
      strcat(newfrase, data);
    } else if (frase[i] == ',' && frase[i + 2] == '\0') {
      strcat(newfrase, ",");
      strcat(newfrase, data);
    } else {
      char temp[2] = {frase[i], '\0'};
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


///////////////////////// Lista Ligada /////////////////////////

// Definindo a estrutura Node
typedef struct Node {
    struct Node* prox;
    struct Node* ant;
    struct Jogador Valor;
}Node;

// Definindo a estrutura Lista
typedef struct Lista {
    struct Node* primeiro;
    struct Node* ultimo;
}Lista ;
void iniciarLista(Lista* lista) {
    lista->primeiro = lista->ultimo = NULL;
}

// Funções para manipulação da lista e ordenação
struct Node* VenhaAoMundo(struct Jogador x) {
    struct Node* novoNode = (struct Node*)malloc(sizeof(struct Node));
    novoNode->Valor = x;
    novoNode->prox = novoNode->ant = NULL;
    return novoNode;
}

void inserir( Lista* lista,  Jogador x) {
    struct Node* temp = VenhaAoMundo(x);

    if (lista->primeiro == NULL) {
        lista->primeiro = lista->ultimo = temp;
    } else {
        temp->ant = lista->ultimo;
        lista->ultimo->prox = temp;
        lista->ultimo = temp;
    }
}

void imprimirLista(Lista* lista) {
    struct Node* temp = lista->primeiro;
    while (temp != NULL) {
        imprimir(temp->Valor);
        temp = temp->prox;
    }
}

int tamanho(struct Lista* lista) {
    int count = 0;
    struct Node* temp = lista->primeiro;
    while (temp != NULL) {
        count++;
        temp = temp->prox;
    }
    return count;
}

void parseArray(struct Lista* lista, struct Jogador array[]) {
    struct Node* temp = lista->primeiro;
    int i = 0;
    while (temp != NULL) {
        array[i] = temp->Valor;
        i++;
        temp = temp->prox;
    }
}

void arrayToList(struct Jogador array[], int tamanho, struct Lista* lista) {
    Lista* novaLista = malloc(sizeof(Lista));

    for (int i = 0; i < tamanho; i++) {
        inserir(novaLista, array[i]);
    }
    lista->primeiro = novaLista->primeiro;
    lista->ultimo = novaLista->ultimo;
}

int compare(struct Jogador vet[], int i, struct Jogador pivot) {
    int result = strcmp(vet[i].estadoNascimento, pivot.estadoNascimento);
    if (result != 0) {
        return result;
    }
    return strcmp(vet[i].nome, pivot.nome);
}

void trocar(Jogador array[], int i, int j) {
    struct Jogador temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

void QuickSort(struct Jogador array[], int esq, int dir) {
  for (int i = 0; i < dir; i++) {
    for (int j = i+1; j <= dir; j++) {
      if (compare(array, i, array[j]) > 0) {
          trocar(array, i, j);
      }
    }
  }
}

int main() {
  char leraq[600];

  Jogador time[3922];

  FILE *arq = fopen("/tmp/players.csv", "r");

  fgets(leraq, sizeof(leraq), arq);

  for (int i = 0; fgets(leraq, 600, arq) != NULL; i++) {
    char *frase = tratarFrase(leraq);

    char dados[8][100];
    split(frase, ',', dados);
    free(frase);

    adcionarPlayer(&time[i], dados);
  }

  // Lista circular aqui
    Lista *Lista = malloc(sizeof(Lista)); 
  iniciarLista(Lista);
  
  for (int i = 0; 1; i++) {
    char entrada[100];
    scanf("%s", entrada);
    if (strcmp(entrada, "FIM") == 0) {
      break;
    }
    int id = atoi(entrada);
    inserir(Lista,time[id]);  
  }
    int size =  tamanho(Lista);
    Jogador array[size];
    parseArray(Lista, array);
    QuickSort(array, 0, size - 1);
    arrayToList(array, size, Lista);
    imprimirLista(Lista);

  fclose(arq);
  return 0;
}
