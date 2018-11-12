/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
public class Distribuidora extends Pessoa{    
    public static enum TipoTransporte {TERRESTRES, AQUATICOS, AEROVIARIOS;}
    private String Cnpj;    
    private String RazaoSocial;
    private String NomeFantasia;
    private ArrayList<Funcionario> Funcionarios;

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

    public ArrayList<Funcionario> getFuncionarios() {
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
       return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno) {
       Distribuidora objDistribuidora = new Distribuidora();
       JSONArray arrayFuncs;
       objDistribuidora.preencheAtributosRetorno(jsonRetorno);
       objDistribuidora.setCnpj(jsonRetorno.getString("Cnpj"));
       objDistribuidora.setRazaoSocial(jsonRetorno.getString("RazaoSocial"));
       objDistribuidora.setNomeFantasia(jsonRetorno.getString("NomeFantasia"));
       if(jsonRetorno.has("Funcionarios")){
            arrayFuncs = jsonRetorno.getJSONArray("Funcionarios");
            for(int i = 0; i< arrayFuncs.length(); i++)
                objDistribuidora.getFuncionarios().add((Funcionario)new Funcionario().toObjectBase(arrayFuncs.getJSONObject(i)));
       }
       return objDistribuidora;
    }

    @Override
    public ObjectBase toObjectBase(ResultSet rs) {
        try {            
            super.setCodigo(rs.getString("Codigo"));
            Cnpj = rs.getString("Cnpj");
            NomeFantasia = rs.getString("NomeFantasia");
            RazaoSocial = rs.getString("RazaoSocial");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }
    
}
