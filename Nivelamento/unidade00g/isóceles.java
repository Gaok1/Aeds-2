package unidade00g;

public class isóceles {

    public static void main(String[] args){
        int lado1 = MyIO.readInt();
        int lado2 = MyIO.readInt();
        int lado3 = MyIO.readInt();
        
        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("Triângulo Equilátero");
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            System.out.println("Triângulo Isósceles");
        } else {
            System.out.println("Triângulo Escaleno");
        }
    }
}
