/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Encomenda;
import java.util.Date;
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
    public List<Encomenda> GetByIntervaloData(String dataInicial, String dataFinal) {
        String hql = "from Encomenda e"
                + " where e.dataCadastro between :data1 and :data2";
        Query query = session.createQuery(hql);
        query.setString("data1", dataInicial);
        query.setString("data2", dataFinal);
        return (List<Encomenda>) query.list();
    }
}
