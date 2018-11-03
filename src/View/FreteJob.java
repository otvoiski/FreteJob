/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cidade;
import Model.Endereco;
import Model.Estado;
import Model.ObjectBase;
import Model.Pais;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author Aluno
 */
public class FreteJob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ArrayList<JSONObject> a = (new Controller.ClienteController()).GetAll();
        /*for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i)[0]);
        }*/
        
        Estado estado = new Estado();
        estado.setCodigo("1");
        estado.setNome("Minas Gerais");
        estado.setSigla("MG");
        estado.setPais(new Pais("Brasil", "BR"));
        estado.getPais().setCodigo("2");
        Cidade cidade = new Cidade("Ubá", "q1231", estado);
        cidade.setCodigo("3");
        Endereco endereco = new Endereco("Rua gustavo Goria", "Santa bernadete", "36502166", "150", "E", cidade);
        endereco.setCodigo("4");
        endereco.setComplemento("Fundos");
        
        JSONObject json = endereco.toJson();
        System.out.println(json);
        endereco = (Endereco) endereco.toObjectBase(json);
        System.out.println("Rua: "+ endereco.getRua()+
                "\n"+"Bairro: "+endereco.getBairro()+"\n"+
                "Numero: "+ endereco.getNumero()+"\n"+
                "Complemento: "+ endereco.getComplemento()+ "\n"+
                "Cidade: "+ endereco.getCidade().getNome()+"\n"+
                "Estado: "+endereco.getCidade().getEstado().getNome()+"\n"+
                "Pais: "+endereco.getCidade().getEstado().getPais().getNome());
    }
    
}
