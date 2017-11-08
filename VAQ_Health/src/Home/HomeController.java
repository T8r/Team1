/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ProfileController profileController = new ProfileController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void OpenProfile() throws IOException
    {
        profileController.OpenPersonal();
    }
    
    @FXML
    public void OpenExercise() throws IOException
    {
        profileController.OpenExercise();
    }
    
    @FXML
    private void OpenSignIn() throws IOException
    {
         profileController.OpenSignIn();
    }
    
}
