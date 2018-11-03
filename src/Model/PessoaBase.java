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
 * @author Matheus
 */
public abstract class PessoaBase extends ObjectBase {
    private String tipoPessoa;// variável para guardar se a pessoa se trata de cliente fisico,juridico, funcionario, ou é uma distribuidora    
    private ArrayList<String> Telefones;
    private ArrayList<Endereco> Enderecos;

    public PessoaBase() {
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
        return tipoPessoa;
    }
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    public ArrayList<String> getTelefones() {
        return Telefones;
    }

    public void setTelefones(ArrayList<String> Telefones) {
        this.Telefones = Telefones;
    }
    
}
