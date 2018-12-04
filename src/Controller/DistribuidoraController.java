/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import DAO.DistribuidoraDAO;
import Model.Distribuidora;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */
public class DistribuidoraController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DistribuidoraDAO(Model.Distribuidora.class);
        Object = new Distribuidora();
    }
    public List<JSONObject> GetByCidadeAtende(String cidadeCodigo) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.DistribuidoraBusiness().GetByCidadeAtende(Integer.parseInt(cidadeCodigo)).forEach((cidade) -> {
            jsonRetorno.add(new JSONObject(cidade));
        });
        return jsonRetorno;
    }
    public List<JSONObject> GetByName(String descricao) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.DistribuidoraBusiness().GetByName(descricao).forEach((distribuidora) -> {
            jsonRetorno.add(new JSONObject(distribuidora));
        });
        return jsonRetorno;
    }
}
