//objeto main para controle

package Bibloteca;

import java.util.Scanner;

/**
 * Bibloteca
 */
public class Bibloteca {

    public static Livro Estante[] = new Livro[100];
    public static int index = 0;
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        //criando autores
        Autor jorge = new Autor("Jorge", 20, "M", "20/10/1999");
        Autor Maria = new Autor("Maria", 20, "F", "20/10/1999");
        Autor João = new Autor("João", 20, "M", "20/10/1999");

        // clientes
        Cliente luis = new Cliente("Luis Phillip", 19, "Masculino", "22/08/2004", 1441283, "30280370");

        Livro CafeSeneca = new Livro( "Cafe com Seneca",872,"Filosofando",jorge);
        System.out.println("primeiro livro adicionado: " + CafeSeneca.getTitulo() +"\npertencente ao autor :" + CafeSeneca.getAutor().getNome()); // fazer isso é do karalho kkk
        InserirLivro(CafeSeneca);
        CafeSeneca.setClienteAtual(luis);
        System.out.println("cliente atual que possui o livro: " + CafeSeneca.getClienteAtual().getNome());

        // interaçao usuario

        System.out.println("deseja interagir como autor ou como cliente? 1/2");
        int resp = input.nextInt();

        

      



    }




    public static void InserirLivro(Livro livro){
        if(Estante.length == index){
            System.out.println("estante cheia\nRealocando Livros...");
            Livro buffer[] =  Estante;
            Estante = new Livro[index*2];
            for(int i = 0; i<index;i++){
                Estante[i] = buffer[i];

            }
            System.out.println("alocação completa :)");
            Estante[index] = livro;
            System.out.println("livro adicionado com sucesso");
            index++;


        }else{
              Estante[index] = livro;
            System.out.println("livro adicionado com sucesso");
            index++;
        }
    }


    public static Livro[] getEstante(){

        return Estante;
    }
}