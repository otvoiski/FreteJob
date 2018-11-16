/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
            String msg = "O Campo " + field.getName() + " não pode está vázio!";
            JOptionPane.showMessageDialog(null, msg);
            throw new Error(msg,new Throwable(field.getName() + " está vazio"));
        } else 
            return field.getText();
    }

    public static String InputToString(JPasswordField field, int tamanho) {
        String senha = String.valueOf(field.getPassword());
        try {
            if(InputToString(field).length() < tamanho)
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
}
