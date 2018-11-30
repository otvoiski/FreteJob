/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Model.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class PessoaJuridicaController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
        DAO = new DAO.PessoaFisicaDAO(Model.PessoaFisica.class);
        Object = new PessoaJuridica();
    }
    public List<JSONObject> GetPessoaByName(String nomePessoa) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.PessoaJuridicaBusiness().GetPessoaByName(nomePessoa).forEach((pessoa) -> {
            jsonRetorno.add(new JSONObject(pessoa));
        });
        return jsonRetorno;
    }
     public List<JSONObject> GetClienteByName(String nomePessoa) {
        ArrayList<JSONObject> jsonRetorno = new ArrayList<>();
        new Business.PessoaJuridicaBusiness().GetClienteByName(nomePessoa).forEach((pessoa) -> {
            jsonRetorno.add(new JSONObject(pessoa));
        });
        return jsonRetorno;
    }
    
    
}
