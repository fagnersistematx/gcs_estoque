package GUI.Estoque;

import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Produto;
import Fachada.Fachada;
import gerenciadorclientes.GerenciadorClientesApp;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fagner
 */
public class ListaProdutos extends javax.swing.JDialog {

    private JDialog tela;
    private DefaultTableModel modelo;
    private Long codigo;

    public ListaProdutos(java.awt.Frame parent) {
        super(parent);
        initComponents();
        preecherJTableProdutos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();
        btNovaConta = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        PrecoVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Produtos");

        jPanel1.setBackground(java.awt.Color.white);

        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Produto", "Código Interno", "Preço de Venda "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);

        btNovaConta.setText("Novo Produto");
        btNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaContaActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Produtos");

        tfPesquisa.setToolTipText("Pesquisar produto");
        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyPressed(evt);
            }
        });

        PrecoVenda.setText("Preço de Venda");
        PrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btNovaConta)
                                .addGap(18, 18, 18)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovaConta)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(PrecoVenda)
                    .addComponent(tfPesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(871, 428));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void btNovaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaContaActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    tela = new CadastrarProduto(mainFrame, this);
    GerenciadorClientesApp.getApplication().show(tela);
    tela.setSize(628, 297);
    setVisible(false);
}//GEN-LAST:event_btNovaContaActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (codigo != null) {
            JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
            tela = new AlterarProduto(mainFrame, this, codigo);
            GerenciadorClientesApp.getApplication().show(tela);
            tela.setSize(517, 297);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto.", "Atenção", 0);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void jtProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseClicked
        int linha = jtProduto.getSelectedRow();
        codigo = (Long) jtProduto.getValueAt(linha, 0);
    }//GEN-LAST:event_jtProdutoMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (codigo != null) {
            String nomeProduto;
            try {
                nomeProduto = Fachada.getInstance().buscaProduto(codigo).getNome();
            } catch (ProdutoException ex) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Atenção", 0);
                return;
            }

            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que dezeja excluir o produto " + nomeProduto, "Atenção", JOptionPane.YES_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                try {
                    Fachada.getInstance().removerProduto(codigo);
                    preecherJTableProdutos();
                    JOptionPane.showMessageDialog(null, "Produto excluído.");
                } catch (ProdutoException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir este produto pois o mesmo já \n"
                            + "esta relacionado.", "Atenção", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto.", "Atenção", 0);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyPressed
        this.preecherJTableProdutos();
    }//GEN-LAST:event_tfPesquisaKeyPressed

    private void PrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoVendaActionPerformed
        if (codigo != null) {
            JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
            tela = new ValorVendaProduto(mainFrame,codigo,this);
            GerenciadorClientesApp.getApplication().show(tela);
            tela.setSize(1098, 555);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto.", "Atenção", 0);
        }
    }//GEN-LAST:event_PrecoVendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrecoVenda;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovaConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtProduto;
    private javax.swing.JTextField tfPesquisa;
    // End of variables declaration//GEN-END:variables

    public void preecherJTableProdutos() {

        jtProduto.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtProduto.getColumnModel().getColumn(2).setPreferredWidth(50);

        modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);

        List<Object> produtos;
        produtos = Fachada.getInstance().listarProdutos(tfPesquisa.getText());

        try {
            for (Object o : produtos) {
                Produto produto = (Produto) o;
                modelo.addRow(new Object[]{
                            produto.getId(),
                            produto.getNome(),
                            produto.getCodigo()
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela de produtos." + erro);
        }
    }
}
