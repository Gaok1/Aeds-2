package Bibloteca;

public class Autor extends Pessoa {

    Autor(String nome, int idade, String sexo, String dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;

    }
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
