/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Medical;

import Database.DatabaseManager;
import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckListView;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class Profile_Medical1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    ProfileController profileController = new ProfileController();
    
    @FXML
    TextField weightTF = new TextField();
    @FXML
    TextField heightTF = new TextField();
    @FXML
    CheckBox hasDiabetesChB = new CheckBox();
    @FXML
    CheckBox hasHighCholesterol = new CheckBox();
    @FXML
    CheckBox hasCeliacDisease = new CheckBox();
    @FXML
    CheckBox hasKidneyDisease = new CheckBox();
    @FXML
    CheckBox hasHighBloodPressure = new CheckBox();
    @FXML
    CheckBox hasGout = new CheckBox();
    @FXML
    CheckListView allergyCCB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        FillAllergyList();
      
    }  
    
    private void FillAllergyList()
    {
        ArrayList<String> allergyList = DatabaseManager.GetAllergyList();

        for (String allergy : allergyList) {
   
            allergyCCB.getItems().add(allergy);          
        }
        //Doesnt let you check after adding. Adding apparently resets the checks of all the elements.... so loop again
        for (int i=0; i < allergyList.size(); i++)
        {
            if (VAQ_Health.profile.allergies.map.get(allergyList.get(i)))
            {
               allergyCCB.getCheckModel().check(allergyList.get(i));
            }
        }
        
    }
    
    private void FillMedicalGUI()
    {
        weightTF.setText(VAQ_Health.profile.medical.getWeight());
        heightTF.setText(VAQ_Health.profile.medical.getHeight());
        hasCeliacDisease.setDisable(VAQ_Health.profile.medical.getHasCeliacDisease());
        hasKidneyDisease.setDisable(VAQ_Health.profile.medical.getHasKidneyDisease());
        hasHighBloodPressure.setDisable(VAQ_Health.profile.medical.getHasHighBloodPressure());
        hasGout.setDisable(VAQ_Health.profile.medical.getHasGout());   
    }
    
    @FXML
    public void OpenPersonal() throws IOException
    {
        profileController.OpenPersonal();
    }
    @FXML
    public void OpenAllergies() throws IOException
    {
        profileController.OpenProfileExercise();
    }
    @FXML
    public void OpenHome() throws IOException
    {
        profileController.OpenHome();
    } 
    
    @FXML
    public void SaveButtion()
    {
        if (weightTF.getText() != null)
            VAQ_Health.profile.medical.setWeight(weightTF.getText()); 
        if (heightTF.getText() != null)
            VAQ_Health.profile.medical.setHeight(heightTF.getText());
        if (hasDiabetesChB.isSelected())
            VAQ_Health.profile.medical.setHasDiabetes(true);
        else
            VAQ_Health.profile.medical.setHasDiabetes(false);
        
        if (hasHighCholesterol.isSelected())
            VAQ_Health.profile.medical.setHasHighCholesterol(true);
        else
            VAQ_Health.profile.medical.setHasHighCholesterol(false);
        
        if (hasCeliacDisease.isSelected())
            VAQ_Health.profile.medical.setHasCeliacDisease(true);
        else
            VAQ_Health.profile.medical.setHasCeliacDisease(false);
        
        if (hasKidneyDisease.isSelected())
            VAQ_Health.profile.medical.setHasKidneyDisease(true);
        else
            VAQ_Health.profile.medical.setHasKidneyDisease(false);
        
        if (hasHighBloodPressure.isSelected())
            VAQ_Health.profile.medical.setHasHighBloodPressure(true);
        else
            VAQ_Health.profile.medical.setHasHighBloodPressure(false);
        
        if (hasGout.isSelected())
            VAQ_Health.profile.medical.setHasGout(true);
        else
            VAQ_Health.profile.medical.setHasGout(false);
        
        System.out.println(VAQ_Health.profile.medical);
    }
    
}
