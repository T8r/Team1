/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Exercise;

import Database.DatabaseManager;
import Disease.Disease;
import Exercise.Equipment.Equipment;
import Exercise.Exercise;
import Profile.Allergies.Allergy;
import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.CheckListView;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    CheckListView equipmentCCB;
    @FXML
    ImageView equipmentIV;
    
    Image bicycleImage = new Image("/Equipment/bike.jpg");
    Image weightImage = new Image("/Equipment/weight.jpg");
    Image jumpRopeImage = new Image("/Equipment/jumpRope.png");
    ProfileController profileController = new ProfileController();
    ArrayList<Equipment> equipmentList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         equipmentList = DatabaseManager.GetEquipmentList();

        for (Equipment equipment : equipmentList) {         
            equipmentCCB.getItems().add(equipment);
        }
       
        equipmentCCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipment>() {
             @Override
             public void changed(ObservableValue<? extends Equipment> observable, Equipment oldValue, Equipment equipment) {
                 if (equipment.getName().equals("Bicycle"))
                {
                    equipmentIV.setImage(bicycleImage);
                }
                else if (equipment.getName().equals("Jump Rope"))
                    equipmentIV.setImage(jumpRopeImage);
                else
                    equipmentIV.setImage(weightImage);
             }
           
        });   
         DisplayExerciseProfile();
    }  
    
    private void DisplayExerciseProfile() {

        for (int i = 0; i < VAQ_Health.profile.exerciseProfile.equipmentList.size(); i++) {
             equipmentCCB.getCheckModel().check(VAQ_Health.profile.exerciseProfile.equipmentList.get(i));
        }
//        if (equipmentList.size() > 0){
//            equipmentCCB.getSelectionModel().select(0);                   
//        }
    }
    
    @FXML
    public void Save()
    {
        for (int i = 0; i < equipmentList.size(); i++) {
            Equipment equipment = equipmentList.get(i);
            if (VAQ_Health.profile.exerciseProfile.equipmentList.contains(equipment))
            {
                 if (!equipmentCCB.getCheckModel().isChecked(i))
                    VAQ_Health.profile.exerciseProfile.equipmentList.remove(equipment);   
            }
            else if (equipmentCCB.getCheckModel().isChecked(i))
                VAQ_Health.profile.exerciseProfile.equipmentList.add(equipment);     
                
            System.out.println("Equipment: " + equipmentCCB.getCheckModel().getItem(i).toString() + ":   " + equipmentCCB.getCheckModel().isChecked(i));
        }
        DatabaseManager.UpdateExerciseProfile(VAQ_Health.profile);
    }
    
     @FXML
    public void OpenPersonal() throws IOException
    {
        profileController.OpenPersonal();
    }
    @FXML
    public void OpenHome() throws IOException
    {
        profileController.OpenHome();
    }
    @FXML
    public void OpenMedical() throws IOException
    {
        profileController.OpenMedical();
    }
    
}
