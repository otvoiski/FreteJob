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


    public Endereco(String Rua, String Bairro, String CEP, String Numero, String Tipo, Cidade cidade) {
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.cidade = cidade;

    }
    
    public Endereco(){};

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
    @Override
    public JSONObject toJson() {
       JSONObject json = new JSONObject();
       
       json.put("Codigo", getCodigo());
       json.put("Rua",Rua);
       json.put("Bairro",Bairro);
       json.put("CEP",CEP);
       json.put("Numero",Numero);
       json.put("Complemento",Complemento);
       json.put("Tipo",Tipo);
       json.put("Cidade",cidade.toJson());
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Cidade objCidade = new Cidade();
        Endereco objEndereco = new Endereco();
        
        objEndereco.setRua(jsonRetorno.getString("Rua"));
        objEndereco.setBairro(jsonRetorno.getString("Bairro"));
        objEndereco.setCEP(jsonRetorno.getString("CEP"));
        objEndereco.setCidade((Cidade) objCidade.toObjectBase(jsonRetorno.getJSONObject("Cidade")));
        objEndereco.setComplemento(jsonRetorno.getString("Complemento"));
        objEndereco.setNumero(jsonRetorno.getString("Numero"));
        objEndereco.setTipo(jsonRetorno.getString("Tipo"));
        
        return objEndereco;
    }
    
    
}
