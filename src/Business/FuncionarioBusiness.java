/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.Funcionario;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Otavio
 */
public class FuncionarioBusiness extends Base.BusinessBase{
    
    public List<Funcionario> GetAll(int distribuidora) {
        String hql = "from Funcionario where LocalTrabalho = :distribuidora";
        Query query = session.createQuery(hql);
        query.setInteger("distribuidora", distribuidora);
        return (List<Funcionario>) query.list();
    }
    public List<Funcionario> GetAllByDistribuidoras(int distribuidora1, int distribuidora2) {
        String hql = "from Funcionario where LocalTrabalho = :distribuidora1 OR LocalTrabalho = :distribuidora2";
        Query query = session.createQuery(hql);
        query.setInteger("distribuidora1", distribuidora1);
        query.setInteger("distribuidora2", distribuidora2);
        return (List<Funcionario>) query.list();
    }
    public List<Funcionario> GetByName(String nome, int distribuidora) {
        String hql = "from Funcionario c where c.Nome like :nome and c.LocalTrabalho = :distribuidora";
        Query query = session.createQuery(hql);
        query.setString("nome", nome + "%");
        query.setInteger("distribuidora", distribuidora);
        return (List<Funcionario>) query.list();
    }
}
