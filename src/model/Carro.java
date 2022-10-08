package model;

public class Carro extends Veiculo {

	private Integer portas;
	private double capacidadePortaMalas;

	public Carro(Integer portas, Integer capacidadePortaMalas) {
		this.portas = portas;
		this.capacidadePortaMalas = capacidadePortaMalas;
	}

	public Integer getPortas() {
		return portas;
	}

	public double getCapacidadePortaMalas() {
		return capacidadePortaMalas;
	}

	public void setPortas(Integer portas) {
		this.portas = portas;
	}

	public void setCapacidadePortaMalas(double capacidadePortaMalas) {
		this.capacidadePortaMalas = capacidadePortaMalas;
	}

	public Carro() {
	}
}
