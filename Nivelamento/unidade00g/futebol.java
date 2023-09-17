package unidade00g;

public class futebol {

    public static void main(String[] args){

        MyIO.print("Digite os pontos do mandante e do visitante");
        int mandante = MyIO.readInt(); int visitante = MyIO.readInt();

        if(mandante == visitante){
            MyIO.println("Empate!");
        }else if(mandante > visitante){
            MyIO.println("Mandante ganhou!");

        }else{
            MyIO.println("visitante Ganhou!");
        }
    }
    
}
