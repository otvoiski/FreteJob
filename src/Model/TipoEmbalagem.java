
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
 * @author Matheus
 */
@Entity
public class TipoEmbalagem extends ObjectBase implements Serializable {
        
    private static final long serialVersionUID = 1L;
    private String Descricao;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public TipoEmbalagem(String descricao) {
        this.Descricao = descricao;
    }
    public TipoEmbalagem(){}

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Codigo", getCodigo());
        json.put("Descricao", Descricao);
        return json;
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        TipoEmbalagem objEmbalagem =  new TipoEmbalagem();
        objEmbalagem.setDescricao(jsonRetorno.getString("Descricao"));
        objEmbalagem.setCodigo(jsonRetorno.getInt("Codigo"));
        return objEmbalagem;
    }
    
}
