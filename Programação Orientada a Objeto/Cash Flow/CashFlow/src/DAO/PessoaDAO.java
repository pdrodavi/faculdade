/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Endereco;
import Dominio.Pessoa;
import Dominio.TipoPessoa;
import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amand
 */
public class PessoaDAO {

    private Connection conexao;

    public boolean create(Pessoa pessoa) {

        Integer lastInsertId = 0;
        try {
            open();

            PreparedStatement stmt;
            String command = ("INSERT INTO PESSOA (NOME, APELIDO, CPF_CNPJ, RG, NASCIMENTO, SEXO, EMAIL) VALUES (?,?,?,?,?,?,?)");

            stmt = conexao.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);
//            stmt.setString(1, p.getTipoPessoa().getDescricao());
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getApelido());
            stmt.setString(3, pessoa.getCpf_cnpj());
            stmt.setString(4, pessoa.getRg());
            stmt.setString(5, pessoa.getNascimento());
            stmt.setString(6, pessoa.getSexo());
            stmt.setString(7, pessoa.getEmail());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                lastInsertId = rs.getInt(1);// retornando IDPESSOA
            }
            stmt.close();

            PreparedStatement stmt2;
            String command2 = "INSERT INTO ENDERECO (ENDERECO, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, ID_PESSOA) VALUES (?,?,?,?,?,?,?) ";
            stmt2 = conexao.prepareStatement(command2);
            stmt2.setString(1, pessoa.getEndereco().getEndereco());
            stmt2.setString(2, pessoa.getEndereco().getNumero());
            stmt2.setString(3, pessoa.getEndereco().getBairro());
            stmt2.setString(4, pessoa.getEndereco().getCidade());
            stmt2.setString(5, pessoa.getEndereco().getEstado());
            stmt2.setString(6, pessoa.getEndereco().getCep());

            stmt2.setInt(7, lastInsertId);

            int result = stmt2.executeUpdate();
            stmt2.close();
            close();

            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            close();
            return false;
        }
    }

    public List<Pessoa> read() {

       Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
//                pessoa.setTipoPessoa((TipoPessoa)rs.getObject("F, j"));
                pessoa.setId(rs.getInt("IDPESSOA"));
//                pessoa.setTipoPessoa((TipoPessoa) rs.getObject("F, J"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setApelido(rs.getString("APELIDO"));
                pessoa.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                pessoa.setRg(rs.getString("RG"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setEmail(rs.getString("EMAIL"));

                pessoas.add(pessoa);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro aqui na classe pessoaDAO!");
        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }

    public List<Pessoa> readForNome(String nome) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pessoa> pessoas = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM PESSOA WHERE NOME LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
//                pessoa.setTipoPessoa((TipoPessoa) rs.getObject("F, J"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setApelido(rs.getString("APELIDO"));
                pessoa.setCpf_cnpj(rs.getString("CPF_CNPJ"));
                pessoa.setRg(rs.getString("RG"));
                pessoa.setNascimento(rs.getString("NASCIMENTO"));
                pessoa.setSexo(rs.getString("SEXO"));
                pessoa.setEmail(rs.getString("EMAIL"));

                pessoas.add(pessoa);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! no método readfornome");
        } finally {

            ConectionFactory.closeConnection(con, stmt, rs);
        }

        return pessoas;

    }

    public void update(Pessoa p) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE PESSOA SET NOME = ?, APELIDO = ?, CPF_CNPJ = ?, RG = ?, NASCIMENTO = ?, SEXO = ?, EMAIL = ? WHERE IDPESSOA = ?");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getApelido());
            stmt.setString(3, p.getCpf_cnpj());
            stmt.setString(4, p.getRg());
            stmt.setString(5, p.getNascimento());
            stmt.setString(6, p.getSexo());
            stmt.setString(7, p.getEmail());

            stmt.setInt(8, p.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao altualizar: " + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Pessoa p) {

        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE IDPESSOA = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
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
