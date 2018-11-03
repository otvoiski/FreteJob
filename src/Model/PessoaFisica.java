/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Professor
 */
public class PessoaFisica extends Model.Pessoa{

    private String Nome;
    private String Cpf;
    private String Rg;
    private Date DataNascimento;
    private char Sexo;
    private ArrayList<String> MidiaSociais;

    
    public PessoaFisica(ResultSet rs)
    {
        try {            
            super.setCodigo(rs.getString("Codigo"));
            Nome = rs.getString("Nome");
            Cpf = rs.getString("Cpf");
            Rg = rs.getString("Rg");
            DataNascimento = (new SimpleDateFormat("dd-MM-yyyy")).parse(rs.getString("DataNascimento"));
            Sexo = rs.getString("Sexo").toCharArray()[0];
            MidiaSociais = new ArrayList<>();
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
        
    public PessoaFisica(){
        super();
        MidiaSociais = new ArrayList<>();
    }
    
    public  ArrayList<String>getMidiaSociais() {
        return MidiaSociais;
    }

    public void setMidiaSociais(ArrayList<String> MidiaSociais) {
        this.MidiaSociais = MidiaSociais;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public Date getData_Nascimento() {
        return DataNascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.DataNascimento = data_Nascimento;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
         json.put("Codigo", getCodigo());
         json.put("Nome", Nome);
         json.put("Cpf", Cpf);
         json.put("Rg", Rg);
         json.put("DataNascimento", DataNascimento);
         json.put("Sexo", Sexo);
        json.put("Midias_Sociais", MidiaSociais);
        return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno){
        PessoaFisica objPessoa = new PessoaFisica();
      /*String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        java.util.Date d;
       try {
            d = sdf.parse(jsonRetorno.getString("Data_Nascimento"));
            objPessoa.setData_Nascimento(d);
        } catch (ParseException ex) {
            objPessoa.setData_Nascimento(null);
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        objPessoa.setCodigo(jsonRetorno.getString("Codigo"));
        objPessoa.setTipoPessoa(jsonRetorno.getString("Tipo_Pessoa"));
        objPessoa.setTelefones((ArrayList)jsonRetorno.getJSONArray("Telefones").toList());
        objPessoa.setEnderecos((ArrayList)jsonRetorno.getJSONArray("Enderecos").toList());
        objPessoa.setNome(jsonRetorno.getString("Nome"));
        objPessoa.setCpf(jsonRetorno.getString("CPF"));
        objPessoa.setRg(jsonRetorno.getString("RG"));
        objPessoa.setSexo(jsonRetorno.getString("Sexo").charAt(0));
        objPessoa.setMidiaSociais((ArrayList)jsonRetorno.getJSONArray("Midias_Sociais").toList());
        return objPessoa;
        
    }
}
