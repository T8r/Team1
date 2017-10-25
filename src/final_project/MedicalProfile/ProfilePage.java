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
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Stephen
 */
public class ProfilePage {

    /**
     * This is the makeup look for Personals Tab*/
   public static Tab CreateProfilePage(){
        Tab  tab = new Tab("Personal");
        VBox  vBoxContent1 = new VBox();
        vBoxContent1.getChildren().addAll(
                new HBox(new Label("First Name"),PersonalGUI.fNameTF),
                new HBox(new Label("Last Name"), PersonalGUI.lNameTF),
                new HBox(new Label("Sex"), PersonalGUI.sexRB1, 
                        PersonalGUI.sexRB2),
                new HBox(new Label("Address"), PersonalGUI.addressTF),
                new HBox(new Label("State"), PersonalGUI.stateTF),
                new HBox(new Label("City"),PersonalGUI.cityTF)
        );
        PersonalGUI.setToggles();
        tab.setContent(vBoxContent1);
        return tab;
   }
   
   /**
    * This is the makeup look for Medical Tab*/
   public static Tab CreateMedicalTab(){
       Tab tab = new Tab("Medical History");
       VBox vBoxContent2 = new VBox();
       vBoxContent2.getChildren().addAll(
               new HBox(new Label("Has your family had a history with diabetes?")),
               new HBox(new Label("Other than diabetes has your family had a "
                       + "medical impairment history?")),//choice
               new HBox(new Label("Are you abusing drugs or alcohol?")),//y/n
               new HBox(new Label("Are you experiencing heart complications?")),//y/n
               new HBox(new Label("Do you have digestive problems?")),//y/n
               new HBox(new Label("Do you posses high or low blood pressure?")),
               new HBox(new Label("Are you pregnant?")),//when Female is selected
               new HBox(new Label("Does your work involve strenuous labor or"
                       + " exorcise?"))
       );
       tab.setContent(vBoxContent2);
       
       return tab;
   }
   public static Tab CreateAllergyTab(){
       Tab tab = new Tab("Allergies");
       VBox vBoxContent3 = new VBox(); 
       vBoxContent3.getChildren().addAll(
               new Label("Select the following Medications you're allergic to:"),
               
       
               new Label("Select the following Food types you're allergic to:")
       
       );
       
       tab.setContent(vBoxContent3);
       return tab;
   }
   
   /**
    * For now a place away from the main tabs where we are 
    * ready to collect the information from for the profile
    */
   public static Tab CreateConfirmationTab(){
       Tab tab = new Tab("Confirmation");
       VBox vBoxContent4 = new VBox();
       Button bigbtn = new Button("Confirmation");
       bigbtn.setOnAction(new EventHandler<ActionEvent>() {                                                    //e -> primaryStage.setScene(scene2)
            @Override
            public void handle(ActionEvent event){
                SaveProfile();
            }
        });
       
       vBoxContent4.getChildren().addAll(
               bigbtn
       );
       
       tab.setContent(vBoxContent4);
       return tab;
   }
   
   public static void OpenProfileTab(Profile profile){
        PersonalGUI.fNameTF.setText(profile.personal.fname);
        
    }
   
   /**
    * Want this to be the work to collect the Profile 
    * from the collected work
    * @return 
    */
    public static Profile SaveProfile(){
        Profile newProfile = new Profile();
        newProfile.personal.fname = PersonalGUI.fNameTF.getText();
        newProfile.personal.lName = PersonalGUI.lNameTF.getText();
        RadioButton endSexRB = new RadioButton();
        if(PersonalGUI.sexTG.getSelectedToggle() == null)
                    endSexRB.setText("No Sex Selected");
                else
                    endSexRB = (RadioButton) PersonalGUI.sexTG.getSelectedToggle();
        newProfile.personal.sex = endSexRB.getText();
        newProfile.personal.address = PersonalGUI.addressTF.getText();
        newProfile.personal.state = PersonalGUI.stateTF.getText();
        newProfile.personal.email = PersonalGUI.emailTF.getText();
        
        
        return newProfile;
    }
    
    
}
