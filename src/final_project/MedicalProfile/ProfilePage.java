/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Stephen
 */
public class ProfilePage {

   public static Tab CreateProfilePage()
   {
        Tab  tab = new Tab("Personal");
        VBox  vBoxContent = new VBox();
        vBoxContent.getChildren().addAll(
                new HBox(new Label("First Name"),PersonalGUI.fNameTF),
                new HBox(new Label("Last Name"), PersonalGUI.lNameTF),
                new HBox(new Label("Address"), PersonalGUI.addressTF),
                new HBox(new Label("State"), PersonalGUI.stateTF),
                new HBox(new Label("City"),PersonalGUI.cityTF)
        );
        tab.setContent(vBoxContent);
        return tab;
   }
   
   public static void OpenProfileTab(Profile profile)
    {
        PersonalGUI.fNameTF.setText(profile.personal.fname);
        
    }
    public static Profile SaveProfile()
    {
        Profile newProfile = new Profile();
        newProfile.personal.fname = PersonalGUI.fNameTF.getText();
        return newProfile;
    }
    
}
