package model;

import java.time.LocalDate;

public class Funcionario extends PessoaFisica{

    private String ctps;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String telefone, String email, Endereco endereco, String cpf,
                       LocalDate dataNascimento, String sexo, String ctps, String cargo, double salario) {
        super(nome, telefone, email, endereco, cpf, dataNascimento, sexo);
        this.ctps = ctps;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCtps() {
        return ctps;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getDocumento() {
        return "nome: " + getNome() +
                " telefone: " + getTelefone() +
                " email: " + getEmail();
    }

    public Funcionario() {
    }
}
