/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
public class Validacao
{
    
    public static String InputToString (JTextField field) throws Error
    {
        if(field.getText().isEmpty())
        {
            throw new Error("O Campo " + field.getName() + " não pode estar vazio!",
                  new Throwable(field.getName() + " está vazio"));
        } else 
            return field.getText();
    }
    public static String InputToString(JPasswordField field, int tamanho) throws Error 
    {
        String senha = String.valueOf(field.getPassword());
        
        if(InputToString(field).length() < tamanho)
        {
            throw new Error("O Campo " + field.getName() + " não pode ser menor que " + tamanho);
        } else
            return Util.MD5.Get(senha);
    }
    public static String freteRadioButtonSelected(ButtonGroup group) throws Error{
        if(group.getSelection() == null){
            throw new Error("Uma das opçoes de frete deve ser selecionada!" ,
                  new Throwable(group.getElements().toString()+ " está vazio"));
        } else {
            Enumeration button = group.getElements();
            while(button.hasMoreElements()){
                JRadioButton b = (JRadioButton) button.nextElement();
                if(b.isSelected())
                    return b.getText();
            }
        }
        return null;
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
