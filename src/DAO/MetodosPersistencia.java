/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ObjectBase;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class MetodosPersistencia {

    public static boolean Query(String query) {
        Connection conn = FabricaConexao.GetTransaction();
        try {            
            PreparedStatement ps = conn.prepareStatement(query);
            return FabricaConexao.CommitTransaction(conn, (ps.executeUpdate() > 0));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            FabricaConexao.CloseConnection(conn);
        }
    }
    private static ObjectBase SetObject(Class classe, ResultSet rs){
        try {             
            Constructor ctor = classe.getDeclaredConstructor(ResultSet.class);
            ctor.setAccessible(true);
            ObjectBase obj = (ObjectBase) ctor.newInstance(rs);
            return obj;            
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   public static String getValue(Field field, Object obj) {
       field.setAccessible(true);
        try {
            return (String) field.get(obj);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);    
            return null;
        }
   }
    
    
    /**
     * Inserir
     * @param obj 
     * @return  
     */
    public static boolean persistir(Object obj) {
        /*
        String query = "Insert into " + obj.getClass().getSimpleName() + " ( ";
        for (int i = 0; i < obj.getClass().getDeclaredFields().length; i++) {
            query += obj.getClass().getDeclaredFields()[i].getName();
            if(i < obj.getClass().getDeclaredFields().length-1)
                query += ", ";
        }
        query += " ) values ( ";
        for (int i = 0; i < obj.getClass().getDeclaredFields().length; i++) {
            try {
                query += "'" + getValue(obj.getClass().getDeclaredFields()[i], obj.getClass()) + "'";
            } catch (SecurityException ex) {
                Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(i < obj.getClass().getDeclaredFields().length-1)
                query += ", ";
        }
        
        query += " )";
        */
        String query = "Insert into " + obj.getClass().getSimpleName() + " ( ";
        for (int i = 0; i < obj.getClass().getDeclaredFields().length; i++) {
            query += obj.getClass().getDeclaredFields()[i].getName();
            if(i < obj.getClass().getDeclaredFields().length-1)
                query += ", ";
        }
        query += " ) values ( ?, ? )";      
        
        return Query(query);
    }
    
    /**
     * Update
     * @param obj 
     */
    public static void fundir(Object obj) {
        
    }
    
    public static boolean excluir(String chave, Class classe) throws SQLException{
        String query = "delete from " + classe.getSimpleName() + " where Codigo = " + chave;        
        return Query(query);        
    }
    
    
    public static ObjectBase recuperar(String chave, Class classe) throws SQLException{
        Connection conexao = FabricaConexao.NewSingleton();
        String query = "select * from " + classe.getSimpleName() + " where Codigo = " + chave;        
        PreparedStatement ps = conexao.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        try 
        {            
            if(rs.next())
            {
                return SetObject(classe, rs);
            } else
                return null;
        } catch (SQLException e){
            return null;
        } finally {
            conexao.close();
        }
    }
    
    public static List<?> selecionar(Class classe, String whereJPQL) throws SQLException {
        Connection conn = FabricaConexao.NewSingleton();
        String sJPQL = "select * from " + classe.getSimpleName() + " " + whereJPQL;
        PreparedStatement ps = conn.prepareStatement(sJPQL);
        ResultSet rs = ps.executeQuery();
        
        try {
            ArrayList<Object> list = new ArrayList<>();
            int colunas = rs.getMetaData().getColumnCount();
            while (rs.next()) {                
                Object obj = classe.newInstance();
                for (int i = 0; i < colunas; i++) {
                    String nomeColuna = classe.getDeclaredFields()[i].getName();
                    System.out.println(rs.getString(nomeColuna));                    
                }
                list.add(obj);
            }
            return list;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println( "Falha ao adicionar os items na lista" );
            return null;
        } finally {
            conn.close();
        }
    }

    public List<?> selecionar(Class classe, String[][] parametros) {
        String where = "";
        if (parametros.length > 0) {
            for (int i = 0; i < parametros.length; i++) {
                if (i == 0) {
                    where = where + " where ";
                } else {
                    where = where + " and ";
                }

                String campo = parametros[i][0];
                String valor = parametros[i][1];
                where = where + campo + " = '" + valor + "'";
            }
        }
        try {
            return selecionar(classe, where);
        } catch (SQLException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<?> selecionar(Class classe) {
        try {
            return selecionar(classe, "");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
