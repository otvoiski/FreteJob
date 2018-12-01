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
import javax.persistence.Table;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
@Table(name = "MidiaSocial")
public class MidiaSocial extends ObjectBase implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    private String Descricao;

    public MidiaSocial() {
    }

    public MidiaSocial(String descricao) {
        this.Descricao = descricao;
    }
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }
    
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        MidiaSocial objMidia =  new MidiaSocial();
        if(jsonRetorno.has("codigo"))
            objMidia.setCodigo(jsonRetorno.getInt("codigo"));
        else
            objMidia.setCodigo(0);
        
        if(jsonRetorno.has("descricao"))
            objMidia.setDescricao(jsonRetorno.getString("descricao"));
            
        return objMidia;
    }
    
}
