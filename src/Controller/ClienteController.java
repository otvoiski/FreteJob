/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


/**
 *
 * @author Otavio
 */
public class ClienteController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.ClienteDAO(Model.PessoaFisica.class);
        Object = new Model.PessoaFisica();
    }
}
