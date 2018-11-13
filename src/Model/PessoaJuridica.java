/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.sql.ResultSet;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
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
       json.put("nomefantasia", getNomeFantasia());
       json.put("razaosocial", getRazaoSocial());
       json.put("cnpj", getCnpj()); 
       return json;
       
    }
    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        PessoaJuridica objPessoa = new PessoaJuridica();
        objPessoa.preencheAtributosRetorno(jsonRetorno);
        objPessoa.setCnpj(jsonRetorno.getString("cnpj"));
        objPessoa.setNomeFantasia(jsonRetorno.getString("nomefantasia"));
        objPessoa.setRazaoSocial(jsonRetorno.getString("razaosocial"));
        return objPessoa;
    }
    
    
}
