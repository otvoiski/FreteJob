/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ObjectBase;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 * @param <T>
 */
public abstract class Persistencia<T extends ObjectBase> {
    /*
    protected String Tabela;
    protected String[] Campos;
    protected String Chave;
    */
   /* private String SQLInsert; 
    private String SQLSelect; 
    private String SQLUpdate; 
    private String SQLDelete;*/
     
    private final Class<T> classePersistente;

    public Persistencia(Class persistedClass) {
        this.classePersistente = persistedClass;
        //inicializarPersistencia();
    }
    //protected abstract void inicializarPersistencia();//ainda nao implementado nas classes filhas
    
    
    public boolean Save(T obj) {
        if (!obj.getCodigo().isEmpty()) {
            return MetodosPersistencia.fundir(obj);
        } else {
            return MetodosPersistencia.persistir(obj);
        }
    }

    public boolean Remove(String i) {
        try {
            return MetodosPersistencia.excluir(i, classePersistente);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public T Get(String id) {
        Object obj = null;
        try {
            obj = MetodosPersistencia.recuperar(id, classePersistente);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (T) obj;
        //return null;
    }

    public List<T> GetAll() {
        return (List<T>) MetodosPersistencia.selecionar(classePersistente);
    }
    public List<T> GetAll(String[] rangeId) {
        String[][] data = {
            {"Codigo", rangeId[0]},
            {"Codigo", rangeId[1]}
        };
        return (List<T>) MetodosPersistencia.selecionar(classePersistente);
    }

    public List<T> Login(String login, String pass) {
        String[][] data = {
            {"Login", login},
            {"Senha", Util.MD5.Get(pass)}
        };
        return (List<T>) (new MetodosPersistencia()).selecionar(classePersistente, data);
    }
}
