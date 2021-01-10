/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Titulo;
import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author amand
 */
public class TituloDAO {
      public void create(Titulo t) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO TITULO (TIPOTITULO, DATATITULO, DESCRICAO, VALOR,PAGO,ID_PESSOA,ID_CATEGORIATITULO) VALUES (?,?,?,?,?,?,?)");
              stmt.setString(1, t.getTipoTitulo());
              stmt.setDate(2, (Date) t.getData());
              stmt.setString(3, t.getDescricao());
              stmt.setDouble(4, t.getValor());
              stmt.setBoolean(5, t.getPago());
              stmt.setInt(6, t.getPessoa().getId());
              stmt.setString(7, t.getCategoria().getDescricao());


            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Titulo Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }
    
}
