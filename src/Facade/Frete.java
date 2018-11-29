/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Base.MetodosJPA;
import Base.Persistencia;
import DAO.FreteDAO;
import org.hibernate.Session;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Frete {
    private Persistencia DAO;
    private Model.Frete Encomenda;
    private final Session transaction;
    
     public Frete(Persistencia encDao){
        this.DAO = encDao;
        transaction = MetodosJPA.abrirTransacao();
    }
      public void setDAO(FreteDAO DAO) {
        this.DAO = DAO;
    }
    public void setEncomenda(Model.Frete Frete) {
        this.Encomenda = Frete;
    }
     public boolean persistirFrete(JSONObject jsonFrete){
        Model.Frete objFrete =  (Model.Frete) new Model.Frete().toObjectBase(jsonFrete);
        return(DAO.Save(objFrete));
 
    }
}
