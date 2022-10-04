package model;

public abstract class Veiculo {

    private String placa;
    private String renavam;
    private String cor;
    private Integer kilometragem;
    private Integer ano;
    private double valor;

    public String getPlaca() {
        return placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public String getCor() {
        return cor;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public Integer getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
