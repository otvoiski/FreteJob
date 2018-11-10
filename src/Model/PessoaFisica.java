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
    private String Sexo;

    
    public PessoaFisica(ResultSet rs)
    {
        try {            
            super.setCodigo(rs.getString("Codigo"));
            Nome = rs.getString("Nome");
            Cpf = rs.getString("Cpf");
            Rg = rs.getString("Rg");
            DataNascimento = (new SimpleDateFormat("yyyy/MM/dd")).parse(rs.getString("DataNascimento"));
            Sexo = rs.getString("Sexo");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public PessoaFisica(){
        super();
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
        JSONObject json = super.preencheJson();
        json.put("nome", getNome());
        json.put("cpf", getCpf());
        json.put("rg", getRg());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String data = sdf.format(DataNascimento);         
        json.put("datanascimento", data);
        json.put("sexo", getSexo());
        return json;
    }

    @Override
    public ObjectBase toObjectBase(org.json.JSONObject jsonRetorno){
        PessoaFisica objPessoa = new PessoaFisica();
        objPessoa.preencheAtributosRetorno(jsonRetorno);
        objPessoa.setNome(jsonRetorno.getString("nome"));
        objPessoa.setCpf(jsonRetorno.getString("cpf"));
        objPessoa.setRg(jsonRetorno.getString("rg"));
        objPessoa.setSexo(jsonRetorno.getString("sexo"));
        try {
            objPessoa.DataNascimento = (new SimpleDateFormat("yyyy/MM/dd").parse(jsonRetorno.getString("datanascimento")));
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPessoa;
        
    }
}
