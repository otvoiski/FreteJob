/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import javax.persistence.Entity;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class MidiaSocial extends ObjectBase implements Serializable{
    private static final long serialVersionUID = 1L;
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
        return new MidiaSocial(jsonRetorno.getString("Descricao"));
    }
    
}
