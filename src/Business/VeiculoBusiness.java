/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Model.Veiculo;

/**
 *
 * @author Matheus
 */
import java.util.List;
import org.hibernate.Query;
public class VeiculoBusiness  extends Base.BusinessBase{
    public List<Veiculo> GetByPlaca(String placa) {
        String hql = "from Veiculo v where Placa  like :placa";
        Query query = session.createQuery(hql);
        query.setString("placa", placa + "%");
        return query.list();
    }
}
