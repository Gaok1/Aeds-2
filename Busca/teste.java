package Busca;

import java.util.Scanner;

class teste {
    public static void main(String[] args) {
        // escanear numero n

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        for (int i = n; i > 0; i /= 2) {

            count++;

            System.out.println("valor de i" + i);

        }

        System.out.println(count);
        sc.close();
    }
}