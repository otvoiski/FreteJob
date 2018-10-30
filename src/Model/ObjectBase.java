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
    private int Codigo;    
    
    public abstract String[] toVector();
    public abstract ObjectBase toObjectBase(String[] vector);
    public int getCodigo() { return Codigo; }
    public void setCodigo(int Codigo) { this.Codigo = Codigo; }    
}
