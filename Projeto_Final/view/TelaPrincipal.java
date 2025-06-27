package view;

import controller.VendaController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import util.CentralizarJanela;

public class TelaPrincipal extends javax.swing.JFrame {

    CentralizarJanela janelaCentralizada = new CentralizarJanela();
    
    public TelaPrincipal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpDesktop = new javax.swing.JDesktopPane();
        jmbBarraMenu = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmiCliente = new javax.swing.JMenuItem();
        js1 = new javax.swing.JPopupMenu.Separator();
        jmiFornecedor = new javax.swing.JMenuItem();
        js2 = new javax.swing.JPopupMenu.Separator();
        jmiVenda = new javax.swing.JMenuItem();
        jmRelatorio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmSobre = new javax.swing.JMenu();
        jmiSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jdpDesktopLayout = new javax.swing.GroupLayout(jdpDesktop);
        jdpDesktop.setLayout(jdpDesktopLayout);
        jdpDesktopLayout.setHorizontalGroup(
            jdpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jdpDesktopLayout.setVerticalGroup(
            jdpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        jmArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arquivo.png"))); // NOI18N
        jmArquivo.setText("Arquivo");

        jmiCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCliente.setText("Cliente");
        jmiCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClienteActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiCliente);
        jmArquivo.add(js1);

        jmiFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiFornecedor.setText("Fornecedor");
        jmiFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFornecedorActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiFornecedor);
        jmArquivo.add(js2);

        jmiVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiVenda.setText("Venda");
        jmiVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVendaActionPerformed(evt);
            }
        });
        jmArquivo.add(jmiVenda);

        jmbBarraMenu.add(jmArquivo);

        jmRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/relatorio.png"))); // NOI18N
        jmRelatorio.setText("Relatorio");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Gerar Relatório");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmRelatorio.add(jMenuItem1);

        jmbBarraMenu.add(jmRelatorio);

        jmSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sobre.png"))); // NOI18N
        jmSobre.setText("Sobre");

        jmiSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiSobre.setText("Visualizar");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        jmSobre.add(jmiSobre);

        jmbBarraMenu.add(jmSobre);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpDesktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClienteActionPerformed
        JanelaCliente janela;
        janelaCentralizada.abrirJanela(janela = new JanelaCliente(), jdpDesktop);
        janela.setTitle("Cadastro de Clientes");
    }//GEN-LAST:event_jmiClienteActionPerformed

    private void jmiFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFornecedorActionPerformed
        JanelaFornecedor janela;
        janelaCentralizada.abrirJanela(janela = new JanelaFornecedor(), jdpDesktop);
        janela.setTitle("Cadastro de Fornecedores");
    }//GEN-LAST:event_jmiFornecedorActionPerformed

    private void jmiVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVendaActionPerformed
        JanelaVenda janela;
        janelaCentralizada.abrirJanela(janela = new JanelaVenda(), jdpDesktop);
        janela.setTitle("Cadastro de Vendas");
    }//GEN-LAST:event_jmiVendaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VendaController.gerarRelatorio();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSobreActionPerformed
        JOptionPane.showMessageDialog(null, "Dev: Guilherme Kenta Masuda\nDocente: Allan Santos Alvares de Lima\nSistema criado para o trabalho de LPI-3 com o objetivo de utilizar os conceitos de POO e de interface gráfica que foram trabalhados durante o ano.");
    }//GEN-LAST:event_jmiSobreActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JDesktopPane jdpDesktop;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmRelatorio;
    private javax.swing.JMenu jmSobre;
    private javax.swing.JMenuBar jmbBarraMenu;
    private javax.swing.JMenuItem jmiCliente;
    private javax.swing.JMenuItem jmiFornecedor;
    private javax.swing.JMenuItem jmiSobre;
    private javax.swing.JMenuItem jmiVenda;
    private javax.swing.JPopupMenu.Separator js1;
    private javax.swing.JPopupMenu.Separator js2;
    // End of variables declaration//GEN-END:variables
}
