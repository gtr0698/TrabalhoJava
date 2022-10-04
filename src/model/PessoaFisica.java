package model;

import java.util.Date;

public class PessoaFisica extends Pessoa {

    private String cpf;
    private Date dataNascimento;
    private String sexo;

    public PessoaFisica(String nome, String telefone, String email, Endereco endereco, String cpf, Date dataNascimento, String sexo) {
        super(nome, telefone, email, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public PessoaFisica() {

    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String getDocumento(){
        return "nome: " + getNome() +
                "telefone: " + getTelefone() +
                " email: " + getEmail() +
                " cpf: " + cpf +
                " dataNascimento: " + dataNascimento +
                " sexo: " + sexo;
    }

    @Override
    public String getTipoPessoa() {
        return this.getClass().getSimpleName();
    }
}
