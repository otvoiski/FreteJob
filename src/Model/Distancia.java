/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Base.ObjectBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.json.JSONObject;

/**
 *
 * @author Otavio
 */

@Entity
public class Distancia extends ObjectBase implements Serializable{

    @OneToOne
    private Cidade Origem;
    private double KM;
    @OneToOne
    private Cidade Destino;

    public Distancia() {
    }

    public Distancia(Cidade Origem, double KM, Cidade Destino) {
        this.Origem = Origem;
        this.KM = KM;
        this.Destino = Destino;
    }

    public Cidade getOrigem() {
        return Origem;
    }

    public void setOrigem(Cidade Origem) {
        this.Origem = Origem;
    }

    public double getKM() {
        return KM;
    }

    public void setKM(double KM) {
        this.KM = KM;
    }

    public Cidade getDestino() {
        return Destino;
    }

    public void setDestino(Cidade Destino) {
        this.Destino = Destino;
    }
    
    
    
    @Override
    public JSONObject toJson() {
        return new JSONObject(this);
    }

    @Override
    public ObjectBase toObjectBase(JSONObject jsonRetorno) {
        return new Distancia(
                (Cidade) jsonRetorno.get("Origem"),
                jsonRetorno.getDouble("KM"),
                (Cidade) jsonRetorno.get("Destino")
        );
    }
    
}
