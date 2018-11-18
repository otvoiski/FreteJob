/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType. TABLE_PER_CLASS)
public abstract class ObjectBase {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int Codigo;
    
    public ObjectBase(){ Codigo = 0; }
    
    public abstract JSONObject toJson();
    public abstract ObjectBase toObjectBase(org.json.JSONObject jsonRetorno);
    public int getCodigo() { return Codigo; }
    public void setCodigo(int Codigo) { this.Codigo = Codigo; }    
}
