/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.ResultSet;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
public abstract class ObjectBase {
    private String Codigo;
    
    public ObjectBase(){ Codigo = ""; }
    
    public abstract JSONObject toJson();
    public abstract ObjectBase toObjectBase(org.json.JSONObject jsonRetorno);
    public abstract ObjectBase toObjectBase(ResultSet rs);
    public String getCodigo() { return Codigo; }
    public void setCodigo(String Codigo) { this.Codigo = Codigo; }    
}
