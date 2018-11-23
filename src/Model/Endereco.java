/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import Util.Enums;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class Endereco extends ObjectBase implements Serializable {
    
    private String Rua;
    private String Bairro;
    private String cep;
    private String Numero;
    private String Complemento;
    private Util.Enums.TipoEndereco Tipo;//indica o tipo do endereço(cobrança,entrega, etc)// IMPORTANTE

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Enums.TipoEndereco getTipo() {
        return Tipo;
    }

    public void setTipo(Enums.TipoEndereco Tipo) {
        this.Tipo = Tipo;
    }
    @ManyToOne
    private Cidade Cidade;


    public Endereco(String Rua, String Bairro, String cep, String Numero, Util.Enums.TipoEndereco Tipo, Cidade cidade) {
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.cep = cep;
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
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
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
       json.put("rua",getRua());
       json.put("bairro",getBairro());
       json.put("cep",getCEP());
       json.put("numero",getNumero());
       json.put("complemento",getComplemento());
       json.put("tipo",getTipo());
       json.put("cidade",Cidade.toJson());
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
        Cidade objCidade = new Cidade();
        Endereco objEndereco = new Endereco();
        if(jsonRetorno.has("codigo"))
            objEndereco.setCodigo(jsonRetorno.getInt("codigo"));
        else
            objEndereco.setCodigo(0);
        objEndereco.setRua(jsonRetorno.getString("rua"));
        objEndereco.setBairro(jsonRetorno.getString("bairro"));
        objEndereco.setCEP(jsonRetorno.getString("CEP"));
        objEndereco.setCidade((Cidade) objCidade.toObjectBase(jsonRetorno.getJSONObject("cidade")));
        if(jsonRetorno.has("complemento"))
            objEndereco.setComplemento(jsonRetorno.getString("complemento"));
        
        objEndereco.setNumero(jsonRetorno.getString("numero"));
        objEndereco.setTipo(jsonRetorno.getEnum(Util.Enums.TipoEndereco.class,"tipo"));
        
        return objEndereco;
    }
    
}
