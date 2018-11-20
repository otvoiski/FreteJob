/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import Controller.DistanciaController;
import Util.Enums;
import Util.Enums.TipoFreteEncomenda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.json.JSONArray;
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
    private double valorCobrado;
    private TipoFreteEncomenda tipoFreteEscolhido;
    private String codRastreio;

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }


    public String getCodRastreio() {
        return codRastreio;
    }

    public void setCodRastreio(String codRastreio) {
        this.codRastreio = codRastreio;
    }

    public TipoFreteEncomenda getTipoFreteEscolhido() {
        return tipoFreteEscolhido;
    }

    public void setTipoFreteEscolhido(TipoFreteEncomenda tipoFreteEscolhido) {
        this.tipoFreteEscolhido = tipoFreteEscolhido;
    }
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
    public void calculaValorTransporte(){
        double pesoTotal = 0.0;
        double multipPeso;
        double multipModalFrete = 0;
        double distanciaPercorrer =  new DistanciaController().retornaDistanciaEntreCidades(EndOrigem.getCidade(), EndDestino.getCidade());
        
        for(ObjetoEncomenda obj:Objetos)
            pesoTotal+= obj.getPeso();
        
        if(pesoTotal < 1.0)
            multipPeso = 0.06;
        else if(pesoTotal >=1 && pesoTotal<3.0)
            multipPeso = 0.10;
        else if(pesoTotal >=3.0 && pesoTotal < 5.0)
            multipPeso = 0.15;
        else
             multipPeso = 0.20;
        
        if(tipoFreteEscolhido.compareTo(TipoFreteEncomenda.Normal) == 0)
            multipModalFrete = 1;
        else if(tipoFreteEscolhido.compareTo(TipoFreteEncomenda.Rapido) == 0)
             multipModalFrete = 1.2;
        else multipModalFrete = 1.5;
        
        this.valorCobrado = multipModalFrete*distanciaPercorrer*multipPeso*0.02;
                
    }
    public void gerarCodRastreamento(){
        if(tipoFreteEscolhido.compareTo(TipoFreteEncomenda.Normal) == 0)
            codRastreio += "NR";
        else if(tipoFreteEscolhido.compareTo(TipoFreteEncomenda.Rapido) == 0)
            codRastreio += "RP";
        else codRastreio += "SR";
    }
        
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Encomenda objEncomenda =  new Encomenda();
        JSONArray arrayAux;
        objEncomenda.setCodigo(jsonRetorno.getInt("codigo"));
        if(jsonRetorno.getJSONObject("emitente").getEnum(Util.Enums.TipoPessoa.class,"TipoPessoa").compareTo(Enums.TipoPessoa.Fisica) == 0){
            objEncomenda.setEmitente((Pessoa) new PessoaFisica().toObjectBase(jsonRetorno.getJSONObject("emitente"))); 
        }else
             objEncomenda.setEmitente((Pessoa) new PessoaJuridica().toObjectBase(jsonRetorno.getJSONObject("emitente")));
        
        if(jsonRetorno.getJSONObject("destinatario").getEnum(Util.Enums.TipoPessoa.class,"TipoPessoa").compareTo(Enums.TipoPessoa.Fisica)==0){
            objEncomenda.setEmitente((Pessoa) new PessoaFisica().toObjectBase(jsonRetorno.getJSONObject("destinatario"))); 
        }else
            objEncomenda.setEmitente((Pessoa) new PessoaJuridica().toObjectBase(jsonRetorno.getJSONObject("destinatario")));
        
        objEncomenda.setEndOrigem((Endereco) new Endereco().toObjectBase(jsonRetorno.getJSONObject("end_origem")));
        objEncomenda.setEndDestino((Endereco) new Endereco().toObjectBase(jsonRetorno.getJSONObject("end_destino")));
        arrayAux = jsonRetorno.getJSONArray("objetos");
        for(int i = 0; i< arrayAux.length(); i++){
            objEncomenda.getObjetos().add((ObjetoEncomenda) new ObjetoEncomenda().toObjectBase(arrayAux.getJSONObject(i)));
        }
        arrayAux = jsonRetorno.getJSONArray("distribuidora_coleta");
        for(int i = 0; i< arrayAux.length(); i++){
            objEncomenda.getDistribuidoraColeta().add((Distribuidora) new Distribuidora().toObjectBase(arrayAux.getJSONObject(i)));
        }
        arrayAux = jsonRetorno.getJSONArray("respons_manipulacao");
        for(int i = 0; i< arrayAux.length(); i++){
            objEncomenda.getResponsManipulacao().add((Funcionario) new Funcionario().toObjectBase(arrayAux.getJSONObject(i)));
        }
        objEncomenda.setValorCobrado(jsonRetorno.getDouble("valor_cobrado"));
        objEncomenda.setCodRastreio(jsonRetorno.getString("cod_rastreio"));
        
        return objEncomenda;
    }
}
