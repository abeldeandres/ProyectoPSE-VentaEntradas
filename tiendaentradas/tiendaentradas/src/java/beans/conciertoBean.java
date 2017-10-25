/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ConciertoDao;
import dao.ConciertoDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Concierto;

/**
 *
 * @author Abel
 */
@Named(value = "conciertoBean")
@RequestScoped
public class conciertoBean {
    
    private List<Concierto> conciertos;
    private Concierto selectedConcierto;
    private int borrar;

    public int getBorrar() {
        return borrar;
    }

    public void setBorrar(int borrar) {
        this.borrar = borrar;
    }
    
    /**
     * Creates a new instance of conciertoBean
     */
    public conciertoBean() {
        this.conciertos = new ArrayList<Concierto>();
    }

    public List<Concierto> getConciertos() {
        ConciertoDao conciertoDao = new ConciertoDaoImpl();
        this.conciertos = conciertoDao.findALL();
        return conciertos;
    }

    public Concierto getSelectedConcierto() {
        return selectedConcierto;
    }

    public void setSelectedConcierto(Concierto selectedConcierto) {
        this.selectedConcierto = selectedConcierto;
    }
 
    public void btnCreateConcierto(ActionEvent actionEvent){
        ConciertoDao conciertoDao = new ConciertoDaoImpl();
        String msg;
        if (conciertoDao.create(this.selectedConcierto))
        {
            msg="Se creo correctamente";
        } else
        {
            msg="Error al crear";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void btnUpdateConcierto(ActionEvent actionEvent){
        ConciertoDao conciertoDao = new ConciertoDaoImpl();
        String msg;
        if (conciertoDao.update(this.selectedConcierto))
        {
            msg="Se modifico correctamente";
        } else
        {
            msg="Error al modificar";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void btnDeleteConcierto(){
        ConciertoDao conciertoDao = new ConciertoDaoImpl();      
        conciertoDao.deleteConcierto(borrar);
        
    }
}
