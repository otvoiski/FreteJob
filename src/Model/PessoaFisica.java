/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Base.ObjectBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import org.json.JSONObject;

/**
 *
 * @author Professor
 */
@Entity
public class PessoaFisica extends Model.Pessoa{

    private String Nome;
    private String Cpf;
    private String Rg;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataNascimento;
    private String Sexo;

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
        if(jsonRetorno.has("cpf"))
            objPessoa.setCpf(jsonRetorno.getString("cpf"));
        if(jsonRetorno.has("rg"))
            objPessoa.setRg(jsonRetorno.getString("rg"));
        if(jsonRetorno.has("sexo"))
            objPessoa.setSexo(jsonRetorno.getString("sexo"));
        try {
            if(jsonRetorno.has("datanascimento"))
                objPessoa.DataNascimento = (new SimpleDateFormat("yyyy/MM/dd").parse(jsonRetorno.getString("datanascimento")));
        } catch (ParseException ex) {
            Logger.getLogger(PessoaFisica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objPessoa;
        
    }
}

