/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author Professor
 */
public class ClienteFisico extends Model.Pessoa{

    private String Nome;
    private String Cpf;
    private String Rg;
    private Date data_Nascimento;
    private char Sexo;
    private Map<String,String> MidiaSociais;

        
    public ClienteFisico(){
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
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa toObjectBase(org.json.JSONObject jsonRetorno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
