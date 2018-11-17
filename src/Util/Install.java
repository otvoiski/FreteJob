/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Base.Global;
import Model.Categoria;
import Model.Cidade;
import Model.Distribuidora;
import Model.Email;
import Model.Endereco;
import Model.Estado;
import Model.Funcionario;
import Model.MidiaSocial;
import Model.Pais;
import Model.Telefone;
import Model.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.json.JSONObject;


/**
 *
 * @author Otavio
 */
public class Install {
    private static boolean isInstalled = false;
    private JLabel msg;
    
    public Install(JLabel msg) {
        this.msg = msg;
        try {
            isInstalled = _Read("isInstall");
        } catch (Exception e) {
            _Update(isInstalled);
        }
    }
    public boolean Start(){        
        isInstalled = _Start();
        _Update(isInstalled);
        if(isInstalled) Populate();
        return isInstalled;
    }
    /**
     * Popula o sistema com dados base
     * @return <b>False</b> caso o sistema não tiver erros
     */
    public static boolean Populate(){
        Pais brasil = new Pais("Brasil", "BR"),
                usa = new Pais("Estados Unidos", "US");
        
        if((new DAO.PaisDAO(Model.Pais.class)).Save(brasil))
            if((new DAO.PaisDAO(Model.Pais.class)).Save(usa)){
                Estado mg = new Estado("Minas Gerais", "MG", brasil);
                Estado rj = new Estado("Rio de Janeiro", "RJ", brasil);
                Estado sp = new Estado("São Paulo", "SP", brasil);
                if((new DAO.EstadoDAO(Model.Estado.class).Save(mg)))
                    if((new DAO.EstadoDAO(Model.Estado.class).Save(rj)))
                        if((new DAO.EstadoDAO(Model.Estado.class).Save(sp))){
                            Cidade belohorizonte = new Cidade("Belo Horizonte", "3106200", mg);
                            Cidade uba = new Cidade("Ubá", "3169901", mg);
                            Cidade cataguases = new Cidade("Cataguases", "3115300", mg);
                            Cidade juizdefora = new Cidade("Juiz de Fora", "3136702", mg);
                            Cidade guaxupe = new Cidade("Guaxupé", "3128709", mg);
                            Cidade riodejaneiro = new Cidade("Rio de Janeiro", "3304557", rj);
                            Cidade saopaulo = new Cidade("São Paulo", "3550308", sp);
                            Cidade ribeiraopreto = new Cidade("Ribeirão Preto", "3543402", sp);
                            if((new DAO.CidadeDAO(Model.Cidade.class)).Save(belohorizonte))
                                if((new DAO.CidadeDAO(Model.Cidade.class)).Save(uba))
                                    if((new DAO.CidadeDAO(Model.Cidade.class)).Save(cataguases))
                                        if((new DAO.CidadeDAO(Model.Cidade.class)).Save(juizdefora))
                                            if((new DAO.CidadeDAO(Model.Cidade.class)).Save(guaxupe))
                                                if((new DAO.CidadeDAO(Model.Cidade.class)).Save(riodejaneiro))
                                                    if((new DAO.CidadeDAO(Model.Cidade.class)).Save(saopaulo))  
                                                        if((new DAO.CidadeDAO(Model.Cidade.class)).Save(ribeiraopreto)){
                                                            ArrayList<Cidade> regiao1 = new ArrayList<>();
                                                                regiao1.add(uba);
                                                                regiao1.add(juizdefora);
                                                                regiao1.add(belohorizonte);
                                                            ArrayList<Telefone> tel1 = new ArrayList<>();
                                                                tel1.add(new Telefone(32, "(32) 3574-0548"));
                                                                tel1.add(new Telefone(32, "(32) 3539-8304"));
                                                                tel1.add(new Telefone(32, "(32) 98953-4064"));
                                                            ArrayList<Endereco> end1 = new ArrayList<>();
                                                                end1.add(new Endereco("Rua Moacyr Machado Castanho", "Residencial Sorriso", "38701-650", "569", "", uba));                                                                
                                                            ArrayList<MidiaSocial> site1 = new ArrayList<>();
                                                                site1.add(new MidiaSocial("http://www.transportes-so.com.br/"));
                                                            ArrayList<Email> email1 = new ArrayList<>();
                                                                email1.add(new Email("atendimento@transmporte-so.com.br"));
                                                                
                                                                
                                                            ArrayList<Cidade> regiao2 = new ArrayList<>();
                                                                regiao2.add(juizdefora);
                                                                regiao2.add(belohorizonte);
                                                                regiao2.add(saopaulo);
                                                                regiao2.add(ribeiraopreto);
                                                                regiao2.add(guaxupe);
                                                            ArrayList<Telefone> tel2 = new ArrayList<>();
                                                                tel1.add(new Telefone(35, "(35) 3502-4547"));
                                                                tel1.add(new Telefone(35, "(35) 99382-5130"));
                                                            ArrayList<Endereco> end2 = new ArrayList<>();
                                                                end1.add(new Endereco("Rua São Bento", "Vila Martins", "37010-270", "116", "", belohorizonte));                                                                
                                                                end1.add(new Endereco("Rua Cláudio Manoel da Costa", "Centro", "32185-210", "3510", "", juizdefora));                                                                
                                                            ArrayList<MidiaSocial> site2 = new ArrayList<>();
                                                                site1.add(new MidiaSocial("http://www.fast-entregas.com.br/"));
                                                            ArrayList<Email> email2 = new ArrayList<>();
                                                                email1.add(new Email("entregas@fast-entregas.com.br"));
                                                                email1.add(new Email("comercial@fast-entregas.com.br"));
                                                                
                                                                
                                                            ArrayList<Cidade> regiao3 = new ArrayList<>();
                                                                regiao3.add(belohorizonte);
                                                                regiao3.add(riodejaneiro);
                                                            ArrayList<Telefone> tel3 = new ArrayList<>();
                                                                tel1.add(new Telefone(31, "(31) 3973-6288"));
                                                                tel1.add(new Telefone(33, "(33) 2686-1780"));
                                                                tel1.add(new Telefone(31, "(31) 3693-2114"));
                                                            ArrayList<Endereco> end3 = new ArrayList<>();
                                                                end1.add(new Endereco("Rua São Bento", "Vila Martins", "37010-270", "1511", "", riodejaneiro));                                                                
                                                                end1.add(new Endereco("Rua Cláudio Manoel da Costa", "Centro", "32185-210", "2515", "", belohorizonte));                                                                
                                                            ArrayList<MidiaSocial> site3 = new ArrayList<>();
                                                                site1.add(new MidiaSocial("http://www.trasportesmega.com.br/"));
                                                                site1.add(new MidiaSocial("http://www.megastore.com/"));
                                                                site1.add(new MidiaSocial("http://www.megacomunicao.com.br/"));
                                                            ArrayList<Email> email3 = new ArrayList<>();
                                                                email1.add(new Email("comercial@trasportesmega.com.br"));   
                                                                email1.add(new Email("suport@megastore.com"));   
                                                                email1.add(new Email("contato@megacomunicao.com.br"));   
                                                                
                                                                
                                                            ArrayList<Cidade> regiao4 = new ArrayList<>();
                                                                regiao4.add(riodejaneiro);
                                                                regiao4.add(belohorizonte);
                                                                regiao4.add(saopaulo);
                                                            ArrayList<Telefone> tel4 = new ArrayList<>();
                                                                tel1.add(new Telefone(31, "(35) 3556-2631"));
                                                                tel1.add(new Telefone(35, "(35) 3824-4534"));
                                                            ArrayList<Endereco> end4 = new ArrayList<>();
                                                                end1.add(new Endereco("Rua São Bento", "Vila Martins", "37010-270", "1511", "", riodejaneiro));                                                                
                                                                end1.add(new Endereco("Rua Cláudio Manoel da Costa", "Centro", "32185-210", "2515", "", belohorizonte));                                                                
                                                            ArrayList<MidiaSocial> site4 = new ArrayList<>();
                                                                site1.add(new MidiaSocial("http://www.trasportesmega.com.br/"));
                                                                site1.add(new MidiaSocial("http://www.megastore.com/"));
                                                                site1.add(new MidiaSocial("http://www.megacomunicao.com.br/"));
                                                            ArrayList<Email> email4 = new ArrayList<>();
                                                                email1.add(new Email("comercial@trasportesmega.com.br"));   
                                                                email1.add(new Email("suport@megastore.com"));   
                                                                email1.add(new Email("contato@megacomunicao.com.br")); 
                                                                
                                                                
                                                            Distribuidora dist1 = new Distribuidora("80.437.877/0001-83", "Severino e Osvaldo Transportes ME", "Severino e Osvaldo Transportes", regiao1, tel1, end1, site1, email1);
                                                            Distribuidora dist2 = new Distribuidora("39.089.110/0001-07", "Isaac e Renan Entregas Expressas Ltda", "Isaac e Renan Entregas Expressas", regiao2, tel2, end2, site2, email2);
                                                            Distribuidora dist3 = new Distribuidora("16.543.578/0001-24", "Marcelo Transportadora ME", "Marcelo Transportadora", regiao3, tel3, end3, site3, email3);
                                                            Distribuidora dist4 = new Distribuidora("81.323.052/0001-09", "Calebe e Brenda Transportes Ltda", "Calebe e Brenda Transportes", regiao4, tel4, end4, site4, email4);
                                                            
                                                            if((new DAO.DistribuidoraDAO(Model.Distribuidora.class)).Save(dist1))
                                                                if((new DAO.DistribuidoraDAO(Model.Distribuidora.class)).Save(dist2))
                                                                    if((new DAO.DistribuidoraDAO(Model.Distribuidora.class)).Save(dist3))
                                                                        if((new DAO.DistribuidoraDAO(Model.Distribuidora.class)).Save(dist4)){
                                                                            Funcionario f1 = new Funcionario("701.082.218-22", "20.618.434-7", "Henry Francisco Drumond", dist1);
                                                                            Funcionario f2 = new Funcionario("796.606.171-00", "26.594.694-3", "Martin Otávio Leonardo Cavalcanti", dist1);
                                                                            Funcionario f3 = new Funcionario("360.317.747-98", "48.871.409-6", "Vinicius Samuel Gomes", dist1);
                                                                            Funcionario f4 = new Funcionario("745.506.209-51", "17.206.061-8", "Cauã Daniel Vicente Melo", dist1);
                                                                            Funcionario f5 = new Funcionario("131.915.884-69", "24.708.555-8", "Alexandre Julio Tiago da Paz", dist1);
                                                                            
                                                                            Funcionario f6 = new Funcionario("769.506.731-83", "24.821.353-2", "Henrique Nelson das Neves", dist2);
                                                                            Funcionario f7 = new Funcionario("765.591.295-51", "28.456.926-4", "Fábio Noah da Cruz", dist2);
                                                                            Funcionario f8 = new Funcionario("195.309.829-09", "22.981.528-5", "Kevin Joaquim Luís Castro", dist2);
                                                                            Funcionario f9 = new Funcionario("215.775.079-75", "26.860.007-7", "Kaique Daniel Pedro Rezende", dist2);
                                                                            Funcionario f10 = new Funcionario("188.396.784-84", "15.685.352-8", "Lorenzo Henry Anthony Silveira", dist2);
                                                                            
                                                                            Funcionario f11 = new Funcionario("714.264.739-66", "23.263.856-1", "Cláudio Augusto Nicolas Souza", dist3);
                                                                            Funcionario f12 = new Funcionario("149.236.289-10", "28.503.469-8", "Leonardo André João da Paz", dist3);
                                                                            Funcionario f13 = new Funcionario("767.057.359-70", "15.015.647-9", "Jorge Levi Mendes", dist3);
                                                                            Funcionario f14 = new Funcionario("735.177.750-02", "18.954.057-6", "Mateus Roberto Tiago Rodrigues", dist3);
                                                                            Funcionario f15 = new Funcionario("270.257.562-53", "39.498.338-5", "Lucca Martin Lima", dist3);
                                                                            Funcionario f16 = new Funcionario("376.449.920-65", "33.949.378-1", "Enzo Diogo da Costa", dist3);
                                                                            Funcionario f17 = new Funcionario("645.240.589-66", "33.030.321-1", "Nelson Rodrigo Rezende", dist3);
                                                                            
                                                                            Funcionario f18 = new Funcionario("229.339.747-54", "41.105.271-8", "Carlos Eduardo Yuri Cauã da Silva", dist4);
                                                                            Funcionario f19 = new Funcionario("457.025.836-04", "22.649.611-9", "Augusto Kevin Pedro Henrique Baptista", dist4);                                                                           
                                                                            Funcionario f20 = new Funcionario("625.577.525-92", "14.271.069-6", "Hugo Edson Paulo da Mata", dist4);                                                                           
                                                                            
                                                                            if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f1))
                                                                                if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f2))
                                                                                    if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f3))
                                                                                        if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f4))
                                                                                            if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f5))
                                                                                                if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f6))
                                                                                                    if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f7))
                                                                                                        if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f8))
                                                                                                            if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f9))
                                                                                                                if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f10))
                                                                                                                    if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f11))
                                                                                                                        if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f12))
                                                                                                                            if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f13))
                                                                                                                                if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f14))
                                                                                                                                    if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f15))
                                                                                                                                        if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f16))
                                                                                                                                            if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f17))
                                                                                                                                                if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f18))
                                                                                                                                                    if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f19))
                                                                                                                                                        if((new DAO.FuncionarioDAO(Model.Funcionario.class)).Save(f20))
                                                                                                                                                            return false;
                                                                        }
                                                        }
                            
                        }
                            
            }
        return true;
    }
    public static boolean isIsInstalled() {
        return isInstalled;
    }        
    private boolean _Read(String read){
        Util.Files files = new Util.Files("/config.dat");
        try {
            JSONObject json = files.Read();
            return json.getBoolean(read);
        } catch (IOException ex) {
            Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private void _Update(boolean value){
        Util.Files files = new Util.Files("/config.dat");
        try {
            files.Write(new JSONObject().put("isInstall", value));
        } catch (IOException ex) {
            Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean _Start(){
        if(!isInstalled){               
            try {                
                msg.setText("Criando Base de Dados...");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=123456"); 
                String query = "Create database " + Global.DB_NAME;  
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
                if(ps.executeUpdate()> 0){
                    msg.setText("Criando Usuario...");
                    Usuario usuario = new Usuario();
                    usuario.setLogin("admin");
                    usuario.setSenha("admin");
                    
                    Model.Categoria categoria = new Categoria();
                    categoria.setDescricao("Administrador");
                    
                    if((new DAO.CategoriaDAO(Model.Categoria.class)).Save(categoria)){
                        usuario.setUserCategoria(categoria);   
                        return (new DAO.UsuarioDAO(Model.Usuario.class)).Save(usuario);
                    } else 
                        return false;
                } else 
                    return false;        
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        } return true;
    }
}
