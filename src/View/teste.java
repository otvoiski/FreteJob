/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cidade;
import Model.Estado;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class teste {
    public static void main(String[] args) {
      Cidade city  =  new Cidade("Uba", "123124", new Estado("Minas Gerais", "Mg", new Model.Pais("BRASIL", "BR")));
      city.setCodigo(99999999);
        JSONObject json =  city.toJson();
        System.out.println(json);
    }
}
