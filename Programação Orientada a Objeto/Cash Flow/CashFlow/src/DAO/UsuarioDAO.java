/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Usuario;
import Dominio.Usuario;
import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amand
 */
public class UsuarioDAO {

    private Connection conexao;

    public boolean checkLogin(String login, String senha) {// VALIDANDO O LOGIN E SENHA

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;//Criando um retorno

        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE LOGIN =? and SENHA =?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            //exetuda oq ta em cima e manda mo "rs" ResultSet aqui embaixo
            rs = stmt.executeQuery();

            if (rs.next()) {// se econtrar alguma coisa ...

                check = true;//encontrou
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }

        return check;// retornando o check

    }

    public boolean create(Usuario usuario) {

        Integer lastInsertId = 0;
        try {
            open();

            PreparedStatement stmt;
            String command = ("INSERT INTO USUARIO (USUARIO, SENHA) VALUES (?,?)");

            stmt = conexao.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);
//            stmt.setString(1, p.getTipoPessoa().getDescricao());
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            stmt.close();

            close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            close();
            return false;
        }

        return true;

    }

    private void open() {
        ConectionFactory cf = new ConectionFactory();
        this.conexao = cf.getConnection();
    }

    private void close() {
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
