package controller;

import model.Carro;
import model.Pessoa;
import util.Conexao;
import util.Input;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroController {

	public static Carro cadastrar(Carro c) {
		if (c == null) {
			return null;
		}
		setarCarro(c);
		return c;
	}

	public static Carro setarCarro(Carro c) {
		VeiculoController.setarVeiculo(c);

		System.out.print("Nº de Portas");
		c.setPortas(Input.nextInt());
		System.out.print("Capacidade do porta malas");
		c.setCapacidadePortaMalas(Input.nextDouble());

		return c;
	}

	public static void listar() {
		List<Carro> carros = new ArrayList<Carro>();
		String sql = "";

		Carro c = null;

		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

			c = new Carro();

			c.setPlaca(rs.getString("placa"));
			c.setAno(rs.getInt("ano"));
			c.setCor(rs.getString("cor"));
			c.setRenavam(rs.getString("renavam"));
			c.setKilometragem(rs.getInt("kilometragem"));
			c.setPortas(rs.getInt("portas"));
			c.setCapacidadePortaMalas(rs.getDouble("porta_malas"));


			carros.add(c);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		for (Carro carro : carros) {
			//print dos dados dos carros;
		}

	}


	public static Carro buscar(String nextLine) {
		String sql = "";
		Carro c = null;
		try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {
			while (rs.next()) {
				c = new Carro();

				c.setPlaca(rs.getString("placa"));
				c.setAno(rs.getInt("ano"));
				c.setCor(rs.getString("cor"));
				c.setRenavam(rs.getString("renavam"));
				c.setKilometragem(rs.getInt("kilometragem"));
				c.setPortas(rs.getInt("portas"));
				c.setCapacidadePortaMalas(rs.getDouble("porta_malas"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return c;
	}
}
