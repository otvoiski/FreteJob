/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import DAO.DistribuidoraDAO;
import Model.Distribuidora;

/**
 *
 * @author Otavio
 */
public class DistribuidoraController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DistribuidoraDAO(Model.Distribuidora.class);
        Object = new Distribuidora();
    }
    
}
