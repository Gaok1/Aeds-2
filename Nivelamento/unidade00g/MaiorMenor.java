package unidade00g;



public class MaiorMenor {
    static public void main(String[] args){
         

        int numero1 = MyIO.readInt();

         int numero2 = MyIO.readInt();

         int numero3 = MyIO.readInt();

        int menor = Math.min(Math.min(numero1, numero2), numero3);
        int maior = Math.max(Math.max(numero1, numero2), numero3);

        System.out.println("O menor número é: " + menor);
        System.out.println("O maior número é: " + maior);

        
    }
    
}
