/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "Distribuidora")
public class Distribuidora extends Pessoa{    
    private String Cnpj;    
    private String RazaoSocial;
    private String NomeFantasia;
    @ManyToMany
    private List<Cidade> CidadesAtuacao;

    public Distribuidora(String cnpj, String razaoSocial, String nomeFantasia, List<Cidade> cidadesAtuacao, List<Telefone> telefones, List<Endereco> endereco, List<MidiaSocial> midiaSociais,List<Email> emails ) {
        super(Util.Enums.TipoPessoa.Juridica, telefones, endereco, midiaSociais, emails);        
        this.Cnpj = cnpj;
        this.RazaoSocial = razaoSocial;
        this.NomeFantasia = nomeFantasia;
        this.CidadesAtuacao = cidadesAtuacao;
    }
    
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
    
    public Distribuidora() {
        super();
    }

    @Override
    public JSONObject toJson() {
       JSONObject json = super.preencheJson();
       json.put("NomeFantasia", getNomeFantasia());
       json.put("RazaoSocial", getRazaoSocial());
       json.put("Cnpj", getCnpj());
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
       if(jsonRetorno.has("CidadesAtuacao")){
            arrayAux = jsonRetorno.getJSONArray("CidadesAtuacao");
            for(int i = 0; i< arrayAux.length(); i++)
                objDistribuidora.getCidadesAtuacao().add((Cidade)new Cidade().toObjectBase(arrayAux.getJSONObject(i)));
       }
       return objDistribuidora;
    }    
}
