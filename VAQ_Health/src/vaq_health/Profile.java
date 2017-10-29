/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaq_health;

import Profile.Data.Allergy;
import Profile.Data.Medical;
import Profile.Data.Personal;

/**
 *
 * @author ^.^
 */
public class Profile {
    public Personal personal = new Personal();
    public Medical medical = new Medical();
    public Allergy allergies = new Allergy();
    
    @Override
    public String toString()
    {      
        return personal.toString();
    }
}
