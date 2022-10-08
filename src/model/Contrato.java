package model;

import java.time.LocalDate;
import java.util.Date;

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

	public Contrato() {
	}

	public int getId() {
		return id;
	}

	public int diasAlugados() {
		return (int) DAYS.between(this.dataInicio, this.dataTermino);
	}

	public double calcularValorSeguro(int d, double v, Pessoa p) {
		double total = 0;
		if (p instanceof PessoaFisica) {
			if (((PessoaFisica) p).getSexo().equalsIgnoreCase("F")) {
				return total = (d * v) - ((d * v) * 0.1);
			}

			if (idade(((PessoaFisica) p).getDataNascimento()) >= 35) {
				return total = (d * v) - ((d * v) * 0.15);
			}
		}
		return d * v;
	}

	public double calcularValorTotal(int d, int v, double s) {
		double total = (d * v) + s;
		if (d >= 90) {
			return total -= total * 0.25;
		}
		if (d >= 30) {
			return total -= total * 0.1;
		}
		return total;

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

	public int idade(Date d) {
		int idade = new Date().getYear() - d.getYear();
		return idade;
	}
}
