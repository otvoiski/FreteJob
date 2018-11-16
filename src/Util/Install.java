/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Base.Global;
import Model.Categoria;
import Model.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
