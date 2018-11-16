/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@Entity
public class Distribuidora extends Pessoa{    
    public static enum TipoTransporte {TERRESTRES, AQUATICOS, AEROVIARIOS;}
    private String Cnpj;    
    private String RazaoSocial;
    private String NomeFantasia;
    @ManyToOne
    private List<Funcionario> Funcionarios;
    @ManyToMany
    private List<Cidade> CidadesAtuacao;

    public List<Cidade> getCidadesAtuacao() {
        return CidadesAtuacao;
    }

    public void setCidadesAtuacao(List<Cidade> CidadesAtuacao) {
        this.CidadesAtuacao = CidadesAtuacao;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.RazaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return NomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.NomeFantasia = nomeFantasia;
    }

    public List<Funcionario> getFuncionarios() {
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
       json.put("NomeFantasia", getNomeFantasia());
       json.put("RazaoSocial", getRazaoSocial());
       json.put("Cnpj", getCnpj());
       json.put("Funcionarios", getFuncionarios());
       json.put("CidadesAtuacao", getCidadesAtuacao());
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
       Distribuidora objDistribuidora = new Distribuidora();
       JSONArray arrayAux;
       objDistribuidora.preencheAtributosRetorno(jsonRetorno);
       objDistribuidora.setCnpj(jsonRetorno.getString("Cnpj"));
       objDistribuidora.setRazaoSocial(jsonRetorno.getString("RazaoSocial"));
       objDistribuidora.setNomeFantasia(jsonRetorno.getString("NomeFantasia"));
       if(jsonRetorno.has("Funcionarios")){
            arrayAux = jsonRetorno.getJSONArray("Funcionarios");
            for(int i = 0; i< arrayAux.length(); i++)
                objDistribuidora.getFuncionarios().add((Funcionario)new Funcionario().toObjectBase(arrayAux.getJSONObject(i)));
       }
       if(jsonRetorno.has("CidadesAtuacao")){
            arrayAux = jsonRetorno.getJSONArray("CidadesAtuacao");
            for(int i = 0; i< arrayAux.length(); i++)
                objDistribuidora.getCidadesAtuacao().add((Cidade)new Cidade().toObjectBase(arrayAux.getJSONObject(i)));
       }
       return objDistribuidora;
    }    
}
