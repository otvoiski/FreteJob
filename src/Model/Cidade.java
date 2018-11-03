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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
