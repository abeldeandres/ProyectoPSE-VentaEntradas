/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;
import modelo.Usuario;
import org.hibernate.Session;

/**
 *
 * @author Abel
 */
public interface InterfaceUsuario {
    public boolean register(Usuario usuario) throws Exception;
    public boolean modificar(Usuario usuario) throws Exception;
    public List<Usuario> getAll(Session session) throws Exception;
    public void updateCustomer(Usuario cust)throws Exception;
}
