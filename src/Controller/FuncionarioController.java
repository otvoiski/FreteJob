/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
public class FuncionarioController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new FuncionarioDAO(Model.Funcionario.class);
        Object = new Model.Funcionario();
    }

    public List<JSONObject> GetAll(int distribuidora) {
        List<Funcionario> list =  new Business.FuncionarioBusiness().GetAll(distribuidora);
        ArrayList<JSONObject> listRetorno = new ArrayList<>();
        list.forEach((funcionario) -> {
            listRetorno.add(new JSONObject(funcionario));
        });
        return listRetorno;
    }
    
    public List<JSONObject> GetByName(String name, int distribuidora) {
        List<Funcionario> list =  new Business.FuncionarioBusiness().GetByName(name, distribuidora);
        ArrayList<JSONObject> listRetorno = new ArrayList<>();
        list.forEach((funcionario) -> {
            listRetorno.add(new JSONObject(funcionario));
        });
        return listRetorno;
    }
}
