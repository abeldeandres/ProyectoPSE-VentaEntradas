/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import modelo.Concierto;

/**
 *
 * @author Abel
 */
public interface InterfaceConcierto {
    public boolean crearConcierto(Concierto concierto)throws Exception;
    public boolean update(Concierto concierto)throws Exception;
    
}
