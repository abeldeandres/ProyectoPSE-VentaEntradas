/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.InterfaceTickets;
import modelo.Ticketscomprados;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abel
 */
public class DaoRegisterTicket implements InterfaceTickets {

    private Session session;
    @Override
    public boolean registerTickets(Ticketscomprados tickets) throws Exception {
       session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tickets);
        transaction.commit();
        session.close();
        
        return true;
    }
    
}
