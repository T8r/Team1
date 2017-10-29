/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vaq_health.VAQ_Health;
import vaq_health.VAQ_Health;
import vaq_health.VAQ_Health;

/**
 *
 * @author ^.^
 */
public class ProfileController {
     
    public void OpenMedical() throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("/Profile/Medical/Profile_Medical1.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainStage.show();
    }
    
    public void OpenPersonal()throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("/Profile/Personal1/Profile_Personal.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainStage.show();
    }
    
    public void OpenAllergies()throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("/Profile/Allergies/Allergies.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainStage.show();
    }
    
}
