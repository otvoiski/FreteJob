/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DistribuidoraController;
import Model.Distribuidora;
import java.util.ArrayList;
import org.json.JSONObject;


/**
 *
 * @author Aluno
 */
public class FreteJob {
    public static void main(String[] args) {             
        DistribuidoraController distribuidoraController = new DistribuidoraController();
        /*
        Model.Distribuidora distribuidora = new Distribuidora();
        distribuidora.setCnpj("79314120000113");
        distribuidora.setNomeFantasia("M Republic Relations");
        distribuidora.setRazaoSocial("M Republic Relations S.A");
        boolean json = distribuidoraController.Save(distribuidora.toJson());
        System.out.println(json);
        */
        
        ArrayList<JSONObject> distribuidoras = distribuidoraController.GetAll();
        for (JSONObject distribuidora : distribuidoras)
        System.out.println(distribuidora);
    }    
}
