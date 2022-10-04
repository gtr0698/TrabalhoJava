package controller;

import model.Pessoa;
import model.PessoaJuridica;
import util.Conexao;
import util.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoJuridicaController {

    public static PessoaJuridica cadastrar(PessoaJuridica pj){

        if(pj == null){
            return null;
        }
        setarInformacoes(pj);
        return pj;
    }

    public static void setarInformacoes(PessoaJuridica pj){
        PessoJuridicaController.setarInformacoes(pj);

        System.out.println("CNPJ: ");
        pj.setCnpj(Input.next());

        System.out.println("Razão Social: ");
        pj.setRazaoSocial(Input.next());

        System.out.println("Data Abertura: ");
        pj.setDataAbertura(Input.nextDate());
    }

    public static void Listar(){

        List<PessoaJuridica> pj = new ArrayList<PessoaJuridica>();
        Pessoa p = null;
        String sql = "";
        try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()) {
            while (rs.next()) {

                p = new PessoaJuridica();
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));

                pj.add((PessoaJuridica) p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (PessoaJuridica pj2 : pj) {
            // montar view dados
        }
    }

    public static PessoaJuridica buscar() throws SQLException {

        PessoaJuridica pj = new PessoaJuridica();

        String sql = "";
        try (ResultSet rs = Conexao.getConnection().prepareStatement(sql).executeQuery()){
            while (rs.next()){

                pj.setCnpj(rs.getString("cnpj"));
            }
        }

        return pj;
    }

    public static PessoaJuridica editar() throws SQLException{

        PessoaJuridica pj = new PessoaJuridica();

        pj = buscar();
        String sql = "";
        Connection con = Conexao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pj.getNome());
            ps.setString(2, pj.getEmail());
            ps.setString(3, pj.getTelefone());
            ps.setString(4, pj.getRazaoSocial());
            ps.setDate(5, new java.sql.Date(pj.getDataAbertura().getTime()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pj;
    }

    public static void remover() throws SQLException {

        PessoaJuridica pj = new PessoaJuridica();

        pj = buscar();
        String sql = "";
        Connection con = Conexao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pj.getCnpj());
            ps.execute();
        } finally {
            con.close();
        }
    }
}
