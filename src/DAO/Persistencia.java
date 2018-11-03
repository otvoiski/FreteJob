/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ObjectBase;
import java.util.List;

/**
 *
 * @author Aluno
 * @param <T>
 */
public abstract class Persistencia<T extends ObjectBase> {
    protected String Tabela;
    protected String[] Campos;
    protected String Chave;
    
   /* private String SQLInsert; 
    private String SQLSelect; 
    private String SQLUpdate; 
    private String SQLDelete;*/
     
    private final Class<T> classePersistente;

    public Persistencia(Class<T> persistedClass) {
        this.classePersistente = persistedClass;
        inicializarPersistencia();
    }
    protected abstract void inicializarPersistencia();//ainda nao implementado nas classes filhas
    
    
    public void Save(T obj) {
        if (!obj.getCodigo().isEmpty()) {
            //MetodosJPA.fundir(obj);
        } else {
            //MetodosJPA.persistir(obj);
        }
    }

    public void Remove(String i) {
        //MetodosJPA.excluir(i, classePersistente);
    }

    public T Get(String id) {
        //Object obj = MetodosJPA.recuperar(id, classePersistente);
        //return (T) obj;
        return null;
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

    public List<T> Login(String login, String pass) {
        String[][] data = {
            {"Login", login},
            {"Senha", Util.MD5.Get(pass)}
        };
        return (List<T>) (new MetodosJPA()).selecionar(classePersistente, data);
    }
}
