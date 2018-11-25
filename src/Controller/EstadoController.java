/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EstadoDAO;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class EstadoController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new EstadoDAO(Model.Estado.class);
        Object = new Model.Estado();
    }
    public List<JSONObject> GetByName(String estadoNome) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.EstadoBusiness().GetByName(estadoNome).forEach((estado) -> {
            jsonRetorno.add(new JSONObject(estado));
        });
        return jsonRetorno;
    }
    
}
