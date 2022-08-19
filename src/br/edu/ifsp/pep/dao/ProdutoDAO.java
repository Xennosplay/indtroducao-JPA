/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class ProdutoDAO {
    
    private EntityManagerFactory emf;

    public ProdutoDAO() {
        
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }
    
    
    
    private EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    
    public void inserir(Produto produto){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Produto produto){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        
        em.close();
        
    }
    
    public List<Produto> buscar(){
        //JPQL
        //Sempre pensar em classe
        //SELECT p FROM Produto(Nome da classe) p
        TypedQuery<Produto> query = getEntityManager()
                .createQuery("SELECT p FROM Produto p", Produto.class);
        
        return query.getResultList();
    }
}
