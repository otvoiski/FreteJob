/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JFrame;
import javax.swing.JTable;

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
}
