/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
public class UsuarioDAO extends Base.Persistencia{
    
    public UsuarioDAO(Class persistedClass) {
        super(persistedClass);
    }
}
