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
 * @author Otavio
 */
@Entity
public class MidiaSocial extends ObjectBase {
    private String descricao;
    @ManyToOne
    private Pessoa pessoaMidia;
    
    public MidiaSocial(){
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getPessoaMidia() {
        return pessoaMidia;
    }

    public void setPessoaMidia(Pessoa pessoaMidia) {
        this.pessoaMidia = pessoaMidia;
    }
    
    @Override
    public JSONObject toJson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
