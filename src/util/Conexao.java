package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static String status = "Fail in connection ...";

    public static Connection getConnection() {
        Connection con = null;
        try {
            String drive = "com.mysql.jdbc.Driver";
            Class.forName(drive);
            String server = "localhost"; // ip
            String database = "locadora"; // nome banco
            String url = "jdbc:mysql://" + server + "/" + database;

            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                status = "STATUS => Conexão realizada com sucesso";
            } else {
                status = "STATUS => Falha ao se conectar com o banco de dados";
            }
            //return con;
        } catch (ClassNotFoundException err) {
            System.out.println("Connection fail, drive not found!");
        } catch (SQLException err) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
        return con;
    }

    public static String statusConnection() {
        return status;
    }

    public static boolean closeConnection() {
        try {
            Conexao.getConnection().close();
            return true;
        } catch (SQLException err) {
            return false;
        }
    }

    public static Connection restarConnnection() {
        closeConnection();

        return Conexao.getConnection();

    }
}
