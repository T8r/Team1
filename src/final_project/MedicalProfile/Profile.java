/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

/**
 *
 * @author Stephen
 */
public class Profile {
    public Personal personal;
    public Medical medical;
    public Allergy allergy;
    
    @Override
    public String toString(){
        return personal.toString() +"\n"
                + medical.toString() +"\n"
                + allergy.toString();
    }
    
}
