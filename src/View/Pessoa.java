/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Util.Enums.TipoEndereco;
import Util.Error;
import Util.Helper;
import Util.TelaHandler;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Otavio
 */
public class Pessoa extends javax.swing.JFrame {

    private JFrame windowsBack;
   // private final Thread TCheckCadastrarEmitente;
    private final TelaHandler tratarEventos;
    private int enderCidadeID;
    private int distibuidoraID;

    /**
     * Creates new form EncomendaCriarPessoa
     *
     * @param windowsBack
     */
    private void insereLinhaTabela(JTable tabela){
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        if(tabela.getRowCount() == 0){
            modelo.addRow(new Object[]{});
            tabela.setModel(modelo);
        }else{
            modelo.addRow(new Object[]{});
            tabela.setModel(modelo);
        }
         
    }
    private void removeLinhaSelecionada(JTable tabela){
        DefaultTableModel modelo =  (DefaultTableModel) tabela.getModel();
        if(tabela.getSelectedRow() != -1){
            modelo.removeRow(tabela.getSelectedRow());
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para remover");
        }
        tabela.setModel(modelo);
    }
    public Pessoa(JFrame windowsBack) {
        initComponents();
        this.tratarEventos = new TelaHandler(jbIncluir, jbGravar, jbCancelar, jbExluir, jbConsultar);

        this.windowsBack = windowsBack;

        for (TipoEndereco tipo : Util.Enums.TipoEndereco.values()) {
            jcbTiposEndereco.addItem(tipo.name());
        }
        /*TCheckCadastrarEmitente = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (jrbFisica.isSelected()) {
                            jbGravar.setEnabled(
                                    !jtfNome_RazaoSoc.getText().isEmpty()
                                    && !jtfCpf_NomeFantasia.getText().isEmpty()
                                    && !jtfRg_CNPJ.getText().isEmpty()
                                    && !jtfDataNasc.getText().isEmpty()
                            );
                        } else {
                            jbGravar.setEnabled(
                                    !jtfNome_RazaoSoc.getText().isEmpty()
                                    && !jtfCpf_NomeFantasia.getText().isEmpty()
                                    && !jtfRg_CNPJ.getText().isEmpty()
                            );
                        }
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        TCheckCadastrarEmitente.start();*/

        TableColumnModel columnModel = jtbTelefones.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(15);
        columnModel.getColumn(1).setPreferredWidth(300);

        columnModel = jtbDistCidadesAtua.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(15);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(100);

        jrbFisica.setSelected(true);
        jckDistribuidora.setEnabled(false);
        ativaFuncionario(false);
        ativaDistribuidora(false);

        ArrayList<JTextField> campos = new ArrayList<>();
        campos.add(jtfCpf_NomeFantasia);
        campos.add(jtfRg_CNPJ);
        campos.add(jtfCodigoPessoa);
        campos.add(jtfCep);
        campos.add(jtfBairro);
        campos.add(jtfNumero);
        campos.add(jtfNome_RazaoSoc);
        campos.add(jtfLogradouro);
        campos.add(jtfDataNasc);
        campos.add(jtfComplemento);
        campos.add(jtfDDD);
        campos.add(jtfNumeroTel);
        campos.add(jtfEmail);
        campos.add(jtfMidiaSocial);
        tratarEventos.setCampos(campos);
        jtbDistCidadesAtua.setCellSelectionEnabled(true);
        jtbEmails.setCellSelectionEnabled(true);
        jtbEndereco.setCellSelectionEnabled(true);
        jtbMidias.setCellSelectionEnabled(true);
        jtbTelefones.setCellSelectionEnabled(true);
    }

    private void inicializaCamposBuscar() {
        jtfDistFuncTrabNome.setText("Busque uma Distribuidora");
        jtfDistFuncionarioTrabCod.setText("");
        jtfCidadeCodigo.setText("");
        jtfCidadeNome.setText("Busque uma Cidade");
    }

