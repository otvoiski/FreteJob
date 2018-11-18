/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class Veiculo extends ObjectBase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String PlacaIdentificacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataFabricacao;
    private Double CapacidadeCarga;
    private String Classificacao;
    private TipoVeiculo Tipo;
    
    public Veiculo(){
        
    }
    public String getPlacaIdentificacao() {
        return PlacaIdentificacao;
    }

    public void setPlacaIdentificacao(String placaIdentificacao) {
        this.PlacaIdentificacao = placaIdentificacao;
    }

    public Date getDataFabricacao() {
        return DataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.DataFabricacao = dataFabricacao;
    }

    public Double getCapacidadeCarga() {
        return CapacidadeCarga;
    }

    public void setCapacidadeCarga(Double capacidadeCarga) {
        this.CapacidadeCarga = capacidadeCarga;
    }

    public String getClassificacao() {
        return Classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.Classificacao = classificacao;
    }

    public TipoVeiculo getTipo() {
        return Tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.Tipo = tipo;
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
