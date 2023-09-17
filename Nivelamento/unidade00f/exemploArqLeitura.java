package unidade00f;

public class exemploArqLeitura {

    public static void main(String[] args) {
        Arq.openRead("exemplo.txt");
        int inteiro = Arq.readInt();
        double real = Arq.readDouble();
        char caractere = Arq.readChar();
        boolean boleano = Arq.readBoolean();
        String str = Arq.readString();
        Arq.close();
        System.out.println("inteiro: " + inteiro);
        System.out.println("real: " + real);
        System.out.println("caractere: " + caractere);
        System.out.println("boleano: " + boleano);
        System.out.println("str: " + str);
    }

}
