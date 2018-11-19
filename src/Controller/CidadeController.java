/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CidadeDAO;
import Model.Cidade;

/**
 *
 * @author Otavio
 */
public class CidadeController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new CidadeDAO(Model.Cidade.class);
        Object = new Cidade();
    }
    
}
