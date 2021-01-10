package br.com.rokobasi.eakademy.dao;

import br.com.rokobasi.eakademy.connection.ConnectionFactory;
import br.com.rokobasi.eakademy.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();

    public Login autenticacao(String cpf, String senha) {
        
        Login login = null;
        String sql = "select * from usuarios where cpf = ? and senha = ?";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, cpf);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                    
                  login = new Login(rs.getLong("id"), 
                          rs.getString("nome"), 
                          rs.getString("cpf"), 
                          rs.getString("senha"), 
                          rs.getString("perfil"), 
                          rs.getInt("id_curso"));
                  
            }

            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no método de autenticação: " + ex);
        }
        return login;
    }

}

