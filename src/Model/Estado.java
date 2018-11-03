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
    private Pais pais;

    public Estado(String Nome, String Sigla, Pais pais) {

        this.Nome = Nome;
        this.Sigla = Sigla;
        this.pais = pais;
    }
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
