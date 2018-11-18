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
public class TipoVeiculo extends ObjectBase {

    private String descricao;
    private double pesoMaximo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public TipoVeiculo(String descricao, double pesoMaximo) {
        this.descricao = descricao;
        this.pesoMaximo = pesoMaximo;
    }
    
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
       TipoVeiculo objTipoVeiculo = new TipoVeiculo(jsonRetorno.getString("descricao"), jsonRetorno.getDouble("pesoMaximo"));
       objTipoVeiculo.setCodigo(jsonRetorno.getInt("Codigo"));
       return objTipoVeiculo;
    }
    
}
