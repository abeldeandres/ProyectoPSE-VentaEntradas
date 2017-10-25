/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Concierto;

/**
 *
 * @author Abel
 */
public interface ConciertoDao {
    public List<Concierto> findALL();
    public boolean create(Concierto concierto);
    public boolean update(Concierto concierto);
    public void deleteConcierto(int custid);
}
