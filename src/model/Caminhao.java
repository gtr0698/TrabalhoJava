package model;

public class Caminhao extends Veiculo {

	private Integer eixos;
	private double capacidadeCarga;

	public Caminhao(Integer eixos, double capacidadeCarga) {
		this.eixos = eixos;
		this.capacidadeCarga = capacidadeCarga;
	}

	public Integer getEixos() {
		return eixos;
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setEixos(Integer eixos) {
		this.eixos = eixos;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public Caminhao() {
	}
}
