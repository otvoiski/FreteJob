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
public class Pais extends ObjectBase{
    private String Nome;
    private String Sigla;

    public Pais(String Nome, String sigla) {
        this.Nome = Nome;
        this.Sigla = sigla;
    }
    public Pais(){}
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        this.Sigla = sigla;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Codigo", getCodigo());
        json.put("Nome", Nome);
        json.put("Sigla", Sigla);
        return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Pais objPais = new Pais();
        objPais.setCodigo(jsonRetorno.getString("Codigo"));
        objPais.setNome(jsonRetorno.getString("Nome"));
        objPais.setSigla(jsonRetorno.getString("Sigla"));
        return objPais;  
    }
    
}
