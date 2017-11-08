/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Medical;

import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void OpenPersonal() throws IOException
    {
        profileController.OpenPersonal();
    }
    @FXML
    public void OpenAllergies() throws IOException
    {
        profileController.OpenAllergies();
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
