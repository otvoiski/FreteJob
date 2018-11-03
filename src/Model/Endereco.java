/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Endereco extends ObjectBase {
    
    private String Rua;
    private String Bairro;
    private String CEP;
    private String Numero;
    private String Complemento;
    private String Tipo;//indica o tipo do endereço(cobrança,entrega, etc)
    private Cidade cidade;
    private Estado estado;

    public Endereco(String Rua, String Bairro, String CEP, String Numero, String Tipo, Cidade cidade, Estado estado) {
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public JSONObject toJson() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
