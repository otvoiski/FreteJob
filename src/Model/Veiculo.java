/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
@Table(name = "Veiculo")
public class Veiculo extends ObjectBase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Column(name = "Placa", nullable = false)
    private String PlacaIdentificacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "Fabricacao", nullable = false)
    private Date DataFabricacao;
    @Column(nullable = false)
    private Double CapacidadeCarga;
    @ManyToOne
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
    public TipoVeiculo getTipo() {
        return Tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.Tipo = tipo;
    }
    

    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Veiculo objVeiculo =  new Veiculo();
        if(jsonRetorno.has("codigo"))
            objVeiculo.setCodigo(jsonRetorno.getInt("codigo"));
        else
            objVeiculo.setCodigo(0);
        if(jsonRetorno.has("placaIdentificacao"))
            objVeiculo.setPlacaIdentificacao(jsonRetorno.getString("placaIdentificacao"));
        
        try {
            if(jsonRetorno.has("dataFabricacao"))
                objVeiculo.setDataFabricacao((new SimpleDateFormat("yyyy/MM/dd").parse(jsonRetorno.getString("dataFabricacao"))));
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(jsonRetorno.has("capacidadeCarga"))
            objVeiculo.setCapacidadeCarga(jsonRetorno.getDouble("capacidadeCarga"));
        if(jsonRetorno.has("tipo"))
            objVeiculo.setTipo((TipoVeiculo) new TipoVeiculo().toObjectBase(jsonRetorno.getJSONObject("tipo")));
        
        
        return objVeiculo;
    }
    
}
