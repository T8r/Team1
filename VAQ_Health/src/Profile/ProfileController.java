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
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenPersonal()throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("/Profile/Personal1/Profile_Personal.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenProfileExercise()throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/Profile/Exercise/ExerciseProfile.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    public void OpenExerciseHome() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/ExerciseHome/ExerciseHome.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/ExerciseHome/ExerciseHome.css").getPath());
        VAQ_Health.mainStage.setScene(scene);
       VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show(); 
    }
    
    public void OpenHome() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/Home/Home.fxml"));
        
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenCreateAccount() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/SignIn/CreateAccount/CreateAccount.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show(); 
    }
    
    public void OpenSignIn() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/SignIn/SignIn.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show(); 
    }

    public void OpenExercises() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Exercise/Exercise.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene); 
        VAQ_Health.mainScene = scene;
        VAQ_Health.mainStage.show();
    }
    
    public void OpenRoutine() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Routine/Routine.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);  
        VAQ_Health.mainScene = scene; 
        VAQ_Health.mainStage.show();
    }

    public void OpenProfileExport() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Profile/Export/Export.fxml"));
        Scene scene = new Scene(root);
        VAQ_Health.mainStage.setScene(scene);  
        VAQ_Health.mainScene = scene; 
        VAQ_Health.mainStage.show();
    }
    
  
    
}
