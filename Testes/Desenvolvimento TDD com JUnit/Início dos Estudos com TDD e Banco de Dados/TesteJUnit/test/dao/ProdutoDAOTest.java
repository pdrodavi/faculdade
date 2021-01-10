package dao;

import model.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
    }

    @Test
    @Ignore // anotação para ignorar o método ja testado 
    public void cadastrarProduto() {
        
        Produto p = new Produto("Galaxy S8", 2500);
        ProdutoDAO dao = new ProdutoDAO();
        
        if(dao.cadastrarProduto(p)){
            System.out.println("Cadastrado com sucesso!");
        } else {
            fail("Erro em cadastrar o produto");
        }  
    }
    
    @Test
    public void listarProdutos(){
    
        ProdutoDAO dao = new ProdutoDAO();
        for(Produto p : dao.getProdutos()){
            System.out.println("");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("");
        }
    }
    
    @Test
    @Ignore
    public void excluirProduto(){
        ProdutoDAO dao = new ProdutoDAO();
        if(dao.excluirProduto(4/*id do produto*/)){
            System.out.println("Excluído com sucesso!");
        } else {
            fail("Erro em excluir o produto");
        }
    }
    
    @Test
    @Ignore
    public void atualizarProduto() {

        Produto p = new Produto("Iphone 7", 2500);
        p.setId(5);
        ProdutoDAO dao = new ProdutoDAO();
        
        if(dao.atualizarProduto(p)){
            System.out.println("Atualizado com Sucesso!");
        } else {
            fail("Erro em atualizar o produto");
        }
    }
    
}
