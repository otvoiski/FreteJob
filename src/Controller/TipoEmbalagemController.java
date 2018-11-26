/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TipoEmbalagem;

/**
 *
 * @author Matheus
 */
public class TipoEmbalagemController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.TipoEmbalagemDAO(Model.TipoEmbalagem.class);
        Object = new TipoEmbalagem();
    }
    
}
