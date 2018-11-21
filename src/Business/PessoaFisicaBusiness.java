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
    
    public List<Pessoa> GetPessoa(String nome) {
        String hql = "from Pessoa p"
                + "inner join PessoaFisica pf on(p.codigo = pf.codigo)"
                + "where Nome like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        return (List<Pessoa>) query.list();
    }
}
