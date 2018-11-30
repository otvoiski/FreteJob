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
public class PessoaFisicaBusiness extends Base.BusinessBase {
    
    public List<Pessoa> GetByName(String nome) {
        String hql = "from PessoaFisica pf where pf.Nome like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome",nome + "%");
        return (List<Pessoa>) query.list();
    }
    
    public List<Pessoa> GetClienteByName(String nome) {
        String hql = "from PessoaFisica pf where pf.Nome like :nome"
                    + " and pf.TipoPessoa = :tipo";
        Query query = session.createQuery(hql);
        query.setString("nome",nome + "%");
        query.setInteger("tipo",Util.Enums.TipoPessoa.Cliente.ordinal());
        return (List<Pessoa>) query.list();
    }
}
