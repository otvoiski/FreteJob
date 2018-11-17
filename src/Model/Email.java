/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import javax.persistence.Entity;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class Email extends ObjectBase implements Serializable {

    private String email;

    public Email() {
    }
   
    public String getEmail() {
        return email;
    }

    public Email(String email) {
        this.email = email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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
        return objEmail;
    }
    
}
