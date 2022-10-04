package model;

import java.util.Date;

public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String razaoSocial;
    private Date dataAbertura;

    public PessoaJuridica(String nome, String telefone, String email, Endereco endereco, String cnpj, String razaoSocial, Date dataAbertura) {
        super(nome, telefone, email, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.dataAbertura = dataAbertura;
    }

    public PessoaJuridica() {

    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    @Override
    public String getDocumento(){
        return "nome: " + getNome() +
                "telefone: " + getTelefone() +
                " email: " + getEmail() +
                " cnpj: " + cnpj +
                " razaoSocial: " + razaoSocial +
                " dataAbertura: " + dataAbertura;
    }

    @Override
    public String getTipoPessoa() {
        return this.getClass().getSimpleName();
    }
}
