/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Base.Persistencia;
import Model.Encomenda;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class EncomendaController extends ControllerBase {

    @Override
    protected void START_CONTROLLER() {
        this.DAO = new Persistencia<>(Encomenda.class);
        this.Object = new Encomenda();
    }
    @Override
    public boolean Save(JSONObject dados){        
        Encomenda objEncomenda = (Encomenda) new Encomenda().toObjectBase(dados);
        objEncomenda.calculaValorTransporte();
        Object = objEncomenda;
        return DAO.Save(Object);
    };
    
}