    private void ativaGravar(boolean ativar) {
        tratarEventos.ativaGravar(ativar);
        ((DefaultTableModel) jtbMidias.getModel()).setRowCount(0);
        ((DefaultTableModel) jtbEmails.getModel()).setRowCount(0);
        ((DefaultTableModel) jtbEndereco.getModel()).setRowCount(0);
        ((DefaultTableModel) jtbTelefones.getModel()).setRowCount(0);
        ((DefaultTableModel) jtbDistCidadesAtua.getModel()).setRowCount(0);
        jbAddEmail.setEnabled(ativar);
        jbAddEndereco.setEnabled(ativar);
        jbAddMidia.setEnabled(ativar);
        jbAddTelefone.setEnabled(ativar);
        jbBuscarCidadeEndereco.setEnabled(ativar);
        jbBuscarDistrFunc.setEnabled(ativar);
        jbRemoveMidia.setEnabled(ativar);
        jbRemoverEmail.setEnabled(ativar);
        jbRemoverEndereco.setEnabled(ativar);
        jbFiltrarCidadeAtuacao.setEnabled(ativar);
        jbRemoverTelefone.setEnabled(ativar);
        jrbFisica.setEnabled(ativar);
        jrbFisica.setSelected(true);
        jrbJuridica.setEnabled(ativar);
        jckCliente.setEnabled(ativar);
        jckFuncionario.setEnabled(ativar);
        jrbMasculino.setEnabled(ativar);
        jrbFeminino.setEnabled(ativar);
        jcbTiposEndereco.setEnabled(ativar);
        if (ativar) {
            jckDistribuidora.setEnabled(!ativar);
        } else {
            jckDistribuidora.setEnabled(ativar);
        }
        jckCliente.setSelected(ativar);
        inicializaCamposBuscar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sexo = new javax.swing.ButtonGroup();
        Pessoa = new javax.swing.ButtonGroup();
        Main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        LNome = new javax.swing.JLabel();
        jtfNome_RazaoSoc = new javax.swing.JTextField();
        LCPF = new javax.swing.JLabel();
        LRG = new javax.swing.JLabel();
        jtfCpf_NomeFantasia = new javax.swing.JTextField();
        jtfRg_CNPJ = new javax.swing.JTextField();
        JFisica = new javax.swing.JPanel();
        LData = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
        jtfDataNasc = new javax.swing.JFormattedTextField();
        jpFuncLocalTrab = new javax.swing.JPanel();
        jtfDistFuncionarioTrabCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfDistFuncTrabNome = new javax.swing.JTextField();
        jbBuscarDistrFunc = new javax.swing.JButton();
        jpDistribuidora = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbDistCidadesAtua = new javax.swing.JTable();
        jbFiltrarCidadeAtuacao = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jckCliente = new javax.swing.JCheckBox();
        jckDistribuidora = new javax.swing.JCheckBox();
        jckFuncionario = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jrbFisica = new javax.swing.JRadioButton();
        jrbJuridica = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jtpMidias = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jtfLogradouro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtfCep = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jbAddEndereco = new javax.swing.JButton();
        jbRemoverEndereco = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbEndereco = new javax.swing.JTable();
        jtfCidadeCodigo = new javax.swing.JTextField();
        jtfCidadeNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbBuscarCidadeEndereco = new javax.swing.JButton();
        jcbTiposEndereco = new javax.swing.JComboBox<>();
        jtfComplemento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jpAddTelefone = new javax.swing.JPanel();
        jbAddTelefone = new javax.swing.JButton();
        jbRemoverTelefone = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbTelefones = new javax.swing.JTable();
        jtfDDD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNumeroTel = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jbAddEmail = new javax.swing.JButton();
        jbRemoverEmail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbEmails = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jbAddMidia = new javax.swing.JButton();
        jbRemoveMidia = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbMidias = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jtfMidiaSocial = new javax.swing.JTextField();
        jtfCodigoPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbIncluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbExluir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de pessoa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.white, null), "Informações"));

        LNome.setText("Nome");

        jtfNome_RazaoSoc.setEnabled(false);
        jtfNome_RazaoSoc.setName("jtfNome_RazaoSoc"); // NOI18N

        LCPF.setText("CPF");

        LRG.setText("RG");

        jtfCpf_NomeFantasia.setEnabled(false);
        jtfCpf_NomeFantasia.setName("jtfCpf_NomeFantasia"); // NOI18N

        jtfRg_CNPJ.setEnabled(false);
        jtfRg_CNPJ.setName("jtfRg_CNPJ"); // NOI18N

        JFisica.setBackground(new java.awt.Color(255, 255, 255));
        JFisica.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.lightGray, null), "Nascimento/Sexo"));
        JFisica.setPreferredSize(new java.awt.Dimension(387, 75));

        LData.setText("Data Nascimento");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        jrbMasculino.setBackground(new java.awt.Color(255, 255, 255));
        Sexo.add(jrbMasculino);
        jrbMasculino.setSelected(true);
        jrbMasculino.setText("Masculino");
        jrbMasculino.setEnabled(false);
        jrbMasculino.setName("Sexo"); // NOI18N

        jrbFeminino.setBackground(new java.awt.Color(255, 255, 255));
        Sexo.add(jrbFeminino);
        jrbFeminino.setText("Feminino");
        jrbFeminino.setEnabled(false);
        jrbFeminino.setName("Sexo"); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jrbMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbFeminino)
                .addGap(117, 117, 117))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrbMasculino)
                .addComponent(jrbFeminino))
        );

        jtfDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jtfDataNasc.setEnabled(false);

        javax.swing.GroupLayout JFisicaLayout = new javax.swing.GroupLayout(JFisica);
        JFisica.setLayout(JFisicaLayout);
        JFisicaLayout.setHorizontalGroup(
            JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFisicaLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(LData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JFisicaLayout.setVerticalGroup(
            JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFisicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LData)
                    .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(JFisicaLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            jtfDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));

        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jpFuncLocalTrab.setBackground(new java.awt.Color(255, 255, 255));
        jpFuncLocalTrab.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.lightGray, null), "Local De Trabalho"));

        jtfDistFuncionarioTrabCod.setEnabled(false);

        jLabel4.setText("Codigo");

        jtfDistFuncTrabNome.setText("Busque uma Distribuidora");
        jtfDistFuncTrabNome.setEnabled(false);

        jbBuscarDistrFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscarDistrFunc.setEnabled(false);
        jbBuscarDistrFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarDistrFuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFuncLocalTrabLayout = new javax.swing.GroupLayout(jpFuncLocalTrab);
        jpFuncLocalTrab.setLayout(jpFuncLocalTrabLayout);
        jpFuncLocalTrabLayout.setHorizontalGroup(
            jpFuncLocalTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncLocalTrabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpFuncLocalTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jpFuncLocalTrabLayout.createSequentialGroup()
                        .addComponent(jtfDistFuncionarioTrabCod, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfDistFuncTrabNome, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jbBuscarDistrFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFuncLocalTrabLayout.setVerticalGroup(
            jpFuncLocalTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncLocalTrabLayout.createSequentialGroup()
                .addGroup(jpFuncLocalTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbBuscarDistrFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFuncLocalTrabLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFuncLocalTrabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDistFuncionarioTrabCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDistFuncTrabNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        jpDistribuidora.setBackground(new java.awt.Color(255, 255, 255));
        jpDistribuidora.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.lightGray, null), "Cidades Atuação"));

        jtbDistCidadesAtua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nome", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDistCidadesAtua.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jtbDistCidadesAtua);
        if (jtbDistCidadesAtua.getColumnModel().getColumnCount() > 0) {
            jtbDistCidadesAtua.getColumnModel().getColumn(0).setResizable(false);
            jtbDistCidadesAtua.getColumnModel().getColumn(1).setResizable(false);
            jtbDistCidadesAtua.getColumnModel().getColumn(2).setResizable(false);
        }

        jbFiltrarCidadeAtuacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/funnel.png"))); // NOI18N
        jbFiltrarCidadeAtuacao.setText("Filtrar");
        jbFiltrarCidadeAtuacao.setEnabled(false);

        javax.swing.GroupLayout jpDistribuidoraLayout = new javax.swing.GroupLayout(jpDistribuidora);
        jpDistribuidora.setLayout(jpDistribuidoraLayout);
        jpDistribuidoraLayout.setHorizontalGroup(
            jpDistribuidoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jpDistribuidoraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbFiltrarCidadeAtuacao))
        );
        jpDistribuidoraLayout.setVerticalGroup(
            jpDistribuidoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDistribuidoraLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbFiltrarCidadeAtuacao))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.lightGray, null), "Natureza/Tipo"));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));

        jckCliente.setBackground(new java.awt.Color(255, 255, 255));
        jckCliente.setText("Cliente");
        jckCliente.setEnabled(false);
        jckCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckClienteActionPerformed(evt);
            }
        });

        jckDistribuidora.setBackground(new java.awt.Color(255, 255, 255));
        jckDistribuidora.setText("Distribuidora");
        jckDistribuidora.setEnabled(false);
        jckDistribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckDistribuidoraActionPerformed(evt);
            }
        });

        jckFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        jckFuncionario.setText("Funcionário");
        jckFuncionario.setEnabled(false);
        jckFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jckCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jckDistribuidora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jckFuncionario))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jckCliente)
                    .addComponent(jckDistribuidora)
                    .addComponent(jckFuncionario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Natureza"));

        jrbFisica.setBackground(new java.awt.Color(255, 255, 255));
        Pessoa.add(jrbFisica);
        jrbFisica.setSelected(true);
        jrbFisica.setText("Fisica");
        jrbFisica.setEnabled(false);
        jrbFisica.setName("Tipo de Pessoa"); // NOI18N
        jrbFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFisicaActionPerformed(evt);
            }
        });

        jrbJuridica.setBackground(new java.awt.Color(255, 255, 255));
        Pessoa.add(jrbJuridica);
        jrbJuridica.setText("Juridica");
        jrbJuridica.setEnabled(false);
        jrbJuridica.setName("Tipo de Pessoa"); // NOI18N
        jrbJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbJuridicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbFisica)
                    .addComponent(jrbJuridica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jrbFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbJuridica))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LCPF)
                            .addComponent(jtfCpf_NomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LRG)
                            .addComponent(jtfRg_CNPJ)))
                    .addComponent(LNome)
                    .addComponent(jtfNome_RazaoSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpFuncLocalTrab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JFisica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jpDistribuidora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome_RazaoSoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LCPF)
                            .addComponent(LRG))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCpf_NomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfRg_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jpFuncLocalTrab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpDistribuidora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.darkGray, null), "Contato"));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Logradouro(Rua)");

        jtfLogradouro.setEnabled(false);
        jtfLogradouro.setName("Logradouro"); // NOI18N

        jLabel13.setText("Nº:");

        jtfNumero.setEnabled(false);
        jtfNumero.setName("Numero de Endereço"); // NOI18N

        jtfBairro.setEnabled(false);
        jtfBairro.setName("Bairro"); // NOI18N

        jLabel14.setText("Bairro:");

        jLabel15.setText("Tipo:");

        jLabel16.setText("Cep:");

        jtfCep.setEnabled(false);
        jtfCep.setName("CEP"); // NOI18N
        jtfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCepActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jbAddEndereco.setText("Adicionar Endereço");
        jbAddEndereco.setEnabled(false);
        jbAddEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel15.add(jbAddEndereco);

        jbRemoverEndereco.setText("Remover");
        jbRemoverEndereco.setEnabled(false);
        jbRemoverEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel15.add(jbRemoverEndereco);

        jtbEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Logradouro", "Bairro", "CEP", "Número", "Comp", "Tipo", "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEndereco.setName("Listagem de Endereços"); // NOI18N
        jtbEndereco.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtbEndereco);
        if (jtbEndereco.getColumnModel().getColumnCount() > 0) {
            jtbEndereco.getColumnModel().getColumn(0).setResizable(false);
            jtbEndereco.getColumnModel().getColumn(1).setResizable(false);
            jtbEndereco.getColumnModel().getColumn(2).setResizable(false);
            jtbEndereco.getColumnModel().getColumn(3).setResizable(false);
            jtbEndereco.getColumnModel().getColumn(4).setResizable(false);
            jtbEndereco.getColumnModel().getColumn(5).setResizable(false);
            jtbEndereco.getColumnModel().getColumn(6).setResizable(false);
        }

        jtfCidadeCodigo.setEnabled(false);
        jtfCidadeCodigo.setName("Cidade"); // NOI18N

        jtfCidadeNome.setText("Busque uma Cidade");
        jtfCidadeNome.setEnabled(false);

        jLabel1.setText("Cidade:");

        jbBuscarCidadeEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscarCidadeEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarCidadeEnderecoActionPerformed(evt);
            }
        });

        jcbTiposEndereco.setEnabled(false);

        jtfComplemento.setEnabled(false);
        jtfComplemento.setName(""); // NOI18N

        jLabel2.setText("Complemento");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbTiposEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jtfCidadeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfCidadeNome, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbBuscarCidadeEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel16)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jcbTiposEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbBuscarCidadeEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jtfCidadeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfCidadeNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(43, 43, 43)))))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        jtpMidias.addTab("Endereços", jPanel16);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jpAddTelefone.setBackground(new java.awt.Color(255, 255, 255));

        jbAddTelefone.setText("Adicionar Telefone");
        jbAddTelefone.setEnabled(false);
        jbAddTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddTelefoneActionPerformed(evt);
            }
        });
        jpAddTelefone.add(jbAddTelefone);

        jbRemoverTelefone.setText("Remover");
        jbRemoverTelefone.setEnabled(false);
        jbRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverTelefoneActionPerformed(evt);
            }
        });
        jpAddTelefone.add(jbRemoverTelefone);

        jtbTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DDD", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbTelefones.setName("Telefones"); // NOI18N
        jtbTelefones.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtbTelefones);

        jtfDDD.setEnabled(false);
        jtfDDD.setName("DDD"); // NOI18N

        jLabel5.setText("DDD:");

        jtfNumeroTel.setEnabled(false);
        jtfNumeroTel.setName("Telefone"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNumeroTel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtfNumeroTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpAddTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jtpMidias.addTab("Telefones", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jbAddEmail.setText("Adicionar Email");
        jbAddEmail.setEnabled(false);
        jbAddEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddEmailActionPerformed(evt);
            }
        });
        jPanel9.add(jbAddEmail);

        jbRemoverEmail.setText("Remover");
        jbRemoverEmail.setEnabled(false);
        jbRemoverEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverEmailActionPerformed(evt);
            }
        });
        jPanel9.add(jbRemoverEmail);

        jtbEmails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbEmails.setToolTipText("");
        jtbEmails.setName("Email"); // NOI18N
        jtbEmails.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtbEmails);

        jLabel6.setText("Email:");

        jtfEmail.setEnabled(false);
        jtfEmail.setName("Email"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jtpMidias.addTab("Email's", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jbAddMidia.setText("Adicionar Midia");
        jbAddMidia.setEnabled(false);
        jbAddMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddMidiaActionPerformed(evt);
            }
        });
        jPanel11.add(jbAddMidia);

        jbRemoveMidia.setText("Remover");
        jbRemoveMidia.setEnabled(false);
        jbRemoveMidia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveMidiaActionPerformed(evt);
            }
        });
        jPanel11.add(jbRemoveMidia);

        jtbMidias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Midia Social"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbMidias.setName("Midias Sociais"); // NOI18N
        jtbMidias.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtbMidias);

        jLabel7.setText("Midia:");

        jtfMidiaSocial.setEnabled(false);
        jtfMidiaSocial.setName("Midia"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfMidiaSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(494, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jtfMidiaSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jtpMidias.addTab("Midias Sociais", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpMidias))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMidias, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jtfCodigoPessoa.setName("Codigo da Pessoa"); // NOI18N

        jLabel3.setText("Codigo:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jbIncluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jbIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/IncluirIcon.png"))); // NOI18N
        jbIncluir.setText("Incluir");
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });
        jPanel3.add(jbIncluir);

        jbGravar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/SaveIcon.png"))); // NOI18N
        jbGravar.setText("Gravar");
        jbGravar.setEnabled(false);
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });
        jPanel3.add(jbGravar);

        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/CancelIcon.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(jbCancelar);

        jbExluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/trash.png"))); // NOI18N
        jbExluir.setText("Excluir");
        jbExluir.setEnabled(false);
        jbExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExluirActionPerformed(evt);
            }
        });
        jPanel3.add(jbExluir);

        jbConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });
        jPanel3.add(jbConsultar);

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(Main, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            //TCheckCadastrarEmitente.stop();
            Helper.CloseDialog(this, windowsBack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void ativaDistribuidora(boolean ativar) {
        jpDistribuidora.setVisible(ativar);
        jckDistribuidora.setEnabled(ativar);
    }

    private void ativaFuncionario(boolean ativar) {
        jpFuncLocalTrab.setVisible(ativar);
        jckFuncionario.setEnabled(ativar);
    }

    private void ativaCliente(boolean ativar) {
        jckCliente.setEnabled(ativar);
    }
    private void jrbFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFisicaActionPerformed
        // TODO add your handling code here:
        if (jrbFisica.isSelected()) {
            ativaCliente(true);
            jckCliente.setSelected(true);
            jckFuncionario.setEnabled(true);
            ativaDistribuidora(false);
            jckDistribuidora.setSelected(false);
            LNome.setText("Nome");
            LCPF.setText("CPF");
            LRG.setText("RG");
            JFisica.setVisible(true);

            jtfNome_RazaoSoc.setText("");
            jtfCpf_NomeFantasia.setText("");
            jtfRg_CNPJ.setText("");
            jtfCep.setText("");
            jtfDataNasc.setText("");
        }
    }//GEN-LAST:event_jrbFisicaActionPerformed

    private void jrbJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbJuridicaActionPerformed
        // TODO add your handling code here:
        if (jrbJuridica.isSelected()) {
            ativaCliente(true);
            ativaFuncionario(false);
            jckDistribuidora.setEnabled(true);
            jckFuncionario.setSelected(false);
            jckCliente.setSelected(true);
            LNome.setText("Razão Social");
            LCPF.setText("Nome Fantasia");
            LRG.setText("CNPJ");
            JFisica.setVisible(false);

            jtfNome_RazaoSoc.setText("");
            jtfCpf_NomeFantasia.setText("");
            jtfRg_CNPJ.setText("");
            //jtfCep.setText("");
        }

    }//GEN-LAST:event_jrbJuridicaActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        // TODO add your handling code here:
        try {
            JSONObject json;
            if(jrbFisica.isSelected())
                json = new Controller.PessoaFisicaController().Get(Integer.parseInt(Util.Validacao.InputToString(jtfCodigoPessoa)));
            else
                json = new Controller.PessoaJuridicaController().Get(Integer.parseInt(Util.Validacao.InputToString(jtfCodigoPessoa)));
            
            if(json == null)
                JOptionPane.showMessageDialog(rootPane, "Pessoa não encontrada!");
        } catch (Error ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jbExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbExluirActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        ativaGravar(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        ativaGravar(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbEndereco.getModel();
        try {
            Util.Validacao.InputToString(jtfLogradouro);
            Util.Validacao.InputToString(jtfBairro);
            Util.Validacao.InputToString(jtfCep);
            Util.Validacao.InputToString(jtfNumero);
            Util.Validacao.InputToString(jtfCidadeCodigo);
            Util.Validacao.InputToString(jtfComplemento);

            modelo.addRow(
                    new Object[]{
                        jtfLogradouro.getText(),
                        jtfBairro.getText(),
                        jtfCep.getText(),
                        jtfNumero.getText(),
                        jtfComplemento.getText(),
                        jcbTiposEndereco.getSelectedItem().toString(),
                        jtfCidadeNome.getText(),});

            jtbEndereco.setModel(modelo);

        } catch (Error ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbAddEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddEmailActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbEmails.getModel();
        try {
            Util.Validacao.InputToString(jtfEmail);
            modelo.addRow(new Object[]{
                        jtfEmail.getText()
            });
            jtbEmails.setModel(modelo);
        } catch (Error ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAddEmailActionPerformed

    private void jtfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCepActionPerformed

    private void jckFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckFuncionarioActionPerformed
        ativaCliente(!jckFuncionario.isSelected());
        jckCliente.setSelected(!jckFuncionario.isSelected());
        ativaDistribuidora(!jckFuncionario.isSelected() && jrbJuridica.isSelected());
        ativaFuncionario(jckFuncionario.isSelected());
    }//GEN-LAST:event_jckFuncionarioActionPerformed

    private void jckDistribuidoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckDistribuidoraActionPerformed
        ativaCliente(!jckDistribuidora.isSelected());
        ativaFuncionario(false);
        ativaDistribuidora(jckDistribuidora.isSelected());
        jckCliente.setSelected(!jckDistribuidora.isSelected());
    }//GEN-LAST:event_jckDistribuidoraActionPerformed

    private void jckClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckClienteActionPerformed
        ativaFuncionario(!jckCliente.isSelected() && jrbFisica.isSelected());
        ativaDistribuidora(!jckCliente.isSelected() && jrbJuridica.isSelected());
        jckDistribuidora.setSelected(!jckCliente.isSelected() && jrbJuridica.isSelected());
        jckFuncionario.setSelected(!jckCliente.isSelected() && jrbFisica.isSelected());
    }//GEN-LAST:event_jckClienteActionPerformed

    private void jbBuscarCidadeEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarCidadeEnderecoActionPerformed
        Helper.ShowDialog(this, new FreteBuscarCidade(this, jtfCidadeNome, jtfCidadeCodigo, enderCidadeID));
    }//GEN-LAST:event_jbBuscarCidadeEnderecoActionPerformed

    private void jbAddTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddTelefoneActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbTelefones.getModel();
        try {
            Util.Validacao.InputToString(jtfDDD);
            Util.Validacao.InputToString(jtfNumeroTel);
            modelo.addRow(new Object[]{
                        jtfDDD.getText(),
                        jtfNumeroTel.getText()
            });
            jtbTelefones.setModel(modelo);
        } catch (Error ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAddTelefoneActionPerformed

    private void jbRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverTelefoneActionPerformed
        removeLinhaSelecionada(jtbTelefones);
    }//GEN-LAST:event_jbRemoverTelefoneActionPerformed

    private void jbRemoverEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverEmailActionPerformed
        removeLinhaSelecionada(jtbEmails);
    }//GEN-LAST:event_jbRemoverEmailActionPerformed

    private void jbAddMidiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddMidiaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jtbMidias.getModel();
        try {
            Util.Validacao.InputToString(jtfMidiaSocial);
            modelo.addRow(new Object[]{
                        jtfMidiaSocial.getText()
            });
            jtbMidias.setModel(modelo);
        } catch (Error ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAddMidiaActionPerformed

    private void jbRemoveMidiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveMidiaActionPerformed
        removeLinhaSelecionada(jtbMidias);
    }//GEN-LAST:event_jbRemoveMidiaActionPerformed

    private void jbBuscarDistrFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDistrFuncActionPerformed
        Helper.ShowDialog(this, new BuscaDistribuidora(this, jtfDistFuncTrabNome, jtfDistFuncionarioTrabCod, distibuidoraID));
    }//GEN-LAST:event_jbBuscarDistrFuncActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
           
        boolean exito =  false;
        try {
            // TODO add your handling code here:            
            JSONObject jsonPersistencia = new JSONObject();
            JSONArray jsonArrayAux;
            JSONObject jsonAux;
            /*DADOS PRINCIPAIS*/
            if (jrbFisica.isSelected()) {
                jsonPersistencia.put("nome", Util.Validacao.InputToString(jtfNome_RazaoSoc));
                jsonPersistencia.put("cpf", Util.Validacao.InputToString(jtfCpf_NomeFantasia));
                jsonPersistencia.put("rg", Util.Validacao.InputToString(jtfRg_CNPJ));
                jsonPersistencia.put("dataNascimento", Util.Validacao.InputToString(jtfDataNasc));
                jsonPersistencia.put("sexo", Util.Validacao.freteRadioButtonSelected(Sexo));
                jsonPersistencia.put("naturezaPessoa", Util.Enums.NaturezaPessoa.Fisica);
                if (jckFuncionario.isSelected()) {
                    jsonPersistencia.put("localTrabalho", jtfDistFuncionarioTrabCod.getText());
                    jsonPersistencia.put("tipoPessoa", Util.Enums.TipoPessoa.Funcionario);
                } else {
                    jsonPersistencia.put("tipoPessoa", Util.Enums.TipoPessoa.Cliente);
                }
            } else {
                jsonPersistencia.put("razaoSocial", Util.Validacao.InputToString(jtfNome_RazaoSoc));
                jsonPersistencia.put("nomeFantasia", Util.Validacao.InputToString(jtfCpf_NomeFantasia));
                jsonPersistencia.put("cnpj", Util.Validacao.InputToString(jtfRg_CNPJ));
                jsonPersistencia.put("naturezaPessoa", Util.Enums.NaturezaPessoa.Juridica);
                if (jckDistribuidora.isSelected()) {
                    jsonArrayAux = new JSONArray();
                    for (int i = 0; i < jtbDistCidadesAtua.getRowCount(); i++) {
                        jsonAux = new JSONObject();
                        jsonAux.put("codigo", jtbDistCidadesAtua.getModel().getValueAt(i, 0));
                        jsonArrayAux.put(jsonAux);
                    }
                    jsonPersistencia.put("cidadesAtuacao", jsonArrayAux);
                    jsonPersistencia.put("tipoPessoa", Util.Enums.TipoPessoa.Distribuidora);
                } else {
                    jsonPersistencia.put("tipoPessoa", Util.Enums.TipoPessoa.Cliente);
                }
            }
             /*FIM DADOS PRINCIPAIS*/
           
            /*ENDERECOS*/
             Util.Validacao.itensjTable(jtbEndereco);
            jsonArrayAux = new JSONArray();
            for (int i = 0; i < jtbEndereco.getRowCount(); i++) {
                jsonAux = new JSONObject();
                jsonAux.put("rua", jtbEndereco.getModel().getValueAt(i, 0));
                jsonAux.put("bairro", jtbEndereco.getModel().getValueAt(i, 1));
                jsonAux.put("cep", jtbEndereco.getModel().getValueAt(i, 2));
                jsonAux.put("numero", jtbEndereco.getModel().getValueAt(i, 3));
                if (jtbEndereco.getModel().getValueAt(i, 4) != null) {
                    jsonAux.put("complemento", jtbEndereco.getModel().getValueAt(i, 4));
                }
                if (jtbEndereco.getModel().getValueAt(i, 5).equals(Util.Enums.TipoEndereco.Coleta.toString())) {
                    jsonAux.put("tipo", Util.Enums.TipoEndereco.Coleta);
                } else if (jtbEndereco.getModel().getValueAt(i, 5).equals(Util.Enums.TipoEndereco.Entrega.toString())) {
                    jsonAux.put("tipo", Util.Enums.TipoEndereco.Entrega);
                } else {
                    jsonAux.put("tipo", Util.Enums.TipoEndereco.Principal);
                }

                jsonAux.put("cidade", new JSONObject().put("nome", jtbEndereco.getModel().getValueAt(i, 6)));
                jsonArrayAux.put(jsonAux);
            }
            jsonPersistencia.put("enderecos", jsonArrayAux);
            
             /*FIM ENDERECOS*/
             
             /*EMAILS*/
            jsonArrayAux =  new JSONArray();
            Util.Validacao.itensjTable(jtbEmails);
            for (int i = 0; i < jtbEmails.getRowCount(); i++) {
                jsonArrayAux.put(new JSONObject().put("email", jtbEmails.getModel().getValueAt(i, 0)));
            }
            jsonPersistencia.put("emails", jsonArrayAux);
            
            
            /*FIM EMAILS*/
            
            /*TELEFONES*/
            Util.Validacao.itensjTable(jtbTelefones);
            jsonArrayAux = new JSONArray();
            for (int i = 0; i < jtbTelefones.getRowCount(); i++) {
                jsonAux = new JSONObject();
                jsonAux.put("ddd", jtbTelefones.getModel().getValueAt(i, 0));
                jsonAux.put("numero", jtbTelefones.getModel().getValueAt(i, 1));
                jsonArrayAux.put(jsonAux);
            }
            jsonPersistencia.put("telefones", jsonArrayAux);
            /*FIM TELEFONES*/
            
            
            /*MIDIAS*/
            Util.Validacao.itensjTable(jtbMidias);
            jsonArrayAux = new JSONArray();
            for (int i = 0; i < jtbMidias.getRowCount(); i++) {
                jsonArrayAux.put(new JSONObject().put("descricao", jtbMidias.getModel().getValueAt(i, 0)));
            }
            jsonPersistencia.put("midiasSociais", jsonArrayAux);
            /*FIM MIDIAS*/
            
            if(jrbFisica.isSelected()){
                if(jckCliente.isSelected()){
                    if(new Controller.PessoaFisicaController().Save(jsonPersistencia))
                        exito = true;
                    else
                        JOptionPane.showMessageDialog(rootPane, "Falha ao inserir o Cliente");
                }else{
                    if(new Controller.FuncionarioController().Save(jsonPersistencia))
                        exito = true;
                    else
                       JOptionPane.showMessageDialog(rootPane, "Falha ao inserir o Funcionário");
                }
            }else
                if(jckCliente.isSelected()){
                    if(new Controller.PessoaJuridicaController().Save(jsonPersistencia))
                         exito = true;
                    else
                        JOptionPane.showMessageDialog(rootPane, "Falha ao inserir o Cliente");

                }else{
                    if(new Controller.DistribuidoraController().Save(jsonPersistencia))
                         exito = true;
                    else
                        JOptionPane.showMessageDialog(rootPane, "Falha ao inserir a Distribuidora");
                }
            if(exito){
                JOptionPane.showMessageDialog(null, "Registro Gravado com Sucesso!");
                ativaGravar(false);
            }
        
        } catch (Util.Error ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Verificar os campos", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jbGravarActionPerformed

 
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
            java.util.logging.Logger.getLogger(Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pessoa(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JFisica;
    private javax.swing.JLabel LCPF;
    private javax.swing.JLabel LData;
    private javax.swing.JLabel LNome;
    private javax.swing.JLabel LRG;
    private javax.swing.JPanel Main;
    private javax.swing.ButtonGroup Pessoa;
    private javax.swing.ButtonGroup Sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jbAddEmail;
    private javax.swing.JButton jbAddEndereco;
    private javax.swing.JButton jbAddMidia;
    private javax.swing.JButton jbAddTelefone;
    private javax.swing.JButton jbBuscarCidadeEndereco;
    private javax.swing.JButton jbBuscarDistrFunc;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbExluir;
    private javax.swing.JButton jbFiltrarCidadeAtuacao;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JButton jbRemoveMidia;
    private javax.swing.JButton jbRemoverEmail;
    private javax.swing.JButton jbRemoverEndereco;
    private javax.swing.JButton jbRemoverTelefone;
    private javax.swing.JComboBox<String> jcbTiposEndereco;
    private javax.swing.JCheckBox jckCliente;
    private javax.swing.JCheckBox jckDistribuidora;
    private javax.swing.JCheckBox jckFuncionario;
    private javax.swing.JPanel jpAddTelefone;
    private javax.swing.JPanel jpDistribuidora;
    private javax.swing.JPanel jpFuncLocalTrab;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbFisica;
    private javax.swing.JRadioButton jrbJuridica;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JTable jtbDistCidadesAtua;
    private javax.swing.JTable jtbEmails;
    private javax.swing.JTable jtbEndereco;
    private javax.swing.JTable jtbMidias;
    private javax.swing.JTable jtbTelefones;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCep;
    private javax.swing.JTextField jtfCidadeCodigo;
    private javax.swing.JTextField jtfCidadeNome;
    private javax.swing.JTextField jtfCodigoPessoa;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfCpf_NomeFantasia;
    private javax.swing.JTextField jtfDDD;
    private javax.swing.JFormattedTextField jtfDataNasc;
    private javax.swing.JTextField jtfDistFuncTrabNome;
    private javax.swing.JTextField jtfDistFuncionarioTrabCod;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLogradouro;
    private javax.swing.JTextField jtfMidiaSocial;
    private javax.swing.JTextField jtfNome_RazaoSoc;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfNumeroTel;
    private javax.swing.JTextField jtfRg_CNPJ;
    private javax.swing.JTabbedPane jtpMidias;
    // End of variables declaration//GEN-END:variables
}
