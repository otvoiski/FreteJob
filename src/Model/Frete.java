/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
@Entity
@Table(name =  "Frete")
public class Frete extends ObjectBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Veiculo VeiculoTransp;
    @ManyToOne
    private Cidade CidOrigem;
    @ManyToOne
    private Cidade CidDestino;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Funcionario> Responsaveis;
    @OneToMany
    private List<Encomenda> EncomendasTransporte;
    @Column(name = "Valor")
    private double ValorFrete;
    @ManyToOne
    private TipoFrete CategFrete;
    @ManyToOne
    private Distribuidora DistribuidoraSaida;
    @ManyToOne
    private Distribuidora DistribuidoraDestino;

    public Distribuidora getDistribuidoraSaida() {
        return DistribuidoraSaida;
    }

    public void setDistribuidoraSaida(Distribuidora DistribuidoraSaida) {
        this.DistribuidoraSaida = DistribuidoraSaida;
    }

    public Distribuidora getDistribuidoraDestino() {
        return DistribuidoraDestino;
    }

    public void setDistribuidoraDestino(Distribuidora DistribuidoraDestino) {
        this.DistribuidoraDestino = DistribuidoraDestino;
    }
    
    public Veiculo getVeiculoTransp() {
        return VeiculoTransp;
    }

    public void setVeiculoTransp(Veiculo VeiculoTransp) {
        this.VeiculoTransp = VeiculoTransp;
    }

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
        JSONArray jsonAux;
        List<Funcionario> funcAux =  new ArrayList<>();
        List<Encomenda> encomendasAux =  new ArrayList<>();
        Frete objFrete =  new Frete();
        if(jsonRetorno.has("codigo"))
            objFrete.setCodigo(jsonRetorno.getInt("codigo"));
        else
            objFrete.setCodigo(0);
        
        objFrete.setVeiculoTransp((Veiculo) new Veiculo().toObjectBase(jsonRetorno.getJSONObject("veiculoTransp")));
        objFrete.setCidOrigem((Cidade) new Cidade().toObjectBase(jsonRetorno.getJSONObject("cidadeOrigem")));
        objFrete.setCidDestino((Cidade) new Cidade().toObjectBase(jsonRetorno.getJSONObject("cidadeDestino")));
        
        jsonAux = jsonRetorno.getJSONArray("responsaveis");
        for(int i = 0; i< jsonAux.length(); i++){
            funcAux.add((Funcionario) new Funcionario().toObjectBase(jsonAux.getJSONObject(i)));
        }
        objFrete.setResponsaveis(funcAux);
        
        
        jsonAux = jsonRetorno.getJSONArray("encomendasTransporte");
        for(int i = 0; i< jsonAux.length(); i++){
            encomendasAux.add((Encomenda) new Encomenda().toObjectBase(jsonAux.getJSONObject(i)));
        }
        objFrete.setEncomendasTransporte(encomendasAux);
        objFrete.setValorFrete(jsonRetorno.getDouble("valorFrete"));
        objFrete.setCategFrete((TipoFrete) new TipoFrete().toObjectBase(jsonRetorno.getJSONObject("categFrete")));
        objFrete.setDistribuidoraSaida((Distribuidora) new Distribuidora().toObjectBase(jsonRetorno.getJSONObject("distribuidoraSaida")));
        objFrete.setDistribuidoraDestino((Distribuidora) new Distribuidora().toObjectBase(jsonRetorno.getJSONObject("distribuidoraDestino")));
        
        return objFrete;
            
    }
   
}
