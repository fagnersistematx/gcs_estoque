/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Fagner
 */
public class Controller implements Serializable{
    Agenda agenda = new Agenda();     
   
    public Controller() {}

    public void cadastrar(Calendar dataPassada , String descricao , String hora, boolean rep) throws FileNotFoundException{
       
         try {
             
            //da = adf.parse(dataPassada);
           // data.setTime(da);
            Tarefa tarefa = new Tarefa(descricao, false, dataPassada , hora, rep);
            agenda.addListaTarefa(tarefa);                  
            
            JOptionPane.showMessageDialog(null,"Tarefa adicionada com sucesso");        

         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar no controller");
        }
    }
    
    public void alterar(Tarefa t ,Calendar dataPassada , String descricao , String hora , boolean rep) throws ParseException{
       
         t.setDescricao(descricao);
         t.setHora(hora);
         t.setData(dataPassada);
         t.setRepeticao(rep);
         
         agenda.addListaTarefa(t);     
         
         JOptionPane.showMessageDialog(null,"Tarefa alterda com sucesso");  
         
    }  
    
    public void remover(Tarefa t) throws ParseException, FileNotFoundException{
        
        agenda.removerLista(t);  
        JOptionPane.showMessageDialog(null,"Tarefa excluida com sucesso");   
        
    }
    
    public void concluirTarefa(Tarefa tarefa , boolean concluir) throws ParseException{   
        
        agenda.concluirTarefa(tarefa,concluir);       
        JOptionPane.showMessageDialog(null,"Tarefa Concluída");  
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
