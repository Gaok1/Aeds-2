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

// Arvore AVL
typedef struct Node {
  Jogador *jogador;
  struct Node *esq;
  struct Node *dir;
} Node;

Node *venhaAoMundo(Jogador *x) {

  Node *node = malloc(sizeof(Node));
  node->jogador = x;
  node->esq = NULL;
  node->dir = NULL;
  return node;
}

typedef struct AVL {
  Node *root;
} AVL;

Node *BalancearEsq(Node *root);
Node *BalancearDir(Node *root);
Node *Balancear(Node *root);
Node *inserirNo(Node *root, Jogador *jogador);
void pesquisarPriv(Node *root, char *nome);
void pesquisar(AVL *arvore, char *nome);

void incializar(AVL *arvore) { arvore->root = NULL; }

int getAltura(Node *root) {
  if (root == NULL) {
    return 0;
  }
  int alturaDir = (root->dir) ? getAltura(root->dir) : 0;
  int alturaEsq = (root->esq) ? getAltura(root->esq) : 0;
  return (alturaEsq > alturaDir) ? alturaEsq + 1 : alturaDir + 1;
}

Node *BalancearEsq(Node *root) { // balanceando a direita!
  if (getAltura(root->dir->esq) > getAltura(root->dir->dir)) {
    root->dir = BalancearDir(root->dir);
  }
  Node *aux = root->dir;
  root->dir = aux->esq;
  aux->esq = root;
  return aux;
}

Node *BalancearDir(Node *root) { // balanceando a esquerda!
  if (getAltura(root->esq->dir) > getAltura(root->esq->esq)) {
    root->esq = BalancearEsq(root->esq);
  }
  Node *aux = root->esq;
  root->esq = aux->dir;
  aux->dir = root;
  return aux;
}

Node *Balancear(Node *root) {
  int soma = getAltura(root->dir) - getAltura(root->esq);
  if (soma > 1) { // direita está maior, deve ser balanceada

    root = BalancearEsq(root);
  } else if (soma < -1) { // esquerda esta maior, deve ser balanceada

    root = BalancearDir(root);
  }
  return root;
}

void BalancearCimaBaixo(Node* root){
  if(root == NULL){
    return;
  }
  root = Balancear(root);
  BalancearCimaBaixo(root->esq);
  BalancearCimaBaixo(root->dir);

}
// inserir em uma arvore AVL,
Node *inserirNo(Node *root, Jogador *jogador) { // func para inserir No
  if (root == NULL) {

    root = venhaAoMundo(jogador);
  } else if (strcmp(jogador->nome, root->jogador->nome) < 0) {

    root->esq = inserirNo(root->esq, jogador);
    root = Balancear(root);
  } else {

    root->dir = inserirNo(root->dir, jogador);
    root = Balancear(root);
  }
  return root;
}

void inserir(AVL *arvore, Jogador jogador) { // func chamada na Main
  Jogador *x = (Jogador *)malloc(sizeof(Jogador));
  *x = jogador;

  arvore->root = inserirNo(arvore->root, x);
}

void pesquisarPriv(Node *root, char *nome) {
  if (root == NULL) {
    printf(" NAO\n");
    return;
  } else if (strcmp(nome, root->jogador->nome) == 0) {
    printf(" SIM\n");
  } else if (strcmp(nome, root->jogador->nome) < 0) {
    printf(" esq");
    pesquisarPriv(root->esq, nome);
  } else {
    printf(" dir");
    pesquisarPriv(root->dir, nome);
  }
}

void pesquisar(AVL *arvore, char *nome) {
  printf("%s raiz", nome);
  pesquisarPriv(arvore->root, nome);
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
  // primeiro loop para inserir na Arvore
  AVL *arvore = malloc(sizeof(AVL));
  incializar(arvore);

  char buffer[400];
  while (true) {
    scanf(" %[^\n]", buffer);
    if (strcmp(buffer, "FIM") == 0) {
      break;
    } else {
      int id = atoi(buffer);
      inserir(arvore, time[id]);
    }
  }
  buffer[0] = '\0'; //limpando buffer
  // loop de pesquisa
  BalancearCimaBaixo(arvore->root);

  while (true) {
    scanf(" %[^\n]", buffer);
    if (strcmp(buffer, "FIM") == 0) {
      break;
    } else {
      pesquisar(arvore, buffer);
    }
  }

  fclose(arq);
  return 0;
}
