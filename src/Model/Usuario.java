/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class Usuario extends ObjectBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String Login;
    private String Senha;
    @ManyToOne
    private Categoria Categoria;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        senha = Util.MD5.Get(senha);
        this.Senha = senha;
    }

    public Categoria getUserCategoria() {
        return Categoria;
    }

    public void setUserCategoria(Categoria userCategoria) {
        this.Categoria = userCategoria;
    }
    
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Error", false);
        json.put("Login", getLogin());
        json.put("Categoria", getUserCategoria());
        return json;
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
