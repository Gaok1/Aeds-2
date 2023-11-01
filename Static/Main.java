public class Main {
 public static void main(String[] args) {
    Carro uno = new Carro("Fiat", "Uno", 2010);

    
    uno.setConsumo(10);
    
    uno.ligar();
    uno.acelerar();

    Automovel semi_Uno = new Carro("Fiat", "Uno", 2010);

    semi_Uno.ligar();
    semi_Uno.acelerar();
    semi_Uno.frear();
    System.out.println(semi_Uno.getVelocidade());
    semi_Uno.desligar();

    
 }   

}
