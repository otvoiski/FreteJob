/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CidadeController;
import Util.Error;
import Util.Helper;
import Util.TelaHandler;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Cidade extends javax.swing.JFrame {
    private TelaHandler tratarEventos;
    private final JFrame backWindows;
    private int CidadeID;
    JSONObject jsonPersistencia;
    /**
     * Creates new form Pais
     * @param windowsBack
     */
    public Cidade(JFrame windowsBack) {
        initComponents();
        this.backWindows =  windowsBack;
        Init();
    }
    public void Init(){
        tratarEventos = new TelaHandler(jbIncluir, jbGravar, jbCancelar, jbExcluir,jbConsultar);
        ArrayList<JTextField> camposAtivar = new ArrayList<>();
        camposAtivar.add(jtfNomeCidade);
        camposAtivar.add(jtfCodMunicipio);
        camposAtivar.add(jtfCodigoEstado);
        camposAtivar.add(jtfSiglaEstado);
        tratarEventos.setCampos(camposAtivar);
    }
    private void InitCamposBusca(boolean habilitaBusca){
        jtfEstadoNome.setText("Busque um estado");
        jbBuscaEstado.setEnabled(habilitaBusca);
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
        jbIncluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jtfCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtfCodigoEstado = new javax.swing.JTextField();
        jtfEstadoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfSiglaEstado = new javax.swing.JTextField();
        jbBuscaEstado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        jtfNomeCidade = new javax.swing.JTextField();
        jlCodMunicipio = new javax.swing.JLabel();
        jtfCodMunicipio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidade");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(610, 350));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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
        jbCancelar.setBounds(250, 270, 111, 30);

        jbIncluir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/IncluirIcon.png"))); // NOI18N
        jbIncluir.setText("Incluir");
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });
        jPanel1.add(jbIncluir);
        jbIncluir.setBounds(30, 270, 100, 30);

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
        jbGravar.setBounds(140, 270, 100, 30);

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
        jbExcluir.setBounds(370, 270, 90, 30);

        jbConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(jbConsultar);
        jbConsultar.setBounds(470, 270, 110, 30);

        jButton3.setText("<<");
        jPanel1.add(jButton3);
        jButton3.setBounds(400, 0, 50, 23);

        jButton4.setText("<");
        jPanel1.add(jButton4);
        jButton4.setBounds(450, 0, 50, 23);

        jButton5.setText(">");
        jPanel1.add(jButton5);
        jButton5.setBounds(500, 0, 50, 23);

        jButton6.setText(">>");
        jPanel1.add(jButton6);
        jButton6.setBounds(550, 0, 49, 23);
        jPanel1.add(jtfCodigo);
        jtfCodigo.setBounds(50, 0, 70, 20);

        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 0, 40, 14);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        jPanel3.setLayout(null);

        jtfCodigoEstado.setEditable(false);
        jtfCodigoEstado.setEnabled(false);
        jtfCodigoEstado.setName("Codigo do estado"); // NOI18N
        jtfCodigoEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoEstadoActionPerformed(evt);
            }
        });
        jPanel3.add(jtfCodigoEstado);
        jtfCodigoEstado.setBounds(30, 40, 60, 20);

        jtfEstadoNome.setText("Busque um estado");
        jtfEstadoNome.setEnabled(false);
        jtfEstadoNome.setName("nome do estado"); // NOI18N
        jPanel3.add(jtfEstadoNome);
        jtfEstadoNome.setBounds(100, 40, 230, 20);

        jLabel2.setText("Estado");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 20, 40, 20);

        jtfSiglaEstado.setEditable(false);
        jtfSiglaEstado.setEnabled(false);
        jtfSiglaEstado.setName("Sigla"); // NOI18N
        jPanel3.add(jtfSiglaEstado);
        jtfSiglaEstado.setBounds(340, 40, 30, 20);

        jbBuscaEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscaEstado.setEnabled(false);
        jbBuscaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaEstadoActionPerformed(evt);
            }
        });
        jPanel3.add(jbBuscaEstado);
        jbBuscaEstado.setBounds(380, 40, 40, 20);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 140, 580, 90);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidade"));
        jPanel4.setLayout(null);

        jlNome.setText("Nome:");
        jPanel4.add(jlNome);
        jlNome.setBounds(30, 10, 60, 20);

        jtfNomeCidade.setEnabled(false);
        jtfNomeCidade.setName("Nome"); // NOI18N
        jtfNomeCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeCidadeActionPerformed(evt);
            }
        });
        jPanel4.add(jtfNomeCidade);
        jtfNomeCidade.setBounds(30, 30, 390, 20);

        jlCodMunicipio.setText("Código do Municipio");
        jPanel4.add(jlCodMunicipio);
        jlCodMunicipio.setBounds(30, 60, 100, 20);

        jtfCodMunicipio.setEnabled(false);
        jtfCodMunicipio.setName("Codigo do municipio"); // NOI18N
        jPanel4.add(jtfCodMunicipio);
        jtfCodMunicipio.setBounds(30, 80, 130, 20);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(10, 20, 580, 120);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 20, 600, 240);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 620, 330);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNomeCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeCidadeActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtfCodigo.setEnabled(true);
        tratarEventos.ativaGravar(false);
        InitCamposBusca(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        JSONObject jsonAux = new JSONObject();
        jsonPersistencia = new JSONObject();
        
        try {
            Util.Validacao.InputToString(jtfNomeCidade);
            Util.Validacao.InputToString(jtfCodMunicipio);
            Util.Validacao.InputToString(jtfEstadoNome);
            Util.Validacao.InputToString(jtfCodigoEstado);
            
            jsonPersistencia.put("nome", jtfNomeCidade.getText());
            jsonPersistencia.put("cod_municipio", jtfCodMunicipio.getText().toUpperCase());

            jsonAux.put("codigo", jtfCodigoEstado.getText());
            jsonAux.put("nome", jtfEstadoNome.getText());

            jsonPersistencia.put("estado", jsonAux);

            CidadeController cidadeCntrl = new CidadeController();
            if(cidadeCntrl.Save(jsonPersistencia)){
                jtfCodigo.setEnabled(true);
                tratarEventos.ativaGravar(false);
                InitCamposBusca(false);
                JOptionPane.showMessageDialog(null, "Cidade gravada com sucesso!");
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

    private void jtfCodigoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoEstadoActionPerformed

    private void jbBuscaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaEstadoActionPerformed
        Helper.ShowDialog(this,new BuscarLocalidade(this,"Estado", jtfEstadoNome,jtfCodigoEstado,jtfSiglaEstado));
    }//GEN-LAST:event_jbBuscaEstadoActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        InitCamposBusca(false);
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
       //Helper.ShowDialog(this,new BuscarLocalidade(this,this,"Estado"));
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Helper.CloseDialog(this, backWindows);
    }//GEN-LAST:event_formWindowClosing

    public JTextField getJtfCodMunicipio() {
        return jtfCodMunicipio;
    }

    public void setJtfCodMunicipio(JTextField jtfCodMunicipio) {
        this.jtfCodMunicipio = jtfCodMunicipio;
    }

    public JTextField getJtfCodigo() {
        return jtfCodigo;
    }

    public void setJtfCodigo(JTextField jtfCodigo) {
        this.jtfCodigo = jtfCodigo;
    }

    public JTextField getJtfCodigoEstado() {
        return jtfCodigoEstado;
    }

    public void setJtfCodigoEstado(JTextField jtfCodigoEstado) {
        this.jtfCodigoEstado = jtfCodigoEstado;
    }

    public JTextField getJtfEstadoNome() {
        return jtfEstadoNome;
    }

    public void setJtfEstadoNome(JTextField jtfEstadoNome) {
        this.jtfEstadoNome = jtfEstadoNome;
    }

    public JTextField getJtfNomeCidade() {
        return jtfNomeCidade;
    }

    public void setJtfNomeCidade(JTextField jtfNomeCidade) {
        this.jtfNomeCidade = jtfNomeCidade;
    }

    public JTextField getJtfSiglaEstado() {
        return jtfSiglaEstado;
    }

    public void setJtfSiglaEstado(JTextField jtfSiglaEstado) {
        this.jtfSiglaEstado = jtfSiglaEstado;
    }


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
            java.util.logging.Logger.getLogger(Cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cidade(null).setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbBuscaEstado;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JLabel jlCodMunicipio;
    private javax.swing.JLabel jlNome;
    private javax.swing.JTextField jtfCodMunicipio;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCodigoEstado;
    private javax.swing.JTextField jtfEstadoNome;
    private javax.swing.JTextField jtfNomeCidade;
    private javax.swing.JTextField jtfSiglaEstado;
    // End of variables declaration//GEN-END:variables
}
