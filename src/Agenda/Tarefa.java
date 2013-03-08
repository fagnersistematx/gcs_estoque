/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Fagner
 */
@Entity
@Table(name="tarefa")
public class Tarefa  implements Serializable{

    @Id @GeneratedValue
    private Long id;
    private String descricao;
    private String hora;    
    @Temporal(TemporalType.DATE)
    private Calendar dataTarefa;
    private boolean repeticao = false;
    private boolean concluido = false;    
    
    public Tarefa(){
        dataTarefa = Calendar.getInstance();
    }

    public Tarefa(String descricao, boolean concluido , Calendar data , String hora, boolean repeticao) {
        this.dataTarefa= data;        
        this.descricao = descricao;
        this.concluido = concluido;
        this.hora      = hora;
        this.repeticao = repeticao;
    }    

    public boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public Calendar getData() {
        return dataTarefa;
    }

    public void setData(Calendar data) {
        this.dataTarefa = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(boolean repeticao) {
        this.repeticao = repeticao;
    }
    
    
    @Override
    public String toString() {  
        DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.FULL);
        return  "Tarefa.:\n" + "id = " + id +
                "\n"+"descricao = " + descricao +
                "\n"+ "data = " + dataFormatada.format(dataTarefa.getTime()) + 
                "\n"+ "repetição = " + repeticao + 
                "\n"+"concluido = " + concluido +'}';
    }    
}
