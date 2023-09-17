boolean isConsoante(String s, int n) {
    boolean resp = false;

    if (n != s.length()) {
        if (s.charAt(n) < '0' || s.charAt(n) > '9') {
            if (isVogal(s.charAt(n)) == true) {
                resp = false;
            } else {
                resp = isConsoante(s, n + 1);
            }
        } else {
            resp = false;
        }
    }

    return resp;
}

// o codigo primeiro se assegura que o numero N sera o valor do tamanho da string
//depois garante que o ultimo caracter não seja numero, mas falha pois se o caractere for 9 ou 0 ele não será contado no if;
//depois verifica se o ultimo caracter é vogal, se sim, então retorna false;
// caso não seja, ele manda para a função verificar n+1;

/*  O código não me parece correto, até por que pela recursão que o codigo apresenta,
 ela não funcionará já que existe uma verificação para checar se n é igual ao tamanho da string. */

 // correção abaixo:
 boolean isConsoante(String s, int n) {
    boolean resp = true; // Inicialize para verdadeiro, já que estamos procurando consoantes

    if (n < s.length()) {
        if (s.charAt(n) >= '0' && s.charAt(n) <= '9') {
            resp = false; // Se for um dígito, não é uma consoante
        } else if (isVogal(s.charAt(n))) {
            resp = false; // Se for uma vogal, não é uma consoante
        } else {
            resp = isConsoante(s, n + 1);
        }
    }

    return resp;
    }
