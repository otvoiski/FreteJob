/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Pessoa;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Matheus
 */
public class PessoaJuridicaBusiness extends Base.BusinessBase {
    
     public List<Pessoa> GetPessoaByName(String nome) {
        String hql = "from PessoaJuridica pj where NomeFantasia like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome",nome + "%");
        return (List<Pessoa>) query.list();
    }
    public List<Pessoa> GetClienteByName(String nome) {
        String hql = "from PessoaJuridica pj where NomeFantasia like :nome"
                      + " and pj.TipoPessoa = :tipo";
        Query query = session.createQuery(hql);
        query.setString("nome",nome + "%");
        query.setInteger("tipo",Util.Enums.TipoPessoa.Cliente.ordinal());
        return (List<Pessoa>) query.list();
    }
}
