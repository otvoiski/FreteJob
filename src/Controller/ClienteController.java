/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


/**
 * Está classes é um modelo simples que não estara inclusa no projeto
 * foi criada para ajuda no processo de persistencia ao banco.
 * 
 * @deprecated Esta classe sera removida em breve.
 * @author Otavio
 */
public class ClienteController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.ClienteDAO(Model.Cliente.class);
        Object = new Model.Cliente();
    }
}
