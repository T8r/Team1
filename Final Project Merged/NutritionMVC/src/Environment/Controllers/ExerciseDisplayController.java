/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Controllers;

import Environment.Classes.Exercise;
import Environment.MainApplication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class ExerciseDisplayController implements Initializable {

    /**
     * @return the exercise
     */
    public Exercise getExercise() {
        return exercise;
    }

    /**
     * @param exercise the exercise to set
     */
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    
    public void UpdateView() {
         nameL.setText(exercise.getName());
        typeL.setText("Type : " +exercise.getType().toString());
        equipmentL.setText("Equipment : " + exercise.getEquipment().toString());
        metL.setText("MET : " + Double.toString(exercise.getMet()));
        descriptionTF.setText(exercise.getDescription());
        imageView.setImage(exercise.getImage());
       
        String caloriesBurned = Double.toString(Exercise.CaloriesBurned((double)exercise.getMet(), 10,  (double)Integer.parseInt(MainApplication.profile.medical.getWeight())));
        primaryMuscleL.setText("Primary Muscle : " + exercise.getMuscleTypeE().toString());
        typeL.setText("Type : " +exercise.getType().toString()+ "\nExpected Calories to Burn : " + caloriesBurned);
    }

    /**
     * @return the root
     */
    public Parent GetRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void SetRoot(Parent root) {
        this.root = root;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label nameL;
    @FXML
    private Label typeL;
    @FXML
    private Label equipmentL;
    @FXML
    private Label metL;
    @FXML
    private Label primaryMuscleL;
    @FXML
    private TextArea descriptionTF;
    @FXML
    ImageView imageView;
    
    private Parent root;
    private Exercise exercise;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    
    
 
}
