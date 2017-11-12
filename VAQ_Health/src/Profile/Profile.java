/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

import Profile.Allergies.Allergy;
import Profile.Medical.Medical;
import Profile.Personal1.Personal;
import Profile.Personal1.Personal;
import Profile.Personal1.Personal;
import javafx.scene.image.Image;

/**
 *
 * @author ^.^
 */
public class Profile {
    public Personal personal = new Personal();
    public Medical medical = new Medical();
    public Allergy allergies = new Allergy();
    public String username;
    public String password;
    public String imagePath;
    public Image image;
    public int id;
    
    @Override
    public String toString()
    {      
        return personal.toString();
    }
}
