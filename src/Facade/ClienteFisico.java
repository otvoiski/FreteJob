/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Base.MetodosJPA;
import Base.Persistencia;
import Controller.CidadeController;
import Controller.EmailController;
import Controller.EnderecoController;
import Controller.MidiaSocialController;
import Controller.PessoaFisicaController;
import Controller.TelefoneController;
import DAO.PessoaFisicaDAO;
import Model.Cidade;
import Model.PessoaFisica;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class ClienteFisico {
    
    private Persistencia DAO;
    private Model.PessoaFisica Cliente;
    private final Session transaction;
    
    public ClienteFisico(Persistencia dao){
        this.DAO =  dao;
        transaction =  MetodosJPA.abrirTransacao();
    }
    public void setDAO(PessoaFisicaDAO DAO) {
        this.DAO = DAO;
    }
    public boolean persistirCliente(JSONObject json){
        Cidade objCidade;
        CidadeController cidadeCntrl =  new CidadeController();
        PessoaFisica objPersistir =  (PessoaFisica) new PessoaFisica().toObjectBase(json);
          //recupera do banco de dados buscando pelo nome a cidade que for passsada no endereco e sobrescreve a cidade no objeto que vai ser persistido
        for(int i = 0; i< objPersistir.getEnderecos().size(); i++){
            objCidade = (Cidade) new Cidade().toObjectBase(cidadeCntrl.GetByName(objPersistir.getEnderecos().get(i).getCidade().getNome()).get(0));
            objPersistir.getEnderecos().get(i).setCidade(objCidade);
        }
        System.out.println(objPersistir.toJson());
        DAO.Save(objPersistir, transaction);
        return MetodosJPA.FecharTransacao(transaction, true);
    }
    
}
