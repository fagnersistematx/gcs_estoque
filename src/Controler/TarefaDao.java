/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Agenda.Tarefa;
import Util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Fagner
 */
public class TarefaDao {
    Tarefa tarefa = new Tarefa();
    
    private  EntityManager em = HibernateUtil.getInstance().getFactory().createEntityManager(); 
    
    
    public void cadastrarTarefa(Tarefa t){
        try{
            em.getTransaction().begin();            
            em.persist(t);        
            em.getTransaction().commit();      
        }catch(Exception erro){
            em.getTransaction().rollback();             
        }
    }
    
    public List<Tarefa> listarTarefa(){
        return  em.createQuery("SELECT c FROM Tarefa c").getResultList();  
    }
    
    public void removerTarefa(Tarefa t){
        try{
            em.getTransaction().begin();            
            em.remove(t);
            em.getTransaction().commit();             
        }catch(Exception erro){
            em.getTransaction().rollback();            
        }
    }
}
