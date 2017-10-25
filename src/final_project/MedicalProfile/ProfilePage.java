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
                new HBox(new Label("City"),PersonalGUI.cityTF),
                new HBox(new Label("Email"),PersonalGUI.emailTF)
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
               new HBox(new Label("Are you suffering from diabetes currently?"),
                    new HBox(MedicalGUI.personalDiabetesRBy, MedicalGUI.personalDiabetesRBn)),
               new HBox(new Label("Has your family had a history with diabetes?"), 
                    new HBox(MedicalGUI.familyDiabetesRBy, MedicalGUI.familyDiabetesRBn)),
               new HBox(new Label("Other than diabetes has your family had a "
                       + "medical impairment history?"), 
                    new HBox(MedicalGUI.onOtherMedsRBy, MedicalGUI.onOtherMedsRBn)),
               new HBox(new Label("Are you considered abusing drugs currently?"), 
                    new HBox(MedicalGUI.drugAbuseRBy, MedicalGUI.drugAbuseRBn)),
               new HBox(new Label("Are you considered abusing alcohol currently?"),
                    new HBox(MedicalGUI.alcoholRBy, MedicalGUI.alcoholRBn)),
               new HBox(new Label("Are you experiencing heart complications?"),
                    new HBox(MedicalGUI.heartProblemsRBy, MedicalGUI.heartProblemsRBn)),
               new HBox(new Label("Do you have digestive problems?"),
                    new HBox(MedicalGUI.digestiveDisorderRBy, MedicalGUI.digestiveDisorderRBn)),
               new HBox(new Label("Do you posses high or low blood pressure?")),
               new HBox(new Label("Are you pregnant?")),//when Female is selected
               new HBox(new Label("Does your work involve strenuous labor or"
                       + " exorcise?"))
       );
       MedicalGUI.setToggles();
       tab.setContent(vBoxContent2);
       
       return tab;
   }
   public static Tab CreateAllergyTab(){
       Tab tab = new Tab("Allergies");
       VBox vBoxContent3 = new VBox(); 
       vBoxContent3.getChildren().addAll(
               new Label("Select the following Foods are you allergic to:"),
               new HBox(AllergyGUI.cbA1, AllergyGUI.cbA2, AllergyGUI.cbA3, AllergyGUI.cbA4),
               new HBox(AllergyGUI.cbA5, AllergyGUI.cbA6, AllergyGUI.cbA7, AllergyGUI.cbA8),
               new Label("Select the following Food types you're intolerant  to:"),
               new HBox(AllergyGUI.cbI1, AllergyGUI.cbI2, AllergyGUI.cbI3, AllergyGUI.cbI4),
               new HBox(AllergyGUI.cbI5, AllergyGUI.cbI6, AllergyGUI.cbI7, AllergyGUI.cbI8),
               new Label("Select the following Medications you're allergic to:")
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
       bigbtn.setOnAction(new EventHandler<ActionEvent>() {       
            @Override
            public void handle(ActionEvent event){
                Profile current = SaveProfile();
                PersonalGUI.resetPersonals();
                MedicalGUI.resetMedical();
                AllergyGUI.resetCheckboxes();
                
                OpenProfileTab(current);
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
        
        if(AllergyGUI.cbA1.isSelected()){
            newProfile.allergy.dairyA = AllergyGUI.cbA1.getText();
        }
        if(AllergyGUI.cbA2.isSelected()){
            newProfile.allergy.soyA = AllergyGUI.cbA2.getText();
        }
        if(AllergyGUI.cbA3.isSelected()){
            newProfile.allergy.eggsA = AllergyGUI.cbA3.getText();
        }
        if(AllergyGUI.cbA4.isSelected()){
            newProfile.allergy.peanutsA = AllergyGUI.cbA4.getText();
        }
        if(AllergyGUI.cbA5.isSelected()){
            newProfile.allergy.fishA = AllergyGUI.cbA5.getText();
        }
        if(AllergyGUI.cbA6.isSelected()){
            newProfile.allergy.wheatA = AllergyGUI.cbA6.getText();
        }
        if(AllergyGUI.cbA7.isSelected()){
            newProfile.allergy.sesameA = AllergyGUI.cbA7.getText();
        }
        if(AllergyGUI.cbA8.isSelected()){
            newProfile.allergy.tree_nutsA = AllergyGUI.cbA8.getText();
        }
        
        
        
        if(AllergyGUI.cbI1.isSelected()){
            newProfile.allergy.glutenI = AllergyGUI.cbI1.getText();
        }
        if(AllergyGUI.cbI2.isSelected()){
            newProfile.allergy.lactoseI = AllergyGUI.cbI2.getText();
        }
        if(AllergyGUI.cbI3.isSelected()){
            newProfile.allergy.fructoseI = AllergyGUI.cbI3.getText();
        }
        if(AllergyGUI.cbI4.isSelected()){
            newProfile.allergy.sulfitesI = AllergyGUI.cbI4.getText();
        }
        if(AllergyGUI.cbI5.isSelected()){
            newProfile.allergy.histaminesI = AllergyGUI.cbI5.getText();
        }
        if(AllergyGUI.cbI6.isSelected()){
            newProfile.allergy.nitritesI = AllergyGUI.cbI6.getText();
        }
        if(AllergyGUI.cbI7.isSelected()){
            newProfile.allergy.nightshadesI = AllergyGUI.cbI7.getText();
        }
        if(AllergyGUI.cbI8.isSelected()){
            newProfile.allergy.fructansI = AllergyGUI.cbI8.getText();
        }
        
        
        
        
        
        
        return newProfile;
    }
    
    
}