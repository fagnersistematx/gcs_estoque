/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Fagner
 */
public class PreencheJtable {   
    Agenda agenda = new Agenda();
    DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.FULL); 
    
    public JTable preenchetb(boolean controleTabela , JTable tb_Tarefa, boolean controleTabela2){
                tb_Tarefa.setGridColor(new java.awt.Color(255, 255, 255));                

                tb_Tarefa.getColumnModel().getColumn(0).setPreferredWidth(100); 
                tb_Tarefa.getColumnModel().getColumn(1).setPreferredWidth( 20); 
                tb_Tarefa.getColumnModel().getColumn(2).setPreferredWidth(250);
                tb_Tarefa.getColumnModel().getColumn(3).setPreferredWidth( 23);
                tb_Tarefa.getColumnModel().getColumn(4).setPreferredWidth( 23);

                DefaultTableModel modelo = (DefaultTableModel) tb_Tarefa.getModel();
                modelo.setNumRows(0);

                List<Tarefa> Tarefas = new ArrayList<Tarefa>();
                Tarefas = agenda.getListaTarefa();
                try{
                    if (controleTabela == true && controleTabela2 == true){
                        for (Tarefa t : Tarefas){
                            String g , c ;                                
                                if (agenda.atrasado(t) == true)
                                    g = "Esta atrazada";
                                else
                                    g = "Não esta atrazada";
                                if(t.getConcluido() == false)
                                    c = "Não concluida";
                                else
                                    c = "Concluida";

                            modelo.addRow(new Object[]{
                            dataFormatada.format(t.getData().getTime()),t.getHora(),t.getDescricao(),g , c});
                        }
                    }if(controleTabela == false && controleTabela2 == true){
                        for (Tarefa t : Tarefas){
                            if (agenda.atrasado(t) == true){
                                String g = "Esta atrazada";     
                                String c = "Não concluida";     
                                modelo.addRow(new Object[]{
                                dataFormatada.format(t.getData().getTime()),t.getHora(),t.getDescricao(),g , c});
                            }
                        }
                    }if(controleTabela == true && controleTabela2 == false){
                        for (Tarefa t : agenda.tarefaDeHoje()){
                            String g , c ;                                
                                if (agenda.atrasado(t) == true)
                                    g = "Esta atrazada";
                                else
                                    g = "Não esta atrazada";
                                if(t.getConcluido() == false)
                                    c = "Não concluida";
                                else
                                    c = "Concluida";

                            modelo.addRow(new Object[]{
                            dataFormatada.format(t.getData().getTime()),t.getHora(),t.getDescricao(),g , c});
                        }
                    }
                }
                catch(Exception erro){
                    JOptionPane.showMessageDialog(null,"Não consequil carregar a Tabela"+erro);
                }                
               return tb_Tarefa;
         }    
}

