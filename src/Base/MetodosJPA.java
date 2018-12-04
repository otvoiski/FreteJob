/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Aluno
 */
public class MetodosJPA {
    //private static Session transaction =  null;
    public static Session abrirTransacao(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        return session;
    }
    public static boolean FecharTransacao(Session gerente, boolean bCommit){
        if(bCommit){
            gerente.getTransaction().commit();
            return true;
        } else {
            gerente.getTransaction().rollback();
            return false;
        }
    }
    public static boolean persistir(Object obj){
        Session transacao = abrirTransacao();
        transacao.persist(obj);
        return FecharTransacao(transacao, true);        
    }
    /*Metodo criado pelo motivo de que ao persistir uma classe como encomenda por exemplo, será necessário realizar persistencia de outras entidades primeiro
     ** exemplo, endereço, sendo assim deve ser utilizada uma mesma transação, este método não encerra a transação ao final de sua execução. É necessário comitar
     ** manualmente quando a persitência de todas as entidades foi concluída!
    */
     public static void persistirUsandoTransacaoAberta(Object obj, Session transaction){
        transaction.persist(obj);        
    }
    public static boolean fundir(Object obj) {
        Session transacao = abrirTransacao();
        transacao.merge(obj);
        return FecharTransacao(transacao, true);    
    }
    public static void fundirUsandoTransacaoAberta(Object obj, Session transaction) {
        transaction.merge(obj);
          
    }
    public static boolean excluir(int chave, Class classe){
        Session transacao = abrirTransacao();
        Object obj = transacao.get(classe, chave);
        transacao.delete(obj);
        return FecharTransacao(transacao, true);
    }
    public static Object recuperar(int chave, Class classe){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(classe,chave);
    }
    public static List<?> selecionar(Class classe, String whereJPQL){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createQuery("from " + classe.getName() + whereJPQL).list();
    }
    public static List<?> selecionar(Class classe, String[][] parametros){
        String where = "";
        if(parametros.length >0){
            for(int i = 0; i< parametros.length; i++){
                if(i == 0)
                    where = where + " where ";
                else
                    where = where+ " and ";
                for(int  j = 1; j< parametros[0].length; j++){
                    String campo = parametros[i][j-1];
                    String valor = parametros[i][j];
                    where =  where+ campo + " = " + valor;
                }
            }
        }
        return selecionar(classe, where);
    }
    
    public static List<?> selecionar(Class classe){
        return selecionar(classe, "");
    }
}
