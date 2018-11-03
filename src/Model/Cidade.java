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
public class Cidade extends ObjectBase{
    private String Nome;
    private String Cod_municipio;
    private Estado estado;

    public Cidade(String Nome, String Cod_municipio, Estado estado) {
        this.Nome = Nome;
        this.Cod_municipio = Cod_municipio;
        this.estado = estado;
    }
    public Cidade(){}
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public String getCod_municipio() {
        return Cod_municipio;
    }

    public void setCod_municipio(String Cod_municipio) {
        this.Cod_municipio = Cod_municipio;
    }

    @Override
    public JSONObject toJson() {
         JSONObject json = new JSONObject();
         json.put("Codigo", getCodigo());
         json.put("Nome", Nome);
         json.put("Codigo_Municipio", Cod_municipio);
         json.put("Estado", estado.toJson());
         return json;
        
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Estado objEstado = new Estado();
        Cidade objCidade = new Cidade();
        objCidade.setCodigo(jsonRetorno.getString("Codigo"));
        objCidade.setNome(jsonRetorno.getString("Nome"));
        objCidade.setCod_municipio(jsonRetorno.getString("Codigo_Municipio"));
        objCidade.setEstado((Estado) objEstado.toObjectBase(jsonRetorno.getJSONObject("Estado")));
        return objCidade;
    }
    
}
