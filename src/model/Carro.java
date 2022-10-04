package model;

public class Carro {

    private Integer portas;
    private Integer capacidadePortaMalas;

    public Carro(Integer portas, Integer capacidadePortaMalas) {
        this.portas = portas;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    public Integer getPortas() {
        return portas;
    }

    public Integer getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    public void setCapacidadePortaMalas(Integer capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    public Carro() {
    }
}
