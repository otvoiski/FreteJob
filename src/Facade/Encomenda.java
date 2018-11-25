/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Base.Persistencia;
import Controller.CidadeController;
import Controller.EnderecoController;
import DAO.EncomendaDAO;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class Encomenda {
    
    private Persistencia DAO;
    private Model.Encomenda Encomenda;

    public Encomenda(Persistencia encDao){
        this.DAO = encDao;
    }
    public void setDAO(EncomendaDAO DAO) {
        this.DAO = DAO;
    }
    public void setEncomenda(Model.Encomenda Encomenda) {
        this.Encomenda = Encomenda;
    }

    public boolean persistirEncomenda(JSONObject jsonEncomenda){
        boolean persistido = false;
        Model.Encomenda objEncomenda;
        CidadeController cidadeCntrl =  new CidadeController();
        EnderecoController enderecoCntrl = new EnderecoController();
        
        int  cidadeColeta = Integer.parseInt(jsonEncomenda.getJSONObject("endColeta").getString("cidade"));
        jsonEncomenda.getJSONObject("endColeta").remove("cidade");
        jsonEncomenda.getJSONObject("endColeta").remove("cidade"); 
        
        int cidadeDestino =  Integer.parseInt(jsonEncomenda.getJSONObject("endDestino").getString("cidade"));
        jsonEncomenda.getJSONObject("endDestino").remove("cidade");
        
        jsonEncomenda.getJSONObject("endColeta").put("cidade", cidadeCntrl.Get(cidadeColeta));
        jsonEncomenda.getJSONObject("endDestino").put("cidade", cidadeCntrl.Get(cidadeDestino));
        
        objEncomenda = (Model.Encomenda) new Model.Encomenda().toObjectBase(jsonEncomenda);
        objEncomenda.calculaValorTransporte();

        if(enderecoCntrl.Save(objEncomenda.getEndColeta().toJson())){
            if(enderecoCntrl.Save(objEncomenda.getEndDestino().toJson())){
                if(DAO.Save(objEncomenda))
                    persistido = true;
            }
        }
        
        return persistido;
    }
    
}
