/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.ControllerBase;
import Base.Persistencia;
import Model.Cidade;
import Model.Distancia;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class DistanciaController extends ControllerBase{

    @Override
    protected void START_CONTROLLER() {
       this.DAO = new Persistencia<>(Distancia.class);
       this.Object = new Distancia();
    }
    public double retornaDistanciaEntreCidades(Cidade cidade1, Cidade cidade2){
         String[][] parametro = {
             {"Origem_Codigo",  String.valueOf(cidade1.getCodigo())},
             {"Destino_Codigo", String.valueOf(cidade2.getCodigo())}
         };
         List<Distancia> dist = DAO.Get(parametro);
         return dist.get(0).getKM();
    }
    
}
