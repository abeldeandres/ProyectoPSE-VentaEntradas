/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Clases.Encrypt;
import java.util.List;
import modelo.Ticketscomprados;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abel
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario modelo =null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql ="FROM Usuario WHERE nombre='"+usuario.getNombre()+"'";
        try {
            sesion.beginTransaction();
            modelo=(Usuario) sesion.createQuery(sql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return modelo;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario modelo= this.findByUsuario(usuario);
        if (modelo!=null)
        {
            usuario.setContrasenia(Encrypt.sha512(usuario.getContrasenia()));
            if(!usuario.getContrasenia().equals(modelo.getContrasenia()))
                modelo=null;
           
        }
        return modelo;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listado=null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql ="FROM Usuario";
        try {
            sesion.beginTransaction();
            listado= sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listado;
    }

    @Override
    public boolean create(Usuario usuario) {
        Boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean update(Usuario usuario) {
        Boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }
    
    @Override
    public void deleteCustomer(int custid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario cust = (Usuario) session.load(Usuario.class, new Integer(custid));
            session.delete(cust);
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
    
    @Override
    public void añadirsaldo(int custid,float cantidad) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Usuario cust = (Usuario) session.load(Usuario.class, new Integer(custid));
            float saldo =cust.getSaldo()+cantidad;
            cust.setSaldo(saldo);
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
