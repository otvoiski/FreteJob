/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Model.Telefone;

/**
 *
 * @author Matheus
 */
public class TelefoneController  extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.TelefoneDAO(Model.Telefone.class);
        Object = new Telefone();
    }
    
}
