package model;

public class Versao {

    private String nome;
    private String motor;
    private String tipoCombustive;
    private String itensSerie;

    public String getNome() {
        return nome;
    }

    public String getMotor() {
        return motor;
    }

    public String getTipoCombustive() {
        return tipoCombustive;
    }

    public String getItensSerie() {
        return itensSerie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setTipoCombustive(String tipoCombustive) {
        this.tipoCombustive = tipoCombustive;
    }

    public void setItensSerie(String itensSerie) {
        this.itensSerie = itensSerie;
    }
}
