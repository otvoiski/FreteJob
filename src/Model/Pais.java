/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import Model.Encomenda.Estados;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class Pais extends ObjectBase{
    private String Nome;
    private String Sigla;
    @ManyToOne
    private List<Estados> estados;

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }

    public Pais(String Nome, String sigla) {
        this();
        this.Nome = Nome;
        this.Sigla = sigla;
    }
    public Pais(){
        estados = new ArrayList<>();
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

    public void setSigla(String sigla) {
        this.Sigla = sigla;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("codigo", getCodigo());
        json.put("nome", Nome);
        json.put("sigla", Sigla);

        return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Pais objPais = new Pais();
        objPais.setCodigo(jsonRetorno.getInt("codigo"));
        objPais.setNome(jsonRetorno.getString("nome"));
        if(jsonRetorno.has("sigla"))
            objPais.setSigla(jsonRetorno.getString("sigla"));
        
        return objPais;  
    }
}
