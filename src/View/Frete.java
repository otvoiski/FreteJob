/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EncomendaController;
import Controller.FreteController;
import Util.Error;
import Util.Helper;
import Util.TelaHandler;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import org.json.JSONObject;
import java.util.List;
import javax.swing.JTable;
import org.json.JSONArray;

/**
 *
 * @author Otavio
 */
public class Frete extends javax.swing.JFrame {
    private final TelaHandler tratarEventos;
    private JFrame backWindows;
    private HashMap<String, Integer> distsAtendCidadeSaida;
    private HashMap<String, Integer> distsAtendCidadeDestino;
    private int funcionarioID;
    private int cidadeOrigemID;
    private int cidadeDestinoID;
    private int veiculoID;
    private boolean RealizarFrete;
    
    /**
     * Creates new form Frete
     * @param backWindows
     */
    public Frete(JFrame backWindows) {
        initComponents();
        this.backWindows = backWindows;
        this.tratarEventos = new TelaHandler(jbIncluir, jbGravar, jbCancelar, jbExluir,jbConsultar);
        Init();
    }
    private void ativaGravar(boolean ativa){
        tratarEventos.ativaGravar(ativa);
        inicializaCadastro(ativa);
        limparTabela(jtbEncomendas);
        limparTabela(jtbFuncionariosResp);
        zeraConteudoCombos();
    }
    private void inicializaCadastro(boolean iniciar){
        jbBuscaCidadeDestino.setEnabled(iniciar);
        jbBuscaCidadeOrigem.setEnabled(iniciar);
        jbBuscarFuncionario.setEnabled(iniciar);
        jbFiltrarEncomendas.setEnabled(iniciar);
        jbCarregarDistribuidoras.setEnabled(iniciar);
        jbLimparFuncionarios.setEnabled(iniciar);
        jtfCidadeDestinoCod.setText("");
        jtfCidadeDestinoNome.setText("Busque uma cidade");
        jtfCidadeOrigemCod.setText("");
        jtfCidadeOrigemNome.setText("Busque uma cidade");
        jtfVeiculoCapacidade.setText("");
        jtfVeiculoCodigo.setText("");
        jtfVeiculoPlaca.setText("");
        jftDataFinal.setText("");
        jftDataInicial.setText("");
    }
    private void PreencheComboBox(List<JSONObject> list, JComboBox combo, String name){
        list.forEach((j) -> {
            combo.addItem(j.get(name));
        });
    }
    private void zeraConteudoCombos(){
        jcbDistribuidoraDestino.removeAllItems();
        jcbDistribuidoraSaida.removeAllItems();
    }
    private void limparTabela(JTable tabela){
        ((DefaultTableModel)tabela.getModel()).setRowCount(0);
    }
    private void initCombosDistribuidoras(){
        List<JSONObject> distSaida = new Controller.DistribuidoraController().GetByCidadeAtende(jtfCidadeOrigemCod.getText());
        List<JSONObject> distDestino = new Controller.DistribuidoraController().GetByCidadeAtende(jtfCidadeDestinoCod.getText());
        distSaida.forEach((j) -> {
            distsAtendCidadeSaida.put(j.getString("razaoSocial"),j.getInt("codigo"));
        });
        
        distDestino.forEach((j) -> {
            distsAtendCidadeDestino.put(j.getString("razaoSocial"),j.getInt("codigo"));
        });
        PreencheComboBox(distSaida, jcbDistribuidoraSaida,"razaoSocial");
        PreencheComboBox(distDestino, jcbDistribuidoraDestino,"razaoSocial");
    }

    private void Init(){
        distsAtendCidadeSaida = new HashMap<>();
        distsAtendCidadeDestino = new HashMap<>();

        Object[][] rowData = {};
        Object[] columnNames = { "", "#","Emitente","Destinatario","Valor","Origem","Destino"};

        DefaultTableModel model = new DefaultTableModel(rowData, columnNames){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
            }
            @Override
            public boolean isCellEditable(int row, int column) {    
                if (column > 0) return false;   
                return super.isCellEditable(row, column); 
            }
        };  
        jtbEncomendas.setModel(model);
        TableColumnModel columnModelEncomendas = jtbEncomendas.getColumnModel();
        columnModelEncomendas.getColumn(0).setPreferredWidth(15);
        columnModelEncomendas.getColumn(1).setPreferredWidth(80);
        columnModelEncomendas.getColumn(2).setPreferredWidth(250);
        columnModelEncomendas.getColumn(3).setPreferredWidth(250);
        columnModelEncomendas.getColumn(4).setPreferredWidth(110);
        columnModelEncomendas.getColumn(5).setPreferredWidth(160);
        columnModelEncomendas.getColumn(6).setPreferredWidth(160);
        
