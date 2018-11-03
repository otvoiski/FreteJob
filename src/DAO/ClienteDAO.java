/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Otavio
 */
public class ClienteDAO extends Persistencia {
    
    public ClienteDAO(Class persistedClass) {
        super(persistedClass);
    }

    @Override
    protected void inicializarPersistencia() {
        String[] Fields = {
            ""
        };
        Tabela ="CLIENTE_TBL";
        
 
    }
    
}
