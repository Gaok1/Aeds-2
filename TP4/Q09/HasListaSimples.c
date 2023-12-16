#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

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

void imprimir(Jogador jogador, int pos) {

  int altura = atoi(jogador.altura);
  int peso = atoi(jogador.peso);
  int anoNascimento = atoi(jogador.anoNascimento);

  printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos,
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

// Hash com lista simples
typedef struct Node {
  Jogador *jogador;
  struct Node *prox;
} Node;

Node *venhaAoMundo(Jogador *x) {
  Node *node = malloc(sizeof(Node));
  node->jogador = x;
  node->prox = NULL;
  return node;
}

typedef struct Hash {
  Node **array; // Deve ser um array de ponteiros para Node
  int tam;
} Hash;

Hash *criarHash(int tam) {
  Hash *hash = malloc(sizeof(Hash));
  hash->tam = tam;
  hash->array = malloc(sizeof(Node *) * tam);

  for (int i = 0; i < tam; i++) {
    hash->array[i] = NULL; // Inicializar todos os ponteiros para NULL
  }
  return hash;
}

int fazerHash(Jogador *x, Hash *hash) { return x->id % hash->tam; }

void inserir(Jogador *x, Hash *hash) {
  int pos = fazerHash(x, hash);

  if (hash->array[pos] == NULL) {
    // A posição está vazia, insere o novo Node
    hash->array[pos] = venhaAoMundo(x);
  } else {
    // A posição já possui um Node, precisa lidar com colisão
    Node *node = venhaAoMundo(x);
    node->prox = hash->array[pos]; // Adiciona no início da lista
    hash->array[pos] = node;
  }
}

bool pesquisar(int id, Hash *hash) {
  int pos = id % hash->tam;

  // Verificar se a posição está vazia
  if (hash->array[pos] == NULL) {
    return false;
  }

  // Procurar na lista encadeada
  Node *atual = hash->array[pos];
  while (atual != NULL) {
    if (atual->jogador->id == id) {
      return true; // Encontrou o jogador
    }
    atual = atual->prox;
  }

  return false; // Jogador não encontrado na lista
}
Jogador *GetplayerByName(char *nome, Jogador *time) {
  for (int i = 0; i < 3922; i++) {
    if (strcmp(time[i].nome, nome) == 0) {
      return &time[i];
    }
  }
  return NULL;
}

void adicionarQuebraDeLinha(const char *caminhoArquivo) {
    // Abrir o arquivo em modo de adição (append)
    FILE *arquivo = fopen(caminhoArquivo, "a");

    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return;
    }

    // Adicionar quebra de linha no final do arquivo
    fprintf(arquivo, "\n");

    // Fechar o arquivo
    fclose(arquivo);
}

int main() {

     // Caminhos dos arquivos
    const char *caminhoArquivoPub = "pub.out";
    const char *caminhoArquivoPri = "pri.out";

    // Adicionar quebra de linha no arquivo pub.out
    adicionarQuebraDeLinha(caminhoArquivoPub);

    // Adicionar quebra de linha no arquivo pri.out
    adicionarQuebraDeLinha(caminhoArquivoPri);

    
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

  // primeiro loop para inserir na Hash
  Hash *hash = criarHash(25);

  char buffer[400];
  while (true) {
    scanf(" %[^\n]", buffer);
    if (strcmp(buffer, "FIM") == 0) {
      break;
    } else {
      int id = atoi(buffer);
      inserir(&time[id], hash);
    }
  }
  while (true) {
    scanf(" %[^\n]", buffer);
    if (strcmp(buffer, "FIM") == 0) {
      break;
    } else {
      Jogador *player = GetplayerByName(buffer, time);
      int id = player->id;
      bool resp = pesquisar(id, hash);
      printf("%s", time[id].nome);
      if (resp) {
        printf(" SIM\n");
      } else {
        printf(" NAO\n");
      }
    }
  }

  fclose(arq);
  return 0;
}
