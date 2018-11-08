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
    private Cidade Cidade;


    public Endereco(String Rua, String Bairro, String CEP, String Numero, String Tipo, Cidade cidade) {
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.Cidade = cidade;

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
        return Cidade;
    }

    public void setCidade(Cidade cidade) {
        this.Cidade = cidade;
    }
    @Override
    public JSONObject toJson() {
       JSONObject json = new JSONObject();
       
       json.put("codigo", getCodigo());
       json.put("rua",Rua);
       json.put("bairro",Bairro);
       json.put("cep",CEP);
       json.put("numero",Numero);
       json.put("complemento",Complemento);
       json.put("tipo",Tipo);
       json.put("cidade",Cidade.toJson());
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Cidade objCidade = new Cidade();
        Endereco objEndereco = new Endereco();
                
        objEndereco.setCodigo(jsonRetorno.getString("codigo"));
        objEndereco.setRua(jsonRetorno.getString("rua"));
        objEndereco.setBairro(jsonRetorno.getString("bairro"));
        objEndereco.setCEP(jsonRetorno.getString("cep"));
        objEndereco.setCidade((Cidade) objCidade.toObjectBase(jsonRetorno.getJSONObject("cidade")));
        objEndereco.setComplemento(jsonRetorno.getString("complemento"));
        objEndereco.setNumero(jsonRetorno.getString("numero"));
        objEndereco.setTipo(jsonRetorno.getString("tipo"));
        
        return objEndereco;
    }
    
    
}
