package GUI.Estoque;

import Entidade.Estoque.Exception.LoteException;
import Entidade.Estoque.Lote;
import Fachada.Fachada;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fagner
 */
public class ListaLote extends javax.swing.JDialog {

    private JDialog telaVoltar;
    private DefaultTableModel modelo;
    private Long codigo;
    private int tab = 1;
    private Lote lote;

    public ListaLote(java.awt.Frame parent, JDialog telaVoltar) {
        super(parent);
        initComponents();
        this.telaVoltar = telaVoltar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPesquisa = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLote = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tfCodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        tfNumero = new javax.swing.JTextField();
        btOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Produtos");

        pnPesquisa.setBackground(java.awt.Color.white);
        pnPesquisa.setLayout(null);
        pnPesquisa.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 890, 10);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel1.setText("Pesquisa de Produtos");
        pnPesquisa.add(jLabel1);
        jLabel1.setBounds(27, 12, 250, 24);

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

        pnPesquisa.add(jScrollPane1);
        jScrollPane1.setBounds(20, 150, 880, 260);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tfNome.setFont(new java.awt.Font("Ubuntu", 0, 14));
        tfNome.setToolTipText("Pesquisar produto");
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });
        jPanel2.add(tfNome, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Nome", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        tfCodigo.setFont(new java.awt.Font("Ubuntu", 0, 14));
        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoKeyPressed(evt);
            }
        });
        jPanel3.add(tfCodigo, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Código Interno", jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        tfNumero.setFont(new java.awt.Font("Ubuntu", 0, 14));
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNumeroKeyPressed(evt);
            }
        });
        jPanel4.add(tfNumero, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Lote/Número", jPanel4);

        pnPesquisa.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 60, 240, 80);

        btOk.setText("Finalizar");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });
        pnPesquisa.add(btOk);
        btOk.setBounds(780, 90, 100, 40);

        getContentPane().add(pnPesquisa, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-918)/2, (screenSize.height-461)/2, 918, 461);
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
        this.preecherJTableLote(1);
    }//GEN-LAST:event_tfNomeKeyPressed

    private void jtLoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLoteMouseClicked
        int linha = jtLote.getSelectedRow();
        codigo = (Long) jtLote.getValueAt(linha, 0);
        try {
            this.lote = Fachada.getInstance().buscaLotes(codigo);
        } catch (LoteException ex) {
            JOptionPane.showMessageDialog(null, "Não é possivel ligar o produtos.", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
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

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        if (lote != null) {
            if (telaVoltar instanceof CadastrarPedido) {
                CadastrarPedido cadastrarPedido = (CadastrarPedido) telaVoltar;
                cadastrarPedido.addLote(lote);
                this.setVisible(false);
                telaVoltar.setVisible(true);
            }
            return;
        }
        JOptionPane.showMessageDialog(null, "Selecione um produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btOkActionPerformed

    private void tfCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoKeyPressed
        this.preecherJTableLote(2);
    }//GEN-LAST:event_tfCodigoKeyPressed

    private void tfNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyPressed
        this.preecherJTableLote(3);
    }//GEN-LAST:event_tfNumeroKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtLote;
    private javax.swing.JPanel pnPesquisa;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    // End of variables declaration//GEN-END:variables

    public void preecherJTableLote(int op) {

        jtLote.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtLote.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtLote.getColumnModel().getColumn(2).setPreferredWidth(100);

        modelo = (DefaultTableModel) jtLote.getModel();
        modelo.setNumRows(0);

        List<Object> lotes = new ArrayList<Object>();
        if (op == 1) {
            lotes = Fachada.getInstance().listarLotes(tfNome.getText());
        } else if (op == 2) {
            lotes = Fachada.getInstance().listarLotes(tfCodigo.getText());
        } else if (op == 3) {
            lotes = Fachada.getInstance().listarLotes(tfNumero.getText());
        }
        try {
            for (Object object : lotes) {
                Lote l = (Lote) object;
                String fornecedor ="";
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
                            (l.getQuant() * l.getValor())
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela de produtos." + erro);
        }
    }
}
