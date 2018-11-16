/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class Cidade extends ObjectBase{
    private String Nome;
    private String CodMunicipio;
    @ManyToOne
    private Estado Estado;

    public Cidade(String Nome, String Cod_municipio, Estado estado) {
        this.Nome = Nome;
        this.CodMunicipio = Cod_municipio;
        this.Estado = estado;
    }
    public Cidade(){}
    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado estado) {
        this.Estado = estado;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public String getCod_municipio() {
        return CodMunicipio;
    }

    public void setCod_municipio(String Cod_municipio) {
        this.CodMunicipio = Cod_municipio;
    }

    @Override
    public JSONObject toJson() {
         return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Estado objEstado = new Estado();
        Cidade objCidade = new Cidade();
        objCidade.setCodigo(jsonRetorno.getInt("codigo"));
        objCidade.setNome(jsonRetorno.getString("nome"));
        if(jsonRetorno.has("cod_municipio"))
            objCidade.setCod_municipio(jsonRetorno.getString("cod_municipio"));
        
        objCidade.setEstado((Estado) objEstado.toObjectBase(jsonRetorno.getJSONObject("estado")));
        return objCidade;
    }    
}
