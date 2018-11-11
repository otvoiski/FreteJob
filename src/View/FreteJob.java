/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DistribuidoraController;
import Model.Distribuidora;
import org.json.JSONObject;


/**
 *
 * @author Aluno
 */
public class FreteJob {
    public static void main(String[] args) {             
        DistribuidoraController distribuidoraController = new DistribuidoraController();
        
        Model.Distribuidora distribuidora = new Distribuidora();
        distribuidora.setCnpj("18.558.935/0001-53");
        distribuidora.setNomeFantasia("M Republic Relations");
        distribuidora.setRazaoSocial("M Republic Relations S.A");
        System.out.println(distribuidora.toJson());
        boolean json = distribuidoraController.Save(distribuidora.toJson());
        System.out.println(json);
    }    
}
