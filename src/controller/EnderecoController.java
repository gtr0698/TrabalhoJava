package controller;

import model.Endereco;
import util.Input;

public class EnderecoController {

    public static Endereco cadastrar(){
        Endereco endereco = new Endereco();
        setarInformacoes(endereco);
        return endereco;
    }

    public static void setarInformacoes(Endereco endereco){
        if(endereco == null){
            System.out.println("Falha ao setar informações de Endereco");
            return;
        }

        System.out.println("Cidade: ");
        endereco.setCidade(Input.nextLine());

        System.out.println("Rua: ");
        endereco.setRua(Input.nextLine());

        System.out.println("Numero: ");
        endereco.setNumero(Input.nextLine());
    }
}
