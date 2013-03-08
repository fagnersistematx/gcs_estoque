
package Agenda;
/**
 *
 * @author Fagner
 */
import Controler.TarefaDao;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda implements Comparator<Tarefa> {
    
    Tarefa tarefa = new Tarefa();    
    TarefaDao td = new TarefaDao();    
    private List <Tarefa> listaTarefa = new ArrayList<Tarefa>();
    private List <Tarefa> listaTarefaAtrasadas = new ArrayList<Tarefa>();    
    
    public Agenda(){
        addTodasTarefa();
    }
   
    public final void addTodasTarefa(){
        listaTarefa = td.listarTarefa();
    }
    
    public void ordenarTarefa(){
            Collections.sort(listaTarefa ,this);
    }

    public void addListaTarefa(Tarefa t){
        td.cadastrarTarefa(t);
        listaTarefa.add(t);        
    }
    public void removerLista(Tarefa ta){        
        try{
            for (Tarefa t : listaTarefa){
                if(t.toString().equals(ta.toString())){
                    td.removerTarefa(t);
                    listaTarefa.remove(t);                    
                }            
            }
        }catch(Exception erro){
            System.out.println("erro ao remover metodo removerLista agenda ");
        }
    }
    public void concluirTarefa(Tarefa ta ,boolean concluir){         
         for (Tarefa t : listaTarefa){
            if(t.toString().equals(ta.toString())){
                t.setConcluido(concluir);
                td.cadastrarTarefa(t);
            }
         }         
    }   
    
    public boolean atrasado(Tarefa t){        
        Calendar c = Calendar.getInstance();
        if (t.getConcluido() == false && t.getData().before(c)){            
            return true;
        }else{            
            return false;
        }
    }
    public Tarefa pesquisarPorDescricao(String descricao){
        for (Tarefa t : listaTarefa){
            if(t.getDescricao().equalsIgnoreCase(descricao)){                
                return t;                 
            }
        }
        return null;
    }
    public List <Tarefa> tarefaDeHoje(){
        List <Tarefa> tarefaHoje = new ArrayList<Tarefa>();
        Calendar c = Calendar.getInstance();
        DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.FULL);
        try{
            for (Tarefa t : listaTarefa){                       
                if (dataFormatada.format(t.getData().getTime()).equals(dataFormatada.format(c.getTime())) || t.getRepeticao() == true){
                    tarefaHoje.add(t);                   
                }
            }
        }
        catch(Exception erro){       
        }
        return tarefaHoje;
    } 
    @Override
    public int compare(Tarefa t1, Tarefa t2) {
        return t1.getData().compareTo(t2.getData());
    }   

    public List<Tarefa> getListaTarefa() {
        return listaTarefa;
    }

    public List<Tarefa> getListaTarefaAtrasadas() {
        return listaTarefaAtrasadas;
    }

    public void setListaTarefaAtrasadas(List<Tarefa> listaTarefaAtrasadas) {
        this.listaTarefaAtrasadas = listaTarefaAtrasadas;
    }
    
}
