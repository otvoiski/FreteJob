/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.TipoEmbalagem;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Matheus
 */
public class TipoEmbalagemBusiness extends Base.BusinessBase {
    public List<TipoEmbalagem> GetTipoEmbalagemByName(String nome) {
        String hql = "from TipoEmbalagem t where Descricao like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        return query.list();
    }
}
