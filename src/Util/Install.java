/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Base.FabricaConexaoJDBC;
import Base.Global;
import DAO.DistanciaDAO;
import Model.Categoria;
import Model.Cidade;
import Model.Distancia;
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
import java.sql.SQLException;
import java.util.ArrayList;
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
        return isInstalled;
    }
    /**
     * Popula o sistema com dados base
     * @return <b>False</b> caso o sistema não tiver erros
     */
    private boolean Populate(){
        Pais brasil = new Pais("Brasil", "BR");
        
        if((new DAO.PaisDAO(Model.Pais.class)).Save(brasil)){            
            msg.setText("Criando Cidades...");
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
                       
                    msg.setText("Calculando Distancias...");
                    Distancia distancia1 = new Distancia(belohorizonte, 281, uba);
                    Distancia distancia2 = new Distancia(belohorizonte, 314, cataguases);
                    Distancia distancia3 = new Distancia(belohorizonte, 274, juizdefora);
                    Distancia distancia4 = new Distancia(belohorizonte, 421, guaxupe);
                    Distancia distancia5 = new Distancia(belohorizonte, 441, riodejaneiro);
                    Distancia distancia6 = new Distancia(belohorizonte, 586, saopaulo);
                    Distancia distancia7 = new Distancia(belohorizonte, 526, ribeiraopreto);
                    
                    Distancia distancia8 = new Distancia(uba, 280, belohorizonte);
                    Distancia distancia9 = new Distancia(uba, 63.8, cataguases);
                    Distancia distancia10 = new Distancia(uba, 110, juizdefora);
                    Distancia distancia11 = new Distancia(uba, 499, guaxupe);
                    Distancia distancia12 = new Distancia(uba, 310, riodejaneiro);
                    Distancia distancia13 = new Distancia(uba, 599, saopaulo);
                    Distancia distancia14 = new Distancia(uba, 664, ribeiraopreto);
                    
                    Distancia distancia15 = new Distancia(cataguases, 304, belohorizonte);
                    Distancia distancia16 = new Distancia(cataguases, 54.6, uba);
                    Distancia distancia17 = new Distancia(cataguases, 119, juizdefora);
                    Distancia distancia18 = new Distancia(cataguases, 523, guaxupe);
                    Distancia distancia19 = new Distancia(cataguases, 258, riodejaneiro);
                    Distancia distancia20 = new Distancia(cataguases, 582, saopaulo);
                    Distancia distancia21 = new Distancia(cataguases, 688, ribeiraopreto);
                    
                    Distancia distancia22 = new Distancia(juizdefora, 261, belohorizonte);
                    Distancia distancia23 = new Distancia(juizdefora, 111, uba);
                    Distancia distancia24 = new Distancia(juizdefora, 118, cataguases);
                    Distancia distancia25 = new Distancia(juizdefora, 469, guaxupe);
                    Distancia distancia26 = new Distancia(juizdefora, 185, riodejaneiro);
                    Distancia distancia27 = new Distancia(juizdefora, 479, saopaulo);
                    Distancia distancia28 = new Distancia(juizdefora, 638, ribeiraopreto);
                    
                    Distancia distancia29 = new Distancia(guaxupe, 424, belohorizonte);
                    Distancia distancia30 = new Distancia(guaxupe, 499, uba);
                    Distancia distancia31 = new Distancia(guaxupe, 522, cataguases);
                    Distancia distancia32 = new Distancia(guaxupe, 476, juizdefora);
                    Distancia distancia33 = new Distancia(guaxupe, 564, riodejaneiro);
                    Distancia distancia34 = new Distancia(guaxupe, 300, saopaulo);
                    Distancia distancia35 = new Distancia(guaxupe, 173, ribeiraopreto);
                                        
                    Distancia distancia36 = new Distancia(riodejaneiro, 441, belohorizonte);
                    Distancia distancia37 = new Distancia(riodejaneiro, 310, uba);
                    Distancia distancia38 = new Distancia(riodejaneiro, 256, cataguases);
                    Distancia distancia39 = new Distancia(riodejaneiro, 182, juizdefora);
                    Distancia distancia40 = new Distancia(riodejaneiro, 550, guaxupe);
                    Distancia distancia41 = new Distancia(riodejaneiro, 456, saopaulo);
                    Distancia distancia42 = new Distancia(riodejaneiro, 727, ribeiraopreto);
                    
                    Distancia distancia43 = new Distancia(saopaulo, 613, belohorizonte);
                    Distancia distancia44 = new Distancia(saopaulo, 599, uba);
                    Distancia distancia45 = new Distancia(saopaulo, 604, cataguases);
                    Distancia distancia46 = new Distancia(saopaulo, 526, juizdefora);
                    Distancia distancia47 = new Distancia(saopaulo, 298, guaxupe);
                    Distancia distancia48 = new Distancia(saopaulo, 456, riodejaneiro);
                    Distancia distancia49 = new Distancia(saopaulo, 331, ribeiraopreto);
                    
                    Distancia distancia50 = new Distancia(ribeiraopreto, 531, belohorizonte);
                    Distancia distancia51 = new Distancia(ribeiraopreto, 664, uba);
                    Distancia distancia52 = new Distancia(ribeiraopreto, 688, cataguases);
                    Distancia distancia53 = new Distancia(ribeiraopreto, 648, juizdefora);
                    Distancia distancia54 = new Distancia(ribeiraopreto, 174, guaxupe);
                    Distancia distancia55 = new Distancia(ribeiraopreto, 729, riodejaneiro);
                    Distancia distancia56 = new Distancia(ribeiraopreto, 331, saopaulo);
                    
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia1))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia2))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia3))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia4))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia5))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia6))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia7))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia8))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia9))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia10))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia11))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia12))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia13))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia14))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia15))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia16))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia17))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia18))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia19))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia20))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia21))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia22))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia23))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia24))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia25))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia26))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia27))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia28))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia29))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia30))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia31))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia32))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia33))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia34))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia35))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia36))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia37))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia38))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia39))
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia40))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia41))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia42))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia43))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia44))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia45))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia46))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia47))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia48))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia49))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia50))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia51))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia52))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia53))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia54))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia55))  
                    if((new DistanciaDAO(Model.Distancia.class)).Save(distancia56)){
                           
                        msg.setText("Gerando Dados...");

                        Telefone telefone1 = new Telefone(32, "(32) 3574-0548");
                        Telefone telefone2 = new Telefone(32, "(32) 3539-8304");
                        Telefone telefone3 = new Telefone(32, "(32) 98953-4064");

                        Telefone telefone4 = new Telefone(35, "(35) 3502-4547");
                        Telefone telefone5 = new Telefone(35, "(35) 99382-5130");

                        Telefone telefone6 = new Telefone(31, "(31) 3973-6288");
                        Telefone telefone7 = new Telefone(33, "(33) 2686-1780");
                        Telefone telefone8 = new Telefone(31, "(31) 3693-2114");

                        Telefone telefone9 = new Telefone(31, "(35) 3556-2631");                                                            
                        Telefone telefone10 = new Telefone(35, "(35) 3824-4534");


                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone1))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone2))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone3))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone4))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone5))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone6))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone7))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone8))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone9))
                        if((new DAO.TelefoneDAO(Model.Telefone.class)).Save(telefone10)){      

                            Endereco endereco1 = new Endereco("Rua Moacyr Machado Castanho", "Residencial Sorriso", "38701-650", "569", Util.Enums.TipoEndereco.P, uba);
                            Endereco endereco2 = new Endereco("Rua São Bento", "Vila Martins", "37010-270", "116", Util.Enums.TipoEndereco.P, belohorizonte);
                            Endereco endereco3 = new Endereco("Rua Cláudio Manoel da Costa", "Centro", "32185-210", "3510", Util.Enums.TipoEndereco.P, juizdefora);
                            Endereco endereco4 = new Endereco("Rua São Bento", "Vila Martins", "37010-270", "1511", Util.Enums.TipoEndereco.P, riodejaneiro);
                            Endereco endereco5 = new Endereco("Rua Cláudio Manoel da Costa", "Centro", "32185-210", "2515", Util.Enums.TipoEndereco.P, belohorizonte);
                            Endereco endereco6 = new Endereco("Rua São Bento", "Vila Martins", "37010-270", "1511", Util.Enums.TipoEndereco.P, riodejaneiro);
                            Endereco endereco7 = new Endereco("Rua Cláudio Manoel da Costa", "Centro", "32185-210", "2515", Util.Enums.TipoEndereco.P, belohorizonte);


                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco1))    
                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco2))    
                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco3))    
                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco4))    
                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco5))    
                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco6))    
                            if((new DAO.EnderecoDAO(Model.Endereco.class)).Save(endereco7)){

                                MidiaSocial midia1 = new MidiaSocial("http://www.transportes-so.com.br/");
                                MidiaSocial midia2 = new MidiaSocial("http://www.fast-entregas.com.br/");
                                MidiaSocial midia3 = new MidiaSocial("http://www.trasportesmega.com.br/");
                                MidiaSocial midia4 = new MidiaSocial("http://www.megastore.com/");
                                MidiaSocial midia5 = new MidiaSocial("http://www.megacomunicao.com.br/");
                                MidiaSocial midia6 = new MidiaSocial("http://www.trasportesmega.com.br/");
                                MidiaSocial midia7 = new MidiaSocial("http://www.megastore.com/");
                                MidiaSocial midia8 = new MidiaSocial("http://www.megacomunicao.com.br/");

                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia1))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia2))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia3))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia4))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia5))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia6))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia7))
                                if((new DAO.MidiaSocialDAO(Model.MidiaSocial.class)).Save(midia8)){

                                    Email aemail1 = new Email("atendimento@transmporte-so.com.br");
                                    Email aemail2 = new Email("entregas@fast-entregas.com.br");
                                    Email aemail3 = new Email("comercial@fast-entregas.com.br");
                                    Email aemail4 = new Email("comercial@trasportesmega.com.br");
                                    Email aemail5 = new Email("suport@megastore.com");
                                    Email aemail6 = new Email("contato@megacomunicao.com.br");
                                    Email aemail7 = new Email("comercial@trasportesmega.com.br");
                                    Email aemail8 = new Email("suport@megastore.com");
                                    Email aemail9 = new Email("contato@megacomunicao.com.br");

                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail1))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail2))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail3))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail4))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail5))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail6))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail7))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail8))
                                    if((new DAO.EmailDAO(Model.Email.class)).Save(aemail9)){

                                        ArrayList<Cidade> regiao1 = new ArrayList<>();
                                            regiao1.add(uba);
                                            regiao1.add(juizdefora);
                                            regiao1.add(belohorizonte);
                                        ArrayList<Telefone> tel1 = new ArrayList<>();
                                            tel1.add(telefone1);
                                            tel1.add(telefone2);
                                            tel1.add(telefone3);
                                        ArrayList<Endereco> end1 = new ArrayList<>();
                                            end1.add(endereco1);                                                                
                                        ArrayList<MidiaSocial> site1 = new ArrayList<>();
                                            site1.add(midia1);
                                        ArrayList<Email> email1 = new ArrayList<>();
                                            email1.add(aemail1);


                                        ArrayList<Cidade> regiao2 = new ArrayList<>();
                                            regiao2.add(juizdefora);
                                            regiao2.add(belohorizonte);
                                            regiao2.add(saopaulo);
                                            regiao2.add(ribeiraopreto);
                                            regiao2.add(guaxupe);
                                        ArrayList<Telefone> tel2 = new ArrayList<>();
                                            tel1.add(telefone4);
                                            tel1.add(telefone5);
                                        ArrayList<Endereco> end2 = new ArrayList<>();
                                            end1.add(endereco2);                                                                
                                            end1.add(endereco3);                                                                
                                        ArrayList<MidiaSocial> site2 = new ArrayList<>();
                                            site1.add(midia2);
                                        ArrayList<Email> email2 = new ArrayList<>();
                                            email1.add(aemail2);
                                            email1.add(aemail3);


                                        ArrayList<Cidade> regiao3 = new ArrayList<>();
                                            regiao3.add(belohorizonte);
                                            regiao3.add(riodejaneiro);
                                        ArrayList<Telefone> tel3 = new ArrayList<>();
                                            tel1.add(telefone6);
                                            tel1.add(telefone7);
                                            tel1.add(telefone8);
                                        ArrayList<Endereco> end3 = new ArrayList<>();
                                            end1.add(endereco4);                                                                
                                            end1.add(endereco5);                                                                
                                        ArrayList<MidiaSocial> site3 = new ArrayList<>();
                                            site1.add(midia3);
                                            site1.add(midia4);
                                            site1.add(midia5);
                                        ArrayList<Email> email3 = new ArrayList<>();
                                            email1.add(aemail4);   
                                            email1.add(aemail5);   
                                            email1.add(aemail6);   


                                        ArrayList<Cidade> regiao4 = new ArrayList<>();
                                            regiao4.add(riodejaneiro);
                                            regiao4.add(belohorizonte);
                                            regiao4.add(saopaulo);
                                        ArrayList<Telefone> tel4 = new ArrayList<>();
                                            tel1.add(telefone9);
                                            tel1.add(telefone10);
                                        ArrayList<Endereco> end4 = new ArrayList<>();
                                            end1.add(endereco6);                                                                
                                            end1.add(endereco7);                                                                
                                        ArrayList<MidiaSocial> site4 = new ArrayList<>();
                                            site1.add(midia6);
                                            site1.add(midia7);
                                            site1.add(midia8);
                                        ArrayList<Email> email4 = new ArrayList<>();
                                            email1.add(aemail7);   
                                            email1.add(aemail8);   
                                            email1.add(aemail9); 


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
                        }
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
                Connection conn = FabricaConexaoJDBC.GetConnection();
                String query = "Create database " + Global.DB_NAME;  
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
                int exe = ps.executeUpdate();
                if(exe > 0){
                    msg.setText("Criando Usuario...");
                    Usuario usuario = new Usuario();
                    usuario.setLogin("admin");
                    usuario.setSenha("admin");
                    
                    Model.Categoria categoria = new Categoria();
                    categoria.setDescricao("Administrador");
                    
                    if((new DAO.CategoriaDAO(Model.Categoria.class)).Save(categoria)){
                        usuario.setUserCategoria(categoria);   
                        if(new DAO.UsuarioDAO(Model.Usuario.class).Save(usuario)){
                            conn.close();
                            return !Populate();
                        }else{
                            conn.close();
                            return false;
                        }
                    } else{
                        conn.close();
                        return false;
                    }
                } else {
                    conn.close();
                    return false;     
                }
                       
            } catch (SQLException e) {
                if(e.getMessage().contains("database exists")){
                    try {
                        msg.setText("Deletando Base de Dados com defeito...");
                        Connection conn; 

                        conn = FabricaConexaoJDBC.GetConnection();

                        String query = "drop database " + Global.DB_NAME;  
                        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
                        int exe = ps.executeUpdate();
                        if(exe > 0)
                            Start();
                        else return false;
                    } catch (SQLException ex) {
                        Logger.getLogger(Install.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                } else{ 
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        } return true;
    }
}
