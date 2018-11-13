/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 * @param <T>
 */
public abstract class PersistenciaJDBC<T extends ObjectBase> {
    private final Class<T> classePersistente;

    public PersistenciaJDBC(Class persistedClass) {
        this.classePersistente = persistedClass;
    }
    
    
    public boolean Save(T obj) {
        /*
        if (!obj.getCodigo().isEmpty()) {
            return MetodosPersistenciaJDBC.fundir(obj);
        } else {
            return MetodosPersistenciaJDBC.persistir(obj);
        }
        */
        return false;
    }

    public boolean Remove(String i) {
        try {
            return MetodosPersistenciaJDBC.excluir(i, classePersistente);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public T Get(String id) {
        Object obj = null;
        try {
            obj = MetodosPersistenciaJDBC.recuperar(id, classePersistente);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (T) obj;
    }

    public List<T> GetAll() {
        return (List<T>) MetodosPersistenciaJDBC.selecionar(classePersistente);
    }

    public List<T> Login(String login, String pass) {
        String[][] data = {
            {"Login", login},
            {"Senha", Util.MD5.Get(pass)}
        };
        return (List<T>) (new MetodosPersistenciaJDBC()).selecionar(classePersistente, data);
    }
}
