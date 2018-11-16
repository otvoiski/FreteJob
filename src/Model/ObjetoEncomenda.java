/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class ObjetoEncomenda extends ObjectBase {

    
    private String descricao;
    private double peso;
    private Encomenda encomendaPertence;
    @ManyToOne
    private TipoEmbalagem tipoEmbalagem;
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Encomenda getEncomendaPertence() {
        return encomendaPertence;
    }

    public void setEncomendaPertence(Encomenda encomendaPertence) {
        this.encomendaPertence = encomendaPertence;
    }

    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
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