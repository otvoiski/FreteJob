/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class Cidade extends ObjectBase implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column(unique = true)
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
        if(jsonRetorno.has("codigo"))
            objCidade.setCodigo(jsonRetorno.getInt("codigo"));
        else
            objCidade.setCodigo(0);
        if(jsonRetorno.has("nome"))
            objCidade.setNome(jsonRetorno.getString("nome"));
        
        if(jsonRetorno.has("cod_municipio"))
            objCidade.setCod_municipio(jsonRetorno.getString("cod_municipio"));
        if(jsonRetorno.has("estado"))
            objCidade.setEstado((Estado) objEstado.toObjectBase(jsonRetorno.getJSONObject("estado")));
        
        return objCidade;
    }    
}
