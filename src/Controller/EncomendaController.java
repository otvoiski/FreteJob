/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Base.Persistencia;
import Model.Encomenda;
import java.util.ArrayList;
import java.util.Date;
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
        List<Encomenda> list = new Business.EncomendaBusiness().GetByEmitenteName(nome);
        ArrayList<JSONObject> listRetorno = new ArrayList<>();
        list.forEach((funcionario) -> {
            listRetorno.add(new JSONObject(funcionario));
        });
        return listRetorno;
    }
    public List<JSONObject> recupEncomsSemFretePorIntervalo(String dataInicial, String dataFinal)
    {
        String data1 = Util.Validacao.converteDatePadraoAmericanoToString(Util.Validacao.converteDatePadraoBrParaAmericano(dataInicial));
        String data2 = Util.Validacao.converteDatePadraoAmericanoToString(Util.Validacao.converteDatePadraoBrParaAmericano(dataFinal));
        List<Encomenda> list = new Business.EncomendaBusiness().recupEncomsSemFretePorIntervalo(data1,data2);
        ArrayList<JSONObject> listRetorno = new ArrayList<>();
        list.forEach((encomenda) -> {
            listRetorno.add(new JSONObject(encomenda));
        });
        return listRetorno;
    }
    
    public List<JSONObject> recupEncomsPorIntervalo(String dataInicial, String dataFinal)
    {
        String data1 = Util.Validacao.converteDatePadraoAmericanoToString(Util.Validacao.converteDatePadraoBrParaAmericano(dataInicial));
        String data2 = Util.Validacao.converteDatePadraoAmericanoToString(Util.Validacao.converteDatePadraoBrParaAmericano(dataFinal));
        List<Encomenda> list = new Business.EncomendaBusiness().recupEncomsPorIntervalo(data1,data2);
        ArrayList<JSONObject> listRetorno = new ArrayList<>();
        list.forEach((encomenda) -> {
            listRetorno.add(new JSONObject(encomenda));
        });
        return listRetorno;
    }
    public List<Encomenda> GetByCodigoList(ArrayList<Integer> codigos){
        return new Business.EncomendaBusiness().GertByCodigoList(codigos);
    }
}
