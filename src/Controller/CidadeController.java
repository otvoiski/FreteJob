/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.CidadeBusiness;
import DAO.CidadeDAO;
import Model.Cidade;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

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

    public List<JSONObject> GetByName(String cidadeNome) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.CidadeBusiness().GetCidadeName(cidadeNome).forEach((cidade) -> {
            jsonRetorno.add(new JSONObject(cidade));
        });
        return jsonRetorno;
    }
    
}
