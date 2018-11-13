/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aluno
 */
public class MetodosJPA {
    public static EntityManager abrirTransacao(){
        EntityManager gerente = FabricaConexao.getManager();
        gerente.getTransaction().begin();
        return gerente;
    }
    public static boolean FecharTransacao(EntityManager gerente, boolean bCommit){
        if(bCommit){
            gerente.getTransaction().commit();
            return true;
        } else {
            gerente.getTransaction().rollback();
            return false;
        }
    }
    public static boolean persistir(Object obj){
        EntityManager transacao = abrirTransacao();
        transacao.persist(obj);
        return FecharTransacao(transacao, true);        
    }
    public static boolean fundir(Object obj) {
        EntityManager transacao = abrirTransacao();
        transacao.merge(obj);
        return FecharTransacao(transacao, true);    
    }
    public static boolean excluir(int chave, Class classe){
        EntityManager transacao = abrirTransacao();
        Object obj = transacao.find(classe, chave);
        transacao.remove(obj);
        return FecharTransacao(transacao, true);
    }
    public static Object recuperar(int chave, Class classe){
        EntityManager transacao = FabricaConexao.getManager();
        return transacao.find(classe,chave);
    }
    public static List<?> selecionar(Class classe, String whereJPQL){
        EntityManager transacao = FabricaConexao.getManager();
        String sJPQL = "select u from "+classe.getName()+ " u "+whereJPQL;
        Query minhaQuery = transacao.createQuery(sJPQL);
        return minhaQuery.getResultList();
        
    }
    public List<?> selecionar(Class classe, String[][] parametros){
        String where = "";
        if(parametros.length >0){
            for(int i = 0; i< parametros.length; i++){
                if(i == 0)
                    where = where + " where ";
                else
                    where = where+ " and ";
                
                String campo = parametros[i][0];
                String valor = parametros[i][1];
                where =  where+ campo + " = '" + valor + "'";
            }
        }
        return selecionar(classe, where);
    }
    
    public static List<?> selecionar(Class classe){
        return selecionar(classe, "");
    }
}
