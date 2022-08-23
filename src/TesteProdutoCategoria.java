
import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class TesteProdutoCategoria {
    
    
    private static ProdutoDAO produtoDAO = new ProdutoDAO();

    public TesteProdutoCategoria() {
        
    }
    
    
    
    public static void main(String[] args) {
        
        adicionarProdutos();
        
        reajustarPrecoProdutos(10);
        exibirProdutos();
            
    }
    
//    private static void teste(){
//        EntityManager em = Persistence.createEntityManagerFactory("aula1PU").createEntityManager();
//                
//        
//        adicionarProdutos();
//        
//        List<Produto> produtos = produtoDAO.buscar();
//        for (Produto p : produtos){
//            System.out.println("Descrição:" + p.getDescricao());
//            System.out.println("Categoria:" + p.getCategoria().getDescricao());
//        }
//    }
    
    
    private static void adicionarProdutos(){
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        for(int i = 0; i < 10; i++){
        Categoria categoria = new Categoria();
        categoria.setDescricao("Categoria" + i);
        categoriaDAO.inserir(categoria);
        
        Produto produto = new Produto();
        produto.setDescricao("Produto" + i);
        produto.setPreco(new BigDecimal(60.0 * (i+1)));
        produto.setQuantidade(100);
        
        produto.setCategoria(categoria);
        
        produtoDAO.inserir(produto);
        }
    }
    
    private static void reajustarPrecoProdutos(double porcentagem){
        for (Produto p : produtoDAO.buscar()){
//            BigDecimal reajustar = new BigDecimal(p.getPreco().multiply((porcentagem/100)));
//            p.setPreco(reajustar.add(p.getPreco()));
        }
    }
    
    private static void exibirProdutos(){
        for (Produto p : produtoDAO.buscar()){
            System.out.println("Descrição:" + p.getDescricao());
            System.out.println("Categoria:" + p.getCategoria().getDescricao());
    }
   }
}
