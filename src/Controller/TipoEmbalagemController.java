/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TipoEmbalagem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

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
    public List<JSONObject> GetByName(String cidadeNome) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.TipoEmbalagemBusiness().GetTipoEmbalagemByName(cidadeNome).forEach((cidade) -> {
            jsonRetorno.add(new JSONObject(cidade));
        });
        return jsonRetorno;
    }
}
