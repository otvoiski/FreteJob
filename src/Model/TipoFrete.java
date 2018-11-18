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
public class TipoFrete extends ObjectBase {
    
    private String descricao;
    private double percentualAcrescimo;

    public TipoFrete(String descricao, double percentualAcrescimo) {
        this.descricao = descricao;
        this.percentualAcrescimo = percentualAcrescimo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPercentualAcrescimo() {
        return percentualAcrescimo;
    }

    public void setPercentualAcrescimo(double percentualAcrescimo) {
        this.percentualAcrescimo = percentualAcrescimo;
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
