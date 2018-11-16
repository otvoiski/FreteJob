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
public class Categoria extends ObjectBase implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String Descricao;

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
        Categoria objCtg = new Categoria();
        objCtg.setCodigo(jsonRetorno.getInt("Codigo"));
        objCtg.setDescricao(jsonRetorno.getString("Descricao"));
        return objCtg;
        
    }
    
}
