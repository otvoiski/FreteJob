/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Pais;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Matheus
 */
public class PaisBusiness  extends Base.BusinessBase{
    public List<Pais> GetByName(String nome) {
        String hql = "from Pais p where Nome like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        return query.list();
    }
}
