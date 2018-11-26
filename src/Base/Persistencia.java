/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 * @param <T>
 */
public class Persistencia<T extends ObjectBase> {

    private final Class<T> classePersistente;

    public Persistencia(Class<T> persistedClass) {
        this.classePersistente = persistedClass;
    }

    public boolean Save(T obj) {
        if (obj.getCodigo() > 0) {
            return MetodosJPA.fundir(obj);
        } else {
            return MetodosJPA.persistir(obj);
        }
    }
    public void Save(T obj, Session transaction) {
        if (obj.getCodigo() > 0) {
            MetodosJPA.fundir(obj);
        } else {
            MetodosJPA.persistirUsandoTransacaoAberta(obj,transaction);
        }
    }
    public boolean Remove(int i) {
        return MetodosJPA.excluir(i, classePersistente);
    }

    public T Get(int id) {
        Object obj = MetodosJPA.recuperar(id, classePersistente);
        return (T) obj;
    }
    public List<T> Get(String[][] parametros){
        return (List<T>) MetodosJPA.selecionar(classePersistente, parametros);
    }

    public List<T> GetAll() {
        return (List<T>) MetodosJPA.selecionar(classePersistente);
    }
    public List<T> GetAll(String[] rangeId) {
        String[][] data = {
            {"Codigo", rangeId[0]},
            {"Codigo", rangeId[1]}
        };
        return (List<T>) MetodosJPA.selecionar(classePersistente);
    }
}
