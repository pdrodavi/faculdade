package main;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Produto;

public class Main {
    
    public static void main(String[] args) {
        
        boolean controle = true;
       
        while(controle){
            
            Scanner input = new Scanner(System.in);
           
            System.out.println("");
            System.out.println("MENU");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - EXCLUIR PRODUTO");
            System.out.println("3 - ATUALIZAR PRODUTO");
            System.out.println("4 - LISTAR PRODUTOS");
            System.out.println("0 - SAIR DO PROGRAMA");
            System.out.println("");
            
            int op = input.nextInt();
            
            ProdutoDAO dao = new ProdutoDAO();
            
            switch(op){
            
                case 1:
                    // cadastrar
                    System.out.println("Digite o nome: ");
                    String nome = input.next();
                    System.out.println("Digite o valor: ");
                    float preco = input.nextFloat();
                    Produto p = new Produto(nome, preco);
                    dao.cadastrarProduto(p);
                    break;
                    
                case 2:
                    // excluir
                    System.out.println("ID do produto a ser excluido: ");
                    int id = input.nextInt();
                    dao.excluirProduto(id);
                    break;
                    
                case 3:
                    // atualizar
                    System.out.println("Digite o ID do produto para atualizar: ");
                    id = input.nextInt();
                    p = dao.getProdutoById(id);
                    System.out.println("Novo nome: ");
                    String novoNome = input.next();
                    System.out.println("Novo valor: ");
                    float novoPreco = input.nextFloat();
                    Produto p2 = new Produto(p.getId(), novoNome, novoPreco);
                    dao.atualizarProduto(p2);
                    break;
                    
                case 4:
                    // listar
                    List<Produto> produtos = new ArrayList();
                    produtos = dao.getProdutos();
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println("ID: " + produtos.get(i).getId());
                        System.out.println("Nome: " + produtos.get(i).getNome());
                        System.out.println("Preço: " + produtos.get(i).getPreco());
                    }
                    break;
                    
                case 0:
                    // sair
                    controle = false;
                    break;
            }
            
        }
        
    }
    
}
