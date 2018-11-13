/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public abstract class Pessoa extends ObjectBase{
    private String TipoPessoa;// variável para guardar se a pessoa se trata de cliente fisico,juridico, funcionario, ou é uma distribuidora    
    private ArrayList<Telefone> Telefones;
    private ArrayList<Endereco> Enderecos;
    private ArrayList<String> MidiaSociais;
    
    public Pessoa() {
        Telefones = new ArrayList<>();
        Enderecos = new ArrayList<>();
        MidiaSociais = new ArrayList<>();
    }

    public ArrayList<Endereco> getEnderecos() {
        return Enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> Enderecos) {
        this.Enderecos = Enderecos;
    }

    public String getTipoPessoa() {
        return TipoPessoa;
    }
    public void setTipoPessoa(String tipoPessoa) {
        this.TipoPessoa = tipoPessoa;
    }
    public ArrayList<Telefone> getTelefones() {
        return Telefones;
    }

    public void setTelefones(ArrayList<Telefone> Telefones) {
        this.Telefones = Telefones;
    }
    
     
    public  ArrayList<String>getMidiaSociais() {
        return MidiaSociais;
    }

    public void setMidiaSociais(ArrayList<String> MidiaSociais) {
        this.MidiaSociais = MidiaSociais;
    }
    
    protected JSONObject preencheJson(){
        JSONObject json = new JSONObject();
        json.put("Codigo", getCodigo());
        json.put("TipoPessoa",getTipoPessoa());
        json.put("Enderecos", getEnderecos());
        json.put("Telefones", getTelefones());
        json.put("MidiasSociais", getMidiaSociais());
        
        return json;
    }
    protected void preencheAtributosRetorno(JSONObject jsonRetorno){
        JSONArray jsonArrayAux;
        setCodigo(jsonRetorno.getInt("Codigo"));
        if(jsonRetorno.has("TipoPessoa"))
            setTipoPessoa(jsonRetorno.getString("TipoPessoa"));
        if(jsonRetorno.has("MidiasSociais")){
            JSONArray auxMidias = jsonRetorno.getJSONArray("MidiasSociais");
            for(int i = 0; i<auxMidias.length(); i++){
                getMidiaSociais().add((String)auxMidias.get(i));
            }
        }
        jsonArrayAux = jsonRetorno.getJSONArray("Telefones");
        for(int i = 0; i<jsonArrayAux.length(); i++)
            Telefones.add((Telefone) new Telefone().toObjectBase(jsonArrayAux.getJSONObject(i)));
        
         jsonArrayAux = jsonRetorno.getJSONArray("Enderecos");
        for(int i = 0; i<jsonArrayAux.length(); i++)
            Enderecos.add((Endereco) new Endereco().toObjectBase(jsonArrayAux.getJSONObject(i)));
    }
}
