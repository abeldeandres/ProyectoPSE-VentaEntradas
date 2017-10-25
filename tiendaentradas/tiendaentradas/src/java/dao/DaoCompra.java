/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Concierto;
import modelo.Ticketscomprados;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abel
 */
public class DaoCompra {
     public void crearCompra(Concierto concierto, Usuario usuario, Ticketscomprados tickets)throws Exception{
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(concierto);
            session.update(usuario);
            session.save(tickets);
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
