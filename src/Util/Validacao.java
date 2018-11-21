/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
public class Validacao
{
    //ADICIONEI UM PARAMETRO A MAIS PRA SER PASSADO O NOME DO CAMPO QUE ESTÁ SENDO TRATATO SÓ PRA ELE SER IMPRESSO NA MESAGEM DE ERRO!
    public static String InputToString (JTextField field, String nomeCampo) throws Error
    {
        if(field.getText().isEmpty())
        {
            String msg = "O Campo " + nomeCampo + " não pode estar vazio!";
            JOptionPane.showMessageDialog(null, msg);
            throw new Error(msg,new Throwable(field.getName() + " está vazio"));
        } else 
            return field.getText();
    }

    public static String InputToString(JPasswordField field, int tamanho) {
        String senha = String.valueOf(field.getPassword());
        try {
            if(InputToString(field, field.getName()).length() < tamanho)
            {
                String msg = "O Campo " + field.getName() + " não pode ser menor que " + tamanho;
                JOptionPane.showMessageDialog(null, msg);
                throw new Error(msg);
            } else
                return Util.MD5.Get(senha);
        } catch (Error ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void freteRadioButtonSelected(ButtonGroup group) throws Error{
        if(group.getSelection() == null){
            String msg = "Uma das opçoes de frete deve ser selecionada!";
            JOptionPane.showMessageDialog(null, msg);
            throw new Error(msg,new Throwable(group.getElements().toString()+ " está vazio"));
        }
    }
    public static void itensjTable(JTable tabela) throws Error{
        String msg = "";
        boolean tabelaAceita = true;
        if(tabela.getRowCount() == 0){
            msg = "A tabela deve conter elementos!";
            tabelaAceita = false;
        }else{
            for(int i = 0; i< tabela.getRowCount(); i++){
                for(int j = 0; j< tabela.getColumnCount(); j++){
                    if(tabela.getModel().getValueAt(i, j) == null){
                        msg = "Todos os dados na tabela devem estar preenchidos!";
                        tabelaAceita = false;
                    }
                }
            }
        }

           
        if(!tabelaAceita){
            JOptionPane.showMessageDialog(null, msg);
            throw new Error(msg,new Throwable(tabela.getName()+ " está vazio"));
        }
    }
}
