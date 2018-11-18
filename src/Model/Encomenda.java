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
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Professor
 */
@Entity
public class Encomenda extends ObjectBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Pessoa Emitente;
    @ManyToOne
    private Pessoa Destinatario;
    @ManyToOne
    private Endereco EndOrigem; //existem estes atributos de endereço pois existe a possibilidade da encomenda sair de um endereço que não é endereço do remetente e vice versa
    @ManyToOne
    private Endereco EndDestino;    
    @ManyToMany
    private List<ObjetoEncomenda> Objetos;
    @ManyToMany
    private List<Distribuidora> DistribuidoraColeta;
    @ManyToMany
    private List<Funcionario> ResponsManipulacao;

    
    public ArrayList<Distribuidora> getDistribuidoraColeta() {
        return (ArrayList<Distribuidora>)DistribuidoraColeta;
    }

    public void setDistribuidoraColeta(ArrayList<Distribuidora> DistribuidoraColeta) {
        this.DistribuidoraColeta = DistribuidoraColeta;
    }

    public ArrayList<Funcionario> getResponsManipulacao() {
        return (ArrayList<Funcionario>)ResponsManipulacao;
    }

    public void setResponsManipulacao(ArrayList<Funcionario> responsManipulacao) {
        this.ResponsManipulacao = responsManipulacao;
    }

    public Pessoa getEmitente() {
        return Emitente;
    }

    public void setEmitente(Pessoa Emitente) {
        this.Emitente = Emitente;
    }

    public Pessoa getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(Pessoa Destinatario) {
        this.Destinatario = Destinatario;
    }

    public Endereco getEndOrigem() {
        return EndOrigem;
    }

    public void setEndOrigem(Endereco EndOrigem) {
        this.EndOrigem = EndOrigem;
    }

    public Endereco getEndDestino() {
        return EndDestino;
    }

    public void setEndDestino(Endereco EndDestino) {
        this.EndDestino = EndDestino;
    }

    public ArrayList<ObjetoEncomenda> getObjetos() {
        return (ArrayList<ObjetoEncomenda>)Objetos;
    }

    public void setObjetos(ArrayList<ObjetoEncomenda> Objetos) {
        this.Objetos = Objetos;
    }
        
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
