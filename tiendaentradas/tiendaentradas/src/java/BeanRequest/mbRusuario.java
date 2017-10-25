/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanRequest;

import Clases.Encrypt;
import dao.DaoRegisterUsuario;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import modelo.Usuario;

/**
 *
 * @author Abel
 */
@Named(value = "mbRusuario")
@RequestScoped
public class mbRusuario {
    private Usuario usuario;
    private List<Usuario> listaUsuario;
    boolean opcion=false;
    
    
    /**
     * Creates a new instance of mbRusuario
     */
    public mbRusuario() throws Exception {
        float saldo=0;
        this.usuario=new Usuario();
        this.usuario.setIdUsuario(Integer.MIN_VALUE);
        this.usuario.setSaldo(saldo);
    }


    public void register() throws Exception
    {
            String msg;
            this.usuario.setContrasenia(Encrypt.sha512(this.usuario.getContrasenia()));
            DaoRegisterUsuario daoRegisterUsuario = new DaoRegisterUsuario();
            daoRegisterUsuario.register(this.usuario);
            msg="Se creo correctamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);


    }
    
    
     public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
