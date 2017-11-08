/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaq_health;

import Profile.Profile;
import java.security.MessageDigest;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ^.^
 */
public class VAQ_Health extends Application {
    
   static public Stage mainStage;
   static public Profile profile = new Profile();
   
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/SignIn/SignIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        mainStage = stage;
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
