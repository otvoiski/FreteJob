/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import DAO.FabricaConexao;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Libs Relatorio*/
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Otavio
 */
public class Relatorios {
    
    public void GerarRelatorio(String NomeRelatorio, String data, String[] rangeId) throws JRException{
        ResultSet rs = GetData(data, rangeId);
        JRResultSetDataSource jrsds = new JRResultSetDataSource(rs);
        String pathConfig = "Relatorios" + File.separator +  NomeRelatorio + ".jasper";
        String localPrint = JasperFillManager.fillReportToFile(pathConfig, null,jrsds);
        JasperViewer.viewReport(localPrint,false,false);
        JasperExportManager.exportReportToPdfFile(localPrint);
        
    }
    
    
    private ResultSet GetData(String data, String[] rangeId){

        String sql;
        
        int Inicio = Integer.parseInt(rangeId[0]);
        int Final = Integer.parseInt(rangeId[1]);
        
        switch(data){
            case "usuario":
                sql = "SELECT * FROM usuario LEFT JOIN categoria ON categoria_usr = codigo_cat WHERE codigo_usr BETWEEN "+Inicio+" AND "+Final;
                break;
            case "categoria":
                sql = "SELECT * FROM categoria WHERE codigo_cat BETWEEN "+Inicio+" AND "+Final;
                break;
            default:
                sql = "";
                break;
        }
        
        try {
            Connection conn = FabricaConexaoRelatorios.GeraConexaoSINGLETON();
            Statement stm = conn.createStatement();        
            return stm.executeQuery(sql);
        } catch (SQLException ex) {
            return null;
        }
    }
}
