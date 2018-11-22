/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.EncomendaDAO;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Encomenda {
    
    private EncomendaDAO DAO;
    private Model.Encomenda Encomenda;

    public Encomenda(EncomendaDAO encDao){
        this.DAO = encDao;
    }
    public void setDAO(EncomendaDAO DAO) {
        this.DAO = DAO;
    }
    public void setEncomenda(Model.Encomenda Encomenda) {
        this.Encomenda = Encomenda;
    }

    public void persistirEncomenda(JSONObject jsonTela){
        
    }
    
}
