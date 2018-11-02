/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Professor
 */
public class Encomenda extends ObjectBase {

    private Cliente Emitente;
    private Cliente Destinatario;
    private String EndOrigem;
    private String EndDestino;
    private ArrayList<String> Objetos;
    private String Estado;
    private ArrayList<Distribuidora> Distribuidora;
    private Cliente Responsavel;
    
    @Override
    public String[] toVector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObjectBase toObjectBase(String[] vector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente getEmitente() {
        return Emitente;
    }

    public void setEmitente(Cliente Emitente) {
        this.Emitente = Emitente;
    }

    public Cliente getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(Cliente Destinatario) {
        this.Destinatario = Destinatario;
    }

    public String getEndOrigem() {
        return EndOrigem;
    }

    public void setEndOrigem(String EndOrigem) {
        this.EndOrigem = EndOrigem;
    }

    public String getEndDestino() {
        return EndDestino;
    }

    public void setEndDestino(String EndDestino) {
        this.EndDestino = EndDestino;
    }

    public ArrayList<String> getObjetos() {
        return Objetos;
    }

    public void setObjetos(ArrayList<String> Objetos) {
        this.Objetos = Objetos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
