/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Matheus
 */
public class TelaHandler{
    private JButton jbIncluir, jbGravar, jbCancelar, jbExcluir, jbConsultar;
    private ArrayList<JTextField> campos;


    public TelaHandler(JButton jbIncluir, JButton jbGravar, JButton jbCancelar, JButton jbExcluir, JButton jbConsultar) {
        this.jbIncluir = jbIncluir;
        this.jbGravar = jbGravar;
        this.jbCancelar = jbCancelar;
        this.jbExcluir = jbExcluir;
        this.jbConsultar = jbConsultar;
        this.campos = new ArrayList<>();
    }
    public void limparTela(){
        for(JTextField campo : campos)
            campo.setText("");
    }
    public void ativaGravar(boolean ativar){
        this.limparTela();
        jbCancelar.setEnabled(ativar);
        jbIncluir.setEnabled(!ativar);
        jbGravar.setEnabled(ativar);
        jbExcluir.setEnabled(!ativar);
        jbConsultar.setEnabled(!ativar);
        for(JTextField campo : campos)
            campo.setEnabled(ativar);
        
    }
    public void setCampos(ArrayList<JTextField> campos) {
        this.campos = campos;
    }

}
