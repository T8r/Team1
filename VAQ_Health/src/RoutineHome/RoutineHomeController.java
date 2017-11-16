/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoutineHome;

import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutineHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    VBox mondayVBox = new VBox();
    @FXML
    AnchorPane exerciseSlotTemplate;
    ProfileController profileController  = new ProfileController();
    boolean isMondayOpen;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ViewMonday();
    }   
    @FXML
    private void ViewMonday()
    {
        if (!isMondayOpen)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                mondayVBox.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            for (int i=1; i < mondayVBox.getChildren().size(); i++)
            {
                mondayVBox.getChildren().remove(i);
            }
        }
        isMondayOpen = !isMondayOpen;
        
    }
    
    @FXML
    private void OpenHome() throws IOException
    {
        profileController.OpenHome();
    }
    
    @FXML
    private void OpenManager() throws IOException
    {
        profileController.OpenRoutineManager();
    }
   
    
}
