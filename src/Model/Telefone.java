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
 * @author Matheus
 */
@Entity
public class Telefone extends ObjectBase implements Serializable{
    
    private int DDD;
    private String Numero;

    public Telefone(int ddd, String numero) {
        this.DDD = ddd;
        this.Numero = numero;
    }
    public Telefone() {}
    public int getDdd() {
        return DDD;
    }
    public void setDdd(int ddd) {
        this.DDD = ddd;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        this.Numero = numero;
    }
    
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("codigo", getCodigo());
        json.put("ddd", DDD);
        json.put("numero", Numero);
        return json;
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Telefone objTelefone = new Telefone();
        objTelefone.setCodigo(jsonRetorno.getInt("codigo"));
        objTelefone.setDdd(jsonRetorno.getInt("ddd"));
        objTelefone.setNumero(jsonRetorno.getString("numero"));
        return objTelefone;    
    }
}
