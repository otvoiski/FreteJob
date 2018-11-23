/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Base.ObjectBase;
import Model.Email;
import Model.Endereco;
import Model.MidiaSocial;
import Model.Telefone;
import Util.Enums;
import Util.Enums.TipoPessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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

    private TipoPessoa TipoPessoa;// variável para guardar se a pessoa se trata de cliente fisico,juridico
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Telefone> Telefones;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Endereco> Enderecos;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<MidiaSocial> MidiaSociais;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Email> Emails;
    
    public Pessoa() {
        Telefones = new ArrayList<>();
        Enderecos = new ArrayList<>();
        MidiaSociais = new ArrayList<>();
    }
    
    public List<Email> getEmails() {
        return (List<Email>)Emails;
    }

    public void setEmails(List<Email> Emails) {
        this.Emails = Emails;
    }
    
    public Pessoa(Enums.TipoPessoa tipoPessoa, List<Telefone> telefones, List<Endereco> endereco, List<MidiaSocial> midiaSociais, List<Email> emails) {
        this.TipoPessoa = tipoPessoa;
        this.Telefones = telefones;
        this.Enderecos = endereco;
        this.MidiaSociais = midiaSociais;
        this.Emails = emails;
    }

    public List<Endereco> getEnderecos() {
        return (List<Endereco>)Enderecos;
    }

    public void setEnderecos(List<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }

    public Enums.TipoPessoa getTipoPessoa() {
        return TipoPessoa;
    }
    public void setTipoPessoa(Util.Enums.TipoPessoa tipoPessoa) {
        this.TipoPessoa = tipoPessoa;
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
    
    protected JSONObject preencheJson(){
        return new JSONObject(this);
    }
    protected void preencheAtributosRetorno(JSONObject jsonRetorno){
        JSONArray jsonArrayAux;
        setCodigo(jsonRetorno.getInt("codigo"));
        if(jsonRetorno.has("tipoPessoa"))
            setTipoPessoa(jsonRetorno.getEnum(Util.Enums.TipoPessoa.class,"tipoPessoa"));
        if(jsonRetorno.has("midiasSocias")){
            jsonArrayAux = jsonRetorno.getJSONArray("midiasSociais");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                MidiaSociais.add((MidiaSocial) new MidiaSocial().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        if(jsonRetorno.has("emails")){
            jsonArrayAux = jsonRetorno.getJSONArray("emails");
            for(int i = 0; i<jsonArrayAux.length(); i++)
                Emails.add((Email) new Email().toObjectBase(jsonArrayAux.getJSONObject(i)));
        }
        jsonArrayAux = jsonRetorno.getJSONArray("telefones");
        for(int i = 0; i<jsonArrayAux.length(); i++)
            Telefones.add((Telefone) new Telefone().toObjectBase(jsonArrayAux.getJSONObject(i)));
        
         jsonArrayAux = jsonRetorno.getJSONArray("enderecos");
        for(int i = 0; i<jsonArrayAux.length(); i++)
            Enderecos.add((Endereco) new Endereco().toObjectBase(jsonArrayAux.getJSONObject(i)));
    }
}
