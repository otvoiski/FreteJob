/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import DAO.MidiaSocialDAO;
import Model.MidiaSocial;

/**
 *
 * @author Matheus
 */
public class MidiaSocialController  extends ControllerBase {

    @Override
    protected void START_CONTROLLER() {
        DAO = new MidiaSocialDAO(Model.MidiaSocial.class);
        Object = new MidiaSocial();
    }
    
}
