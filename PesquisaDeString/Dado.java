public class Dado {
    private int valor;
    private String frase = "";

    Dado(String frase){
        this.frase = frase;
        calcularValor();
    }

    //calcular valor do dado

    private void calcularValor(){
        int soma = 0;
        for(int i = 0; i < frase.length(); i++){
            soma +=(int) frase.charAt(i);
        }

        this.valor = soma;
    }

    //setters e getters para  valor
    public int getValor(){
        return this.valor;
    }



    //setters e getters para frase
    public String getFrase(){
        return this.frase;
    }

    public void setFrase(String frase){
        this.frase = frase;
        calcularValor();//atualiza o valor do dado
    }
}
