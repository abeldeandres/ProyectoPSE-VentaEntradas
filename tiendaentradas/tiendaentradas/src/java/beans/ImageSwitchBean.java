/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Abel
 */
@Named(value = "imageSwitchBean")
@Dependent
public class ImageSwitchBean {

    private List<String> images;
 
    public ImageSwitchBean() {
        images = new ArrayList<String>();
        images.add("nature1.jpg");
        images.add("nature2.jpg");
      
    }
 
    public List<String> getImages() {
        return images;
    }
}
