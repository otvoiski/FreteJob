/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import Util.Enums;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "Funcionario")
public class Funcionario extends Pessoa {
    @Column(nullable = false)
    private String Cpf;
    @Column(nullable = false)
    private String Rg;
    @Column(nullable = false)
    private String Nome;
    @ManyToOne
    private Distribuidora LocalTrabalho;

    public Funcionario() {
        super();
    }
    
    public Funcionario(String Cpf, String Rg, String Nome, Distribuidora LocalTrabalho) {
        super(Enums.NaturezaPessoa.Fisica, null, null, null, null);
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
        if(jsonRetorno.has("nome"))
            objFuncionario.setNome(jsonRetorno.getString("nome"));
        if(jsonRetorno.has("cpf"))
            objFuncionario.setCpf(jsonRetorno.getString("cpf"));
        if(jsonRetorno.has("rg"))
            objFuncionario.setRg(jsonRetorno.getString("rg"));
        if(jsonRetorno.has("localTrabalho"))
            objFuncionario.setLocalTrabalho((Distribuidora)new Distribuidora().toObjectBase(jsonRetorno.getJSONObject("localTrabalho")));
        
        return objFuncionario;
    }
}
