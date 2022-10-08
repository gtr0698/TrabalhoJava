package controller;

import model.Moto;
import model.Veiculo;
import util.Conexao;
import util.Input;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoController {

	public static Moto cadastrar(Moto m) {
		if (m == null) {
			return null;
		}
		setarMoto(m);
		return m;
	}

	public static Moto setarMoto(Moto c) {
		VeiculoController.setarVeiculo(c);

		System.out.print("Nº de Portas");
		c.setCilindradas(Input.nextInt());
		System.out.print("Capacidade do porta malas");


		return c;
	}

	public static void listar() {
		List<Moto> motos = new ArrayList<Moto>();
		String sql = "";

		Moto m = null;

		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

			m = new Moto();

			m.setPlaca(rs.getString("placa"));
			m.setAno(rs.getInt("ano"));
			m.setCor(rs.getString("cor"));
			m.setRenavam(rs.getString("renavam"));
			m.setKilometragem(rs.getInt("kilometragem"));

			motos.add(m);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		for (Moto moto : motos) {
			//print dos dados dos carros;
		}

	}

	public static Moto buscar(String placa) {
		Moto m = null;
		String sql = "";
		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {
			m = new Moto();

			m.setPlaca(rs.getString("placa"));
			m.setAno(rs.getInt("ano"));
			m.setCor(rs.getString("cor"));
			m.setRenavam(rs.getString("renavam"));
			m.setKilometragem(rs.getInt("kilometragem"));

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return m;
	}
}
