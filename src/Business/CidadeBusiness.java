/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Cidade;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Otavio
 */
public class CidadeBusiness extends Base.BusinessBase{
    
//    public List<Cidade> GetCidadesBrasileiras(int estado) {
//        String hql = "from Cidade c "
//                + "inner join fetch c.Estado as e "
//                + "inner join fetch e.Pais as p "
//                + "where e.Codigo = :estado "
//                + "and p.Codigo = :pais";
//        Query query = session.createQuery(hql);
//        query.setInteger("estado", estado);
//        query.setInteger("pais", 1);
//        return (List<Cidade>) query.list();
//    }
  
    public List<Cidade> GetCidadeName(String nome) {
        String hql = "from Cidade c where Nome like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        return (List<Cidade>) query.list();
    }
    
}
