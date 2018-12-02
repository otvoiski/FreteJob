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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */

@Entity
@Table(name = "Pessoa")
public abstract class Pessoa extends ObjectBase implements Serializable{
    @Column(nullable = false)
    private Enums.NaturezaPessoa NaturezaPessoa;// variável para guardar se a pessoa se trata de cliente fisico,juridico
    private Enums.TipoPessoa TipoPessoa;// variável para guardar se a pessoa se trata de cliente, funcionario, ou distribuidora
    @OneToMany(cascade = CascadeType.ALL)
    private List<Telefone> Telefones;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> Enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MidiaSocial> MidiaSociais;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> Emails;
    
    public Pessoa() {
        Telefones = new ArrayList<>();
        Enderecos = new ArrayList<>();
        MidiaSociais = new ArrayList<>();
        Emails =  new ArrayList<>();
    }
    
    public List<Email> getEmails() {
        return (List<Email>)Emails;
    }

    public void setEmails(List<Email> Emails) {
        this.Emails = Emails;
    }
    
public Pessoa(Enums.NaturezaPessoa naturezaPessoa, List<Telefone> telefones, List<Endereco> endereco, List<MidiaSocial> midiaSociais, List<Email> emails, Enums.TipoPessoa tipoPessoa) {
        this.NaturezaPessoa = naturezaPessoa;
        this.Telefones = telefones;
        this.Enderecos = endereco;
        this.MidiaSociais = midiaSociais;
        this.Emails = emails;
        this.TipoPessoa = tipoPessoa;
    }

    public List<Endereco> getEnderecos() {
        return (List<Endereco>)Enderecos;
    }

    public void setEnderecos(List<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }

    public Enums.NaturezaPessoa getNaturezaPessoa() {
        return NaturezaPessoa;
    }
    public void setNaturezaPessoa(Util.Enums.NaturezaPessoa tipoPessoa) {
        this.NaturezaPessoa = tipoPessoa;
    }
    public List<Telefone> getTelefones() {
        return (List<Telefone>)Telefones;
    }

    public void setTelefones(List<Telefone> Telefones) {
        this.Telefones = Telefones;
    }
    
     
    public  List<MidiaSocial>getMidiaSociais() {
        return(List<MidiaSocial>)MidiaSociais;
    }

    public void setMidiaSociais(List<MidiaSocial> MidiaSociais) {
        this.MidiaSociais = MidiaSociais;
    }
    
    public Enums.TipoPessoa getTipoPessoa() {
        return TipoPessoa;
    }

    public void setTipoPessoa(Enums.TipoPessoa TipoPessoa) {
        this.TipoPessoa = TipoPessoa;
    }
    
    protected JSONObject preencheJson(){
        return new JSONObject(this);
    }
    protected void preencheAtributosRetorno(JSONObject jsonRetorno){
        JSONArray jsonArrayAux;
        if(jsonRetorno.has("codigo"))
            setCodigo(jsonRetorno.getInt("codigo"));
        else
            setCodigo(0);
        if(jsonRetorno.has("naturezaPessoa"))
            setNaturezaPessoa(jsonRetorno.getEnum(Util.Enums.NaturezaPessoa.class,"naturezaPessoa"));
        if(jsonRetorno.has("tipoPessoa")){
            setTipoPessoa(jsonRetorno.getEnum(Util.Enums.TipoPessoa.class, "tipoPessoa"));
        }
        if(jsonRetorno.has("midiasSociais")){
            jsonArrayAux = jsonRetorno.getJSONArray("midiasSociais");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                MidiaSociais.add((MidiaSocial) new MidiaSocial().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        if(jsonRetorno.has("emails")){
            jsonArrayAux = jsonRetorno.getJSONArray("emails");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                Emails.add((Email) new Email().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        if(jsonRetorno.has("telefones")){
            jsonArrayAux = jsonRetorno.getJSONArray("telefones");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                Telefones.add((Telefone) new Telefone().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        if(jsonRetorno.has("enderecos")){
            jsonArrayAux = jsonRetorno.getJSONArray("enderecos");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                Enderecos.add((Endereco) new Endereco().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
    }
}
