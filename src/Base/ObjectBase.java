/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@MappedSuperclass
public abstract class ObjectBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Codigo;
    
    public ObjectBase(){ Codigo = -1; }
    
    public abstract JSONObject toJson();
    public abstract ObjectBase toObjectBase(org.json.JSONObject jsonRetorno);
    public int getCodigo() { return Codigo; }
    public void setCodigo(int Codigo) { this.Codigo = Codigo; }    
}
