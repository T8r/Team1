/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

import javafx.scene.control.TextField;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/**
 *
 * @author Stephen
 */
public class PersonalGUI {
    static public TextField fNameTF = new TextField();
    static public TextField lNameTF = new TextField();
    public static RadioButton sexRB1 = new RadioButton("Male");
    public static RadioButton sexRB2 = new RadioButton("Female");
    public static final ToggleGroup sexTG = new ToggleGroup();
    static public TextField ageTF = new TextField();
    static public TextField addressTF = new TextField();
    static public TextField stateTF = new TextField();
    static public TextField cityTF = new TextField();
    static public TextField emailTF = new TextField();
    
    public static void setToggles(){
     sexRB1.setToggleGroup(sexTG);
     sexRB2.setToggleGroup(sexTG);
    }
    
    /**
     * Not working as intended, want to reset when confirmation is pushed
     */
    public static void resetPersonals(){
        fNameTF.setText("");
        lNameTF.setText("");
        sexRB1.setSelected(false);
        sexRB2.setSelected(false);
        ageTF.setText("");
        addressTF.setText("");
        cityTF.setText("");
        emailTF.setText("");
    
    }
    
    
}
