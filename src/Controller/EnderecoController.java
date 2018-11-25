/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import DAO.EnderecoDAO;


/**
 *
 * @author Matheus
 */
public class EnderecoController extends ControllerBase {

    @Override
    protected void START_CONTROLLER() {
        DAO = new EnderecoDAO(Model.Endereco.class);
        Object = new Model.Endereco();
    }
    
}
