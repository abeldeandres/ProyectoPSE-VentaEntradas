/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.InterfaceUsuario;
import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abel
 */
public class DaoRegisterUsuario implements InterfaceUsuario {
    private Session session;
    @Override
    public boolean register(Usuario usuario) throws Exception {
       session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();
        
        return true;
    }

    @Override
    public List<Usuario> getAll(Session session) throws Exception {
        String hql="FROM Usuario";
        return null;
    }

    @Override
    public boolean modificar(Usuario usuario) throws Exception {
        session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(usuario);
        transaction.commit();
        session.close();
        
        return true;
    }
    
    public void updateCustomer(Usuario cust) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
}
