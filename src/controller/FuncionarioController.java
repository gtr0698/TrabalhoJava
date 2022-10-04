package controller;

import model.Funcionario;
import model.Pessoa;
import util.Conexao;
import util.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    public static Funcionario cadastrar(Funcionario fc){

        if(fc == null){
            return null;
        }
        setarInformacoes(fc);
        return fc;
    }

    public static void setarInformacoes(Funcionario fc){
        PessoaController.setarInformacoes(fc);

        System.out.println("CTPS: ");
        fc.setCtps(Input.next());

        System.out.println("Cargo: ");
        fc.setCargo(Input.next());

        System.out.println("Salario: ");
        fc.setSalario(Input.nextDouble());
    }
    
    public static void Listar(){

        List<Funcionario> fc = new ArrayList<Funcionario>();
        String sql = "";
        Pessoa p= null;
        try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {
            while (rs.next()) {

                p = new Funcionario();
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));

                fc.add((Funcionario) p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (Funcionario fc2 : fc) {
            // montar view dados
        }
    }

    public static Funcionario buscar() throws SQLException {

        Funcionario fc = new Funcionario();

        String sql = "";
        try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()){
            while (rs.next()){

                fc.setCpf(rs.getString("cpf"));
            }
        }

        return fc;
    }

    public static Funcionario editar() throws SQLException{

        Funcionario fc = new Funcionario();

        fc = buscar();
        String sql = "";
        Connection con = Conexao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fc.getNome());
            ps.setString(2, fc.getEmail());
            ps.setString(3, fc.getTelefone());
            ps.setString(4, fc.getCargo());
            ps.setString(5, fc.getCtps());
            ps.setDouble(6, fc.getSalario());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fc;
    }

    public static void remover() throws SQLException {

        Funcionario fc = new Funcionario();

        fc = buscar();
        String sql = "";
        Connection con = Conexao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fc.getCpf());
            ps.execute();
        } finally {
            con.close();
        }
    }
}
