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
public class Estado extends ObjectBase{
    private String Nome;
    private String Sigla;
    private Pais Pais;

    public Estado(String Nome, String Sigla, Pais pais) {

        this.Nome = Nome;
        this.Sigla = Sigla;
        this.Pais = pais;
    }
    public Estado(){}
    public Pais getPais() {
        return Pais;
    }

    public void setPais(Pais pais) {
        this.Pais = pais;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    @Override
    public JSONObject toJson() {
       JSONObject json = new JSONObject();
       json.put("codigo", getCodigo());
       json.put("nome",Nome);
       json.put("sigla",Sigla);
       json.put("pais",Pais.toJson());
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Estado objEstado = new Estado();
        Pais objPais = new Pais();
        objEstado.setCodigo(jsonRetorno.getString("codigo"));
        objEstado.setNome(jsonRetorno.getString("nome"));
        objEstado.setSigla(jsonRetorno.getString("sigla"));
        objEstado.setPais((Pais) objPais.toObjectBase(jsonRetorno.getJSONObject("pais")));
        return objEstado;  
    }

   
    
}
