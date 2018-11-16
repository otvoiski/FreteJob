/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

/**
 *
 * @author Matheus
 */
public class Facade <T extends ObjectBase>{
    private final Class<T> classePersistente;

    public Facade(Class persistedClass) {
        this.classePersistente = persistedClass;
    }
    public boolean persistirEntidade(T obj){
        return false;
    }
}
