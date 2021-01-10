package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {
    
    private final Connection con = ConnectionFactory.getConnectionFactory().getConnection();
    
    public boolean cadastrarProduto(Produto produto) {

        String sql = "insert into produto values (default,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getPreco());
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro em Cadastrar Produto: " + ex);
        }
        
        return true;
    }
    
    public boolean excluirProduto(int id){
    
        String sql = "delete from produto where id = ?";
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em Excluir Produto: " + ex);
        }
        
        return true;
    }
    
    public boolean atualizarProduto(Produto produto) {

        String sql = "update produto set nome=?, preco=? where id = ?";
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getPreco());
            ps.setInt(3, produto.getId());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro em Atualizar Produto: " + ex);
            return false;
        }
        return true;
    }
    
    public List<Produto> getProdutos() {

        List<Produto> produtos = new ArrayList();
        String sql = "select * from produto";
        PreparedStatement ps;

        try {

            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco"));
                produtos.add(produto);
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Listar Produtos: " + ex);
        }
        return produtos;
    }
    
    public Produto getProdutoById(int id) {
        
        Produto produto = new Produto();
        String sql = "select * from produto where id=?";
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();

            ResultSet rs = ps.getResultSet();
            
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
            }
            
            ps.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro no pegar produto por id: " + ex);
        }
        return produto;
    }
    
}
