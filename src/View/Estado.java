/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EstadoController;
import Util.Error;
import Util.Helper;
import Util.TelaHandler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Estado extends javax.swing.JFrame {
    private TelaHandler tratarEventos;
    private final JFrame windowsBack;
    private int estadoID;
    JSONObject jsonPersistencia;
    /**
     * Creates new form Pais
     * @param windowsBack
     */
    public Estado(JFrame windowsBack) {
        initComponents();
        this.windowsBack =  windowsBack;
        Init();
    }
    public void Init(){
        tratarEventos = new TelaHandler(jbIncluir, jbGravar, jbCancelar, jbExcluir,jbConsultar);
        ArrayList<JTextField> camposAtivar = new ArrayList<>();
        camposAtivar.add(jtfNomeEstado);
        camposAtivar.add(jtfSigla);
        camposAtivar.add(jtfCodigoPais);
        camposAtivar.add(jtfSiglaPais);
        tratarEventos.setCampos(camposAtivar);
    }
    private void InitCamposBusca(boolean habilitaBusca){
        jtfPaisNome.setText("Busque um país");
        jbBuscaPais.setEnabled(habilitaBusca);
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
        jlNome = new javax.swing.JLabel();
        jlSigla = new javax.swing.JLabel();
        jtfSigla = new javax.swing.JTextField();
        jbIncluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jtfNomeEstado = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jtfCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfPaisNome = new javax.swing.JTextField();
        jtfCodigoPais = new javax.swing.JTextField();
        jbBuscaPais = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfSiglaPais = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de País");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(521, 230));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("MenuItem.selectionForeground"));
        jPanel1.setLayout(null);

        jbCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/CancelIcon.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar);
        jbCancelar.setBounds(0, 80, 120, 40);

        jlNome.setText("Nome:");
        jPanel1.add(jlNome);
        jlNome.setBounds(180, 30, 60, 20);

        jlSigla.setText("Sigla:");
        jPanel1.add(jlSigla);
        jlSigla.setBounds(180, 80, 50, 20);

        jtfSigla.setEnabled(false);
        jtfSigla.setName("Sigla"); // NOI18N
        jPanel1.add(jtfSigla);
        jtfSigla.setBounds(180, 100, 60, 20);

        jbIncluir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/IncluirIcon.png"))); // NOI18N
        jbIncluir.setText("Incluir");
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });
        jPanel1.add(jbIncluir);
        jbIncluir.setBounds(0, 0, 120, 40);

        jbGravar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/SaveIcon.png"))); // NOI18N
        jbGravar.setText("Gravar");
        jbGravar.setEnabled(false);
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGravar);
        jbGravar.setBounds(0, 40, 120, 40);

        jtfNomeEstado.setEnabled(false);
        jtfNomeEstado.setName("Nome"); // NOI18N
        jtfNomeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(jtfNomeEstado);
        jtfNomeEstado.setBounds(180, 50, 270, 20);

        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/trash.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jbExcluir);
        jbExcluir.setBounds(0, 120, 120, 40);

        jbConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbConsultar.setText("Consultar");
        jPanel1.add(jbConsultar);
        jbConsultar.setBounds(0, 160, 120, 40);

        jButton3.setText("<<");
        jPanel1.add(jButton3);
        jButton3.setBounds(310, 0, 50, 23);

        jButton4.setText("<");
        jPanel1.add(jButton4);
        jButton4.setBounds(360, 0, 50, 23);

        jButton5.setText(">");
        jPanel1.add(jButton5);
        jButton5.setBounds(410, 0, 50, 23);

        jButton6.setText(">>");
        jPanel1.add(jButton6);
        jButton6.setBounds(460, 0, 49, 23);
        jPanel1.add(jtfCodigo);
        jtfCodigo.setBounds(230, 0, 70, 20);

        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 0, 40, 14);

        jtfPaisNome.setText("Busque um país");
        jtfPaisNome.setEnabled(false);
        jtfPaisNome.setName("nome do país"); // NOI18N
        jPanel1.add(jtfPaisNome);
        jtfPaisNome.setBounds(250, 140, 150, 20);

        jtfCodigoPais.setEditable(false);
        jtfCodigoPais.setEnabled(false);
        jtfCodigoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoPaisActionPerformed(evt);
            }
        });
        jPanel1.add(jtfCodigoPais);
        jtfCodigoPais.setBounds(180, 140, 60, 20);

        jbBuscaPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscaPais.setEnabled(false);
        jbBuscaPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaPaisActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscaPais);
        jbBuscaPais.setBounds(450, 140, 40, 20);

        jLabel2.setText("País");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 120, 19, 20);

        jtfSiglaPais.setEditable(false);
        jtfSiglaPais.setEnabled(false);
        jPanel1.add(jtfSiglaPais);
        jtfSiglaPais.setBounds(410, 140, 30, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 210);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNomeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeEstadoActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtfCodigo.setEnabled(true);
        tratarEventos.ativaGravar(false);
        InitCamposBusca(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        JSONObject jsonAux = new JSONObject();
        jsonPersistencia = new JSONObject();
        
        try {
            Util.Validacao.InputToString(jtfNomeEstado);
            Util.Validacao.InputToString(jtfSigla);
            Util.Validacao.InputToString(jtfPaisNome);
            Util.Validacao.InputToString(jtfCodigoPais);
            
            jsonPersistencia.put("nome", jtfNomeEstado.getText());
            jsonPersistencia.put("sigla", jtfSigla.getText().toUpperCase());

            jsonAux.put("codigo", jtfCodigoPais.getText());
            jsonAux.put("nome", jtfPaisNome.getText());

            jsonPersistencia.put("pais", jsonAux);

            EstadoController estadoCntrl = new EstadoController();
            if(estadoCntrl.Save(jsonPersistencia)){
                jtfCodigo.setEnabled(true);
                tratarEventos.ativaGravar(false);
                InitCamposBusca(false);
            }
        } catch (Error ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
      
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
       jtfCodigo.setEnabled(false);
       tratarEventos.ativaGravar(true);
       InitCamposBusca(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jtfCodigoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoPaisActionPerformed

    private void jbBuscaPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaPaisActionPerformed
        Helper.ShowDialog(this,new BuscarLocalidade(this,jtfPaisNome,jtfCodigoPais,jtfSiglaPais,estadoID,"Pais"));
    }//GEN-LAST:event_jbBuscaPaisActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        InitCamposBusca(false);
    }//GEN-LAST:event_jbExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(Estado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estado(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscaPais;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlSigla;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCodigoPais;
    private javax.swing.JTextField jtfNomeEstado;
    private javax.swing.JTextField jtfPaisNome;
    private javax.swing.JTextField jtfSigla;
    private javax.swing.JTextField jtfSiglaPais;
    // End of variables declaration//GEN-END:variables
}
