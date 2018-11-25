/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Base.Persistencia;
import DAO.EncomendaDAO;
import Model.Cidade;
import Model.Encomenda;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class EncomendaController extends ControllerBase {

    @Override
    protected void START_CONTROLLER() {
        this.DAO = new Persistencia<>(Model.Encomenda.class);
        this.Object = new Encomenda();
    }
    @Override
    public boolean Save(JSONObject dados){
       Facade.Encomenda facade = new Facade.Encomenda(this.DAO);
       return facade.persistirEncomenda(dados);
    };
    
    public List<JSONObject> GetByName(String nome)
    {
        List<Encomenda> list = new Business.EncomendaBusiness().GetByName(nome);
        ArrayList<JSONObject> listRetorno = new ArrayList<>();
        list.forEach((funcionario) -> {
            listRetorno.add(new JSONObject(funcionario));
        });
        return listRetorno;
    }
}
