/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FuncionarioDAO;
import Model.Funcionario;
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
    
    public JSONObject GetByName(JSONObject json) {
        List<Funcionario> funcionarios = DAO.GetAll();
        JSONObject jsonRetorno = null;
        int i = 0;
        for(Funcionario f : funcionarios){
            if(f.getNome().contains(json.getString("Nome")))
                jsonRetorno.put(i+++"", f.toJson());
        }
        return jsonRetorno;        
    }
}
