package GUI.Estoque;

import Entidade.Cliente;
import Entidade.Estoque.Lote;
import Entidade.Funcionario;
import GUI.PesquisaPessoa;
import Util.Converte;
import Util.JCalendar;
import gerenciadorclientes.GerenciadorClientesApp;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class CadastrarPedido extends javax.swing.JDialog {

    private Long codigo;
    private JCalendar jcalendar;
    private int tab;
    private JDialog pesquisaPessoa;
    private Funcionario funcionario;
    private Cliente cliente;
    private List<Lote> lotes;

    public CadastrarPedido(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.lotes = new ArrayList<Lote>();
        this.calendario();
        tfObs.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        btReceber = new javax.swing.JButton();
        tfResponsavel = new javax.swing.JTextField();
        btReceber1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLote = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tfReceber3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfValorFinal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfValorTotal = new javax.swing.JTextField();
        tfDesconto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        painelData = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pedido");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 80, 120, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Responsável");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 140, 160, 15);

        tfCliente.setEditable(false);
        tfCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tfCliente);
        tfCliente.setBounds(20, 100, 310, 30);

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        jPanel1.add(btReceber);
        btReceber.setBounds(330, 90, 40, 40);

        tfResponsavel.setEditable(false);
        tfResponsavel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tfResponsavel);
        tfResponsavel.setBounds(20, 160, 310, 30);

        btReceber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btReceber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceber1ActionPerformed(evt);
            }
        });
        jPanel1.add(btReceber1);
        btReceber1.setBounds(330, 150, 40, 40);

        jtLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Produto", "Fornecedor", "Quantidades de Sacos", "Valor Unit. Sacos R$", "Preço por KG", "Total em R$"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLoteMouseClicked(evt);
            }
        });
        jtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtLoteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtLote);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 370, 890, 250);

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474864_Package-Warning.png"))); // NOI18N
        jButton1.setText("Remover Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 310, 200, 42);

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474969_Package-Add.png"))); // NOI18N
        jButton2.setText("Adicionar Produto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 310, 200, 42);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 290, 880, 10);

        tfReceber3.setEditable(false);
        tfReceber3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(tfReceber3);
        tfReceber3.setBounds(20, 220, 250, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Codições de Pagamento");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 200, 200, 15);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        btSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gravar.png"))); // NOI18N
        btSalvar.setMnemonic('s');
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Salvar (Alt+S)");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        btNovo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        btNovo.setMnemonic('n');
        btNovo.setText("Novo");
        btNovo.setToolTipText("Novo (Alt+N)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancelar.png"))); // NOI18N
        btCancelar.setMnemonic('c');
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar (Alt+C)");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btCancelar);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("      Valor Final:        ");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setPreferredSize(new java.awt.Dimension(250, 15));
        jToolBar1.add(jLabel16);

        tfValorFinal.setEditable(false);
        tfValorFinal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfValorFinal.setPreferredSize(new java.awt.Dimension(150, 35));
        jToolBar1.add(tfValorFinal);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 890, 40);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Valor Total do Pedido");
        jLabel15.setMinimumSize(new java.awt.Dimension(187, 15));
        jLabel15.setPreferredSize(new java.awt.Dimension(187, 15));
        jPanel1.add(jLabel15);
        jLabel15.setBounds(700, 310, 187, 15);

        tfValorTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfValorTotal.setPreferredSize(new java.awt.Dimension(150, 35));
        tfValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorTotalActionPerformed(evt);
            }
        });
        jPanel1.add(tfValorTotal);
        tfValorTotal.setBounds(700, 330, 160, 30);

        tfDesconto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfDesconto.setText("0");
        tfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescontoKeyPressed(evt);
            }
        });
        jPanel1.add(tfDesconto);
        tfDesconto.setBounds(520, 330, 160, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Desconto");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(520, 310, 70, 15);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Data da Entrada");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(410, 80, 170, 15);

        painelData.setBackground(java.awt.Color.lightGray);
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

        jPanel1.add(painelData);
        painelData.setBounds(400, 100, 200, 160);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("OBS.");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(620, 80, 120, 15);

        tfObs.setColumns(20);
        tfObs.setRows(5);
        tfObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfObsKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tfObs);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(620, 100, 280, 160);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(916, 661));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        pesquisaPessoa(1);
    }//GEN-LAST:event_btReceberActionPerformed

    private void btReceber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceber1ActionPerformed
        pesquisaPessoa(2);
    }//GEN-LAST:event_btReceber1ActionPerformed

    private void jtLoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLoteMouseClicked
        int linha = jtLote.getSelectedRow();
        codigo = (Long) jtLote.getValueAt(linha, 0);
    }//GEN-LAST:event_jtLoteMouseClicked

    private void jtLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtLoteKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                jtLoteMouseClicked(null);
            }
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                if (tab % 2 == 0) {
                    jtLote.transferFocus();
                }
                tab++;
            }
        } catch (Exception erro) {
        }
    }//GEN-LAST:event_jtLoteKeyPressed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Cadastro de Fornecedor", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            btNovoActionPerformed(evt);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfDesconto.transferFocus();
        }
        //this.calcularDesconto();
    }//GEN-LAST:event_tfDescontoKeyPressed

    private void tfValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorTotalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.listaLote();
    }//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (codigo != null) {
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o produto de código " + codigo + "?", "Cadastro de Fornecedor", JOptionPane.YES_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            for (Lote l : lotes) {
                if (l.getId().toString().equalsIgnoreCase(codigo.toString())) {
                    lotes.remove(l);
                    JOptionPane.showMessageDialog(null, "Produto removido.");
                    preencherJTable();
                    return;
                }
            }
        }
    }
    JOptionPane.showMessageDialog(null, "Selecione um produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event_jButton1ActionPerformed

private void tfObsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfObsKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        tfObs.transferFocus();
    }
}//GEN-LAST:event_tfObsKeyPressed

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
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarPedido dialog = new CadastrarPedido(new javax.swing.JFrame());
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
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btReceber1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtLote;
    private javax.swing.JPanel painelData;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextArea tfObs;
    private javax.swing.JTextField tfReceber3;
    private javax.swing.JTextField tfResponsavel;
    private javax.swing.JTextField tfValorFinal;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables

    private void preencherJTable() {

        jtLote.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtLote.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtLote.getColumnModel().getColumn(2).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) jtLote.getModel();
        modelo.setNumRows(0);

        float valorTotal = 0;

        try {
            for (Lote l : lotes) {
                String fornecedor = "";
                try {
                    fornecedor = l.getFornecedor().getNome();
                } catch (Exception e) {
                }
                valorTotal += (l.getQuant() * l.getValor());
                modelo.addRow(new Object[]{
                            l.getId(),
                            l.getProduto().getNome(),
                            fornecedor,
                            l.getQuant(),
                            l.getValor(),
                            l.getPreco(),
                            (l.getQuant() * l.getValor())
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar a tabela de produtos." + erro);
        }
        tfValorTotal.setText("" + valorTotal);
        float desconto = 0;
        try {
            desconto = Converte.getInstance().converteTextoNumero(tfDesconto.getText());
        } catch (NumberFormatException erro) {
            desconto = 0;
        }
        tfValorFinal.setText("" + (valorTotal - desconto));
    }

    /**
     * Metodo para adicionar calendario aos paineis painelData e
     * painelDataDespesa.
     */
    private void calendario() {
        jcalendar = new JCalendar();
        jcalendar.setBounds(1, 1, painelData.getWidth(), painelData.getHeight());
        painelData.add(jcalendar);
        pack();
    }

    /**
     * Metodo para setar fornecedor na tela.
     *
     * @param funcionario está variavel vem da tela de pesquisa de pessoa.
     */
    public void setFuncionario(Funcionario funcionario) {
        tfResponsavel.setText(funcionario.getNome());
        this.funcionario = funcionario;
    }

    /**
     * Metodo para setar fornecedor na tela.
     *
     * @param cliente está variavel vem da tela de pesquisa de pessoa.
     */
    public void setCliente(Cliente cliente) {
        tfCliente.setText(cliente.getNome());
        this.cliente = cliente;
    }

    /**
     * Metodo para adicionar lote a tabela de produtos.
     *
     * @param lote está variavel vem da tela de pesquisa de produto.
     */
    public void addLote(Lote lote) {
        this.lotes.add(lote);
        this.preencherJTable();
    }

    private void pesquisaPessoa(int op) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        pesquisaPessoa = new PesquisaPessoa(mainFrame, this, op);
        GerenciadorClientesApp.getApplication().show(pesquisaPessoa);
        pesquisaPessoa.setSize(644, 350);
        this.setVisible(false);
    }

    private void listaLote() {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        pesquisaPessoa = new ListaLote(mainFrame, this);
        GerenciadorClientesApp.getApplication().show(pesquisaPessoa);
        pesquisaPessoa.setSize(918, 461);
        this.setVisible(false);
    }
}
