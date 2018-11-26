/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
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

    public static void RemoveRowJTable(JTable jTable) {
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        if (jTable.getSelectedRow() >= 0){
            dtm.removeRow(jTable.getSelectedRow());
            jTable.setModel(dtm);
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }       
    }

    public static void NewRowOnJTable(JTable jTable) {        
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        dtm.addRow(new Object[]{});
        jTable.setModel(dtm);
    }
    
    public static void NewRowOnJTable(JTable jTable, Object[] obj) {        
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        dtm.addRow(obj);
        jTable.setModel(dtm);
    }
    
    public static ArrayList<String[]> GetArrayToJTable(JTable jTable) throws Error {
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        if(dtm.getRowCount() != 0){
            ArrayList<String[]> list = new ArrayList<>();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String[] value = new String[dtm.getColumnCount()];
                for (int j = 0; j < dtm.getColumnCount(); j++) {
                    value[j] = (String) dtm.getValueAt(i, j) + "";
                }
                list.add(value);
            }
            return list;
        } else throw new Error("A Tabela está vazia!");
    }
}
