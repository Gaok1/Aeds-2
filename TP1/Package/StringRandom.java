import java.util.Random;

public class StringRandom {

    public static char LetraRandom(Random gerador) { // funçao que gera um caracter aleatorio e retorna ele
        
        return ((char) ('a' + (Math.abs(gerador.nextInt()) % 26))); // gera char aleatorio e realiza o % para que o caracter seja do alfabeto minusculo;

    }

    public static String strRandom(String frase,Random gerador) { // monta uma nova String substituindo os valores retirados pelo gerador;

        String str = "";

        char Creferencia = LetraRandom(gerador), Ctroca = LetraRandom(gerador);
       
        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == Creferencia) {
                str += Ctroca;
            } else {
                str += frase.charAt(i);
            }

        }

        return str;
    }

    
    static boolean igual(String frase) { // veririca tamanho e caracter por caracter para ver se é igual a FIM

        if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        Random gerador = new Random(); // inicializacao do gerador
        gerador.setSeed(4);
        while (true) {
            

            String frase = MyIO.readLine();
            if(igual(frase)){
                break;
            }

            frase = strRandom(frase,gerador);
            MyIO.println(frase);

        }

    }

}
