/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cidade;
import Model.Endereco;
import Model.Estado;
import Model.Pais;
import Model.PessoaFisica;
import Model.Telefone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/*
import Model.Cidade;
import Model.Endereco;
import Model.Estado;
import Model.ObjectBase;
import Model.Pais;
import java.util.ArrayList;
import net.sf.jasperreports.web.servlets.Controller;
import org.json.JSONObject;
*/
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
        cidade.setCod_municipio(null);
        cidade.setCodigo("3");
        Cidade cidade2 = new Cidade("Tocantins", "q1231", estado);
        cidade2.setCodigo("3");
        Endereco endereco = new Endereco("Rua gustavo Goria", "Santa bernadete", "36502166", "150", "E", cidade);
        endereco.setCodigo("4");
        endereco.setComplemento("Fundos");
        
        Endereco endereco2 = new Endereco("Rua teste", "teste", "36502166", "150", "E", cidade2);
        endereco2.setCodigo("4");
        endereco2.setComplemento("");
        
        Telefone telefone1 = new Telefone();
        telefone1.setCodigo("1");
        telefone1.setDdd("32");
        telefone1.setNumero("988985982");
        Telefone telefone2 = new Telefone();
        telefone2.setCodigo("1");
        telefone2.setDdd("32");
        telefone2.setNumero("35319369");
        
        ArrayList<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        enderecos.add(endereco2);
        
        ArrayList<Telefone> telefones = new ArrayList<>();
        telefones.add(telefone1);
        telefones.add(telefone2);
        
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setCodigo("132");
        pessoa.setTipoPessoa("Cliente");
        pessoa.setCpf("123254567890");
        pessoa.setRg("123254567890");
        pessoa.setSexo("M");
        pessoa.setNome("Matheus Ribeiro");
        pessoa.setDataNascimento((new Date()));
        pessoa.setEnderecos(enderecos);
        pessoa.setTelefones(telefones);
        pessoa.getMidiaSociais().add("www.facebook.com.br");
        pessoa.getMidiaSociais().add("www.tweeter.com.br");
        JSONObject json = pessoa.toJson();
        System.out.println(json);
        
       pessoa = (PessoaFisica)pessoa.toObjectBase(json);
       for(int i = 0; i<pessoa.getEnderecos().size(); i++){
            System.out.println("Rua: "+ pessoa.getEnderecos().get(i).getRua()+
                    "\n"+"Bairro: "+pessoa.getEnderecos().get(i).getBairro()+"\n"+
                    "Numero: "+ pessoa.getEnderecos().get(i).getNumero()+"\n"+
                    "Complemento: "+ pessoa.getEnderecos().get(i).getComplemento()+ "\n"+
                    "Cidade: "+ pessoa.getEnderecos().get(i).getCidade().getNome()+"\n"+
                    "Estado: "+pessoa.getEnderecos().get(i).getCidade().getEstado().getNome()+"\n"+
                    "Pais: "+pessoa.getEnderecos().get(i).getCidade().getEstado().getPais().getNome());
            System.out.println("------------------");
       }
       System.out.println("Midias Sociais");
       for(int i = 0; i<pessoa.getEnderecos().size(); i++){
            System.out.println(pessoa.getMidiaSociais().get(i));
       }
        
        /*JSONObject json = (new Controller.PessoaFisicaController()).Get("0");
        System.err.println(json);*/
        /*
        JSONObject cliente = (new Controller.ClienteController()).Get("2");
        System.out.println(cliente);
        
        
        ArrayList<JSONObject> clientes = (new Controller.ClienteController()).GetAll();
        for (JSONObject c : clientes) {
            System.out.println(c);
        }
        */
        
       /* JSONObject pf = (new Controller.PessoaFisicaController()).Get("1");
        System.out.println(pf);
        
        
        ArrayList<JSONObject> pfs = (new Controller.PessoaFisicaController()).GetAll();
        for (JSONObject c : pfs) {
            System.out.println(c);
        }*/
    }
    
}
