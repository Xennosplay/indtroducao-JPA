
import br.edu.ifsp.pep.dao.AcessorioDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.modelo.Acessorio;

import br.edu.ifsp.pep.modelo.Veiculo;
import java.math.BigDecimal;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class TesteVeiculoAcessorio {
    
    private static VeiculoDAO veiculoDAO = new VeiculoDAO();
    private static AcessorioDAO acessorioDAO = new AcessorioDAO();
    
    public static void main(String[] args) {
        
        adicionarAcessorios();
        adicionarVeiculos();
        
    }
    
    public static void adicionarVeiculos(){
        
        for(int i = 0; i < 10; i++){
        Veiculo veiculo = new Veiculo();
        veiculo.setAnoFabricacao(2000 + i);
        veiculo.setAnoModelo(2000 + i);
        veiculo.setDataCadastro(new Date());
        veiculo.setFabricante("Toyota");
        veiculo.setTipoCombustivel("Gasolina");
        veiculo.setValor(new BigDecimal(60.0 * (i+1)));
        veiculo.setModelo("Corolla");
        veiculo.setAcessorios(acessorioDAO.buscar());
        
        veiculoDAO.inserir(veiculo);
        
        }
    }
    
    public static void adicionarAcessorios(){
        
        for(int i = 0; i < 10; i++){
            Acessorio acessorio = new Acessorio();
            acessorio.setDescricao("Multimídia");  
            acessorioDAO.inserir(acessorio);
        }
    }
}
