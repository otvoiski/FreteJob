/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Persistencia;
import Model.ObjectBase;
import java.util.ArrayList;
import org.json.JSONObject;

public abstract class ControllerBase {
    protected Persistencia DAO;
    protected ObjectBase Object;      
    
    protected abstract void START_CONTROLLER();       
    
    public ControllerBase() {
        START_CONTROLLER();
    }    
    
    public ArrayList<JSONObject> GetAll(){
        ArrayList<ObjectBase> list = (ArrayList<ObjectBase>) DAO.GetAll();
        ArrayList<JSONObject> data = new ArrayList<>();
        if(list != null){
            for (int i = 0; i < list.size(); i++) {
                data.add(list.get(i).toJson());
            }
        }
        
        return data;
    };
    //Deve ser feito uma verificação caso não encontrar um determinado Cogigo
    public JSONObject Get(String codigo){
        Object.setCodigo( codigo );
        return DAO.Get(Object.getCodigo()).toJson();
    };
    
    public boolean Save(JSONObject dados){        
        Object = Object.toObjectBase(dados);
        return DAO.Save(Object);
    };
    
    public boolean Delete(String codigo){
        Object.setCodigo( codigo );
        return DAO.Remove(Object.getCodigo());
    };
}
