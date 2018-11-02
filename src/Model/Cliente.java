<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author Professor
 */
public class Cliente extends Model.ObjectBase{

    private String Nome;
    private String Endereco;
    private Map<String,String> MidiaSociais;
    private ArrayList<String> Telefones;
    
    @Override
    public String[] toVector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(String[] vector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        System.out.println("Apenas um teste");
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public Map<String, String> getMidiaSociais() {
        return MidiaSociais;
    }

    public void setMidiaSociais(Map<String, String> MidiaSociais) {
        this.MidiaSociais = MidiaSociais;
    }

    public ArrayList<String> getTelefones() {
        return Telefones;
    }

    public void setTelefones(ArrayList<String> Telefones) {
        this.Telefones = Telefones;
    }
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author Professor
 */
public class Cliente extends Model.ObjectBase{
    private String Codigo = super.getCodigo();
    private String Nome;
    private String Endereco;
    private Map<String,String> MidiaSociais;
    private ArrayList<String> Telefones;
    
    @Override
    public String[] toVector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(String[] vector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public Map<String, String> getMidiaSociais() {
        return MidiaSociais;
    }

    public void setMidiaSociais(Map<String, String> MidiaSociais) {
        this.MidiaSociais = MidiaSociais;
    }

    public ArrayList<String> getTelefones() {
        return Telefones;
    }

    public void setTelefones(ArrayList<String> Telefones) {
        this.Telefones = Telefones;
    }
    
    
}
>>>>>>> dev
