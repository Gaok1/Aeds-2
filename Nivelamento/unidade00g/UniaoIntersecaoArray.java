package unidade00g;

import java.util.HashSet;

import java.util.Set;

  

public class UniaoIntersecaoArray {

     public static boolean containsElement(int[] array, int elemento) {
        for (int num : array) {
            if (num == elemento) {
                return true;
            }
        }
        return false;
    }

     public static void main(String[] args) {
       
        MyIO.println("Digite o tamanho do primeiro array: ");
        int tamanho1 = MyIO.readInt();
        int[] array1 = new int[tamanho1];

        MyIO.println("Digite os elementos do primeiro array:");
        for (int i = 0; i < tamanho1; i++) {
            array1[i] = MyIO.readInt();
        }

        MyIO.println("Digite o tamanho do segundo array: ");
        int tamanho2 = MyIO.readInt();
        int[] array2 = new int[tamanho2];

        MyIO.println("Digite os elementos do segundo array:");
        for (int i = 0; i < tamanho2; i++) {
            array2[i] = MyIO.readInt();
        }

        Set<Integer> uniao = new HashSet<>();
        Set<Integer> intersecao = new HashSet<>();

        for (int elemento : array1) {
            uniao.add(elemento);
            if (containsElement(array2, elemento)) {
                intersecao.add(elemento);
            }
        }

        for (int elemento : array2) {
            uniao.add(elemento);
        }

        MyIO.println("União dos arrays: " + uniao);
        MyIO.println("Interseção dos arrays: " + intersecao);

    }

 
    
}
