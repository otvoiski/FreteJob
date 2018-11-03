/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Otavio
 */
public class Validacao
{
    public static String InputToString (JTextField field) throws Exception
    {
        if(field.getText().isEmpty())
        {
            String msg = "O Campo " + field.getName() + " não pode está vázio!";
            JOptionPane.showMessageDialog(null, msg);
            throw new Exception(msg,new Throwable(field.getName() + " está vazio"));
        } else 
            return field.getText();
    }
    
    public static String InpuToString (JTextField field, int tamanho) throws Exception
    {        
        if(InputToString(field).length() < tamanho)
        {        
            String msg = "O Campo " + field.getName() + " não pode ser menor que " + tamanho;
            JOptionPane.showMessageDialog(null, msg);
            throw new Exception(msg);
        } else
            return field.getText();
    }
}
