/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import Util.Error;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
public class UsuarioController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new UsuarioDAO(Model.Usuario.class);
        Object = new Usuario();
    }

    public JSONObject Login(JSONObject json) throws Error {        
        List<Usuario> usuarios = DAO.GetAll();       
        
        for(Usuario usuario : usuarios) {
            boolean login = usuario.getLogin().equals(json.getString("Login"));
            boolean senha = usuario.getSenha().equals(json.getString("Senha"));
            
            if(login && senha){                
                return usuario.toJson();
            } else 
                throw new Util.Error("Usuário ou Senha Inválidos.");
        }
        return null;
    }
    
}
