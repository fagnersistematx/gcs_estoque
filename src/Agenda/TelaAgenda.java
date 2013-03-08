
package Agenda;

import Util.JCalendar;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class TelaAgenda extends javax.swing.JDialog {
   
    private Tarefa tarefa;
    private Controller controller;
    private String hora ,horaEx;
    private SimpleDateFormat horaformatada, horaformatada2;
    private MaskFormatter formataHora;
    private int cont =0 , gualTabela = 1;
    private List <Tarefa> tarefaHoje;
    private boolean rep = false;
    private JCalendar jcalendar;
    
    public TelaAgenda(java.awt.Frame parent) {
        super(parent);
        initComponents();
               
        tarefa        = new Tarefa();
        controller    = new Controller();
        horaformatada = new SimpleDateFormat("HH:mm");
        horaformatada2= new SimpleDateFormat("HH:mm:ss");   
        
        tarefaHoje    = new ArrayList<Tarefa>();   
        
        tfhora.setModel(new SpinnerNumberModel(12, 0, 23, 1));
        tfMinutos.setModel(new SpinnerNumberModel(12, 0,59, 1));
        
        Ar_descricao.requestFocus();
        preencheJtable(1);
        
        setTitle("Agenda de Tarefas");        
        setLocation(40,15);
        timer1.start(); 
        
        calendario();        
        tf_hora.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        tf_hora = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pn_esquerdo = new javax.swing.JPanel();
        bt_listarAtrazadas = new javax.swing.JButton();
        bt_Concluir = new javax.swing.JButton();
        bt_listar = new javax.swing.JButton();
        bt_tarefaHoje = new javax.swing.JButton();
        bt_abrirtarefa = new javax.swing.JButton();
        lb_hora = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_tarefa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tfhora = new javax.swing.JSpinner();
        tfMinutos = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        tf_hora      = new JFormattedTextField(formata());
        tf_hora.setBounds(520,115,70,25);
        getContentPane().add(tf_hora);
        cb_repeticao = new javax.swing.JCheckBox();
        PainelData = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        bt_Adicionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bt_Alterar = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ar_descricao = new javax.swing.JTextArea();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        pn_esquerdo.setBackground(new java.awt.Color(255, 255, 255));
        pn_esquerdo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn_esquerdo.setLayout(null);

        bt_listarAtrazadas.setText("Listar Atrazadas");
        bt_listarAtrazadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listarAtrazadasActionPerformed(evt);
            }
        });
        pn_esquerdo.add(bt_listarAtrazadas);
        bt_listarAtrazadas.setBounds(20, 70, 160, 40);

        bt_Concluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/confirmar.png"))); // NOI18N
        bt_Concluir.setText("Concluir");
        bt_Concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ConcluirActionPerformed(evt);
            }
        });
        pn_esquerdo.add(bt_Concluir);
        bt_Concluir.setBounds(20, 170, 160, 40);

        bt_listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisarTarefa.png"))); // NOI18N
        bt_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_listarActionPerformed(evt);
            }
        });
        pn_esquerdo.add(bt_listar);
        bt_listar.setBounds(20, 20, 160, 40);

        bt_tarefaHoje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/hoje.png"))); // NOI18N
        bt_tarefaHoje.setText("Tarefas de Hoje");
        bt_tarefaHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tarefaHojeActionPerformed(evt);
            }
        });
        pn_esquerdo.add(bt_tarefaHoje);
        bt_tarefaHoje.setBounds(20, 120, 160, 40);

        bt_abrirtarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/reabrir.png"))); // NOI18N
        bt_abrirtarefa.setText("Re-abrir ");
        bt_abrirtarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_abrirtarefaActionPerformed(evt);
            }
        });
        pn_esquerdo.add(bt_abrirtarefa);
        bt_abrirtarefa.setBounds(20, 220, 160, 40);

        lb_hora.setFont(new java.awt.Font("Tahoma", 3, 18));
        lb_hora.setText("Hora");
        pn_esquerdo.add(lb_hora);
        lb_hora.setBounds(50, 280, 110, 22);

        jPanel1.add(pn_esquerdo);
        pn_esquerdo.setBounds(20, 260, 210, 320);

        tf_tarefa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data ", "Hora", "Descrição", "Atrazada", "Concluída"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tf_tarefa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_tarefaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tf_tarefa);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(250, 260, 860, 320);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(null);

        tfhora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfhoraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tfhoraMousePressed(evt);
            }
        });
        jPanel2.add(tfhora);
        tfhora.setBounds(20, 30, 50, 30);

        tfMinutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfMinutosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tfMinutosMousePressed(evt);
            }
        });
        jPanel2.add(tfMinutos);
        tfMinutos.setBounds(110, 30, 50, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText(":");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(80, 40, 20, 14);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(660, 80, 180, 80);

        cb_repeticao.setFont(new java.awt.Font("Tahoma", 1, 12));
        cb_repeticao.setText("Repetir Diariamente");
        cb_repeticao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_repeticaoActionPerformed(evt);
            }
        });
        jPanel1.add(cb_repeticao);
        cb_repeticao.setBounds(670, 170, 170, 30);

        PainelData.setBackground(java.awt.Color.lightGray);
        PainelData.setPreferredSize(new java.awt.Dimension(200, 160));

        javax.swing.GroupLayout PainelDataLayout = new javax.swing.GroupLayout(PainelData);
        PainelData.setLayout(PainelDataLayout);
        PainelDataLayout.setHorizontalGroup(
            PainelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        PainelDataLayout.setVerticalGroup(
            PainelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jPanel1.add(PainelData);
        PainelData.setBounds(420, 80, 200, 160);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        bt_Adicionar.setFont(new java.awt.Font("Ubuntu", 1, 12));
        bt_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        bt_Adicionar.setText("Salvar");
        bt_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AdicionarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_Adicionar);

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo.png"))); // NOI18N
        jButton1.setText("    Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        bt_Alterar.setFont(new java.awt.Font("Ubuntu", 1, 12));
        bt_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alter.png"))); // NOI18N
        bt_Alterar.setText("Alterar");
        bt_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_Alterar);

        bt_Remover.setFont(new java.awt.Font("Ubuntu", 1, 12));
        bt_Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lixo.png"))); // NOI18N
        bt_Remover.setText("Remover");
        bt_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_Remover);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 1090, 40);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        Ar_descricao.setColumns(20);
        Ar_descricao.setRows(5);
        jScrollPane1.setViewportView(Ar_descricao);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 80, 390, 160);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1136)/2, (screenSize.height-629)/2, 1136, 629);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_listarAtrazadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listarAtrazadasActionPerformed
        preencheJtable(2);
        gualTabela =2;
    }//GEN-LAST:event_bt_listarAtrazadasActionPerformed

    private void bt_ConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ConcluirActionPerformed
        if (tarefa == null)
        JOptionPane.showMessageDialog(null,"Escolha uma tarefa");
        try {
            controller.concluirTarefa(tarefa, true);
            preencheJtable(gualTabela);
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_bt_ConcluirActionPerformed

    private void bt_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_listarActionPerformed
        preencheJtable(1);
        gualTabela = 1;

    }//GEN-LAST:event_bt_listarActionPerformed

    private void bt_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverActionPerformed
        if (tarefa == null)
        JOptionPane.showMessageDialog(null,"Escolha uma tarefa");
        else{
            try {
                controller.remover(tarefa);
                preencheJtable(gualTabela);
            } catch (ParseException ex) {
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_bt_RemoverActionPerformed

    private void bt_tarefaHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tarefaHojeActionPerformed
        preencheJtable(3);
        gualTabela = 3;
    }//GEN-LAST:event_bt_tarefaHojeActionPerformed

    private void bt_abrirtarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_abrirtarefaActionPerformed
        if (tarefa == null)
        JOptionPane.showMessageDialog(null,"Escolha uma tarefa");
        else
        try {
            controller.concluirTarefa(tarefa, false);
            preencheJtable(gualTabela);
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_bt_abrirtarefaActionPerformed

    private void tf_tarefaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_tarefaMouseClicked
        int linha = tf_tarefa.getSelectedRow();
        String colunaNome = tf_tarefa.getValueAt(linha,2).toString();
        String colunaHora = tf_tarefa.getValueAt(linha,1).toString();
        tarefa = controller.getAgenda().pesquisarPorDescricao(colunaNome);
        Ar_descricao.setText(colunaNome);

        tfhora.getModel().setValue(Integer.parseInt(desconcatenizandoHora(1)));
        tfMinutos.getModel().setValue(Integer.parseInt(desconcatenizandoHora(2)));

        if(tarefa.getRepeticao() == true){
            rep = true;
        }
        else{
            rep = false;
        }
        cb_repeticao.setSelected(rep);
    }//GEN-LAST:event_tf_tarefaMouseClicked

    private void tfhoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfhoraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhoraMouseClicked

    private void tfhoraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfhoraMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfhoraMousePressed

    private void tfMinutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMinutosMouseClicked

    }//GEN-LAST:event_tfMinutosMouseClicked

    private void tfMinutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMinutosMousePressed

    }//GEN-LAST:event_tfMinutosMousePressed

    private void cb_repeticaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_repeticaoActionPerformed
        if (rep == true){
            rep = false;
        }
        else{
            rep = true;
        }
    }//GEN-LAST:event_cb_repeticaoActionPerformed

    private void bt_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AlterarActionPerformed

        if(verificarHora(concatenaHora()) == true){
            try {
                controller.alterar(tarefa ,jcalendar.getCalendar(), Ar_descricao.getText(), concatenaHora(),rep);
                preencheJtable(gualTabela);
            } catch (ParseException ex) {
            }
        }
    }//GEN-LAST:event_bt_AlterarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrarDados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AdicionarActionPerformed

        if(verificarHora(concatenaHora()) == true){
            try {
                controller.cadastrar(jcalendar.getCalendar(), Ar_descricao.getText(), concatenaHora() ,rep);
                preencheJtable(gualTabela);
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_bt_AdicionarActionPerformed

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        le_hora();
        lb_hora.setText(horaEx);
        if (cont  == 0){
            tarefaHoje   = controller.getAgenda().tarefaDeHoje();            
            for (Tarefa t : tarefaHoje){
                if (t.getHora().equals(hora))
                    JOptionPane.showMessageDialog(null, t.getDescricao());
            }            
        }
        ++cont;
        if (cont  == 60)
            cont = 0;
    }//GEN-LAST:event_timer1OnTime
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Ar_descricao;
    private javax.swing.JPanel PainelData;
    private javax.swing.JButton bt_Adicionar;
    private javax.swing.JButton bt_Alterar;
    private javax.swing.JButton bt_Concluir;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_abrirtarefa;
    private javax.swing.JButton bt_listar;
    private javax.swing.JButton bt_listarAtrazadas;
    private javax.swing.JButton bt_tarefaHoje;
    private javax.swing.JCheckBox cb_repeticao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lb_hora;
    private javax.swing.JPanel pn_esquerdo;
    private javax.swing.JSpinner tfMinutos;
    private javax.swing.JTextField tf_hora;
    private javax.swing.JTable tf_tarefa;
    private javax.swing.JSpinner tfhora;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables

    public void preencheJtable(int table){
        
        PreencheJtable pj = new PreencheJtable();
        if (table == 1)
            tf_tarefa = pj.preenchetb(true, tf_tarefa ,true);
        else if(table == 2)
            tf_tarefa = pj.preenchetb(false, tf_tarefa ,true);
        else if(table == 3)
            tf_tarefa = pj.preenchetb(true, tf_tarefa ,false);
    }   

    public final void le_hora(){    
        Date horaAtual = new Date();
        horaEx = horaformatada2.format(horaAtual);
        hora = horaformatada.format(horaAtual);
    }
   
    public MaskFormatter formata() {
        try{
            formataHora   = new MaskFormatter("HH:HH");        
            return formataHora;       
        }catch(ParseException erro){            
            return null;
        }
        
    }  
    
    public boolean verificarHora(String hora){
        try{
        String a = hora.substring(3);
        int var = Integer.parseInt(a);
            if(var <= 59){

                    for (Integer i = 24; i < 100; ++i){
                        if (hora.contains(i.toString()) & var != i){ 
                              JOptionPane.showMessageDialog(null, "Data invalida "+i);  
                              return false;
                        }
                    }
                    return true;

            }
            else{            
                JOptionPane.showMessageDialog(null, "Data invalida");
                return false;
            }
        }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Data invalida");
                return false;
        }
    }
    public void mostrarDados(){
        //tf_hora.setText("");
        Ar_descricao.setText("");
        cb_repeticao.setSelected(false);
    }
    
    /**
     * 
     * @return O conteudo do controle giretorio hora e minitos formando a hora dezejada.
     */
    private String concatenaHora(){
        return tfhora.getModel().getValue() +":"+tfMinutos.getModel().getValue();
    }
    
   /**
     * 
     * @param op igual a um retorna hora e igual a dois retorna o minuto 
     * @return Hora ou minuto 
     */
    private String desconcatenizandoHora(int op){
        
        char[] a = concatenaHora().toCharArray();
        String op1 = "";
        String op2 = "";
        boolean cond = true;
        
        for(int i =0; i< a.length; ++i){
            
            if(a[i] == ':'){
                cond = false;
            } 
            else if(cond){
                op1 +=  ""+a[i];
            }
            else if(!cond){
                op2 +=  ""+a[i];
            }
        }
        
        if(op == 1){
            return op1;
        }else{
            return op2;
        }
        
    }
    
    /**
     * Metodo para adicionar calendario aos paineis painelData e
     * painelDataDespesa.
     */
    private void calendario() {
        jcalendar = new JCalendar();
        jcalendar.setBounds(1, 1, PainelData.getWidth(), PainelData.getHeight());
        PainelData.add(jcalendar);
        pack();
    }
}
