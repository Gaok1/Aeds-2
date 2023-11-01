public class Carro extends Automovel {
    final String marca;
    final String modelo;
    final int ano;

    Carro(String marca, String modelo, int ano){
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;

        
    }

    
    //getters
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAno() {
        return ano;
    }
    
  
    boolean getEstado(){
        return ligado;
    }


    public void acecelerar(){
        if(velocidade<200 &&getEstado()){
            velocidade+=10;  
        }
      
    }

    public void frear(){
        if(velocidade>0 && getEstado()){
            velocidade/=2;
        }
    }



}
