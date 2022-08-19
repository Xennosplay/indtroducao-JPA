/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class CategoriaDAO {
    
    private EntityManagerFactory emf;

    public CategoriaDAO() {
        
        emf = Persistence.createEntityManagerFactory("aula1PU");
    }
    
    
    
    private EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    
    public void inserir(Categoria categoria){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Categoria categoria){
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        
        em.close();
        
    }
    
    public List<Categoria> buscar(){
        //JPQL
        //Sempre pensar em classe
        //SELECT c FROM Categoria(Nome da classe) c
        TypedQuery<Categoria> query = getEntityManager()
                .createQuery("SELECT c FROM Categoria c", Categoria.class);
        
        return query.getResultList();
    }
}
