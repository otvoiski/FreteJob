/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class VeiculoController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.VeiculoDAO(Model.Veiculo.class);
        Object = new Veiculo();
    }
     public List<JSONObject> GetByPlaca(String placa) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.VeiculoBusiness().GetByPlaca(placa).forEach((veiculo) -> {
            jsonRetorno.add(new JSONObject(veiculo));
        });
        return jsonRetorno;
    }
    
}
