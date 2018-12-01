/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Util.Enums.TipoEndereco;
import Util.Helper;
import Util.TelaHandler;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
public class Pessoa extends javax.swing.JFrame {
    private JFrame windowsBack;
    private final Thread TCheckCadastrarEmitente;
    private final TelaHandler tratarEventos;
    /**
     * Creates new form EncomendaCriarPessoa
     * @param windowsBack
     */
    public Pessoa(JFrame windowsBack) {
        initComponents();
        this.tratarEventos = new TelaHandler(jbIncluir, jbGravar, jbCancelar, jbExluir,jbConsultar);
        
        this.windowsBack = windowsBack;
        
        for (TipoEndereco tipo : Util.Enums.TipoEndereco.values()) {
            jcbTiposEndereco.addItem(tipo.name());
        }
        TCheckCadastrarEmitente = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if(jrbFisica.isSelected()){
                            jbGravar.setEnabled(
                                    !jtfNome_RazaoSoc.getText().isEmpty() &&
                                            !jtfCpf_NomeFantasia.getText().isEmpty() &&
                                            !jtfRg_CNPJ.getText().isEmpty() &&
                                            !jtfDataNasc.getText().isEmpty()
                            );
                        } else
                            jbGravar.setEnabled(
                                    !jtfNome_RazaoSoc.getText().isEmpty() &&
                                            !jtfCpf_NomeFantasia.getText().isEmpty() &&
                                            !jtfRg_CNPJ.getText().isEmpty()
                            );
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            } 
        });
        TCheckCadastrarEmitente.start();
        
        TableColumnModel columnModel = jtbTelefones.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(15);
        columnModel.getColumn(1).setPreferredWidth(300);
        
        columnModel =  jtbDistCidadesAtua.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(15);
        columnModel.getColumn(1).setPreferredWidth(500);
        columnModel.getColumn(2).setPreferredWidth(100);

        jrbFisica.setSelected(true);
        jckDistribuidora.setEnabled(false);
        ativaFuncionario(false);
        ativaDistribuidora(false);
        
        ArrayList<JTextField> campos =  new ArrayList<>();
        campos.add(jtfCpf_NomeFantasia);
        campos.add(jtfRg_CNPJ);
        campos.add(jtfCodigoPessoa);
        campos.add(jtfCep);
        campos.add(jtfBairro);
        campos.add(jtfNumero);
        campos.add(jtfNome_RazaoSoc);
        campos.add(jtfLogradouro);
        campos.add(jtfDataNasc);
        tratarEventos.setCampos(campos);

    }
    private void inicializaBuscaLocalTrab(){
        jtfDistFuncTrabNome.setText("Busque uma Distribuidora");
        jtfDistFuncionarioTrabCod.setText("");
    }
    private void ativaGravar(boolean ativar){
         tratarEventos.ativaGravar(ativar);
        ((DefaultTableModel)jtbMidias.getModel()).setRowCount(0);
        ((DefaultTableModel)jtbEmails.getModel()).setRowCount(0);
        ((DefaultTableModel)jtbEndereco.getModel()).setRowCount(0);
        ((DefaultTableModel)jtbTelefones.getModel()).setRowCount(0);
        ((DefaultTableModel)jtbDistCidadesAtua.getModel()).setRowCount(0);
        jbAddEmail.setEnabled(ativar);
        jbAddEndereco.setEnabled(ativar);
        jbAddMidia.setEnabled(ativar);
        jbAddTelefone.setEnabled(ativar);
        jbBuscarCidade.setEnabled(ativar);
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
        if(ativar)
            jckDistribuidora.setEnabled(!ativar);
         else jckDistribuidora.setEnabled(ativar);
        jckCliente.setSelected(ativar);
        inicializaBuscaLocalTrab();
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
        jtfDataNasc = new javax.swing.JTextField();
        LData = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
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
        jbBuscarCidade = new javax.swing.JButton();
        jcbTiposEndereco = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jpAddTelefone = new javax.swing.JPanel();
        jbAddTelefone = new javax.swing.JButton();
        jbRemoverTelefone = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbTelefones = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jbAddEmail = new javax.swing.JButton();
        jbRemoverEmail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbEmails = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jbAddMidia = new javax.swing.JButton();
        jbRemoveMidia = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbMidias = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbIncluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbExluir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jtfCodigoPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

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
        JFisica.setBorder(javax.swing.BorderFactory.createTitledBorder("Nascimento/Sexo"));
        JFisica.setPreferredSize(new java.awt.Dimension(387, 75));

        jtfDataNasc.setEnabled(false);
        jtfDataNasc.setName("Data Nascimento"); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(jrbFeminino)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMasculino)
                    .addComponent(jrbFeminino))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JFisicaLayout = new javax.swing.GroupLayout(JFisica);
        JFisica.setLayout(JFisicaLayout);
        JFisicaLayout.setHorizontalGroup(
            JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFisicaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JFisicaLayout.setVerticalGroup(
            JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JFisicaLayout.createSequentialGroup()
                .addGroup(JFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JFisicaLayout.createSequentialGroup()
                        .addComponent(LData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpFuncLocalTrab.setBackground(new java.awt.Color(255, 255, 255));
        jpFuncLocalTrab.setBorder(javax.swing.BorderFactory.createTitledBorder("Local De Trabalho"));

        jtfDistFuncionarioTrabCod.setEnabled(false);

        jLabel4.setText("Codigo");

        jtfDistFuncTrabNome.setText("Busque uma Distribuidora");
        jtfDistFuncTrabNome.setEnabled(false);

        jbBuscarDistrFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscarDistrFunc.setEnabled(false);

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
                .addContainerGap(41, Short.MAX_VALUE))
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
        jpDistribuidora.setBorder(javax.swing.BorderFactory.createTitledBorder("Cidades Atuação"));

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
            .addGroup(jpDistribuidoraLayout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jbFiltrarCidadeAtuacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
        );
        jpDistribuidoraLayout.setVerticalGroup(
            jpDistribuidoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDistribuidoraLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFiltrarCidadeAtuacao))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Natureza/Tipo"));

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
                .addContainerGap(56, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpFuncLocalTrab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpDistribuidora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpFuncLocalTrab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpDistribuidora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

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
                "Logradouro", "Número", "Bairro", "CEP", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEndereco.setName("Listagem de Endereços"); // NOI18N
        jScrollPane5.setViewportView(jtbEndereco);

        jtfCidadeCodigo.setEnabled(false);

        jtfCidadeNome.setText("Busque uma Cidade");
        jtfCidadeNome.setEnabled(false);

        jLabel1.setText("Cidade:");

        jbBuscarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N

        jcbTiposEndereco.setEnabled(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel15)
                                                .addGap(8, 8, 8)
                                                .addComponent(jcbTiposEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jtfCidadeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfCidadeNome, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jcbTiposEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBuscarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfCidadeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCidadeNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jtpMidias.addTab("Endereços", jPanel16);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jpAddTelefone.setBackground(new java.awt.Color(255, 255, 255));

        jbAddTelefone.setText("Adicionar Telefone");
        jpAddTelefone.add(jbAddTelefone);

        jbRemoverTelefone.setText("Remover");
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
        jScrollPane3.setViewportView(jtbTelefones);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
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
        jScrollPane2.setViewportView(jtbEmails);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jtpMidias.addTab("Email's", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jbAddMidia.setText("Adicionar Midia");
        jbAddMidia.setEnabled(false);
        jPanel11.add(jbAddMidia);

        jbRemoveMidia.setText("Remover");
        jbRemoveMidia.setEnabled(false);
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
        jScrollPane4.setViewportView(jtbMidias);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtpMidias.addTab("Midias Sociais", jPanel7);

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

        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/SaveIcon.png"))); // NOI18N
        jbGravar.setText("Gravar");
        jbGravar.setEnabled(false);
        jbGravar.setMinimumSize(new java.awt.Dimension(101, 27));
        jbGravar.setPreferredSize(new java.awt.Dimension(101, 27));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpMidias)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jtpMidias, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("Codigo:");

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0))))
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
                .addGap(0, 0, 0))
        );

        getContentPane().add(Main, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            TCheckCadastrarEmitente.stop();
            Helper.CloseDialog(this, windowsBack);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing
    
    private void ativaDistribuidora(boolean ativar){
        jpDistribuidora.setVisible(ativar);
        jckDistribuidora.setEnabled(ativar);
    }
    private void ativaFuncionario(boolean ativar){
        jpFuncLocalTrab.setVisible(ativar);
        jckFuncionario.setEnabled(ativar);
    }
    private void ativaCliente(boolean ativar){
        jckCliente.setEnabled(ativar);
    }
    private void jrbFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFisicaActionPerformed
        // TODO add your handling code here:
        if(jrbFisica.isSelected()){
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
        if(jrbJuridica.isSelected()){
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
            jtfCep.setText("");    
        }

    }//GEN-LAST:event_jrbJuridicaActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jbExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbExluirActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        ativaGravar(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        try {
            // TODO add your handling code here:            
            JSONObject jsonPersistencia = new JSONObject();
            JSONArray jsonArrayAux;
            JSONObject jsonAux;
            
            if(jrbFisica.isSelected()){
                jsonPersistencia.put("nome", Util.Validacao.InputToString(jtfNome_RazaoSoc));
                jsonPersistencia.put("cpf", Util.Validacao.InputToString(jtfCpf_NomeFantasia));
                jsonPersistencia.put("rg", Util.Validacao.InputToString(jtfRg_CNPJ));
                jsonPersistencia.put("dataNascimento", Util.Validacao.InputToString(jtfDataNasc));
                jsonPersistencia.put("sexo", Util.Validacao.freteRadioButtonSelected(Sexo));
                jsonPersistencia.put("naturezaPessoa", Util.Enums.NaturezaPessoa.Fisica);
                if(jckFuncionario.isSelected()){
                    jsonPersistencia.put("localTrabalho", jtfDistFuncionarioTrabCod.getText());
                    if(jckCliente.isSelected()){
                        jsonAux =  new JSONObject();
                        jsonAux.put("Entidade1", Util.Enums.TipoPessoa.Cliente);
                        jsonAux.put("Entidade2", Util.Enums.TipoPessoa.Funcionario);
                        jsonPersistencia.put("entidadesPersistir",jsonAux);
                    }
                }
            } else {
                jsonPersistencia.put("razaoSocial", Util.Validacao.InputToString(jtfNome_RazaoSoc));
                jsonPersistencia.put("nomeFantasia", Util.Validacao.InputToString(jtfCpf_NomeFantasia));
                jsonPersistencia.put("cnpj", Util.Validacao.InputToString(jtfRg_CNPJ));
                jsonPersistencia.put("naturezaPessoa", Util.Enums.NaturezaPessoa.Juridica);
            }
            
            
            jsonPersistencia.put("Endereco", Util.Helper.GetArrayToJTable(jtbEndereco));
            jsonPersistencia.put("Email", Util.Helper.GetArrayToJTable(jtbEmails));
            jsonPersistencia.put("Telefone", Util.Helper.GetArrayToJTable(jtbTelefones));
            jsonPersistencia.put("Midia", Util.Helper.GetArrayToJTable(jtbMidias));
            
            
           /* if(jrbFisica.isSelected())
                if(new Controller.PessoaFisicaController().Save(json))
                    Helper.CloseDialog(this, windowsBack);
                else
                    JOptionPane.showMessageDialog(rootPane, "Falha ao inserir Pessoa Fisica");
            else
                if(new Controller.PessoaJuridicaController().Save(json))
                    Helper.CloseDialog(this, windowsBack);
                else
                    JOptionPane.showMessageDialog(rootPane, "Falha ao inserir o Pessoa Juridica");*/
        } catch (Util.Error ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Verificar os campos", JOptionPane.WARNING_MESSAGE);
        }
        
        ativaGravar(false);
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        ativaGravar(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbAddEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddEmailActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JTextField Bairro;
    private javax.swing.JTextField CEP;
    private javax.swing.JComboBox<String> CTipoEndereco;
    private javax.swing.JPanel JFisica;
    private javax.swing.JTable JTEndereco;
    private javax.swing.JLabel LCPF;
    private javax.swing.JLabel LData;
    private javax.swing.JLabel LNome;
    private javax.swing.JLabel LRG;
    private javax.swing.JTextField Logradouro;
    private javax.swing.JPanel Main;
    private javax.swing.JTextField NumeroEndereco;
    private javax.swing.ButtonGroup Pessoa;
    private javax.swing.ButtonGroup Sexo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAddEmail;
    private javax.swing.JButton jbAddEndereco;
    private javax.swing.JButton jbAddMidia;
    private javax.swing.JButton jbAddTelefone;
    private javax.swing.JButton jbBuscarCidade;
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
    private javax.swing.JTextField jtfCpf_NomeFantasia;
    private javax.swing.JTextField jtfDataNasc;
    private javax.swing.JTextField jtfDistFuncTrabNome;
    private javax.swing.JTextField jtfDistFuncionarioTrabCod;
    private javax.swing.JTextField jtfLogradouro;
    private javax.swing.JTextField jtfNome_RazaoSoc;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRg_CNPJ;
    private javax.swing.JTabbedPane jtpMidias;
    // End of variables declaration//GEN-END:variables
}
