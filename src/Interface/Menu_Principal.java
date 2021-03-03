package Interface;

import Classes.Relatorio;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Menu_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Principal
     */
    Date dt = new Date();
    SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
    public Menu_Principal() {
        initComponents();
        this.getContentPane().setBackground(new Color(209, 209, 209));
        jLabelData.setText("Data: " + dtf.format(dt));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogInfo = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonProd = new javax.swing.JButton();
        jButtonVend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemProd = new javax.swing.JMenuItem();
        jMenuItemVend = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemRel = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jDialogInfo.setTitle("Info");
        jDialogInfo.setLocationByPlatform(true);
        jDialogInfo.setMinimumSize(new java.awt.Dimension(381, 200));
        jDialogInfo.setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Este software foi desenvolvido exclusivamente \npara facilitar o gerenciamento de estoque e vendas\ndo estabelecimento comercial \"Amorim Embalagens\",\nlocalizado no municipio de Camaçari, Bahia.");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel2.setText("Desenolvido por: Celso Melo e Leandro Alves. IFBA - CAMAÇARI");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel3.setText("Informação:");

        javax.swing.GroupLayout jDialogInfoLayout = new javax.swing.GroupLayout(jDialogInfo.getContentPane());
        jDialogInfo.getContentPane().setLayout(jDialogInfoLayout);
        jDialogInfoLayout.setHorizontalGroup(
            jDialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jDialogInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogInfoLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialogInfoLayout.setVerticalGroup(
            jDialogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInfoLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationByPlatform(true);
        setResizable(false);

        jLabelData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelData.setText("Data:");

        jPanel1.setBackground(new java.awt.Color(209, 209, 209));

        jButtonProd.setBackground(new java.awt.Color(51, 153, 0));
        jButtonProd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonProd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonProd.setText("Produtos");
        jButtonProd.setToolTipText("");
        jButtonProd.setBorder(null);
        jButtonProd.setBorderPainted(false);
        jButtonProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonProdMouseExited(evt);
            }
        });
        jButtonProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdActionPerformed(evt);
            }
        });

        jButtonVend.setBackground(new java.awt.Color(51, 153, 0));
        jButtonVend.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonVend.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVend.setText("Vendas");
        jButtonVend.setBorder(null);
        jButtonVend.setBorderPainted(false);
        jButtonVend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonVendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonVendMouseExited(evt);
            }
        });
        jButtonVend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo_500x219.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(jButtonVend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVend, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenuBar1.setBorder(null);

        jMenu1.setText("Abrir");

        jMenuItemProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemProd.setText("Gerenciar Produtos");
        jMenuItemProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProd);

        jMenuItemVend.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemVend.setText("Realizar Vendas");
        jMenuItemVend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVendActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemVend);
        jMenu1.add(jSeparator1);

        jMenuItemRel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemRel.setText("Gerar Relátorios");
        jMenuItemRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRelActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRel);
        jMenu1.add(jSeparator2);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opções");

        jMenuItem5.setText("Banco de Dados");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(201, 201, 201));
        jMenu3.setText("Ajuda");

        jMenuItem6.setText("Info");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabelData)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVendActionPerformed
        // TODO add your handling code here:
        Real_Vendas vend = new Real_Vendas();
        vend.setVisible(true);
    }//GEN-LAST:event_jMenuItemVendActionPerformed

    private void jMenuItemProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdActionPerformed
        // TODO add your handling code here:
        Gerenciamento gen = new Gerenciamento();
        gen.setVisible(true);
    }//GEN-LAST:event_jMenuItemProdActionPerformed

    private void jButtonProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdActionPerformed
        // TODO add your handling code here:
        Gerenciamento gen = new Gerenciamento();
        gen.setVisible(true);
    }//GEN-LAST:event_jButtonProdActionPerformed

    private void jButtonVendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendActionPerformed
        // TODO add your handling code here:
        Real_Vendas vend = new Real_Vendas();
        vend.setVisible(true);
    }//GEN-LAST:event_jButtonVendActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRelActionPerformed
        // TODO add your handling code here:
        Relatorio rel = new Relatorio();
        
        try {
            rel.gerarRelatorio();

            int r = JOptionPane.showConfirmDialog(null, "Relátorio gerado com sucesso! Arquivo: "
                    + rel.getSrc() + "\n Deseja abrir o local do arquvo?", "Sucesso", JOptionPane.YES_NO_OPTION);
            if (r == 0) {
                Desktop.getDesktop().open(new File("rel/"));
            }

        } catch (DocumentException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar Relatorio: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemRelActionPerformed

    private void jButtonProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProdMouseEntered
        // TODO add your handling code here:
        jButtonProd.setBackground(new Color(59, 178, 0));
    }//GEN-LAST:event_jButtonProdMouseEntered

    private void jButtonProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProdMouseExited
        // TODO add your handling code here:
         jButtonProd.setBackground(new Color(51, 153, 0));
    }//GEN-LAST:event_jButtonProdMouseExited

    private void jButtonVendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendMouseEntered
        // TODO add your handling code here:
        jButtonVend.setBackground(new Color(59, 178, 0));
    }//GEN-LAST:event_jButtonVendMouseEntered

    private void jButtonVendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVendMouseExited
        // TODO add your handling code here:
        jButtonVend.setBackground(new Color(51, 153, 0));
    }//GEN-LAST:event_jButtonVendMouseExited

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        jDialogInfo.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Ge_BD bd = new Ge_BD();
        
        bd.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonProd;
    private javax.swing.JButton jButtonVend;
    private javax.swing.JDialog jDialogInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemProd;
    private javax.swing.JMenuItem jMenuItemRel;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemVend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
