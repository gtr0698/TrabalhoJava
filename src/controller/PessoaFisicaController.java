package controller;

import model.PessoaFisica;
import model.Pessoa;
import util.Conexao;
import util.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaController {

	public static PessoaFisica cadastrar(PessoaFisica pf) {

		if (pf == null) {
			return null;
		}
		setarInformacoes(pf);
		return pf;
	}

	public static void setarInformacoes(PessoaFisica pf) {
		PessoaController.setarInformacoes(pf);

		System.out.println("CPF: ");
		pf.setCpf(Input.next());

		System.out.println("Data Nascimento: ");
		pf.setDataNascimento(Input.nextDate());

		System.out.println("Sexo: ");
		pf.setSexo(Input.next());
	}

	public static void Listar() {

		List<PessoaFisica> pf = new ArrayList<PessoaFisica>();
		String sql = "";
		Pessoa p = null;
		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {

				p = new PessoaFisica();
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));

				pf.add((PessoaFisica) p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		for (PessoaFisica pf2 : pf) {
			// montar view dados
		}
	}

	public static PessoaFisica buscar(String cpf) throws SQLException {

		PessoaFisica pf = new PessoaFisica();

		String sql = "";
		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {

				pf.setCpf(rs.getString("cpf"));
			}
		}

		return pf;
	}

	public static PessoaFisica editar() throws SQLException {

		PessoaFisica pf = new PessoaFisica();

		System.out.println("Qual cliente deseja editar? ");
		System.out.print("CPF");
		String cpf = Input.next();
		pf = buscar(cpf);
		String sql = "";
		Connection con = Conexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pf.getNome());
			ps.setString(2, pf.getEmail());
			ps.setString(3, pf.getTelefone());
			ps.setString(4, pf.getCpf());
			ps.setDate(5, new java.sql.Date(pf.getDataNascimento().getTime()));
			ps.setString(6, pf.getSexo());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pf;
	}

	public static void remover() throws SQLException {

		PessoaFisica pf = new PessoaFisica();

		pf = buscar();
		String sql = "";
		Connection con = Conexao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pf.getCpf());
			ps.execute();
		} finally {
			con.close();
		}
	}


}
