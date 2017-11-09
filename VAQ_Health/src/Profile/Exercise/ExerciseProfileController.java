/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Exercise;

import Database.DatabaseManager;
import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.CheckListView;

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
    ProfileController profileController = new ProfileController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ArrayList<String> equipmentList = DatabaseManager.GetEquipmentList();

        for (String equipment : equipmentList) {
            equipmentCCB.getItems().add(equipment);
        }
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
