
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
        adicionarVeiculosAcessorios();
        exibirVeiculos();

    }

    public static void adicionarVeiculos() {

        for (int i = 0; i < 10; i++) {
            Veiculo veiculo = new Veiculo();
            veiculo.setAnoFabricacao(2000 + i);
            veiculo.setAnoModelo(2000 + i);
            veiculo.setDataCadastro(new Date());
            veiculo.setFabricante("Toyota");
            veiculo.setTipoCombustivel("Gasolina");
            veiculo.setValor(new BigDecimal(60.0 * (i + 1)));
            veiculo.setModelo("Corolla");

            veiculoDAO.inserir(veiculo);

        }
    }

    public static void adicionarVeiculosAcessorios() {
        
        for (int i = 0; i < 10; i++) {
            Veiculo veiculo = new Veiculo();
            veiculo.setAnoFabricacao(2000 + i);
            veiculo.setAnoModelo(2000 + i);
            veiculo.setDataCadastro(new Date());
            veiculo.setFabricante("Toyota");
            veiculo.setTipoCombustivel("Gasolina");
            veiculo.setValor(new BigDecimal(60.0 * (i + 1)));
            veiculo.setModelo("Corolla");
            veiculo.getAcessorios().add(acessorioDAO.buscar().get(1));
            veiculo.getAcessorios().add(acessorioDAO.buscar().get(2));
            veiculo.getAcessorios().add(acessorioDAO.buscar().get(3));

            veiculoDAO.inserir(veiculo);

        }
    }

    public static void adicionarAcessorios() {

        for (int i = 0; i < 10; i++) {
            Acessorio acessorio = new Acessorio();
            acessorio.setDescricao("Multimídia");
            acessorioDAO.inserir(acessorio);
        }
    }

    public static void exibirVeiculos() {
        for (Veiculo v : veiculoDAO.buscar()) {
            System.out.println("codigo: " + v.getCodigo());
            System.out.println("fabricante: " + v.getFabricante());
            System.out.println("modelo: " + v.getModelo());
            System.out.println("combustível: " + v.getTipoCombustivel());
            System.out.println("ano de fabricação: " + v.getAnoFabricacao());
            System.out.println("ano do modelo: " + v.getAnoModelo());
            if(v.getAcessorios().isEmpty()){
                System.out.println("Sem acessórios.");
            }
            else{
                System.out.println("Acessórios:");
                for (Acessorio a : v.getAcessorios()) {
                    System.out.println("codigo: " + a.getCodigo());
                    System.out.println("descrição: " + a.getDescricao());
            }

            }
            System.out.println("");
        }

    }
}
