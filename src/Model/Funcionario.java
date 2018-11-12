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
public class Funcionario extends Pessoa {

    private String Cpf;
    private String Rg;
    private String Nome;
    private String identFuncional;
    private Distribuidora localTrabalho;

    
    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        this.Rg = rg;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getIdentFuncional() {
        return identFuncional;
    }

    public void setIdentFuncional(String identFuncional) {
        this.identFuncional = identFuncional;
    }

    public Distribuidora getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(Distribuidora localTrabalho) {
        this.localTrabalho = localTrabalho;
    }
    
    @Override
    public JSONObject toJson() {
       JSONObject json = super.preencheJson();
       json.put("nome", getNome());
       json.put("cpf", getCpf());
       json.put("rg", getRg());
       json.put("identidadefuncional", getIdentFuncional());
       json.put("localtrabalho", localTrabalho.toJson());
       return json;
    }
    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Funcionario objFuncionario = new Funcionario();
        objFuncionario.preencheAtributosRetorno(jsonRetorno);
        objFuncionario.setNome(jsonRetorno.getString("nome"));
        objFuncionario.setCpf(jsonRetorno.getString("cpf"));
        objFuncionario.setRg(jsonRetorno.getString("rg"));
        objFuncionario.setIdentFuncional(jsonRetorno.getString("identidadefuncional"));
        objFuncionario.setLocalTrabalho((Distribuidora)new Distribuidora().toObjectBase(jsonRetorno.getJSONObject("localtrabalho")));
        return objFuncionario;
    }

    @Override
    public ObjectBase toObjectBase(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
