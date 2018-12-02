/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Base.ObjectBase;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Util.Enums.Sexo Sexo;

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

    public Util.Enums.Sexo getSexo() {
        return Sexo;
    }

    public void setSexo(Util.Enums.Sexo Sexo) {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(DataNascimento);         
        json.put("dataNascimento", data);
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
            objPessoa.setSexo(jsonRetorno.getEnum(Util.Enums.Sexo.class, "sexo"));

        if(jsonRetorno.has("dataNascimento"))
            objPessoa.setDataNascimento(Util.Validacao.converteDatePadraoBrParaAmericano(jsonRetorno.getString("dataNascimento")));
            

        return objPessoa;
        
    }
}

