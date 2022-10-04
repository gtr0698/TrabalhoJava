package model;

public class Endereco {

    private String cidade;
    private String rua;
    private String numero;

    public Endereco() {
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return cidade + ": " + rua + ", " + numero;
    }
}
