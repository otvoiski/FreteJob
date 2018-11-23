/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Otavio
 */
public class Helper {
    public static void ShowDialog(JFrame thisFrame, JFrame target) {        
        target.setVisible(true);
        thisFrame.enable(false);
    }
    public static void CloseDialog(JFrame thisFrame, JFrame windowsBack) {        
        thisFrame.setVisible(false);
        thisFrame.dispose();
        windowsBack.enable(true);
    }

    public static Object GetValueJTable(JTable jTable, int column) {
        if(jTable.getSelectedRow() != -1){
            int linha = jTable.getSelectedRow();
            return jTable.getValueAt(linha,column);
        } else return false;
    }
    
    public static String GetValorToReal(double Valor){
        BigDecimal valor = new BigDecimal (Valor);  
        NumberFormat nf = NumberFormat.getCurrencyInstance();  
        String formatado = nf.format (valor);
        return formatado;
    }

    public static void RemoveRowJTable(JTable jTable1) {
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        if (jTable1.getSelectedRow() >= 0){
            dtm.removeRow(jTable1.getSelectedRow());
            jTable1.setModel(dtm);
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }       
    }
}
