/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.Pessoa;
import Base.ObjectBase;
import javax.persistence.Entity;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class PessoaJuridica extends Pessoa{
    private String Cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    
    public PessoaJuridica(){
       super();
    }
    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public JSONObject toJson() {
       JSONObject json = super.preencheJson();
       json.put("nomeFantasia", getNomeFantasia());
       json.put("razaoSocial", getRazaoSocial());
       json.put("cnpj", getCnpj()); 
       return json;
       
    }
    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
                System.out.println(jsonRetorno);
        PessoaJuridica objPessoa = new PessoaJuridica();
        objPessoa.preencheAtributosRetorno(jsonRetorno);
        if(jsonRetorno.has("cnpj"))
            objPessoa.setCnpj(jsonRetorno.getString("cnpj"));
        objPessoa.setNomeFantasia(jsonRetorno.getString("nomeFantasia"));
        if(jsonRetorno.has("razaoSocial"))
            objPessoa.setRazaoSocial(jsonRetorno.getString("razaoSocial"));
        return objPessoa;
    }
    
    
}
