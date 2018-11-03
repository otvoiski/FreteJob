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
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
    private Map<String,String> MidiaSociais;

    
    public PessoaFisica(ResultSet rs)
    {
        try {            
            super.setCodigo(rs.getString("Codigo"));
            Nome = rs.getString("Nome");
            Cpf = rs.getString("Cpf");
            Rg = rs.getString("Rg");
            DataNascimento = (new SimpleDateFormat("dd-MM-yyyy")).parse(rs.getString("DataNascimento"));
            Sexo = rs.getString("Sexo").toCharArray()[0];
            MidiaSociais = new HashMap<>();
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
        
    public PessoaFisica(){
        super();
        MidiaSociais = new HashMap<>();
    }
    
    public Map<String, String> getMidiaSociais() {
        return MidiaSociais;
    }

    public void setMidiaSociais(Map<String, String> MidiaSociais) {
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
         return json;
    }

    @Override
    public Pessoa toObjectBase(org.json.JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
