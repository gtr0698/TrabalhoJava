package model;

public abstract class Pessoa {

    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;

    public Pessoa() {
        this.endereco = new Endereco();
    }

    public Pessoa(String nome, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDocumento(){
        return "nome: " + nome + " telefone: " + telefone + " email: " + "endereco: " + endereco;
    }

    public String getTipoPessoa(){
        return "Pessoa";
    }

}
