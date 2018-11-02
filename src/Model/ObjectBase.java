/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aluno
 */
public abstract class ObjectBase {
    private String Codigo;    
    
    public abstract String[] toVector();
    public abstract ObjectBase toObjectBase(String[] vector);
    public String getCodigo() { return Codigo; }
    public void setCodigo(String Codigo) { this.Codigo = Codigo; }    
}
