/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Persistencia;
import Model.ObjectBase;
import java.util.ArrayList;

public abstract class ControllerBase {
    protected Persistencia DAO;
    protected ObjectBase Object;      
    
    protected abstract void START_CONTROLLER();       
    
    public ControllerBase() {
        START_CONTROLLER();
    }    
    
    public ArrayList<String[]> GetAll(){
        ArrayList<ObjectBase> list = (ArrayList<ObjectBase>) DAO.GetAll();
        ArrayList<String[]> data = new ArrayList<>();
        if(list != null){
            for (int i = 0; i < list.size(); i++) {
                data.add(list.get(i).toVector());
            }
        }
        
        return data;
    };
    
    public String[] Get(String codigo){
        Object.setCodigo( codigo );
        return DAO.Get(Object.getCodigo()).toVector();
    };
    
    public void Save(String[] dados){        
        Object = Object.toObjectBase(dados);
        DAO.Save(Object);
    };
    
    public void Delete(String codigo){
        Object.setCodigo( codigo );
        DAO.Remove(Object.getCodigo());
    };
}
