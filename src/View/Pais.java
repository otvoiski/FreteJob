/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Matheus
 */
public class Pais extends javax.swing.JFrame {

    /**
     * Creates new form Pais
     */
    public Pais() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlSigla = new javax.swing.JLabel();
        jtfSigla = new javax.swing.JTextField();
        jbIncluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jtfNomePais = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(594, 322));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionForeground"));
        jPanel1.setLayout(null);

        jbCancelar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/CancelIcon.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(320, 230, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/PaisIcon.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(340, 20, 220, 200);

        jlNome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlNome.setText("Nome:");
        jPanel1.add(jlNome);
        jlNome.setBounds(60, 40, 60, 20);

        jlSigla.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlSigla.setText("Sigla:");
        jPanel1.add(jlSigla);
        jlSigla.setBounds(60, 90, 50, 20);
        jPanel1.add(jtfSigla);
        jtfSigla.setBounds(60, 110, 60, 20);

        jbIncluir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jbIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/IncluirIcon.png"))); // NOI18N
        jbIncluir.setText("Incluir");
        jPanel1.add(jbIncluir);
        jbIncluir.setBounds(120, 230, 90, 30);

        jbGravar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/SaveIcon.png"))); // NOI18N
        jbGravar.setText("Gravar");
        jPanel1.add(jbGravar);
        jbGravar.setBounds(220, 230, 95, 30);

        jtfNomePais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomePaisActionPerformed(evt);
            }
        });
        jPanel1.add(jtfNomePais);
        jtfNomePais.setBounds(60, 60, 270, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 620, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNomePaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomePaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomePaisActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSigla;
    private javax.swing.JTextField jtfNomePais;
    private javax.swing.JTextField jtfSigla;
    // End of variables declaration//GEN-END:variables
}