        TableColumnModel columnModelFuncionarios =  jtbFuncionariosResp.getColumnModel();
        columnModelFuncionarios.getColumn(0).setPreferredWidth(15);
        columnModelFuncionarios.getColumn(1).setPreferredWidth(250);
        columnModelFuncionarios.getColumn(2).setPreferredWidth(200);
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfCidadeOrigemNome = new javax.swing.JTextField();
        jbBuscaCidadeOrigem = new javax.swing.JButton();
        jtfCidadeDestinoNome = new javax.swing.JTextField();
        jbBuscaCidadeDestino = new javax.swing.JButton();
        jtfCidadeOrigemCod = new javax.swing.JTextField();
        jtfCidadeDestinoCod = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbFuncionariosResp = new javax.swing.JTable();
        jbBuscarFuncionario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbLimparFuncionarios = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEncomendas = new javax.swing.JTable();
        jbFiltrarEncomendas = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jftDataFinal = new javax.swing.JFormattedTextField();
        jftDataInicial = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        totalFreteCalculado = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kilometragem = new javax.swing.JLabel();
        valorPorPeso = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jcbDistribuidoraSaida = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbDistribuidoraDestino = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jtfVeiculoCodigo = new javax.swing.JTextField();
        jtfVeiculoCapacidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbBuscaVeiculo = new javax.swing.JButton();
        jtfVeiculoPlaca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jbCarregarDistribuidoras = new javax.swing.JButton();
        jbIncluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbExluir = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Frete");
        setMinimumSize(new java.awt.Dimension(1130, 710));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(1130, 710));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 710));
        jPanel1.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.darkGray, null), "Cidades"));

        jLabel1.setText("Origem");

        jLabel2.setText("Destino");

        jtfCidadeOrigemNome.setToolTipText("Cidade");
        jtfCidadeOrigemNome.setEnabled(false);
        jtfCidadeOrigemNome.setName("Origem"); // NOI18N

        jbBuscaCidadeOrigem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscaCidadeOrigem.setEnabled(false);
        jbBuscaCidadeOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaCidadeOrigemActionPerformed(evt);
            }
        });

        jtfCidadeDestinoNome.setToolTipText("Cidade");
        jtfCidadeDestinoNome.setEnabled(false);
        jtfCidadeDestinoNome.setName("Destino"); // NOI18N

        jbBuscaCidadeDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbBuscaCidadeDestino.setEnabled(false);
        jbBuscaCidadeDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaCidadeDestinoActionPerformed(evt);
            }
        });

        jtfCidadeOrigemCod.setEnabled(false);
        jtfCidadeOrigemCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCidadeOrigemCodActionPerformed(evt);
            }
        });

        jtfCidadeDestinoCod.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCidadeDestinoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCidadeDestinoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscaCidadeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(332, 332, 332))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfCidadeOrigemCod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCidadeOrigemNome)
                                .addGap(10, 10, 10)))
                        .addComponent(jbBuscaCidadeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbBuscaCidadeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCidadeOrigemCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCidadeOrigemNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbBuscaCidadeDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jtfCidadeDestinoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCidadeDestinoCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.darkGray, null), "Informação"));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.darkGray, null), "Funcionarios Responsáveis"));

        jtbFuncionariosResp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nome", "Distribuidora"
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
        jtbFuncionariosResp.setName("Funcionarios Responsáveis"); // NOI18N
        jtbFuncionariosResp.getTableHeader().setReorderingAllowed(false);
        jtbFuncionariosResp.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtbFuncionariosRespPropertyChange(evt);
            }
        });
        jtbFuncionariosResp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbFuncionariosRespKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbFuncionariosResp);
        if (jtbFuncionariosResp.getColumnModel().getColumnCount() > 0) {
            jtbFuncionariosResp.getColumnModel().getColumn(0).setResizable(false);
            jtbFuncionariosResp.getColumnModel().getColumn(1).setResizable(false);
            jtbFuncionariosResp.getColumnModel().getColumn(2).setResizable(false);
        }

        jbBuscarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/funnel.png"))); // NOI18N
        jbBuscarFuncionario.setText("Filtrar Funcionários");
        jbBuscarFuncionario.setEnabled(false);
        jbBuscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarFuncionarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Obs: Pressione delete em uma linha selecionada para excluir um funcionário");

        jbLimparFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/wiping-swipe-for-floors.png"))); // NOI18N
        jbLimparFuncionarios.setText("Limpar");
        jbLimparFuncionarios.setEnabled(false);
        jbLimparFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparFuncionariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbLimparFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jbLimparFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.darkGray, null), "Encomendas"));

        jtbEncomendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "*", "#", "Emitente", "Destinatario", "Valor", "Origem", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEncomendas.setName("Encomendas"); // NOI18N
        jtbEncomendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbEncomendas);
        if (jtbEncomendas.getColumnModel().getColumnCount() > 0) {
            jtbEncomendas.getColumnModel().getColumn(0).setResizable(false);
            jtbEncomendas.getColumnModel().getColumn(1).setResizable(false);
            jtbEncomendas.getColumnModel().getColumn(2).setResizable(false);
            jtbEncomendas.getColumnModel().getColumn(3).setResizable(false);
            jtbEncomendas.getColumnModel().getColumn(4).setResizable(false);
            jtbEncomendas.getColumnModel().getColumn(5).setResizable(false);
            jtbEncomendas.getColumnModel().getColumn(6).setResizable(false);
        }

        jbFiltrarEncomendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/funnel.png"))); // NOI18N
        jbFiltrarEncomendas.setText("Filtrar");
        jbFiltrarEncomendas.setEnabled(false);
        jbFiltrarEncomendas.setMaximumSize(new java.awt.Dimension(150, 40));
        jbFiltrarEncomendas.setMinimumSize(new java.awt.Dimension(150, 40));
        jbFiltrarEncomendas.setPreferredSize(new java.awt.Dimension(150, 40));
        jbFiltrarEncomendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarEncomendasActionPerformed(evt);
            }
        });

        jLabel6.setText("Intervalo de:");

        jLabel7.setText("à");

        jftDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jftDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        totalFreteCalculado.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalFreteCalculado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalFreteCalculado.setText("R$ 0,00");

        jLabel11.setText("Distancia a ser percorrida");

        jLabel12.setText("Valor da embalagem");

        kilometragem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kilometragem.setText("0 KM");

        valorPorPeso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        valorPorPeso.setText("R$ 0,00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(kilometragem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(valorPorPeso)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalFreteCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kilometragem))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorPorPeso))
                    .addComponent(totalFreteCalculado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFiltrarEncomendas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jftDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbFiltrarEncomendas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            jftDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));

        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            jftDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));

        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, java.awt.Color.darkGray, null), "Distribuidoras/Veiculo de transporte"));

        jcbDistribuidoraSaida.setName("Distribuidora"); // NOI18N
        jcbDistribuidoraSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDistribuidoraSaidaActionPerformed(evt);
            }
        });

        jLabel3.setText("Saida");

        jLabel5.setText("Destino");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Veículo"));

        jtfVeiculoCodigo.setEnabled(false);

        jtfVeiculoCapacidade.setEnabled(false);

        jLabel8.setText("Codigo");

        jLabel9.setText("Placa");

        jbBuscaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/delivery-truck.png"))); // NOI18N
        jbBuscaVeiculo.setText("Filtrar Veiculo");
        jbBuscaVeiculo.setEnabled(false);
        jbBuscaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaVeiculoActionPerformed(evt);
            }
        });

        jtfVeiculoPlaca.setEnabled(false);

        jLabel10.setText("Capacidade de carga");

        jLabel13.setText("KG");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfVeiculoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jtfVeiculoCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfVeiculoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfVeiculoCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbBuscaVeiculo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbCarregarDistribuidoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/funnel.png"))); // NOI18N
        jbCarregarDistribuidoras.setText("Carregar");
        jbCarregarDistribuidoras.setEnabled(false);
        jbCarregarDistribuidoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCarregarDistribuidorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jcbDistribuidoraDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCarregarDistribuidoras))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jcbDistribuidoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jcbDistribuidoraSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbCarregarDistribuidoras))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbDistribuidoraDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbIncluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jbIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/IncluirIcon.png"))); // NOI18N
        jbIncluir.setText("Incluir");
        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });

        jbGravar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/SaveIcon.png"))); // NOI18N
        jbGravar.setText("Gravar");
        jbGravar.setEnabled(false);
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/CancelIcon.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setEnabled(false);
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbExluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/trash.png"))); // NOI18N
        jbExluir.setText("Excluir");
        jbExluir.setEnabled(false);
        jbExluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExluirActionPerformed(evt);
            }
        });

        jbConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/search.png"))); // NOI18N
        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jbIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Helper.CloseDialog(this, backWindows);
    }//GEN-LAST:event_formWindowClosing

    private void jbBuscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarFuncionarioActionPerformed
        if(jcbDistribuidoraDestino.getItemCount() == 0 && jcbDistribuidoraSaida.getItemCount() == 0){
            JOptionPane.showMessageDialog(null, "Primeiro filtre as distribuidoras!");
        }else{
            String distSaidaNome = jcbDistribuidoraSaida.getItemAt(jcbDistribuidoraSaida.getSelectedIndex());      
            String distDestinoNome = jcbDistribuidoraDestino.getItemAt(jcbDistribuidoraDestino.getSelectedIndex());
            Helper.ShowDialog(this,new FreteBuscarFuncionario(this,jtbFuncionariosResp,distSaidaNome,distDestinoNome, distsAtendCidadeSaida, distsAtendCidadeDestino));
        }
            
       
    }//GEN-LAST:event_jbBuscarFuncionarioActionPerformed

    private void jbBuscaCidadeOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaCidadeOrigemActionPerformed

        limparTabela(jtbFuncionariosResp);
        zeraConteudoCombos();
        Helper.ShowDialog(this,new FreteBuscarCidade(this, jtfCidadeOrigemNome, jtfCidadeOrigemCod, cidadeOrigemID));
    }//GEN-LAST:event_jbBuscaCidadeOrigemActionPerformed

    private void jbBuscaCidadeDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaCidadeDestinoActionPerformed
        limparTabela(jtbFuncionariosResp);
        zeraConteudoCombos();
        Helper.ShowDialog(this,new FreteBuscarCidade(this, jtfCidadeDestinoNome, jtfCidadeDestinoCod, cidadeDestinoID));
    }//GEN-LAST:event_jbBuscaCidadeDestinoActionPerformed

    private void jbFiltrarEncomendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarEncomendasActionPerformed
        List<JSONObject> encomendas;
        JSONObject jsonAux, encomenda;
        DefaultTableModel modelo = (DefaultTableModel) jtbEncomendas.getModel();
        Object[] objetoAux;
        modelo.setNumRows(0);
       if(!jftDataInicial.getText().equals("__/__/____")){
            if(!jftDataFinal.getText().equals("__/__/____")){
                encomendas = new EncomendaController().recupEncomsSemFretePorIntervalo(jftDataInicial.getText(), jftDataFinal.getText());
                for(int i = 0; i<encomendas.size(); i++){
                    objetoAux =  new Object[modelo.getColumnCount()];
                    encomenda = encomendas.get(i);
                    objetoAux[1] = encomenda.getInt("codigo");
                    jsonAux = encomenda.getJSONObject("emitente");
                    if(jsonAux.has("nomeFantasia")){
                       objetoAux[2] = jsonAux.getString("nomeFantasia");
                    }else
                        objetoAux[2] = jsonAux.getString("nome");
                    
                    jsonAux = encomenda.getJSONObject("destinatario");
                    if(jsonAux.has("nomeFantasia")){
                       objetoAux[3] = jsonAux.getString("nomeFantasia");
                    }else
                        objetoAux[3] = jsonAux.getString("nome");
                    
                    objetoAux[4] = Util.Helper.GetValorToReal(encomenda.getDouble("valorCobrado"));
                    objetoAux[5] = encomenda.getJSONObject("endColeta").getJSONObject("cidade").getString("nome");
                    objetoAux[6] = encomenda.getJSONObject("endDestino").getJSONObject("cidade").getString("nome");

                    modelo.addRow(objetoAux);
                }

                jtbEncomendas.setModel(modelo);
                if(modelo.getRowCount() == 0)
                    JOptionPane.showMessageDialog(rootPane, "Nenhuma Encomenda encontrada!");
            }
       }     
    }//GEN-LAST:event_jbFiltrarEncomendasActionPerformed

    private void jcbDistribuidoraSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDistribuidoraSaidaActionPerformed
        RealizarFrete = false;
    }//GEN-LAST:event_jcbDistribuidoraSaidaActionPerformed

    private void jbBuscaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaVeiculoActionPerformed
        Helper.ShowDialog(this,new FreteBuscarVeiculo(this,jtfVeiculoCodigo,jtfVeiculoPlaca,jtfVeiculoCapacidade,veiculoID));
    }//GEN-LAST:event_jbBuscaVeiculoActionPerformed

    private void jbCarregarDistribuidorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCarregarDistribuidorasActionPerformed
        if(jtbFuncionariosResp.getRowCount() == 0){
            if(jcbDistribuidoraDestino.getItemCount() == 0 && jcbDistribuidoraSaida.getItemCount() == 0){
                if(!jtfCidadeOrigemCod.getText().isEmpty()){
                   if(!jtfCidadeDestinoCod.getText().isEmpty()){
                       initCombosDistribuidoras();
                       jbBuscarFuncionario.setEnabled(true);
                       jbBuscaVeiculo.setEnabled(true);
                   }else
                        JOptionPane.showMessageDialog(null, "O campo Cidade Destino deve estar preenchido");
               }else
                   JOptionPane.showMessageDialog(null, "O campo Cidade Origem deve estar preenchido");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Já existem funcionários destas distribuidoras filtrados, limpe a tabela de funcionários antes de carregar!");
        }
    
    }//GEN-LAST:event_jbCarregarDistribuidorasActionPerformed

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        ativaGravar(true);
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed

        JSONObject jsonPersistencia =  new JSONObject();
        JSONObject jsonAux ;
        JSONArray jsonArrayAux = new JSONArray();
        try {
            Util.Validacao.InputToString(jtfCidadeOrigemCod);
            Util.Validacao.InputToString(jtfCidadeDestinoCod);
            Util.Validacao.InputToString(jtfCidadeDestinoNome);
            Util.Validacao.InputToString(jtfCidadeOrigemNome);
            Util.Validacao.InputToString(jtfVeiculoCodigo);
            Util.Validacao.InputToString(jtfVeiculoPlaca);
            Util.Validacao.InputToString(jtfVeiculoCapacidade);
            Util.Validacao.itensjTable(jtbFuncionariosResp);
            if(jtbEncomendas.getRowCount() > 0){
                /*CIDADE ORIGEM*/
                jsonAux =  new JSONObject();
                jsonAux.put("codigo", jtfCidadeOrigemCod.getText());
                jsonPersistencia.put("cidadeOrigem", jsonAux);
               /*FIM CIDADE ORIGEM*/
               
                /*CIDADE DESTINO*/
                jsonAux =  new JSONObject();
                jsonAux.put("codigo", jtfCidadeDestinoCod.getText());
                jsonPersistencia.put("cidadeDestino", jsonAux);
                /*FIM CIDADE DESTINO*/
                
                /*DISTRIBUIDORA ORIGEM*/
                jsonAux =  new JSONObject();
                jsonAux.put("codigo",distsAtendCidadeSaida.get(jcbDistribuidoraSaida.getSelectedItem()));
                jsonPersistencia.put("distribuidoraSaida", jsonAux);
                /*FIM DISTRIBUIDORA ORIGEM*/
                
                /*DISTRIBUIDORA ORIGEM*/
                jsonAux =  new JSONObject();
                jsonAux.put("codigo",distsAtendCidadeDestino.get(jcbDistribuidoraDestino.getSelectedItem()));
                jsonPersistencia.put("distribuidoraDestino",jsonAux);
                /*FIM DISTRIBUIDORA DESTINO*/
                
                /*VEICULO*/
                jsonAux =  new JSONObject();
                jsonAux.put("codigo", jtfVeiculoCodigo.getText());
                jsonPersistencia.put("veiculoTransp",jsonAux);
                /*FIM VEICULO*/
                
                /*FUNCIONÁRIOS*/
                for(int i = 0; i< jtbFuncionariosResp.getRowCount(); i ++){
                    jsonAux = new JSONObject();
                    jsonAux.put("codigo", jtbFuncionariosResp.getModel().getValueAt(i, 0));
                    jsonArrayAux.put(jsonAux);
                }
                jsonPersistencia.put("responsaveis", jsonArrayAux);
                /*FIM FUNCIONÁRIOS*/
                
                /*ENCOMENDAS*/
                jsonArrayAux =  new JSONArray();
                for(int i = 0; i< jtbEncomendas.getRowCount(); i ++){
                    jsonAux = new JSONObject();
                    if(((Boolean)jtbEncomendas.getModel().getValueAt(i, 0)) != null && ((Comparable<Boolean>)jtbEncomendas.getModel().getValueAt(i, 0)).compareTo(Boolean.TRUE) == 0){
                        jsonAux.put("codigo", jtbEncomendas.getModel().getValueAt(i, 1));
                        jsonArrayAux.put(jsonAux);
                    } 
                }
                jsonPersistencia.put("encomendasTransporte", jsonArrayAux);
                /*FIM ENCOMENDAS*/
                
                FreteController FreteCntrl = new FreteController();
                if(FreteCntrl.Save(jsonPersistencia)){
                    ativaGravar(false);
                    JOptionPane.showMessageDialog(null, "Frete gravado com sucesso!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Não foram encontradas encomendas para vincular ao frete!");
            }
        } catch (Error ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao Gravar", JOptionPane.ERROR_MESSAGE);
        }

        
        
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        ativaGravar(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbExluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExluirActionPerformed

    }//GEN-LAST:event_jbExluirActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbConsultarActionPerformed

    private void jtbFuncionariosRespPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtbFuncionariosRespPropertyChange

    }//GEN-LAST:event_jtbFuncionariosRespPropertyChange

    private void jtbFuncionariosRespKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbFuncionariosRespKeyPressed
       if(evt.getKeyCode() ==  KeyEvent.VK_DELETE)
           if(jtbFuncionariosResp.getSelectedRow() != -1)
               ((DefaultTableModel)jtbFuncionariosResp.getModel()).removeRow(jtbFuncionariosResp.getSelectedRow());
    }//GEN-LAST:event_jtbFuncionariosRespKeyPressed

    private void jbLimparFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparFuncionariosActionPerformed
        limparTabela(jtbFuncionariosResp);
    }//GEN-LAST:event_jbLimparFuncionariosActionPerformed

    private void jtfCidadeOrigemCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCidadeOrigemCodActionPerformed

    }//GEN-LAST:event_jtfCidadeOrigemCodActionPerformed

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
            java.util.logging.Logger.getLogger(Frete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frete(null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBuscaCidadeDestino;
    private javax.swing.JButton jbBuscaCidadeOrigem;
    private javax.swing.JButton jbBuscaVeiculo;
    private javax.swing.JButton jbBuscarFuncionario;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCarregarDistribuidoras;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbExluir;
    private javax.swing.JButton jbFiltrarEncomendas;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JButton jbLimparFuncionarios;
    private javax.swing.JComboBox<String> jcbDistribuidoraDestino;
    private javax.swing.JComboBox<String> jcbDistribuidoraSaida;
    private javax.swing.JFormattedTextField jftDataFinal;
    private javax.swing.JFormattedTextField jftDataInicial;
    private javax.swing.JTable jtbEncomendas;
    private javax.swing.JTable jtbFuncionariosResp;
    private javax.swing.JTextField jtfCidadeDestinoCod;
    private javax.swing.JTextField jtfCidadeDestinoNome;
    private javax.swing.JTextField jtfCidadeOrigemCod;
    private javax.swing.JTextField jtfCidadeOrigemNome;
    private javax.swing.JTextField jtfVeiculoCapacidade;
    private javax.swing.JTextField jtfVeiculoCodigo;
    private javax.swing.JTextField jtfVeiculoPlaca;
    private javax.swing.JLabel kilometragem;
    private javax.swing.JLabel totalFreteCalculado;
    private javax.swing.JLabel valorPorPeso;
    // End of variables declaration//GEN-END:variables
}
