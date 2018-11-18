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
public class TipoFrete extends ObjectBase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String Descricao;
    private double PercentualAcrescimo;

    public TipoFrete() {
    }

    public TipoFrete(String descricao, double percentualAcrescimo) {
        this.Descricao = descricao;
        this.PercentualAcrescimo = percentualAcrescimo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public double getPercentualAcrescimo() {
        return PercentualAcrescimo;
    }

    public void setPercentualAcrescimo(double percentualAcrescimo) {
        this.PercentualAcrescimo = percentualAcrescimo;
    }
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
       TipoFrete objTipoFrete = new TipoFrete(jsonRetorno.getString("descricao"), jsonRetorno.getDouble("percentualAcrescimo"));
       objTipoFrete.setCodigo(jsonRetorno.getInt("Codigo"));
       return objTipoFrete;
    }
    
}
