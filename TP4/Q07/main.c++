#include <iostream>
using namespace std;

class Player{ //protected
  protected: // classe filha irá herdar tais atributos
    int xp;
    int dinheiro;
    string nome;

  private:
  int vida;

  public:

    Player(string x){
      vida = 100;
      xp = 0;
      dinheiro =0;
      nome = x;
    }
    Player(string x, int dinheiros){
      vida = 100;
      xp = 0;
      dinheiro =dinheiros;
      nome = x;
    }

  bool setXp(int valor){
    if(valor < 1000){
      xp +=valor;
      cout << "\n valor adicionado a player:" << nome << "valor atual:" << xp <<"\n";
      return true;
    }
    cout <<"\n Valor excede o possivel para player :" <<nome <<", Negado!\n";
    return false;
  }

    void Dano(int x){ //100 no parametro, nao vai descontar a vida
      if(x<50 && (vida-x) > 0){ //protege de sofrer dano maior do que 50, e de morrer(oq nao faz sentido, mas vale o exemplo)
        vida -=x;
      }else{
        cout <<"nao tirei vida do player:" << nome << "\n";
      }
    }

    ~Player(){ //funcao acionada quando o objeto for destruido
    cout <<"player foi de base\n";
  }

    private:

    void heal(){ //aumentar em 5 o hp
      cout << "Healei 5 pontos de vida" << nome << endl;
      if(vida <=95){

        vida+=5;
      }else{
        vida = 100;
      }
    }

};

class Adm : public Player {
public:
    Adm(string nome, int codigo) :       Player(nome) {
        if(codigo == 567){
          cout <<"Opa, ADM CORRETO!\n";
        }else{
          cout <<"VC NAO É ADM PORRA\n";
        }
    }

    ~Adm() {
        std::cout << "Adm foi destruído\n";
    }

    bool setXp (int valor){
      xp+=valor;
       cout << "\n valor adicionado a player:" << nome << "valor atual:" << xp <<"\n";
       return true;
    }

};

int main() {
  string nome;
  Player joao =  Player("joao");
  Adm Maia = Adm("Maia",567);
  joao.setXp(2000);
  Maia.setXp(2000);
  joao.setXp(100);

  return 0;
}
