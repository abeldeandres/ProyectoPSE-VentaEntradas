/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import util.MiUtil;

/**
 *
 * @author Abel
 */
@ManagedBean
@ApplicationScoped
public class appBean {

    /**
     * Creates a new instance of appBean
     */
    public appBean() {
    }
    
    
    public String getBaseUrl()
    {
        return MiUtil.baseurl();
    }
    
    public String getBasePathAdmin()
    {
        return MiUtil.basepathAdmin();
    }
    
    public String getBasePathUser()
    {
        return MiUtil.basepathUser();
    }
    
}
