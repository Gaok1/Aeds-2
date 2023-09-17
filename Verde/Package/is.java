public class is {

    static boolean isvogal(char c) { // testa o caracer recebido para verificar se é vogal
        if (c == 'a' || c == 'A' || c == 'i' || c == 'I' || c == 'u' || c == 'U' || c == 'e' || c == 'E' || c == 'o'
                || c == 'O') {
            return true;
        } else {
            return false;
        }
    }

    static boolean igual(String frase) { // veririca tamanho e caracter por caracter para ver se é igual a FIM

        if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
            return true;
        } else {
            return false;
        }

    }

    static boolean cvogalRecursiva(String frase, int index) { // funçao recursiva que testa se todos os caracteres da
                                                              // String sao vogais
        if (index >= frase.length()) {
            MyIO.print("SIM ");
            return true;
        }

        if (isvogal(frase.charAt(index))) {
            
            return cvogalRecursiva(frase, index + 1);
        } else {
            MyIO.print("NAO ");
            return false;
        }
    }

    static boolean cvogal(String frase) {
        return cvogalRecursiva(frase, 0);
    }

    static boolean cConsoanteRecursiva(String frase, int index) { // verifica se é composta por consantes por meio da
                                                                  // negaçao da funcao
        // isVogal

        if (index >= frase.length()) {// condiçao de parada da recursao
            MyIO.print("SIM ");
            return true;

        }
        if (!isvogal(frase.charAt(index)) && !isnumber(frase.charAt(index))) {
            cConsoanteRecursiva(frase, index + 1);
            return true;
        } else {
            MyIO.print("NAO ");
            return false;
        }

    }

    static boolean cConsoante(String frase) {
        if (cConsoanteRecursiva(frase, 0)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean cnumeroRecursivo(String frase, int index) { // funçao recursiva para ver se a string é um numero
                                                               // natural (+);
        if (index >= frase.length()) { // condiçao de parada se o index for maior que o tamanho da string, ou seja, ele
                                       // ja percorreu toda a String
            MyIO.print("SIM ");
            return true; // retorna positivo pois so chegara aqui se toda a frase for condicional true
        }

        if (isnumber(frase.charAt(index))) {
            cnumeroRecursivo(frase, index + 1); // chama a proxima recursao
            return true;
        } else {
            MyIO.print("NAO ");
            return false; // retorna false e printa nao;
        }
    }

    static boolean cnumero(String frase) { // chama cnumero recursivo

        if (cnumeroRecursivo(frase, 0)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isnumber(char c) { // checa se é um numero por comparações nada eficientes
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                || c == '0') {
            return true;
        }

        return false;
    }

    static boolean cnumeroRealRecursivo(String frase, int index, int count) {
        if (index >= frase.length()) {
            MyIO.print("SIM\n");
            return true;
        } else {
            if (frase.charAt(index) == '.' || frase.charAt(index) == ',') {
                count++;
                if (count > 1) {
                    MyIO.print("NAO\n");
                    return false;
                }
                cnumeroRealRecursivo(frase, index + 1, count);
                return true;
            }

            if (isnumber(frase.charAt(index))) {
                cnumeroRealRecursivo(frase, index + 1, count);
                return true;
            } else {
                MyIO.print("NAO\n");
                return false;
            }
        }
    }

    static boolean cnumeroreal(String frase) { // metodo que checa se a frase é um numero real
        if (cnumeroRealRecursivo(frase, 0, 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) { // metodo main que le a string e chama as funçoes iterativas

        while (true) {
            String frase = MyIO.readLine();
            if (igual(frase)) {
                break;
            }

            cvogal(frase);
            cConsoante(frase);
            cnumero(frase);
            cnumeroreal(frase);

            // JÁ ACIONA VOGAL QUE PRINTARA O RESULTADAO E USA O RETORNO PARA VER SE É
            // CONSOANTE

        }
    }

}
