/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PaisDAO;

/**
 *
 * @author Matheus
 */
public class PaisController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new PaisDAO(Model.Pais.class);
        Object = new Model.Pais();
    }
    
}
