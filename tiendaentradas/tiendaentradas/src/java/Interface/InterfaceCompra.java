/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import modelo.Concierto;
import modelo.Ticketscomprados;
import modelo.Usuario;

/**
 *
 * @author Abel
 */
public interface InterfaceCompra {
    public void crearCompra(Concierto concierto, Usuario usuario, Ticketscomprados tickets)throws Exception;
}
