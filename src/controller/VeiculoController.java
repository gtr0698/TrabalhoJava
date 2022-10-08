package controller;

import model.Caminhao;
import model.Carro;
import model.Moto;
import model.Veiculo;
import util.Input;

public class VeiculoController {
	public static Veiculo cadastar(Veiculo v) {
		if (v == null) {
			return null;
		}
		setarVeiculo(v);
		return v;
	}

	public static void setarVeiculo(Veiculo v) {
		System.out.println("Qual tipo de veiculo deseja cadastrar ? ");
		System.out.println("1 - Carro | 2 - Moto | 3- Caminhão");

		int opcao = Input.nextInt();
		if (opcao == 1) {
			v = new Carro();
		}
		if (opcao == 2) {
			v = new Moto();
		}
		if (opcao == 3) {
			v = new Caminhao();
		}
		System.out.print("Placa: ");
		v.setPlaca(Input.next());
		System.out.print("RENVAM: ");
		v.setRenavam(Input.next());
		System.out.print("Cor: ");
		v.setCor(Input.next());
		System.out.print("Kilometragem: ");
		v.setKilometragem(Input.nextInt());
		System.out.print("Valor R$");
		v.setValor(Input.nextDouble());

		if (v instanceof Carro) {
			CarroController.cadastrar((Carro) v);
		}
		if (v instanceof Moto) {
			MotoController.cadastrar((Moto) v);
		}
		if (v instanceof Caminhao) {
			CaminhaoController.cadastrar((Caminhao) v);
		}
	}

	public void listarTudo() {
		System.out.println("Selecione quais veliculos deseja ver: ");
		System.out.println("1- Pessoa Fisica:\n2- Pessoa Juridica:\n3- Funcionario");
		int opcao = Input.nextInt();
		if (opcao == 1) {
			CarroController.listar();
		}
		if (opcao == 2) {
			MotoController.listar();
		}
		if (opcao == 3) {
			CaminhaoController.listar();
		}
	}


	// Ediatar para mais tarde
}



/*
* try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {

		} finally {
			Conexao.closeConnection();
		}
*
*
* */
