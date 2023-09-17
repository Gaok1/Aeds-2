public class AlgebraBool {

    static boolean[] analiseElementos(String frase) {
        int tamanho = 0;
        if (frase.charAt(0) == '1') {
            tamanho = 1;

        } else if (frase.charAt(0) == '2') {
            tamanho = 2;

        } else if (frase.charAt(0) == '3') {
            tamanho = 3;

        }

        boolean[] arraybool = new boolean[tamanho];
        int count = 0;
        for (int i = 0; i < tamanho * 2 + 1; i++) {

            if (frase.charAt(i) == '1') {
                arraybool[count] = true;
                count++;
            } else if (frase.charAt(i) == '0') {
                arraybool[count] = false;
                count++;
            }

        }

        return arraybool;
    }

    public static void main(String[] args) {
        boolean arraybool[];
        while (true) {
            String frase = MyIO.readLine();

            if (igual(frase)) {

                break;
            }

            arraybool = analiseElementos(frase); // retorna um array bool com quantos elementos logicos terão e o valor
                                                 // deles em bool ex(a,b,c) se é true ou false;
            frase = funcIntermed(frase, arraybool); // retorna nova String com os operados substituidos por simbolos
            // para facilitar leitura and = ^, or = V, not = !

            frase = logicIntermed(frase);

            MyIO.println(frase);

        }

    }

    // intermediario das funçoes logicas
    public static String logicIntermed(String frase) {

        // preparando para chamar a funçao And
        int operadores = 0;

        for (int i = 0; i < frase.length(); i++) { // loop para contar quantos operadores tem na frase
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {

                operadores++;
            }
        }

        int[] array = new int[operadores];

        operadores--;// ajustando para index do array;
        int count = operadores; // criando copia de operadores

        for (int i = frase.length() - 1; i >= 0; i--) { // loop para guardar a posisao dos operadores em index de tras
                                                        // para frente para a ordem de resoluçao de operaçoes
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {
                array[count] = i;
                count--;
            }
        }

        while (operadores >= 0) { // loop para chamar as funçoes logicas de acordo com a ordem de resoluçao de
                                  // operaçoes



                                  if (frase.charAt(array[operadores]) == '^') {
                frase = andElement(frase, array[operadores]);
            } else if (frase.charAt(array[operadores]) == 'V') {
                frase = OrElement(frase, array[operadores]);
            } else if (frase.charAt(array[operadores]) == '!') {

                frase = notElementSingle(frase, array[operadores]);
            }

            operadores--;
        }

        return frase;
    }

    // faz a operação lógica not, and, or;

    public static String andElement(String frase, int index) {
        String newFrase = "";
        int i = 0;
        int aux = index;

        while (i < frase.length()) {

            if (i == index) {
                int count = 0;
                int positivo = 0;

                // Conta o número de dígitos dentro dos parênteses ate o fim dos parenteses
                while (frase.charAt(index) != ')') {
                    if (isnumber(frase.charAt(index))) {
                        count++;
                        if (frase.charAt(index) == '1') { // conta positivos
                            positivo++;
                        }

                    }
                    index++;
                }

                // Verifica se todos os dígitos dentro dos parênteses são '1'
                if (positivo == count) { // se numero de contagens for igual aos positivos quer dizer que a funçao é
                                         // true para o operador and
                    newFrase += '1';
                } else {
                    newFrase += '0';
                }

                i += count + 3; // Pula os dígitos e os parênteses
            } else {
                newFrase += frase.charAt(i);
                i++;
            }
            index = aux; // restaurando valor de index
        }

        return newFrase;
    }

    public static String notElementSingle(String frase, int index) { // troca o valor dos !not para elementos unicos
                                                                     // exemplo : !(A)
        String newFrase = "";
        int i = 0;
        int aux = index;

        while (i < frase.length()) {

            if (i == index) {
                int count = 0;

                // Conta o número de dígitos dentro dos parênteses
                while (frase.charAt(index) != ')') {
                    if (isnumber(frase.charAt(index))) {
                        count++;
                        if (frase.charAt(index) == '1') { // troca as entradas invertendo elas
                            newFrase += '0';
                        } else if (frase.charAt(index) == '0') {
                            newFrase += '1';
                        }

                    } else {

                    }
                    index++; // atualiza o index
                }

                i += count + 3; // Pula os dígitos e os parênteses
            } else {
                newFrase += frase.charAt(i);
                i++;
            }
            index = aux; // restaura valor do index
        }

        return newFrase;
    }

    public static String OrElement(String frase, int index) {
        String newFrase = "";
        int i = 0;
        int aux = index;

        while (i < frase.length()) {

            if (i == index) {
                int count = 0;
                int positivo = 0;

                // Conta o número de dígitos dentro dos parênteses
                while (frase.charAt(index) != ')') {
                    if (isnumber(frase.charAt(index))) {
                        count++;
                        if (frase.charAt(index) == '1') {
                            positivo++;
                        }

                    }
                    index++;
                }

                // Verifica se há digitos no parenteses que sao positivos
                if (positivo > 0) {
                    newFrase += '1';
                } else {
                    newFrase += '0';
                }

                i += count + 3; // Pula os dígitos e os parênteses
            } else {
                newFrase += frase.charAt(i);
                i++;
            }
            index = aux;
        }

        return newFrase;
    }

    // preparando a String para leitura logica abaixo desse comentário, Que Deus
    // perdoe essas funções malevolentes

    public static String limpandoString(String frase) { // um codigo que não me orgulho mas ele apenas deixa a String
                                                        // com os caracteres essenciais tirando as informação da entrada
                                                        // como espaços ou os numeros iniciais
        String newfrase = "";
        int newindex = 0;
        for (int i = 0; i < frase.length(); i++) { // caminhando e apagando numeros até chegar na operação
            if (frase.charAt(i) == 'V' || frase.charAt(i) == '!' || frase.charAt(i) == '^') {
                newindex = i;
                break;
            }
            if (!clear(frase.charAt(i))) {
                newfrase += frase.charAt(i);
            }
        }

        for (int i = newindex; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ' || frase.charAt(i) == ',') {

            } else {
                newfrase += frase.charAt(i);
            }
        }

        return newfrase;
    }

    public static String converterString(String frase, boolean[] arraybool) { // um metodo triste e nem um poucoc
                                                                              // eficiente para transformar os elementos
                                                                              // booleanos em 0 ou 1 de acordo com o
                                                                              // array montado anteriormente
        String newfrase = "";
        int tamanho = frase.length();
        int qtd = arraybool.length;

        if (qtd == 1) {
            for (int i = 0; i < tamanho; i++) {
                if (frase.charAt(i) == 'A') {
                    if (arraybool[0] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else {
                    newfrase += frase.charAt(i);
                }
            }
        } else if (qtd == 2) {
            for (int i = 0; i < tamanho; i++) {
                if (frase.charAt(i) == 'A') {
                    if (arraybool[0] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else if (frase.charAt(i) == 'B') {
                    if (arraybool[1] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else {
                    newfrase += frase.charAt(i);
                }
            }

        } else if (qtd == 3) {
            for (int i = 0; i < tamanho; i++) {
                if (frase.charAt(i) == 'A') {
                    if (arraybool[0] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else if (frase.charAt(i) == 'B') {
                    if (arraybool[1] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else if (frase.charAt(i) == 'C') {
                    if (arraybool[2] == true) {
                        newfrase += '1';
                    } else {
                        newfrase += '0';
                    }
                } else {
                    newfrase += frase.charAt(i);
                }
            }

        }
        return newfrase;
    }

public static String funcIntermed(String frase, boolean[] arraybool) { // funçõa intermediária que chama as outras
                                                                        // funções para substituir os operadores
                                                                        // logicos por simbolos

        frase = equalsAnd(frase);
        frase = equalsNot(frase);
        frase = equalsOr(frase);
        frase = (converterString(frase, arraybool)); // retorna String com os termos A,B,C substituidos pelos seus
                                                     // valores logicos.
        frase = limpandoString(frase); // remove os numeros da entrada inicial e

        return frase;
    }

    // retorna true se for igual a not
    public static String equalsNot(String frase) { // retorna String com a palavra Not substituida pelo operador !

        int count = 0;
        String newfrase = "";

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == 'n') {
                count++;
            } else if (frase.charAt(i) == 'o' && count == 1) {
                count++;
            } else if (frase.charAt(i) == 't' && count == 2) {
                newfrase += '!';
                count = 0;
            } else {
                newfrase += frase.charAt(i);
            }

        }
        return newfrase;
    }

    // retorna true se for igual a OR
    public static String equalsOr(String frase) {// retorna String com a palabra or substituida pelo operador V

        int count = 0;
        String newfrase = "";

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == 'o') {
                count++;
            } else if (frase.charAt(i) == 'r' && count == 1) {
                count = 0;
                newfrase += 'V';
            } else {
                newfrase += frase.charAt(i);
            }

        }
        return newfrase;
    }

    // retorna true se for igual a And
    public static String equalsAnd(String frase) { // retorna String com a palabra And substituida pelo operador ^
        int count = 0;
        String newfrase = "";

        for (int i = 0; i < frase.length(); i++) {

            if (frase.charAt(i) == 'a') {
                count++;
            } else if (frase.charAt(i) == 'n' && count == 1) {
                count++;
            } else if (frase.charAt(i) == 'd' && count == 2) {
                newfrase += '^';
                count = 0;
            } else {
                newfrase += frase.charAt(i);
            }

        }
        return newfrase;
    }

    static boolean igual(String frase) { // checa se a frase é igual a 0

        if (frase.length() == 1 && frase.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }

    }

    static boolean clear(char c) { // checa se é um numero ou um espaço ou uma virgula
        if (c == '1' || c == '2' || c == '3' || c == '0' || c == ' ' || c == ',' || c == '.') {
            return true;
        }

        return false;
    }

    static boolean isnumber(char c) { // checa se é um numero por comparações nada eficientes
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                || c == '0') {
            return true;
        }
        
        return false;
    }
}
