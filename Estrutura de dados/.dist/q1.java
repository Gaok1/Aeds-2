

int procurarLetra(No1 root, char letra, char letra2){

    if(root.letra == letra){
        return procurarFrases(root.No2, letra2);

    }else if(letra<root.letra){
        procurarLetra(root.esq, letra, letra2);

    }else if(letra>root.letra){
        procurarLetra(root.dir, letra, letra2);
    }

}

int procurarFrases(No2 temp, char letra2){
    char atual = temp.frase.charAt(temp.frase.length()-1);
    int result = 0;
    if(temp.esq != null){
        result += procurarFrases(temp.esq, letra2);
    }
    if(temp.dir != null){
       result += procurarFrases(temp.dir, letra2);
    }
    if(atual == letra2){ // se ele tiver a frase
        return 1+ result;
    }else{ //ele não tem a frase
        return result;
    }

}