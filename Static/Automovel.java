public class Automovel {
    int consumo;
    int velocidade;
    Motor motor;
    
    //getters
    public int getConsumo() {
        return consumo;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public Motor getMotor() {
        return motor;
    }
    //setters
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void acelerar(){
        velocidade++;
    }

    public void frear(){
        velocidade--;
    }   

    
    protected boolean ligado;

    public void ligar(){
        ligado = true;
        velocidade = 0;
    }
    public void desligar(){
        velocidade = 0;
        ligado = false;
    }
}
