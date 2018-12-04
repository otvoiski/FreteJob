/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            msg = "A tabela"+tabela.getName()+"deve conter elementos!";
            tabelaAceita = false;
        }else{
            for(int i = 0; i< tabela.getRowCount(); i++){
                for(int j = 0; j< tabela.getColumnCount(); j++){
                    if(tabela.getModel().getValueAt(i, j) == null || tabela.getModel().getValueAt(i, j).equals("")){
                        msg = "Todos os dados na tabela "+tabela.getName()+" devem estar preenchidos!";
                        tabelaAceita = false;
                    }
                }
            }
        }

           
        if(!tabelaAceita){
            throw new Error(msg,new Throwable(tabela.getName()+ " está vazio"));
        }
    }
    public static String converteDatePadraoBRToString(Date dataPadraoBrasileiro){
        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(dataPadraoBrasileiro);
    }
    public static String converteDatePadraoAmericanoToString(Date dataPadraoAmericano){
        SimpleDateFormat formato =  new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(dataPadraoAmericano);
    }
    public static Date converteStringToDate(String dataConverter){
        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formato.parse(dataConverter);
        } catch (ParseException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public static Date converteDatePadraoBrParaAmericano(Date dataConverter){
        String dataString = converteDatePadraoBRToString(dataConverter);
        String dd = dataString.substring(0, 2);
        String mm = dataString.substring(3, 5);
        String yyyy = dataString.substring(6, 10); 
        String dataPadraoAmericano = yyyy + "-" + mm + "-" + dd ;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formato.parse(dataPadraoAmericano);
        } catch (ParseException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public static Date converteDatePadraoBrParaAmericano(String dataConverter){
        String dd = dataConverter.substring(0, 2);
        String mm = dataConverter.substring(3, 5);
        String yyyy = dataConverter.substring(6, 10); 
        String dataPadraoAmericano = yyyy + "-" + mm + "-" + dd ;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formato.parse(dataPadraoAmericano);
        } catch (ParseException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return data;
    }
    public static Date converteDatePadraoAmericanoParaBr(Date dataConverter){
        String dataString = converteDatePadraoAmericanoToString(dataConverter);
        String dd = dataString.substring(8, 10);
        String mm = dataString.substring(5, 7);
        String yyyy = dataString.substring(0, 4); 
        String dataPadraoBR = dd + "/" + mm + "/" + yyyy ;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formato.parse(dataPadraoBR);
        } catch (ParseException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return data;
    }
     public static Date converteDatePadraoAmericanoParaBr(String dataConverter){
        String dd = dataConverter.substring(8, 10);
        String mm = dataConverter.substring(5, 7);
        String yyyy = dataConverter.substring(0, 4); 
        String dataPadraoBR = dd + "/" + mm + "/" + yyyy ;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formato.parse(dataPadraoBR);
        } catch (ParseException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return data;
    }
}
