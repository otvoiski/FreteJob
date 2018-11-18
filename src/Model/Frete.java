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
 * @author Otavio
 */
@Entity
public class Frete extends ObjectBase implements Serializable {

    @ManyToOne
    private Veiculo veiculoTransp;
    @ManyToOne
    private Cidade cidOrigem;
    @ManyToOne
    private Cidade cidDestino;
    @ManyToMany(mappedBy = "responsFrete")
    private List<Funcionario> responsaveis;
    @ManyToMany(mappedBy = "fretesTransp")
    private List<Encomenda> encomendasTransporte;
    private double valorFrete;
    @ManyToOne
    private TipoFrete categFrete;

    public Veiculo getVeiculoTransp() {
        return veiculoTransp;
    }

    public void setVeiculoTransp(Veiculo veiculoTransp) {
        this.veiculoTransp = veiculoTransp;
    }

    public Cidade getCidOrigem() {
        return cidOrigem;
    }

    public void setCidOrigem(Cidade cidOrigem) {
        this.cidOrigem = cidOrigem;
    }

    public Cidade getCidDestino() {
        return cidDestino;
    }

    public void setCidDestino(Cidade cidDestino) {
        this.cidDestino = cidDestino;
    }

    public List<Funcionario> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Funcionario> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public List<Encomenda> getEncomendasTransporte() {
        return encomendasTransporte;
    }

    public void setEncomendasTransporte(List<Encomenda> encomendasTransporte) {
        this.encomendasTransporte = encomendasTransporte;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public TipoFrete getCategFrete() {
        return categFrete;
    }

    public void setCategFrete(TipoFrete categFrete) {
        this.categFrete = categFrete;
    }
    
    
    public void calculaValorFrete(){
        
    }
    
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
