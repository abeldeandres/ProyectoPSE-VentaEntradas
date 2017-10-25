/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import dao.DaoCompra;
import dao.DaoIncrementoSaldo;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import modelo.Concierto;
import modelo.Ticketscomprados;
import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import util.HibernateUtil;
import util.MiUtil;

/**
 *
 * @author Abel
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    /**
     * Creates a new instance of loginBean
     */
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Ticketscomprados tickets;
    

   

    public loginBean() {
        this.usuarioDao = new UsuarioDaoImpl();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
        
        this.tickets = new Ticketscomprados();
        this.tickets.setIdTickets(Integer.MIN_VALUE);

    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean loggedIn;
        String ruta = "";
        this.usuario = this.usuarioDao.login(this.usuario);
        if (this.usuario != null) {
            if (usuario.isEsAdmin()==true)
            {
                loggedIn = true;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombre());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombre());
                ruta = MiUtil.baserutaLogin()+"vistas2/index.xhtml";
            }
            else{
                loggedIn = true;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombre());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombre());
                ruta = MiUtil.baserutaLogin()+"vistas/comprarConcierto.xhtml";
            }
            
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario o contraseña Invalido");
            if (this.usuario == null) {
                this.usuario = new Usuario();
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }
    
    public void logout()
    {
        String ruta=MiUtil.baserutaLogin()+"login.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
        sesion.invalidate();
        
        context.addCallbackParam("loggetOut",true);
        context.addCallbackParam("ruta",ruta);
    }
    
    //Hasta aqui
    
    public Concierto elegirConcierto(int custid) {
        Transaction trns = null;
        Concierto concierto = new Concierto();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Concierto cust = (Concierto) session.load(Concierto.class, new Integer(custid));
            concierto=cust;
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
        return concierto;
    }  
    
    public void registerConcierto() throws Exception
    {
        String msg;
        Concierto conciertoComprar = new Concierto();
        conciertoComprar = elegirConcierto(this.idConcierto);
        int NumEntradas=conciertoComprar.getNumEntradas();
        float saldo=usuario.getSaldo();
        
        if (usuario.getSaldo()>= conciertoComprar.getPrecio() && NumEntradas>0)
        {           
           NumEntradas=NumEntradas-1;
           saldo=saldo-conciertoComprar.getPrecio();
           //DaoRegisterTicket daotickets = new DaoRegisterTicket();    
           DaoCompra compra = new DaoCompra();
           conciertoComprar.setNumEntradas(NumEntradas);
           usuario.setSaldo(saldo);                 
           tickets.setUsuario(usuario);
           tickets.setConcierto(conciertoComprar);   
           //daotickets.registerTickets(this.tickets);
           compra.crearCompra(conciertoComprar, usuario, tickets);                         
        }
        else
        {
            msg="Error al comprar Concierto, saldo o tickets insuficientes";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
  
    }
    
    
    public int getIdConcierto() {
        return idConcierto;
    }

    public void setIdConcierto(int idConcierto) {
        this.idConcierto = idConcierto;
    }
    private int idConcierto;
    
    
}
