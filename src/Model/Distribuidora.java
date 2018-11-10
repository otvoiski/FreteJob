/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
public class Distribuidora extends Pessoa{
    private String Cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private ArrayList<Funcionario> Funcionarios;

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

    public ArrayList<Funcionario> getFuncionarios() {
        return Funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.Funcionarios = funcionarios;
    }
    
    public Distribuidora() {
        super();
        Funcionarios = new ArrayList<>();
    }

    @Override
    public JSONObject toJson() {
       JSONObject json = super.preencheJson();
       json.put("nomefantasia", getNomeFantasia());
       json.put("razaosocial", getRazaoSocial());
       json.put("cnpj", getCnpj());
       json.put("funcionarios", getFuncionarios());
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
       Distribuidora objDistribuidora = new Distribuidora();
       JSONArray arrayFuncs;
       objDistribuidora.preencheAtributosRetorno(jsonRetorno);
       objDistribuidora.setCnpj(jsonRetorno.getString("cnpj"));
       objDistribuidora.setRazaoSocial(jsonRetorno.getString("razaosocial"));
       objDistribuidora.setNomeFantasia(jsonRetorno.getString("nomefantasia"));
       if(jsonRetorno.has("funcionarios")){
            arrayFuncs = jsonRetorno.getJSONArray("funcionarios");
            for(int i = 0; i< arrayFuncs.length(); i++)
                objDistribuidora.getFuncionarios().add((Funcionario)new Funcionario().toObjectBase(arrayFuncs.getJSONObject(i)));
       }
       return objDistribuidora;
    }
    
}
