/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Stephen
 */
public class Personal {
    
    public String fname;
    public String lName;
    public String sex;
    public Integer age;
    public String address;
    public String state;
    public String city;
    public String email;
    
    
    @Override
    public String toString(){
        return "\nPersonal Information:"+
               "\nFirst Name: "+fname+
                "\nLast Neme: "+lName+
                "\nSex: "+sex+
                "\nAddress: "+address+
                "\nState: "+state+
                "\nCity: "+city+
                "\nEmail: "+email;
    }
    
}