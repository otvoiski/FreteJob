/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import DAO.EmailDAO;
import Model.Email;

/**
 *
 * @author Matheus
 */
public class EmailController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new EmailDAO(Model.Email.class);
        Object = new Email();
    }
    
}
