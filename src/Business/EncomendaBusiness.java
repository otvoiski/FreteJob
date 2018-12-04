/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Encomenda;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Otavio
 */
public class EncomendaBusiness extends Base.BusinessBase{
    
    public List<Encomenda> GetByEmitenteName(String nome) {
        String hql = "from Encomenda e"
                + " inner join fetch Emitente p"
                + " where p.Nome like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        return query.list();
    }
    
    //seleciona todas as encomendas entre as datas passadas pelo parâmetro que não estejam em frete
    public List<Encomenda> recupEncomsSemFretePorIntervalo(String dataInicial, String dataFinal) {
        String hql = "from Encomenda e"
                + " where e.dataCadastro between :data1 and :data2"
                + " and e.Codigo not in "
                + " (select Enc.Codigo from Frete fr"
                + " inner join fr.EncomendasTransporte as Enc)";
        
        Query query = session.createQuery(hql);
        query.setString("data1", dataInicial);
        query.setString("data2", dataFinal);
        return query.list();
    }
    public List<Encomenda> recupEncomsPorIntervalo(String dataInicial, String dataFinal) {
        String hql = "from Encomenda e inner join fetch e.Objetos as o"
                + " where e.dataCadastro between :data1 and :data2";
        Query query = session.createQuery(hql);
        query.setString("data1", dataInicial);
        query.setString("data2", dataFinal);
        return query.list();
    }
    //seleciona todas as encomendas cujo código esteja na lista passada pelo parametro
    public List<Encomenda> GertByCodigoList(ArrayList<Integer> codigosBuscar){
         String hql = "from Encomenda e"
                + " where e.Codigo in( ";
         
        for(int i = 0; i< codigosBuscar.size(); i++){
            hql += ":codigo"+i;
            if(i < codigosBuscar.size()-1)
                hql+=",";
        }
        hql +=")";
        Query query = session.createQuery(hql);
        for(int i = 0; i< codigosBuscar.size(); i++)
            query.setInteger("codigo"+i, codigosBuscar.get(i));
        
        return query.list();
    }
}
