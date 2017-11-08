/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;

import Profile.ProfileController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Database.DatabaseManager;

/**
 * FXML Controller class
 *
 * @author Stephen
 */
public class ExerciseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ListView exerciseLV;
    @FXML
    Label nameLabel;
    @FXML
    TextArea discriptionTA;
    @FXML
    ImageView typeImageV;
    @FXML
    ComboBox workoutTimeCB;
    @FXML
    Label caloriesL;
    @FXML
    Label metL;
    
    Exercise selectedExercise ;
    Image balanceImage = new Image("balance.png");
    Image cardioImage = new Image("cardio.png");
    Image strengthImage = new Image("strength.png");;
    Image flexibilityImage = new Image("flexibility.png");;
    ArrayList<Exercise> exerciseList = new ArrayList<>();
    List<String> timeOpts = Arrays.asList("10m","20m","30m","40m","50m","60m");
    Connection myConnection;
    Statement myStmt;
    ResultSet myRs;
    ProfileController profileController = new ProfileController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        discriptionTA.setWrapText(true);
        workoutTimeCB.setItems(FXCollections.observableList(timeOpts));
        workoutTimeCB.getSelectionModel().selectFirst();
        workoutTimeCB.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
              SetCalories();
            }
        });
        exerciseLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Exercise>() {
        
            @Override
            public void changed(ObservableValue<? extends Exercise> observable, Exercise oldValue, Exercise newValue) {
                selectedExercise = newValue;
                nameLabel.setText(selectedExercise.name);
                discriptionTA.setText(selectedExercise.discription);
                metL.setText(String.valueOf(selectedExercise.met));
               switch(selectedExercise.type){
                   case "CARDIO":  typeImageV.setImage(cardioImage);
                                   break;
                   case "BALANCE": typeImageV.setImage(balanceImage);
                                   break;
                   case "STRENGTH": typeImageV.setImage(strengthImage);
                                   break;
                   case "FLEXIBILITY": typeImageV.setImage(flexibilityImage);
               }
              
               DisplayExercise(selectedExercise);
            }
        });
        GetExercisesFromDB();
    } 
    
    public void SetCalories()
    {
        double t = 0;
        switch (workoutTimeCB.getSelectionModel().getSelectedItem().toString()) {
            case "10m":
                t = 10;
                break;
            case "20m":
                t = 20;
                break;
            case "30m":
                t = 30;
                break;
            case "40m":
                t = 40;
                break;
            case "50m":
                t = 50;
                break;
            case "60m":
                t = 60;
                break;
        }
        t /= 60;
        double caloriesBurned = Exercise.CaloriesBurned(selectedExercise.met, t, 70);
        DecimalFormat dec = new DecimalFormat("#0.00");

        caloriesL.setText(dec.format(caloriesBurned));
    }
    public void DisplayExercise(Exercise exercise)
    {
        SetCalories();
    }
    
    public void GetExercisesFromDB()
    {
        exerciseList = DatabaseManager.GetExerciseTable();
        if (exerciseList.size() > 0)
            System.out.println(exerciseList.get(0).name);
        exerciseLV.setItems(FXCollections.observableList(exerciseList));            
    }
    
    public void OpenHome() throws IOException
    {
        profileController.OpenHome();
    }
}
