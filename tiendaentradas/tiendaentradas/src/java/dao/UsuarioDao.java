/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Ticketscomprados;
import modelo.Usuario;

/**
 *
 * @author Abel
 */
public interface UsuarioDao {
    public Usuario findByUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
    public List<Usuario> findAll();
    public boolean create(Usuario usuario);
    public boolean update(Usuario usuario);
    public void deleteCustomer(int custid);
    public void añadirsaldo(int custid,float cantidad);

    
   
}
