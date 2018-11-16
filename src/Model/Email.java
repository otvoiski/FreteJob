/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import javax.persistence.Entity;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class Email extends ObjectBase {

    private String email;
    private String tipo;
    
    public Email(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Email objEmail = new Email();
        objEmail.setCodigo(jsonRetorno.getInt("codigo"));
        objEmail.setEmail(jsonRetorno.getString("email"));
        objEmail.setTipo(jsonRetorno.getString("tipo"));
        return objEmail;
    }
    
}
