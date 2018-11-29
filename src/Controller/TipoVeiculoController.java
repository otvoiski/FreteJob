/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Model.TipoVeiculo;

/**
 *
 * @author Matheus
 */
public class TipoVeiculoController  extends ControllerBase {

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.TipoVeiculoDAO(Model.TipoVeiculo.class);
        Object = new TipoVeiculo();
    }
    
}
