/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PaisDAO;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class PaisController extends Base.ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new PaisDAO(Model.Pais.class);
        Object = new Model.Pais();
    }
    public List<JSONObject> GetByName(String paisNome) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.PaisBusiness().GetByName(paisNome).forEach((pais) -> {
            jsonRetorno.add(new JSONObject(pais));
        });
        return jsonRetorno;
    }
    
}
