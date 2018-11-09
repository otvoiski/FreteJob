/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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


    public Pessoa() {
        Telefones = new ArrayList<>();
        Enderecos = new ArrayList<>();
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
    protected JSONObject preencheJson(){
        JSONObject json = new JSONObject();
        json.put("codigo", getCodigo());
        json.put("tipopessoa",getTipoPessoa());
        json.put("enderecos", getEnderecos());
        json.put("telefones", getTelefones());
        return json;
    }
    protected void preencheAtributos(JSONObject jsonRetorno){
        Telefone telAux;
        JSONArray jsonArrayAux;
        Cidade cidAux = new Cidade();
        Endereco endAux;
        setCodigo(jsonRetorno.getString("codigo"));
        TipoPessoa = jsonRetorno.getString("tipopessoa");
        
        jsonArrayAux = jsonRetorno.getJSONArray("telefones");
        for(int i = 0; i<jsonArrayAux.length(); i++){
            telAux = new Telefone(jsonArrayAux.getJSONObject(i).getString("ddd"),jsonArrayAux.getJSONObject(i).getString("numero"));
            telAux.setCodigo(jsonArrayAux.getJSONObject(i).getString("codigo"));
            Telefones.add(telAux);
        }
        
         jsonArrayAux = jsonRetorno.getJSONArray("enderecos");
        for(int i = 0; i<jsonArrayAux.length(); i++){
            cidAux = (Cidade) cidAux.toObjectBase(jsonArrayAux.getJSONObject(i).getJSONObject("cidade"));
            endAux = new Endereco(
                jsonArrayAux.getJSONObject(i).getString("rua"),
                    jsonArrayAux.getJSONObject(i).getString("bairro"),
                    jsonArrayAux.getJSONObject(i).getString("CEP"),
                    jsonArrayAux.getJSONObject(i).getString("numero"),
                    jsonArrayAux.getJSONObject(i).getString("tipo"),
                    cidAux
                    
            );
            endAux.setCodigo(jsonArrayAux.getJSONObject(i).getString("codigo"));
            endAux.setComplemento(jsonArrayAux.getJSONObject(i).getString("complemento"));
            Enderecos.add(endAux);
        }
    }
}
