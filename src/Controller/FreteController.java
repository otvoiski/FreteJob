/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FreteDAO;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class FreteController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new FreteDAO(Model.Frete.class);
        Object = new Model.Frete();
    }
    @Override
    public boolean Save(JSONObject dados){
       Facade.Frete facade = new Facade.Frete(this.DAO);
       return facade.persistirFrete(dados);
    };
    
}
