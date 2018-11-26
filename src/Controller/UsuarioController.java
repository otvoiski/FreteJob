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
        String[][] parametro = {
             {"Login ",  "'" + json.getString("Login") + "'"},
             {"Senha ", "'" + json.getString("Senha")+ "'"}
         };
        List<Usuario> usuario = DAO.Get(parametro);       
        if(!usuario.isEmpty()){                
            return usuario.get(0).toJson();
        } else
            throw new Util.Error("Usuário ou Senha Inválidos."); 
    }
    
}
