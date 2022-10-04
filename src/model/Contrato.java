package model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Contrato {

    private int id;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String situcao;
    private Pessoa ciente;
    private Funcionario funcionario;
    private Veiculo veiculo;
    private double valorLocacao;
    private double valorSeguro;

    public Contrato(int id, LocalDate dataInicio, LocalDate dataTermino, String situcao, Pessoa ciente,
                    Funcionario funcionario, Veiculo veiculo, double valorLocacao, double valorSeguro) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.situcao = situcao;
        this.ciente = ciente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.valorLocacao = valorLocacao;
        this.valorSeguro = valorSeguro;
    }

    public int getId() {
        return id;
    }

    public int diasAlugados(){
        return (int) DAYS.between(this.dataInicio, this.dataTermino);
    }

    public double calcularValorSeguro(){
        int dias = diasAlugados();
        return dias * getValorSeguro();
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public String getSitucao() {
        return situcao;
    }

    public Pessoa getCiente() {
        return ciente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setSitucao(String situcao) {
        this.situcao = situcao;
    }

    public void setCiente(Pessoa ciente) {
        this.ciente = ciente;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
}
