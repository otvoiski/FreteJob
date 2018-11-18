/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import javax.persistence.Entity;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
public class Funcionario extends Pessoa {

    private String Cpf;
    private String Rg;
    private String Nome;
    private Distribuidora LocalTrabalho;

    public Funcionario() {
        super();
    }
    
    public Funcionario(String Cpf, String Rg, String Nome, Distribuidora LocalTrabalho) {
        super();
        this.Cpf = Cpf;
        this.Rg = Rg;
        this.Nome = Nome;
        this.LocalTrabalho = LocalTrabalho;
    }

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

    public Distribuidora getLocalTrabalho() {
        return LocalTrabalho;
    }

    public void setLocalTrabalho(Distribuidora localTrabalho) {
        this.LocalTrabalho = localTrabalho;
    }
    
    @Override
    public JSONObject toJson() {
       JSONObject json = super.preencheJson();
       json.put("nome", getNome());
       json.put("cpf", getCpf());
       json.put("rg", getRg());
       json.put("localtrabalho", LocalTrabalho.toJson());
       return json;
    }
    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        Funcionario objFuncionario = new Funcionario();
        objFuncionario.preencheAtributosRetorno(jsonRetorno);
        objFuncionario.setNome(jsonRetorno.getString("nome"));
        objFuncionario.setCpf(jsonRetorno.getString("cpf"));
        objFuncionario.setRg(jsonRetorno.getString("rg"));
        objFuncionario.setLocalTrabalho((Distribuidora)new Distribuidora().toObjectBase(jsonRetorno.getJSONObject("localtrabalho")));
        return objFuncionario;
    }
}
