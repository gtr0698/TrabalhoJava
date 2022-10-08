package controller;

import model.Funcionario;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import util.Input;

public class PessoaController {

    static Pessoa pessoa = null;

    public static Pessoa cadastrar() {
        setarInformacoes(pessoa);
        return pessoa;
    }

    public static void setarInformacoes(Pessoa pessoa) {

        System.out.println("Selecione um tipo de cadastro: ");
        int opcao = Input.nextInt();
        if (opcao == 1) {
            pessoa = new PessoaFisica();
        }
        if (opcao == 2) {
            pessoa = new PessoaJuridica();
        }
        if (opcao == 3) {
            pessoa = new Funcionario();
        }

        System.out.println("Nome: ");
        pessoa.setNome(Input.next());

        System.out.println("Email: ");
        pessoa.setEmail(Input.next());

        System.out.println("Telefone: ");
        pessoa.setTelefone(Input.next());

        EnderecoController.setarInformacoes(pessoa.getEndereco());

        if (pessoa instanceof PessoaFisica) {
            PessoaFisicaController.cadastrar((PessoaFisica) pessoa);
        }
        if (pessoa instanceof PessoaJuridica) {
            PessoaJuridicaController.cadastrar((PessoaJuridica) pessoa);
        }
        if (pessoa instanceof Funcionario) {
            FuncionarioController.cadastrar((Funcionario) pessoa);
        }

    }

    public static void listarTudo() {
        System.out.println("Selecione um tipo de cadastro: ");
        System.out.println("1- Pessoa Fisica:\n2- Pessoa Juridica:\n3- Funcionario");
        int opcao = Input.nextInt();
        if (opcao == 1) {
            PessoaFisicaController.Listar();
        }
        if (opcao == 2) {
            PessoaJuridicaController.Listar();
        }
        if (opcao == 3) {
            FuncionarioController.Listar();
        }
    }

    public static void editar(Pessoa pessoa) {
        setarInformacoes(pessoa);
    }
}
