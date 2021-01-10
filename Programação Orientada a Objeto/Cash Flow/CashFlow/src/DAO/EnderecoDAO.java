///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import Dominio.Endereco;
//import Dominio.Pessoa;
//import conection.ConectionFactory;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author amand
// */
//public class EnderecoDAO {
//
//    public void create(Endereco endereco) {
//        
//        
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        Pessoa pess = new Pessoa();
//
//        try {
//            stmt = con.prepareStatement("INSERT INTO ENDERECO (ENDERECO, BAIRRO, NUMERO, CEP, ESTADO, ID_PESSOA) VALUES (?,?,?,?,?,?) ");
//            stmt.setString(1, endereco.getEndereco());
//            stmt.setString(2, endereco.getBairro());
//            stmt.setString(3, endereco.getNumero());
//            stmt.setString(4, endereco.getCep());
//            stmt.setString(5, endereco.getEstado());
//            stmt.setInt(6, endereco.getId_pessoa()); 
//
//            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Endereço Salvo com sucesso!");
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
//
//        } finally {
//            ConectionFactory.closeConnection(con, stmt);
//        }
//
//    }
//
//    public List<Endereco> read() {
//
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Endereco> enderecos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM endereco");
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Endereco endereco = new Endereco();
//
////                endereco.setId(rs.getInt("IDENDERECO"));
//
//                endereco.setEndereco(rs.getString("ENDERECO"));
////                endereco.setNumero(rs.getString("NUMERO"));
////                endereco.setBairro(rs.getString("BAIRRO"));
////                endereco.setCidade(rs.getString("CIDADE"));
////                endereco.setEstado(rs.getString("ESTADO"));
////                endereco.setCep(rs.getString("CEP"));
////                endereco.setId_pessoa(rs.getInt("ID_PESSOA"));
//
//                enderecos.add(endereco);
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro!");
//        } finally {
//            ConectionFactory.closeConnection(con, stmt, rs);
//        }
//
//        return enderecos;
//
//    }
//        public List<Endereco> readForNome(String endereco) {
//
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Endereco> enderecos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE ENDERECO LIKE ?");
//            stmt.setString(1, "%" + endereco + "%");
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Endereco end = new Endereco();
//                end.setEndereco(rs.getString("ENDERECO"));
//                end.setNumero(rs.getString("NUMERO"));
//                end.setBairro(rs.getString("BAIRRO"));
//                end.setCidade(rs.getString("CIDADE"));
//                end.setEstado(rs.getString("ESTADO"));
//                end.setCep(rs.getString("CEP"));
//              //  end.setId_pessoa(rs.getInt("ID_PESSOA"));
//
//                enderecos.add(end);
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro! no método readfornome");
//        } finally {
// 
//           ConectionFactory.closeConnection(con, stmt, rs);
//        }
//
//        return enderecos;
//
//    }
//        
//            public void update(Endereco endereco) {
//
//        Connection con = ConectionFactory.getConnection();
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("UPDATE ENDERECO SET ENDERECO = ?, BAIRRO = ?, NUMERO = ?, CEP = ?,ESTADO =? WHERE IDENDERECO  = ?");
//           
//            
//          
//            stmt.setString(1, endereco.getEndereco());
//            stmt.setString(2, endereco.getBairro());
//            stmt.setString(3, endereco.getNumero());
//            stmt.setString(4, endereco.getCep());
//            stmt.setString(5, endereco.getEstado());
//            stmt.setInt(6, endereco.getId());
//
//          
//            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao altualizar: " + ex);
//
//        } finally {
//            ConectionFactory.closeConnection(con, stmt);
//        }
//    }
//
//}
