/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class ObjetoEncomenda extends ObjectBase implements Serializable {

    private static final long serialVersionUID = 1L;
    private String Descricao;
    private double Peso;
    private TipoEmbalagem TipoEmbalagem;
    
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        this.Peso = peso;
    }
    
    public TipoEmbalagem getTipoEmbalagem() {
        return TipoEmbalagem;
    }

    public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
        this.TipoEmbalagem = tipoEmbalagem;
    }
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        ObjetoEncomenda objEncomenda = new ObjetoEncomenda();
        objEncomenda.setCodigo(jsonRetorno.getInt("Codigo"));
        objEncomenda.setDescricao(jsonRetorno.getString("descricao"));
        objEncomenda.setPeso(jsonRetorno.getDouble("peso"));
        objEncomenda.setTipoEmbalagem((TipoEmbalagem) new TipoEmbalagem().toObjectBase(jsonRetorno.getJSONObject("tipoembalagem")));
        return objEncomenda;
    }
    
}
