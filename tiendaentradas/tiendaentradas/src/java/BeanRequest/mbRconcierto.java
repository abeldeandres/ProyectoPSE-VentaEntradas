/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanRequest;

import dao.DaoConcierto;
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
@Named(value = "mbRconcierto")
@RequestScoped
public class mbRconcierto {

    /**
     * Creates a new instance of mbRconcierto
     */
    

    private Concierto concierto;
    private List<Concierto> listaConcierto;
    public mbRconcierto() {
        this.concierto=new Concierto();
        this.concierto.setIdConcierto(Integer.MIN_VALUE);
    }
    
    public void registerConcierto() throws Exception
    {
        String msg;
        DaoConcierto daoConcierto = new DaoConcierto();
        daoConcierto.crearConcierto(this.concierto);
        msg="Se creo correctamente";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        this.concierto = concierto;
    }

    public List<Concierto> getListaConcierto() {
        return listaConcierto;
    }

    public void setListaConcierto(List<Concierto> listaConcierto) {
        this.listaConcierto = listaConcierto;
    }
}
