class ciframentoRecursivo {

    public static String cifrarRecursivo(int key, int index, String frase, String cifra) { // preenche a cifra vazia com caracteres de forma recursiva
        if (index == 0) {  //condiçao de parada
            char buffer = (char) ((int) (frase.charAt(index) + key));
            cifra+=buffer;
            return cifra;
        }
        char buffer = (char) ((int) (frase.charAt(index) + key));
        
        cifra =  cifrarRecursivo(key, index - 1, frase, cifra);
        cifra += buffer;  // soma caracter na ordem correta e retortna a cifra;

        return cifra;

    }
    
    public static String cifrar(String frase) { // função que entra em um loop para adicioa +3 na tabela ascii em cada
                                                // caracter
        // chave da frase e string cifra e buffer para portar a soma dos caracteres
      
        String cifra = "";
        cifra = cifrarRecursivo(3, frase.length()-1, frase, cifra);
        return  cifra;
    }

    static boolean igual(String frase) { // veririca tamanho e caracter por caracter para ver se é igual a FIM

        if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) { // escanneia a frase e chama as funçoes
        while (true) {
            String frase = MyIO.readLine();

            if (igual(frase)) {
                break;
            }

            MyIO.println(cifrar(frase));

        }

    }
}
