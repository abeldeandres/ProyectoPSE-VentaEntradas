/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.InterfaceConcierto;
import modelo.Concierto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abel
 */
public class DaoConcierto implements InterfaceConcierto {
    private Session session;
    @Override
    public boolean crearConcierto(Concierto concierto) throws Exception {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();
        session.save(concierto);
        transaction.commit();
        session.close();
        return true;
    }
    
    @Override
    public boolean update(Concierto concierto) {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(concierto);
        transaction.commit();
        session.close();
        
        return true;
    }

    
}
