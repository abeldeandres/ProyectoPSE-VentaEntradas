/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Abel
 */
@Named(value = "usuarioBean")
@RequestScoped
public class usuarioBean {

    /**
     * Creates a new instance of usuarioBean
     */
    private List<Usuario> usuarios;
    private Usuario selectedUsuario;
    private int borrar;
    private float cantidad=0;
    private float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

  


    public int getBorrar() {
        return borrar;
    }

    public void setBorrar(int borrar) {
        this.borrar = borrar;
    }
    
    /**
     * Creates a new instance of usuarioBean
     */

    
    public usuarioBean() {
        this.usuarios = new ArrayList<>();
        
    }

    public List<Usuario> getUsuarios() {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.usuarios = usuarioDao.findAll();
        return usuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    

    
    public void btnUpdateUsuario(ActionEvent actionEvent)
    {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        if (usuarioDao.update(this.selectedUsuario)) {
            msg="Se modifico correctamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else
        {
            msg="Error al modificar Usuario";
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
 
    public void btnDeleteUsuario()
    {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuarioDao.deleteCustomer(borrar);      
    }
    
    public void añadirSaldo()
    {
     this.cantidad=this.saldo;
     UsuarioDao añadirSaldo = new UsuarioDaoImpl();
     añadirSaldo.añadirsaldo(borrar, cantidad);
    }
    
    
    
    

    
  
}
