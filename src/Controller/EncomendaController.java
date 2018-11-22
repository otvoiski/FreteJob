/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Base.Persistencia;
import DAO.EncomendaDAO;
import Model.Encomenda;
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
        this.DAO = new Persistencia<>(Encomenda.class);
        this.Object = new Encomenda();
    }
    @Override
    public boolean Save(JSONObject dados){
        Encomenda objEncomenda = (Encomenda) new Encomenda().toObjectBase(dados);
        objEncomenda.calculaValorTransporte();
        Object = objEncomenda;
        //Facade.Encomenda facade = new Facade.Encomenda((EncomendaDAO)this.DAO);
        return DAO.Save(Object);
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
