/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Encomenda;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Otavio
 */
public class EncomendaBusiness extends Base.BusinessBase{
    
    public List<Encomenda> GetByName(String nome) {
        String hql = "from Encomenda e"
                + " inner join fetch Emitente p"
                + " where p.Nome like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        return (List<Encomenda>) query.list();
    }
}
