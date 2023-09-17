/**
 * main
 */
public class main {

    public static void main(String[] args) {
        //crie cinco frases 5 dados com frases distintas
        Dado array[] = new Dado[5];

        array[0] = new Dado("Olá mundo");
        array[1] = new Dado("Adeus mundo");
        array[2] = new Dado("McDonalds");
        array[3] = new Dado("formiga");
        array[4] = new Dado("prefácio");
        
      

        Pesquisador pesquisador = new Pesquisador(3);

       
        String[] resultados = pesquisador.pesquisar(array, "prefacio");

        
     
        for(int i = 0; i < resultados.length; i++){
            System.out.println(resultados[i]);
        }
    }




}