/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Base.MetodosJPA;
import Base.Persistencia;
import Business.CidadeBusiness;
import Controller.CidadeController;
import DAO.EmailDAO;
import DAO.PessoaFisicaDAO;
import Model.Cidade;
import Model.Email;
import Model.Endereco;
import Model.MidiaSocial;
import Model.PessoaFisica;
import Model.Telefone;
import Util.Enums;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class ClienteFisico {
    
    public boolean persistirCliente(JSONObject json){
        /* Start Connection */
        Session transaction = MetodosJPA.abrirTransacao();
        
        /* Ordem da Pesistencia */
        ArrayList<MidiaSocial> midiaSocial = new ArrayList<>();
        ArrayList<Email> email = new ArrayList<>();
        ArrayList<Telefone> telefone = new ArrayList<>();
        ArrayList<Endereco> endereco = new ArrayList<>();
        
        Cidade cidade;
        
        PessoaFisica pessoaFisica;
        
        /* Preenchendo dados para Persistencia */
        JSONArray temp;
        
        temp = json.getJSONArray("midiasSociais");
        for (int i = 0; i < temp.length(); i++) 
            midiaSocial.add((MidiaSocial) new MidiaSocial().toObjectBase(temp.getJSONObject(i)));
        
        temp = json.getJSONArray("emails");
        for (int i = 0; i < temp.length(); i++) 
            email.add((Email) new Email().toObjectBase(temp.getJSONObject(i)));
        
        temp = json.getJSONArray("telefones");
        for (int i = 0; i < temp.length(); i++) 
            telefone.add((Telefone) new Telefone().toObjectBase(temp.getJSONObject(i)));
        
        temp = json.getJSONArray("enderecos");
        for (int i = 0; i < temp.length(); i++) {
            Endereco e = (Endereco) new Endereco().toObjectBase(temp.getJSONObject(i));
            String nome = temp.getJSONObject(i).getJSONObject("cidade").getString("nome");
            e.setCidade((Cidade) new CidadeBusiness().GetCidadeName(nome).get(0));
            endereco.add(e);
        }
        
        pessoaFisica = new PessoaFisica();
        pessoaFisica.setCodigo(0);
        pessoaFisica.setNome(json.getString("nome"));
        pessoaFisica.setCpf(json.getString("cpf"));
        pessoaFisica.setRg(json.getString("rg"));
        pessoaFisica.setDataNascimento(Util.Validacao.converteStringToDate(json.getString("dataNascimento")));
        pessoaFisica.setSexo(json.getEnum(Enums.Sexo.class,"sexo"));
        pessoaFisica.setNaturezaPessoa(json.getEnum(Enums.NaturezaPessoa.class,"naturezaPessoa"));
        pessoaFisica.setTipoPessoa(json.getEnum(Enums.TipoPessoa.class,"tipoPessoa"));
        
        
        /* Start Persistencia */
        endereco.forEach((T) -> {
            new DAO.EnderecoDAO(Model.Endereco.class).Save(T, transaction);
        });
        email.forEach((T) -> {
            new DAO.EmailDAO(Model.Email.class).Save(T, transaction);
        });
        telefone.forEach((T) -> {
            new DAO.TelefoneDAO(Model.Telefone.class).Save(T, transaction);
        });
        midiaSocial.forEach((T) -> {
            new DAO.MidiaSocialDAO(Model.MidiaSocial.class).Save(T, transaction);
        });
        
        pessoaFisica.setEnderecos(endereco);
        pessoaFisica.setEmails(email);
        pessoaFisica.setTelefones(telefone);
        pessoaFisica.setMidiaSociais(midiaSocial);
                
        new PessoaFisicaDAO(PessoaFisica.class).Save(pessoaFisica, transaction);
        
        MetodosJPA.FecharTransacao(transaction, true);
        return true;
        /*
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
        return MetodosJPA.FecharTransacao(transaction, true);*/
        
    }
    
}
