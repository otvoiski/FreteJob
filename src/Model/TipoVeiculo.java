/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import Util.Enums.TipoTransporte;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "TipoVeiculo")
public class TipoVeiculo extends ObjectBase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private TipoTransporte Descricao;
    private double PesoMaximo;

    public TipoVeiculo() {
    }

    public TipoTransporte getDescricao() {
        return Descricao;
    }

    public void setDescricao(TipoTransporte descricao) {
        this.Descricao = descricao;
    }

    public double getPesoMaximo() {
        return PesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.PesoMaximo = pesoMaximo;
    }

    public TipoVeiculo(TipoTransporte descricao, double pesoMaximo) {
        this.Descricao = descricao;
        this.PesoMaximo = pesoMaximo;
    }
    
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
       TipoVeiculo objTipoVeiculo = new TipoVeiculo(jsonRetorno.getEnum(TipoTransporte.class,"descricao"), jsonRetorno.getDouble("pesoMaximo"));
       if(jsonRetorno.has("codigo"))
            objTipoVeiculo.setCodigo(jsonRetorno.getInt("codigo"));
       else
           objTipoVeiculo.setCodigo(0);
       
       return objTipoVeiculo;
    }
    
}
