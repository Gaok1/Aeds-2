package Bibloteca;

// herda pessoa
public class Cliente extends Pessoa {
    private int codigo;
    private String endereco;
    boolean possuiLivro = false;

    Cliente(String nome, int idade, String sexo, String dataNascimento, int codigo, String endereco) {
        super(); // classe pai não tem construtor padrão
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.codigo = codigo;
        this.endereco = endereco;
    }

    //getters
    public String getNome(){
        return this.nome;
    }
    public int getIdade(){
        return this.idade;
    }
    public String getdataNascimento(){
        return this.dataNascimento;
    }

}

