/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Base.BusinessBase;
import Model.Distribuidora;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Matheus
 */
public class DistribuidoraBusiness extends BusinessBase {
    
    public List<Distribuidora> GetByCidadeAtende(int cidadeCodigo) {
            String hql = "from Distribuidora d"
                + " inner join fetch d.CidadesAtuacao dc"
                + " where dc.Codigo = :codigoCidade";
        Query query = session.createQuery(hql);
        query.setInteger("codigoCidade", cidadeCodigo);
        return (List<Distribuidora>) query.list();
    }
    
    public List<Distribuidora> GetByName(String descricao) {
         String hql = "from Distribuidora d"
                + " where d.RazaoSocial like :descricao or d.NomeFantasia like :descricao2";
         Query query = session.createQuery(hql);
        query.setString("descricao", descricao+ "%");
        query.setString("descricao2", descricao+ "%");
        return (List<Distribuidora>) query.list();
    
    }
}
