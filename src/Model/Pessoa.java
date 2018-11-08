/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public abstract class Pessoa extends ObjectBase {
    private String TipoPessoa;// variável para guardar se a pessoa se trata de cliente fisico,juridico, funcionario, ou é uma distribuidora    
    private ArrayList<Telefone> Telefones;
    private ArrayList<Endereco> Enderecos;

    public Pessoa() {
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
        return TipoPessoa;
    }
    public void setTipoPessoa(String tipoPessoa) {
        this.TipoPessoa = tipoPessoa;
    }
    public ArrayList<Telefone> getTelefones() {
        return Telefones;
    }

    public void setTelefones(ArrayList<Telefone> Telefones) {
        this.Telefones = Telefones;
    }
    
}
