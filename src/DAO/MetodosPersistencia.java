/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ObjectBase;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
public class MetodosPersistencia {

    public static Connection abrirTransacao() {
        return FabricaConexao.GeraTransaction();
    }

    public static boolean FecharTransacao(Connection gerente, boolean bCommit) throws SQLException {
        if (bCommit) {
            gerente.commit();
        } else {
            gerente.rollback();
        }        
        return bCommit;
    }

    public static boolean Query(String query) throws SQLException {
        Connection conn = abrirTransacao();
        PreparedStatement ps = conn.prepareStatement(query);
        return FecharTransacao(conn, ps.execute());
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
    
    /*
    public static void fundir(Object obj) {
        Connection transacao = abrirTransacao();
        transacao.merge(obj);
        FecharTransacao(transacao, true);    
    }
    public static void excluir(int chave, Class classe){
        Connection transacao = abrirTransacao();
        Object obj = transacao.find(classe, chave);
        transacao.remove(obj);
        FecharTransacao(transacao, true);
    }*/
    
    
    public static ObjectBase recuperar(String chave, Class classe) throws SQLException{
        Connection conexao = FabricaConexao.GeraConexaoSINGLETON();
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
        Connection conn = FabricaConexao.GeraConexaoSINGLETON();
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
