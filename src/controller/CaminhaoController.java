package controller;

import model.Caminhao;
import model.Veiculo;
import util.Conexao;
import util.Input;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaminhaoController {
	public static Caminhao cadastrar(Caminhao c) {
		if (c == null) {
			return null;
		}
		setarCaminhao(c);
		return c;
	}

	public static Caminhao setarCaminhao(Caminhao c) {
		VeiculoController.setarVeiculo(c);

		System.out.print("Carga Maxima:");
		c.setCapacidadeCarga(Input.nextDouble());
		System.out.print("Numero de eixos: ");
		c.setEixos(Input.nextInt());

		return c;
	}

	public static void listar() {
		List<Caminhao> caminhoes = new ArrayList<Caminhao>();
		String sql = "";

		Caminhao c = null;

		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

			c = new Caminhao();

			c.setPlaca(rs.getString("placa"));
			c.setAno(rs.getInt("ano"));
			c.setCor(rs.getString("cor"));
			c.setRenavam(rs.getString("renavam"));
			c.setKilometragem(rs.getInt("kilometragem"));
			c.setEixos(rs.getInt("eixos"));
			c.setCapacidadeCarga(rs.getDouble("carga"));

			caminhoes.add(c);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		for (Caminhao caminhao : caminhoes) {
			//print dos dados dos carros;
		}

	}

	public static Veiculo buscar(String nextLine) {
		String sql = "";
		Caminhao c = null;

		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

			c = new Caminhao();

			c.setPlaca(rs.getString("placa"));
			c.setAno(rs.getInt("ano"));
			c.setCor(rs.getString("cor"));
			c.setRenavam(rs.getString("renavam"));
			c.setKilometragem(rs.getInt("kilometragem"));
			c.setEixos(rs.getInt("eixos"));
			c.setCapacidadeCarga(rs.getDouble("carga"));

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return c;
	}
}
