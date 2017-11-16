/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoutineManager;

import Database.DatabaseManager;
import Exercise.Exercise;
import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class RoutineController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ListView exerciseLV = new ListView();
    @FXML
    ListView mondayRoutineLV = new ListView();
    @FXML 
    ImageView imageV = new ImageView();
    ArrayList<Exercise> exerciseList = new ArrayList<>();
    ProfileController profileController = new ProfileController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        TranslateTransition transition = new TranslateTransition();
//        transition.setDuration(Duration.seconds(10));
//        transition.setNode(imageV);
//        transition.setToX(100);
//        transition.play();
        ImageView imageCopyV = new ImageView();
        imageCopyV.setImage(imageV.getImage());
        //VAQ_Health.mainScene.
         exerciseList = DatabaseManager.GetExerciseTable();
         for (Exercise exercise : exerciseList) {
            exerciseLV.getItems().add(exercise);
            mondayRoutineLV.getItems().add(exercise);
        }
    }   
    
    @FXML
    public void OpenRoutineHome() throws IOException
    {
        profileController.OpenRoutine();
    }
    
}
