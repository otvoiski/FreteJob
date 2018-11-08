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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String Sexo;
    private ArrayList<String> MidiaSociais;

    
    public PessoaFisica(ResultSet rs)
    {
        try {            
            super.setCodigo(rs.getString("Codigo"));
            Nome = rs.getString("Nome");
            Cpf = rs.getString("Cpf");
            Rg = rs.getString("Rg");
            DataNascimento = (new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("DataNascimento"));
            Sexo = rs.getString("Sexo");
            MidiaSociais = new ArrayList<>();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
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

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date data_Nascimento) {
        this.DataNascimento = data_Nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
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
         json.put("CPF", Cpf);
         json.put("TipoPessoa",getTipoPessoa());
         json.put("RG", Rg);
         
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String dataAtual = sdf.format(DataNascimento);         
          json.put("DataNascimento", dataAtual);
         
         json.put("Sexo", Sexo);
        json.put("MidiasSociais", MidiaSociais);
        json.put("Enderecos", getEnderecos());
        json.put("Telefones", getTelefones());
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
        objPessoa.setTipoPessoa(jsonRetorno.getString("TipoPessoa"));
        objPessoa.setTelefones((ArrayList)jsonRetorno.getJSONArray("Telefones").toList());
        objPessoa.setEnderecos((ArrayList)jsonRetorno.getJSONArray("Enderecos").toList());
        objPessoa.setNome(jsonRetorno.getString("Nome"));
        objPessoa.setCpf(jsonRetorno.getString("CPF"));
        objPessoa.setRg(jsonRetorno.getString("RG"));
        try {            
            objPessoa.setDataNascimento((new SimpleDateFormat()).parse(jsonRetorno.getString("DataNascimento")));
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
        objPessoa.setSexo(jsonRetorno.getString("Sexo"));
        objPessoa.setMidiaSociais((ArrayList)jsonRetorno.getJSONArray("MidiasSociais").toList());
        return objPessoa;
        
    }
}
