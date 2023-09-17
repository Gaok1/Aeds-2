package Bibloteca;

public class Livro {
    private String titulo;
    private int codigo;
    private String editora;
    private Cliente historicoCliente[]; // lista de clientes que pegaram o livro
    private int index = 0; // index para inserir na lista
    private Cliente clienteAtual; // cliente que está com o livro e inserido na lista
    private Autor autor;

    Livro(){
        this.historicoCliente = new Cliente[10];

    }

    Livro(String titulo, int codigo, String editora, Autor autor) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.editora = editora;
        this.autor = autor;
        this.historicoCliente = new Cliente[10];
    }  

    //Lista
    private void inserirCliente(Cliente cliente){
      if(index == historicoCliente.length){
        System.out.println("Lista cheia");
        System.out.println("realocando historico...");

        Cliente[] buffer = historicoCliente;

        historicoCliente = new Cliente[buffer.length * 2];

        for(int i = 0; i<index;i++){
          historicoCliente[i] = buffer[i];
        }
        
        System.out.println("realocação concluida");
        historicoCliente[index] = cliente;
        index++;
        System.out.println("Cliente salvo no historico com sucesso");
      } else{
        historicoCliente[index] = cliente;
        index++;
        System.out.println("Cliente salvo no historico com sucesso");
      }
        
    }

    //getters
    public String getTitulo() {
        return titulo;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getEditora() {
        return editora;
    }
    public Cliente[] getHistoricoCliente() {
        return historicoCliente;
    }
    public Cliente getClienteAtual() {
        return clienteAtual;
    }
    public Autor getAutor() {
        return autor;
    }	
    //setters
    public void setClienteAtual(Cliente clienteAtual) {

        this.clienteAtual = clienteAtual;
      
            inserirCliente(clienteAtual);
        
    }

    // manipular a lista de clientes
}
