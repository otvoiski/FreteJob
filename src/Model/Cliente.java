/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.json.JSONObject;

/**
 * Está classes é um modelo simples que não estara inclusa no projeto
 * foi criada para ajuda no processo de persistencia ao banco.
 * 
 * @deprecated Esta classe sera removida em breve.
 * @author Otavio
 */
public class Cliente extends ObjectBase{
    String Codigo;
    String Nome;

    public Cliente() {
        Codigo = "";
        Nome = "";
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public JSONObject toJson() {        
        JSONObject json = new JSONObject();
         json.put("Codigo", getCodigo());
         json.put("Nome", getNome());
        return json;
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Cliente obj = new Cliente();      
        obj.setCodigo(jsonRetorno.getString("Codigo"));
        obj.setNome(jsonRetorno.getString("Nome"));
        return obj;
    }
    
}
