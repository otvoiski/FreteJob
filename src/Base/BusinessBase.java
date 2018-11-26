/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Otavio
 */
public abstract class BusinessBase {
    protected Session session;
    protected BusinessBase(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
}
