
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import javax.persistence.Entity;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class TipoEmbalagem extends ObjectBase {
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoEmbalagem(String descricao) {
        this.descricao = descricao;
    }
    public TipoEmbalagem(){}

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Codigo", getCodigo());
        json.put("Descricao", descricao);
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
