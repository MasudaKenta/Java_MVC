package dao;

import java.sql.*;

public class Conexao {
    protected Connection con;
    protected Statement st;
    protected String query;

    public Conexao() {
        try {
            final String URL = "jdbc:mysql://localhost/dbsistema";
            final String DRIVER = "com.mysql.cj.jdbc.Driver";
            final String USUARIO = "root";
            final String SENHA = "";
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
