package br.com.rokobasi.eakademy.dao;

import br.com.rokobasi.eakademy.connection.ConnectionFactory;
import br.com.rokobasi.eakademy.model.Vestibular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VestibularDAO {
    
    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();
    
    public void cadastrarVestibular(Vestibular vestibular){
        
        String sql = "insert into vestibular values(default,?,?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vestibular.getNome());
            ps.setString(2, vestibular.getData());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO no vestibularDAO Cadastro: " + ex);
        }
        
    }
    
    public List<Vestibular> getAll() {
        
        List<Vestibular> vests = new ArrayList();
        String sql = "select * from vestibular";
        PreparedStatement ps;
        
        try {
            
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vests.add(new Vestibular(rs.getLong("id"), rs.getString("nome"), rs.getString("data")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Usuarios DAO: " + ex);
        }
        return vests;
    }
    
    public Vestibular getVestibularById(Long id) {
        Vestibular vest = new Vestibular();
        String sql = "select * from vestibular where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                vest.setId(rs.getLong("id"));
                vest.setNome(rs.getString("nome"));
                vest.setData(rs.getString("data"));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no getUsuarioByID: " + ex);
        }

        return vest;
    }
    
    public void updateVestibular(Vestibular vestibular) {

        String sql = "update vestibular set nome=?, data=? where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vestibular.getNome());
            ps.setString(2, vestibular.getData());
            ps.setLong(3, vestibular.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em atualizar usuario: " + ex);
        }
    }
    
    public void excluir(Long id) {
        String sql = "delete from vestibular where id=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em Excluir usuárioDAO: " + ex);
        }

    }
       
}
