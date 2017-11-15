/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Medical;

import Database.DatabaseManager;
import Disease.Disease;
import Profile.Allergies.Allergy;
import Profile.Profile;
import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
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
    @FXML
    CheckListView diseaseCCB;
    @FXML
    TextArea diseaseTA;
    @FXML
    TextArea allergyTA;
    
    Profile profile;
    ArrayList<Allergy> allergyList;
    ArrayList<Disease> diseaseList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        profile = VAQ_Health.profile;
        allergyList = DatabaseManager.GetAllergyList();
        diseaseList = DatabaseManager.GetDiseaseList();
        allergyTA.setWrapText(true);
        diseaseTA.setWrapText(true);
        DisplayMedicalProfile();
        diseaseCCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Disease>() {
            @Override
            public void changed(ObservableValue<? extends Disease> observable, Disease oldValue, Disease disease) {
                 diseaseTA.setText(disease.getDiscription());
            }
        });
        
        allergyCCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Allergy>() {
            @Override
            public void changed(ObservableValue<? extends Allergy> observable, Allergy oldValue, Allergy allergy) {
                 allergyTA.setText(allergy.getDescription());
            }
        });
        

    }

    private void DisplayMedicalProfile() {
       

        //Allergy
        for (Allergy allergy : allergyList) {

            allergyCCB.getItems().add(allergy);
        }
        for (int i = 0; i < VAQ_Health.profile.medical.allergyList.size(); i++) {
             allergyCCB.getCheckModel().check(VAQ_Health.profile.medical.allergyList.get(i));
        }
        if (allergyList.size() > 0)
        {
            allergyCCB.getSelectionModel().clearAndSelect(0);                   
            allergyTA.setText(allergyList.get(0).getDescription());
        }

        //Disease
        for (Disease disease : diseaseList) {

            diseaseCCB.getItems().add(disease);
        }
        for (int i = 0; i < VAQ_Health.profile.medical.diseaseList.size(); i++) {
            diseaseCCB.getCheckModel().check(VAQ_Health.profile.medical.diseaseList.get(i));
        }
        
        if (diseaseList.size() > 0)
        {
            diseaseCCB.getSelectionModel().clearAndSelect(0);                   
            diseaseTA.setText(diseaseList.get(0).getDiscription());
        }
        
        //Weight & Height
        weightTF.setText(profile.medical.getWeight());
        heightTF.setText(profile.medical.getHeight());

    }

    @FXML
    public void OpenPersonal() throws IOException {
        profileController.OpenPersonal();
    }

    @FXML
    public void OpenExercise() throws IOException {
        profileController.OpenProfileExercise();
    }

    @FXML
    public void OpenHome() throws IOException {
        profileController.OpenHome();
    }

    @FXML
    public void OpenExport() throws IOException {
        profileController.OpenProfileExport();
    }
    
    @FXML
    public void SaveButtion() {
        if (weightTF.getText() != null) {
            VAQ_Health.profile.medical.setWeight(weightTF.getText());
        }
        if (heightTF.getText() != null) {
            VAQ_Health.profile.medical.setHeight(heightTF.getText());
        }
        if (hasDiabetesChB.isSelected()) {
            VAQ_Health.profile.medical.setHasDiabetes(true);
        } else {
            VAQ_Health.profile.medical.setHasDiabetes(false);
        }

        if (hasHighCholesterol.isSelected()) {
            VAQ_Health.profile.medical.setHasHighCholesterol(true);
        } else {
            VAQ_Health.profile.medical.setHasHighCholesterol(false);
        }

        if (hasCeliacDisease.isSelected()) {
            VAQ_Health.profile.medical.setHasCeliacDisease(true);
        } else {
            VAQ_Health.profile.medical.setHasCeliacDisease(false);
        }

        if (hasKidneyDisease.isSelected()) {
            VAQ_Health.profile.medical.setHasKidneyDisease(true);
        } else {
            VAQ_Health.profile.medical.setHasKidneyDisease(false);
        }

        if (hasHighBloodPressure.isSelected()) {
            VAQ_Health.profile.medical.setHasHighBloodPressure(true);
        } else {
            VAQ_Health.profile.medical.setHasHighBloodPressure(false);
        }

        if (hasGout.isSelected()) {
            VAQ_Health.profile.medical.setHasGout(true);
        } else {
            VAQ_Health.profile.medical.setHasGout(false);
        }

        for (int i = 0; i < allergyList.size(); i++) {
            Allergy allergy = allergyList.get(i);
            if (VAQ_Health.profile.medical.allergyList.contains(allergy))
            {
                 if (!allergyCCB.getCheckModel().isChecked(i))
                    VAQ_Health.profile.medical.allergyList.remove(allergy);   
            }
            else if (allergyCCB.getCheckModel().isChecked(i))
                VAQ_Health.profile.medical.allergyList.add(allergy);     
                
            System.out.println("Allergy: " + allergyCCB.getCheckModel().getItem(i).toString() + ":   " + allergyCCB.getCheckModel().isChecked(i));
        }
        
        for (int i = 0; i < diseaseList.size(); i++) {
            Disease disease = diseaseList.get(i);
            if (VAQ_Health.profile.medical.diseaseList.contains(disease))
            {
                 if (!diseaseCCB.getCheckModel().isChecked(i))
                    VAQ_Health.profile.medical.diseaseList.remove(disease);   
            }
            else if (diseaseCCB.getCheckModel().isChecked(i))
                VAQ_Health.profile.medical.diseaseList.add(disease);     
                
            System.out.println("Disease: " + diseaseCCB.getCheckModel().getItem(i).toString() + ":   " + diseaseCCB.getCheckModel().isChecked(i));
        }
        
        System.out.println(VAQ_Health.profile.medical);
        DatabaseManager.UpdateMedical(VAQ_Health.profile);
    }

}
