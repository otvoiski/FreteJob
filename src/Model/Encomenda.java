/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.json.JSONObject;

/**
 *
 * @author Professor
 */
@Entity
public class Encomenda extends ObjectBase {
    public static enum Estados {COLETA, TRANSITO, ENTREGE} 
    @OneToMany
    private Pessoa Emitente;
    @OneToMany
    private Pessoa Destinatario;
    @OneToMany
    private Endereco EndOrigem; //existem estes atributos de endereço pois existe a possibilidade da encomenda sair de um endereço que não é endereço do remetente e vice versa
    @OneToMany
    private Endereco EndDestino;
    @OneToMany
    private List<ObjetoEncomenda> Objetos;
    @ManyToMany
    private List<Distribuidora> DistribuidoraColeta;
    @ManyToMany
    private List<Funcionario> responsManipulacao;

    
    public ArrayList<Distribuidora> getDistribuidoraColeta() {
        return (ArrayList<Distribuidora>)DistribuidoraColeta;
    }

    public void setDistribuidoraColeta(ArrayList<Distribuidora> DistribuidoraColeta) {
        this.DistribuidoraColeta = DistribuidoraColeta;
    }

    public ArrayList<Funcionario> getResponsManipulacao() {
        return (ArrayList<Funcionario>)responsManipulacao;
    }

    public void setResponsManipulacao(ArrayList<Funcionario> responsManipulacao) {
        this.responsManipulacao = responsManipulacao;
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
