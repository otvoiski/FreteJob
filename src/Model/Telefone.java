/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Telefone extends ObjectBase{
    
    private String DDD;
    private String Numero;

    public Telefone(String ddd, String numero) {
        this.DDD = ddd;
        this.Numero = numero;
    }
    public Telefone() {}
    public String getDdd() {
        return DDD;
    }
    public void setDdd(String ddd) {
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
        json.put("Codigo", getCodigo());
        json.put("DDD", DDD);
        json.put("Numero", Numero);
        return json;
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Telefone objTelefone = new Telefone();
        objTelefone.setCodigo(jsonRetorno.getString("Codigo"));
        objTelefone.setDdd(jsonRetorno.getString("DDD"));
        objTelefone.setNumero(jsonRetorno.getString("Numero"));
        return objTelefone;    
    }
    
}
