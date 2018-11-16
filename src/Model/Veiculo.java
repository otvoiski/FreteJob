/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class Veiculo extends ObjectBase {
    
    private String placaIdentificacao;
    private Date dataFabricacao;
    private Double capacidadeCarga;
    private String classificacao;
    @ManyToOne
    private TipoVeiculo tipo;
    
    public Veiculo(){
        
    }
    public String getPlacaIdentificacao() {
        return placaIdentificacao;
    }

    public void setPlacaIdentificacao(String placaIdentificacao) {
        this.placaIdentificacao = placaIdentificacao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(Double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
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
