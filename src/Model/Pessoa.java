/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import Util.Enums;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */

@Entity
public abstract class Pessoa extends ObjectBase implements Serializable{
    private Util.Enums.TipoPessoa TipoPessoa;// variável para guardar se a pessoa se trata de cliente fisico,juridico, funcionario, ou é uma distribuidora  
    @OneToMany(mappedBy = "Telefone")
    private List<Telefone> Telefones;
    @OneToMany(mappedBy = "Endereco")
    private List<Endereco> Enderecos;
    @OneToMany(mappedBy = "MidiaSocial")
    private List<MidiaSocial> MidiaSociais;
    private List<Email> Emails;

    public ArrayList<Email> getEmails() {
        return (ArrayList<Email>)Emails;
    }

    public void setEmails(ArrayList<Email> Emails) {
        this.Emails = Emails;
    }
    
    public Pessoa() {
        Telefones = new ArrayList<>();
        Enderecos = new ArrayList<>();
        MidiaSociais = new ArrayList<>();
    }

    public Pessoa(Enums.TipoPessoa tipoPessoa, List<Telefone> telefones, List<Endereco> endereco, List<MidiaSocial> midiaSociais, List<Email> emails) {
        this.TipoPessoa = tipoPessoa;
        this.Telefones = telefones;
        this.Enderecos = endereco;
        this.MidiaSociais = midiaSociais;
        this.Emails = emails;
    }

    public ArrayList<Endereco> getEnderecos() {
        return (ArrayList<Endereco>)Enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }

    public Enums.TipoPessoa getTipoPessoa() {
        return TipoPessoa;
    }
    public void setTipoPessoa(Util.Enums.TipoPessoa tipoPessoa) {
        this.TipoPessoa = tipoPessoa;
    }
    public ArrayList<Telefone> getTelefones() {
        return (ArrayList<Telefone>)Telefones;
    }

    public void setTelefones(ArrayList<Telefone> Telefones) {
        this.Telefones = Telefones;
    }
    
     
    public  ArrayList<MidiaSocial>getMidiaSociais() {
        return(ArrayList<MidiaSocial>)MidiaSociais;
    }

    public void setMidiaSociais(ArrayList<MidiaSocial> MidiaSociais) {
        this.MidiaSociais = MidiaSociais;
    }
    
    protected JSONObject preencheJson(){
        JSONObject json = new JSONObject();
        json.put("Codigo", getCodigo());
        json.put("TipoPessoa",getTipoPessoa());
        json.put("Enderecos", getEnderecos());
        json.put("Telefones", getTelefones());
        json.put("MidiasSociais", getMidiaSociais());
        json.put("Emails", getEmails());
        
        return json;
    }
    protected void preencheAtributosRetorno(JSONObject jsonRetorno){
        JSONArray jsonArrayAux;
        setCodigo(jsonRetorno.getInt("Codigo"));
        if(jsonRetorno.has("TipoPessoa"))
            setTipoPessoa(jsonRetorno.getEnum(Util.Enums.TipoPessoa.class,"TipoPessoa"));
        if(jsonRetorno.has("MidiasSociais")){
            jsonArrayAux = jsonRetorno.getJSONArray("MidiasSociais");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                MidiaSociais.add((MidiaSocial) new MidiaSocial().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        if(jsonRetorno.has("Emails")){
            jsonArrayAux = jsonRetorno.getJSONArray("Emails");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                Emails.add((Email) new Email().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        jsonArrayAux = jsonRetorno.getJSONArray("Telefones");
        for(int i = 0; i<jsonArrayAux.length(); i++)
            Telefones.add((Telefone) new Telefone().toObjectBase(jsonArrayAux.getJSONObject(i)));
        
         jsonArrayAux = jsonRetorno.getJSONArray("Enderecos");
        for(int i = 0; i<jsonArrayAux.length(); i++)
            Enderecos.add((Endereco) new Endereco().toObjectBase(jsonArrayAux.getJSONObject(i)));
    }
}
