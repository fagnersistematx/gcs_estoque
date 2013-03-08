package GUI.Estoque;

import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Lote;
import Entidade.Estoque.Produto;
import Fachada.Fachada;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ValorVendaProduto extends javax.swing.JDialog {

    private int tab = 0;
    private Produto produto;
    private JDialog telaVoltar;

    public ValorVendaProduto(java.awt.Frame parent, Long codigo, JDialog telaVoltar) {
        super(parent);
        initComponents();
        verificarProduto(codigo);
        this.telaVoltar = telaVoltar;
        this.preencherJTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btVoltar = new javax.swing.JButton();
        btRelatorio = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfValorFinal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Preço do Produto");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Produto", "Nome do Fornecedor", "Quantidades de Sacos", "Valor Unit. Sacos R$", "Preço por KG", "Total em R$", "Lote Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosMouseClicked(evt);
            }
        });
        jtProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtProdutosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtProdutos);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 220, 1060, 280);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        btVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Voltar.png"))); // NOI18N
        btVoltar.setMnemonic('v');
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Voltar (Alt+V)");
        btVoltar.setFocusable(false);
        btVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jToolBar1.add(btVoltar);

        btRelatorio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474038_pie_chart.png"))); // NOI18N
        btRelatorio.setMnemonic('r');
        btRelatorio.setText("Relatório");
        btRelatorio.setToolTipText("Relatório (Alt+R)");
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });
        jToolBar1.add(btRelatorio);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar.png"))); // NOI18N
        btAlterar.setMnemonic('a');
        btAlterar.setText("Alterar preço de venda");
        btAlterar.setToolTipText("Alterar preço de venda(Alt+A)");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(btAlterar);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Preço atual de venda:     ");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setPreferredSize(new java.awt.Dimension(400, 15));
        jToolBar1.add(jLabel16);

        tfValorFinal.setEditable(false);
        tfValorFinal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tfValorFinal.setPreferredSize(new java.awt.Dimension(150, 35));
        jToolBar1.add(tfValorFinal);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 1070, 40);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço mais alto do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Fornecedor:");
        jLabel17.setMinimumSize(new java.awt.Dimension(187, 15));
        jLabel17.setPreferredSize(new java.awt.Dimension(130, 15));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Valor:");
        jLabel18.setMinimumSize(new java.awt.Dimension(187, 15));
        jLabel18.setPreferredSize(new java.awt.Dimension(130, 15));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(390, 80, 360, 120);

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço mais baixo do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("Fornecedor:");
        jLabel19.setMinimumSize(new java.awt.Dimension(187, 15));
        jLabel19.setPreferredSize(new java.awt.Dimension(130, 15));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Valor:");
        jLabel20.setMinimumSize(new java.awt.Dimension(187, 15));
        jLabel20.setPreferredSize(new java.awt.Dimension(130, 15));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 80, 360, 120);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantidade Atual em Estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jTextField5.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(770, 80, 240, 120);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1098)/2, (screenSize.height-555)/2, 1098, 555);
    }// </editor-fold>//GEN-END:initComponents

    private void jtProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosMouseClicked
        int linha = jtProdutos.getSelectedRow();
        //codigo = Integer.parseInt(jtProdutos.getValueAt(linha, 0).toString());
    }//GEN-LAST:event_jtProdutosMouseClicked

    private void jtProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutosKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                jtProdutosMouseClicked(null);
            }
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                if (tab % 2 == 0) {
                    jtProdutos.transferFocus();
                }
                tab++;
            }
        } catch (Exception erro) {
        }
    }//GEN-LAST:event_jtProdutosKeyPressed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        this.telaVoltar.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField tfValorFinal;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para preencher a tabela de produtos.
     */
    private void preencherJTable() {

        jtProdutos.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtProdutos.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) jtProdutos.getModel();
        modelo.setNumRows(0);

        List<Object> lista = Fachada.getInstance().produtoLote(produto.getId());
        
        System.out.println(""+lista.size()+" | "+produto.toString());

        try {
            for (Object object : lista) {

                Lote l = (Lote) object;

                String fornecedor = "";
                try {
                    fornecedor = l.getFornecedor().getNome();
                } catch (Exception e) {
                }

                modelo.addRow(new Object[]{
                            l.getId(),
                            l.getProduto().getNome(),
                            fornecedor,
                            l.getQuant(),
                            l.getValor(),
                            l.getPreco(),
                            (l.getQuant() * l.getValor()),
                            l.getNumero()
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar a tabela de produtos." + erro);
        }
    }

    /**
     * Método para verificar se o produto existe.
     * @param codigo
     */
    private void verificarProduto(Long codigo) {
        try {
            this.produto = Fachada.getInstance().buscaProduto(codigo);
        } catch (ProdutoException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o produto.");
            btVoltarActionPerformed(null);
        }
    }
}
