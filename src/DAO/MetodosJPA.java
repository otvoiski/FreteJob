/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class MetodosJPA {

    public static Connection abrirTransacao() {
        return FabricaConexao.GeraTransaction();
    }

    public static void FecharTransacao(Connection gerente, boolean bCommit) throws SQLException {
        if (bCommit) {
            gerente.commit();
        } else {
            gerente.rollback();
        }
    }

    public static void Query(String query) throws SQLException {
        Connection conn = abrirTransacao();
        PreparedStatement ps = conn.prepareStatement(query);
        FecharTransacao(conn, ps.execute());
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
    }
    public static Object recuperar(int chave, Class classe){
        Connection transacao = FabricaConexao.getManager();
        return transacao.find(classe,chave);
    }
    public static List<?> selecionar(Class classe, String whereJPQL){
        Connection transacao = FabricaConexao.getManager();
        String sJPQL = "select u from "+classe.getName()+ " u "+whereJPQL;
        Query minhaQuery = transacao.createQuery(sJPQL);
        return minhaQuery.getResultList();        
    }
     */
    public static List<?> selecionar(Class classe, String whereJPQL) throws SQLException {
        Connection conn = FabricaConexao.GeraConexaoSINGLETON();
        String sJPQL = "select * from " + classe.getSimpleName() + " " + whereJPQL;
        PreparedStatement ps = conn.prepareStatement(sJPQL);
        ResultSet rs = ps.executeQuery();

        int colunas = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 0; i < colunas; i++) {
                System.out.println(rs.getString(classe.getDeclaredFields()[i].getName()));
            }
        }
        
        return null;
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
            Logger.getLogger(MetodosJPA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<?> selecionar(Class classe) {
        try {
            return selecionar(classe, "");
        } catch (SQLException ex) {
            Logger.getLogger(MetodosJPA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
