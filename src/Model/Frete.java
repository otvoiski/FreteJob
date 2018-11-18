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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
public class Frete extends ObjectBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Veiculo VeiculoTransp;
    @ManyToOne
    private Cidade CidOrigem;
    @ManyToOne
    private Cidade CidDestino;
    @OneToMany
    private List<Funcionario> Responsaveis;
    @OneToMany
    private List<Encomenda> EncomendasTransporte;
    private double ValorFrete;
    @ManyToOne
    private TipoFrete CategFrete;

    public Frete(Veiculo VeiculoTransp, Cidade CidOrigem, Cidade CidDestino, List<Funcionario> Responsaveis, List<Encomenda> EncomendasTransporte, double ValorFrete, TipoFrete CategFrete) {
        this.VeiculoTransp = VeiculoTransp;
        this.CidOrigem = CidOrigem;
        this.CidDestino = CidDestino;
        this.Responsaveis = Responsaveis;
        this.EncomendasTransporte = EncomendasTransporte;
        this.ValorFrete = ValorFrete;
        this.CategFrete = CategFrete;
    }

    public Frete() {
    }

    public Veiculo getVeiculoTransp() {
        return VeiculoTransp;
    }

    public void setVeiculoTransp(Veiculo VeiculoTransp) {
        this.VeiculoTransp = VeiculoTransp;
    }

    public Cidade getCidOrigem() {
        return CidOrigem;
    }

    public void setCidOrigem(Cidade CidOrigem) {
        this.CidOrigem = CidOrigem;
    }

    public Cidade getCidDestino() {
        return CidDestino;
    }

    public void setCidDestino(Cidade CidDestino) {
        this.CidDestino = CidDestino;
    }

    public List<Funcionario> getResponsaveis() {
        return Responsaveis;
    }

    public void setResponsaveis(List<Funcionario> Responsaveis) {
        this.Responsaveis = Responsaveis;
    }

    public List<Encomenda> getEncomendasTransporte() {
        return EncomendasTransporte;
    }

    public void setEncomendasTransporte(List<Encomenda> EncomendasTransporte) {
        this.EncomendasTransporte = EncomendasTransporte;
    }

    public double getValorFrete() {
        return ValorFrete;
    }

    public void setValorFrete(double ValorFrete) {
        this.ValorFrete = ValorFrete;
    }

    public TipoFrete getCategFrete() {
        return CategFrete;
    }

    public void setCategFrete(TipoFrete CategFrete) {
        this.CategFrete = CategFrete;
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
