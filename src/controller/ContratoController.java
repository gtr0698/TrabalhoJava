package controller;

import model.*;
import util.Conexao;
import util.Input;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoController {
	public static Contrato cadastrar(Contrato c) {

		if (c == null) {
			return null;
		}
		setarContrato(c);
		return c;
	}


	private static void setarContrato(Contrato c) {

		System.out.println("Criação do contrato de locação:\n");

		System.out.print("");
		c.setDataInicio(Input.nextLocalDate());
		System.out.println("Qual o tipo do cliente ");
		System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica");
		int tipo = Input.nextInt();
		Pessoa p = null;

		if (tipo == 1) {
			System.out.println("Informe o CPF do cliente:");
			try {
				p = PessoaFisicaController.buscar(Input.nextLine());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		if (tipo == 2) {
			System.out.println("Informe o CNPJ do cliente:");
			try {
				p = PessoaJuridicaController.buscar(Input.nextLine());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		c.setCiente(p);
		System.out.println("Qual veiculo sera locado? \n1- Carro | 2- Moto | 3- Caminhão");
		int tipoVeiculo = Input.nextInt();

		System.out.println("Placa:");
		Veiculo v = null;
		if (tipoVeiculo == 1) {
			v = CarroController.buscar(Input.nextLine());
		}

		if (tipoVeiculo == 2) {
			v = MotoController.buscar(Input.nextLine());
		}

		if (tipoVeiculo == 3) {
			v = CaminhaoController.buscar(Input.nextLine());
		}

		c.setVeiculo(v);
		System.out.println("CPF do funcionario");
		String cpf = Input.nextLine();
		c.setFuncionario(FuncionarioController.buscar());

		c.setDataInicio(Input.nextLocalDate());
		c.setDataTermino(Input.nextLocalDate());
		c.setSitucao("Locado");
		System.out.println("Valor da diaria:");
		c.setValorLocacao(Input.nextDouble());
		c.setValorSeguro(Input.nextDouble());
		if (p instanceof PessoaFisica) {
			c.calcularValorSeguro(c.diasAlugados(), c.getValorSeguro(), p);
		}

		if (p instanceof PessoaJuridica) {
			c.calcularValorSeguro(c.diasAlugados(), c.getValorSeguro(), null);
		}


	}

	public Contrato buscar(int id) {
		String sql = "";
		Contrato contrato = new Contrato();
		Funcionario funcionario = new Funcionario();
		Pessoa p = null;

		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

			while (rs.next()) {
				contrato.setId(rs.getInt("id"));
				contrato.setSitucao(rs.getString("situacao"));
				// Setar dados do funcionario
				//funcionario
				contrato.setFuncionario(funcionario);
				// Setar dados do cliente
				contrato.setCiente(p);
				contrato.setDataInicio(rs.getDate("dataInicio").toLocalDate());
				contrato.setDataTermino(rs.getDate("dataFinal").toLocalDate());

				// outro que ainda faltam
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return contrato;
	}


	public List<Contrato> lista() {
		List<Contrato> contratos = new ArrayList<Contrato>();
		String sql = "";

		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

			while (rs.next()) {
				Contrato contrato = new Contrato();
				Funcionario funcionario = new Funcionario();
				Pessoa p = null;
				contrato.setId(rs.getInt("id"));
				contrato.setSitucao(rs.getString("situacao"));
				// Setar dados do funcionario
				//funcionario
				contrato.setFuncionario(funcionario);
				// Setar dados do cliente
				contrato.setCiente(p);
				contrato.setDataInicio(rs.getDate("dataInicio").toLocalDate());
				contrato.setDataTermino(rs.getDate("dataFinal").toLocalDate());

				// outro que ainda faltam


				contratos.add(contrato);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


		return contratos;
	}
}
