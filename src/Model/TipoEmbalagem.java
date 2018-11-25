
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
    private Util.Enums.TipoEmbalagem Descricao;

    public Util.Enums.TipoEmbalagem getDescricao() {
        return Descricao;
    }

    public void setDescricao(Util.Enums.TipoEmbalagem descricao) {
        this.Descricao = descricao;
    }

    public TipoEmbalagem(Util.Enums.TipoEmbalagem descricao) {
        this.Descricao = descricao;
    }
    public TipoEmbalagem(){}

    @Override
    public JSONObject toJson() {
        return (new JSONObject(this));
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        TipoEmbalagem objEmbalagem =  new TipoEmbalagem();
        objEmbalagem.setDescricao(jsonRetorno.getEnum(Util.Enums.TipoEmbalagem.class, "descricao"));
        objEmbalagem.setCodigo(jsonRetorno.getInt("codigo"));
        return objEmbalagem;
    }
    
}
