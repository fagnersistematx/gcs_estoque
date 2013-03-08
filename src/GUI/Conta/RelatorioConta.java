package GUI.Conta;

import Entidade.Conta.Conta;
import Entidade.Conta.Despesa;
import Entidade.Conta.Fluxo;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.Receita;
import Entidade.Pessoa;
import Fachada.Fachada;
import GUI.PesquisaPessoa;
import Util.JCalendar;
import gerenciadorclientes.GerenciadorClientesApp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class RelatorioConta extends javax.swing.JDialog {

    private JCalendar jcalendar;
    private JDialog telaAux;
    private Pessoa pessoa = null;
    private static final int RECEITA = 1;
    private static final int DESPESA = 2;
    private static final int TODOS = 3;
    private ComboMenuBar cbFluxo;
    private List<Fluxo> fluxus;

    public RelatorioConta(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.iniciar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        GruupData = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbConta = new javax.swing.JComboBox();
        panelMensal = new javax.swing.JPanel();
        painelData = new javax.swing.JPanel();
        rbMes = new javax.swing.JRadioButton();
        rbAno = new javax.swing.JRadioButton();
        rbDia = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rbReceita = new javax.swing.JRadioButton();
        rbDespesa = new javax.swing.JRadioButton();
        btPesquisarPessoa = new javax.swing.JButton();
        tfPessoa = new javax.swing.JTextField();
        lbPlanoConta = new javax.swing.JLabel();
        painelPlanoConta = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rbTodos = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelatorio = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        painelGrafico = new javax.swing.JPanel();
        tfTotal = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório e Gráfico");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Conta:");

        cbConta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        panelMensal.setBackground(new java.awt.Color(168, 181, 230));
        panelMensal.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro de Data"));
        panelMensal.setLayout(null);

        painelData.setBackground(new java.awt.Color(255, 255, 255));
        painelData.setPreferredSize(new java.awt.Dimension(200, 160));

        javax.swing.GroupLayout painelDataLayout = new javax.swing.GroupLayout(painelData);
        painelData.setLayout(painelDataLayout);
        painelDataLayout.setHorizontalGroup(
            painelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        painelDataLayout.setVerticalGroup(
            painelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        panelMensal.add(painelData);
        painelData.setBounds(40, 20, 200, 160);

        GruupData.add(rbMes);
        rbMes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbMes.setText("Mês");
        panelMensal.add(rbMes);
        rbMes.setBounds(110, 200, 60, 23);

        GruupData.add(rbAno);
        rbAno.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbAno.setText("Ano");
        panelMensal.add(rbAno);
        rbAno.setBounds(200, 200, 80, 23);

        GruupData.add(rbDia);
        rbDia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbDia.setSelected(true);
        rbDia.setText("Dia");
        panelMensal.add(rbDia);
        rbDia.setBounds(30, 200, 60, 23);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Pessoa:");

        buttonGroup1.add(rbReceita);
        rbReceita.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbReceita.setText("Receita");
        rbReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReceitaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbDespesa);
        rbDespesa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbDespesa.setText("Despesa");
        rbDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDespesaActionPerformed(evt);
            }
        });

        btPesquisarPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btPesquisarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPessoaActionPerformed(evt);
            }
        });

        tfPessoa.setEditable(false);
        tfPessoa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfPessoa.setText("Todas");

        lbPlanoConta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbPlanoConta.setText("Plano de Conta:");

        painelPlanoConta.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton2.setText("Novo Filtro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbTodos.setSelected(true);
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelMensal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(tfPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btPesquisarPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbPlanoConta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(painelPlanoConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(cbConta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisarPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbReceita)
                    .addComponent(rbDespesa)
                    .addComponent(rbTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPlanoConta)
                .addGap(5, 5, 5)
                .addComponent(painelPlanoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 10, 330, 540);

        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        tbRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tipo do Fluxo", "Conta", "Pessoa", "Plano de Conta", "Valor", "OBS."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbRelatorio);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Relatório", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        painelGrafico.setBackground(java.awt.Color.white);
        painelGrafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelGraficoLayout = new javax.swing.GroupLayout(painelGrafico);
        painelGrafico.setLayout(painelGraficoLayout);
        painelGraficoLayout.setHorizontalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );
        painelGraficoLayout.setVerticalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        jPanel4.add(painelGrafico, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Gráfico", jPanel4);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(370, 90, 790, 460);

        tfTotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel1.add(tfTotal);
        tfTotal.setBounds(760, 20, 380, 50);

        tfQuantidade.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel1.add(tfQuantidade);
        tfQuantidade.setBounds(380, 20, 380, 50);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1180, 596));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPessoaActionPerformed
        pesquisarPessoa();
    }//GEN-LAST:event_btPesquisarPessoaActionPerformed

    private void rbReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReceitaActionPerformed
        this.menuComboBoxFluxo(RECEITA);
        painelPlanoConta.setVisible(true);
        lbPlanoConta.setVisible(true);
    }//GEN-LAST:event_rbReceitaActionPerformed

    private void rbDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDespesaActionPerformed
        this.menuComboBoxFluxo(DESPESA);
        painelPlanoConta.setVisible(true);
        lbPlanoConta.setVisible(true);
    }//GEN-LAST:event_rbDespesaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preecherJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.iniciar();
}//GEN-LAST:event_jButton2ActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        painelPlanoConta.setVisible(false);
        lbPlanoConta.setVisible(false);
    }//GEN-LAST:event_rbTodosActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RelatorioConta dialog = new RelatorioConta(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GruupData;
    private javax.swing.JButton btPesquisarPessoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbConta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbPlanoConta;
    private javax.swing.JPanel painelData;
    private javax.swing.JPanel painelGrafico;
    private javax.swing.JPanel painelPlanoConta;
    private javax.swing.JPanel panelMensal;
    private javax.swing.JRadioButton rbAno;
    private javax.swing.JRadioButton rbDespesa;
    private javax.swing.JRadioButton rbDia;
    private javax.swing.JRadioButton rbMes;
    private javax.swing.JRadioButton rbReceita;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tbRelatorio;
    private javax.swing.JTextField tfPessoa;
    private javax.swing.JLabel tfQuantidade;
    private javax.swing.JLabel tfTotal;
    // End of variables declaration//GEN-END:variables

    /**
     * Inicia métodos basicos da incialização tela;
     */
    private void iniciar() {
        this.calendario();
        this.preencheComboBoxConta();
        this.menuComboBoxFluxo(RECEITA);
        painelPlanoConta.setVisible(false);
        lbPlanoConta.setVisible(false);
    }

    /**
     * Metodo para adicionar calendario ao painel de painelData.
     */
    private void calendario() {
        jcalendar = new JCalendar();
        jcalendar.setBounds(1, 1, painelData.getWidth(), painelData.getHeight());
        painelData.add(jcalendar);
        painelData.revalidate();
        painelData.repaint();
    }

    /**
     * Método para adicioar todas as contas ao ComboBox.
     */
    private void preencheComboBoxConta() {
        cbConta.removeAllItems();
        cbConta.addItem("Todas as Contas");
        List<Object> contas = Fachada.getInstance().listarContas();
        for (Object o : contas) {
            Conta c = (Conta) o;
            cbConta.addItem(c.getNome());
        }
    }

    /**
     * Método para pleencher o painel de plano de curso.
     *
     * @param condFluxo variável que recebe a condição, se é Receita ou Despesa.
     */
    public void menuComboBoxFluxo(int condFluxo) {
        painelPlanoConta.removeAll();
        if (condFluxo == DESPESA) {
            cbFluxo = new ComboBoxMenu(false).getComboMenu();
        } else {
            cbFluxo = new ComboBoxMenu(true).getComboMenu();
        }
        painelPlanoConta.add(cbFluxo);
        painelPlanoConta.revalidate();
        painelPlanoConta.repaint();
    }

    /**
     * Método para setar pessoa atraves da tela de pesquisa de pessoa.
     *
     * @param pessoa pessoa passada pela tela de pesquisa.
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        tfPessoa.setText(pessoa.getNome());
    }

    private void pesquisarPessoa() {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        telaAux = new PesquisaPessoa(mainFrame, this, 0);
        GerenciadorClientesApp.getApplication().show(telaAux);
        telaAux.setSize(644, 350);
        this.setVisible(false);
    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Object object : fluxus) {
            Fluxo f = (Fluxo) object;
            dataset.addValue(10, f.getObs(), "Contas");
        }
        return dataset;

    }

    public void criaGrafico() {

        CategoryDataset cds = createDataset();
        String titulo = "Gráfico de Contas";
        String eixoy = "Valores";
        String txt_legenda = "Ledenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(painelGrafico.getWidth(), painelGrafico.getHeight());
        myChartPanel.setVisible(true);
        painelGrafico.removeAll();
        painelGrafico.add(myChartPanel);
        painelGrafico.revalidate();
        painelGrafico.repaint();

    }

    private List<Object> filtro() {
        List<Object> fluxo = new ArrayList<Object>();
        Conta conta = null;
        ItensPlanoConta itensPlanoConta = null;
        if (!cbConta.getSelectedItem().toString().equalsIgnoreCase("Todas as Contas")) {
            conta = Fachada.getInstance().buscarConta(cbConta.getSelectedItem().toString());
        }
        if (painelPlanoConta.isVisible()) {
            itensPlanoConta = Fachada.getInstance().buscaItensPlanoConta(cbFluxo.getSelectedItem().toString());
        }
        if (rbReceita.isSelected()) {
            fluxo = Fachada.getInstance().receitaConta(conta, pessoa, itensPlanoConta);
        } else if (rbDespesa.isSelected()) {
            fluxo = Fachada.getInstance().despesaConta(conta, pessoa, itensPlanoConta);
        } else{
            fluxo.addAll(Fachada.getInstance().receitaConta(conta, pessoa, itensPlanoConta));
            fluxo.addAll(Fachada.getInstance().despesaConta(conta, pessoa, itensPlanoConta));
        }
        return fluxo;
    }

    private List<Fluxo> filtraData() {

        List<Fluxo> fluxos = new ArrayList<Fluxo>();
        for (Object object : filtro()) {
            Fluxo f = (Fluxo) object;
            if (rbDia.isSelected()) {
                if (f.getData_fluxo().get(Calendar.YEAR) == jcalendar.getCalendar().get(Calendar.YEAR)
                        && f.getData_fluxo().get(Calendar.MONTH) == jcalendar.getCalendar().get(Calendar.MONTH)
                        && f.getData_fluxo().get(Calendar.DAY_OF_YEAR) == jcalendar.getCalendar().get(Calendar.DAY_OF_YEAR)) {
                    fluxos.add(f);
                }
            } else if (rbMes.isSelected()) {
                if (f.getData_fluxo().get(Calendar.YEAR) == jcalendar.getCalendar().get(Calendar.YEAR)
                        && f.getData_fluxo().get(Calendar.MONTH) == jcalendar.getCalendar().get(Calendar.MONTH)) {
                    fluxos.add(f);
                }
            } else if (rbAno.isSelected()) {
                if (f.getData_fluxo().get(Calendar.YEAR) == jcalendar.getCalendar().get(Calendar.YEAR)) {
                    fluxos.add(f);
                }
            }
        }
        return fluxos;
    }

    private void preecherJTable() {

        tbRelatorio.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbRelatorio.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbRelatorio.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbRelatorio.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbRelatorio.getColumnModel().getColumn(4).setPreferredWidth(50);

        DefaultTableModel modelo = (DefaultTableModel) tbRelatorio.getModel();
        modelo.setNumRows(0);

        float totalDespesa = 0;
        float totalReceita = 0;
        fluxus = filtraData();
        try {
            for (Fluxo f : fluxus) {
                String tipo = "Despesa";
                float valor = 0;
                String plano = "";
                String pessoaNome = "";
                if (f instanceof Receita) {
                    Receita receita = (Receita) f;
                    valor = receita.getValor();
                    totalReceita = valor;
                    try {
                        plano = receita.getItensPlanoConta().getNome();
                    } catch (Exception e) {
                    }
                    tipo = "Receita";
                } else if (f instanceof Despesa) {
                    Despesa despesa = (Despesa) f;
                    valor = despesa.getValor();
                    totalDespesa = valor;
                    try {
                        plano = despesa.getItensPlanoConta().getNome();
                    } catch (Exception e) {
                    }
                }
                if (f.getCliente() != null) {
                    pessoaNome = f.getCliente().getNome();
                } else if (f.getFornecedor() != null) {
                    pessoaNome = f.getFornecedor().getNome();
                } else if (f.getFuncionario() != null) {
                    pessoaNome = f.getFuncionario().getNome();
                }                
                modelo.addRow(new Object[]{
                            tipo + "/" + f.getNome(),
                            f.getConta().getNome(),
                            pessoaNome,
                            plano,
                            valor,
                            f.getObs()
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela do relatório.");
        }

        tfTotal.setText("Total: " + (totalReceita - totalDespesa));
        tfQuantidade.setText("Quantidade: " + fluxus.size());
        this.criaGrafico();
    }
}
