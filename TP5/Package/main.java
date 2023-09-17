package Package;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Lista lista = new Lista(5);
        System.out.println("o que deseja fazer na lista?");
        while (true) {

            System.out.println("1 - inserir no inicio");
            System.out.println("2 - inserir");
            System.out.println("3 - inserir no fim");
            System.out.println("4 - listar");
            System.out.println("5 - Remover do inicio");
            System.out.println("6 - Remover ");
            System.out.println("7 - Remover do Fim");

            System.out.println("8 - Sair");
            int resp;
            Scanner scanner = new Scanner(System.in);
            resp = scanner.nextInt();
            switch (resp) {
                case 1:
                    System.out.println("digite o numero que deseja inserir");
                    resp = scanner.nextInt();
                    lista.inserirInicio(resp);
                    break;

                case 2:
                    int indice;
                    System.out.println("digite o numero que deseja inserir e sua posiçao na lista ");
                    resp = scanner.nextInt();
                    indice = scanner.nextInt();
                    lista.inserir(resp, indice);
                    break;

                case 3:
                    System.out.println("digite o numero que deseja inserir e sua posiçao na lista ");
                    resp = scanner.nextInt();
                    lista.inserirFim(resp);
                    break;

                case 4:
                    System.out.println("\n====LISTANDO====\n");
                    for (int e : lista.getLista()) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    lista.removerInicio();
                    break;

                case 6:
                    System.out.println("digite o numero que deseja remover na lista ");
                    resp = scanner.nextInt();
                    lista.remover(resp);
                case 7:
                    lista.removerFim();
                    break;
                case 8:
                    System.exit(1);
                    break;
                default:
            }
        }
    }
}