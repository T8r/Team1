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
import Exercise.Equipment.Equipment;
import Exercise.Exercise.ExerciseTypeE;
import java.util.stream.Collectors;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.controlsfx.control.CheckComboBox;
import vaq_health.VAQ_Health;

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
    @FXML
    CheckComboBox exerciseEquipCCB;
    @FXML
    CheckComboBox exerciseTypeCCB;

    Exercise selectedExercise;
    Image balanceImage = new Image("balance.png");
    Image cardioImage = new Image("cardio.png");
    Image strengthImage = new Image("strength.png");
    ;
    Image flexibilityImage = new Image("flexibility.png");
    ;
    ArrayList<Exercise> exerciseList = new ArrayList<>();
    List<String> timeOpts = Arrays.asList("10m", "20m", "30m", "40m", "50m", "60m");
    Connection myConnection;
    Statement myStmt;
    ResultSet myRs;
    ProfileController profileController = new ProfileController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        exerciseTypeCCB.getItems().add(ExerciseTypeE.BALANCE.toString());
        exerciseTypeCCB.getItems().add(ExerciseTypeE.CARDIO.toString());
        exerciseTypeCCB.getItems().add(ExerciseTypeE.FLEXIBILITY.toString());
        exerciseTypeCCB.getItems().add(ExerciseTypeE.STRENGTH.toString());
        
        exerciseList = DatabaseManager.GetExerciseTable();
        
        if (exerciseList.size() > 0) {
            System.out.println(exerciseList.get(0).name);
        }

        ArrayList<Equipment> equipList = DatabaseManager.GetEquipmentList();
        for (Equipment equipment : equipList) {
            exerciseEquipCCB.getItems().add(equipment);
        }
        for (int i = 0; i < VAQ_Health.profile.exerciseProfile.equipmentList.size(); i++) {
             exerciseEquipCCB.getCheckModel().check(VAQ_Health.profile.exerciseProfile.equipmentList.get(i));
        }
         if (exerciseList.size() > 0)
        {
            exerciseLV.getSelectionModel().clearAndSelect(0);                   
            nameLabel.setText(exerciseList.get(0).name);
            discriptionTA.setText(exerciseList.get(0).description);
            metL.setText(String.valueOf(exerciseList.get(0).met));
                switch (exerciseList.get(0).type) {
                    case CARDIO:
                        typeImageV.setImage(cardioImage);
                        break;
                    case BALANCE:
                        typeImageV.setImage(balanceImage);
                        break;
                    case STRENGTH:
                        typeImageV.setImage(strengthImage);
                        break;
                    case FLEXIBILITY:
                        typeImageV.setImage(flexibilityImage);
                }
            
        }
        
        //Get rid of exercises that require equipment the user doesnt have
        UpdateExerciseList();

        discriptionTA.setWrapText(true);
        workoutTimeCB.setItems(FXCollections.observableList(timeOpts));
        workoutTimeCB.getSelectionModel().selectFirst();

        //EVENT HANDLERS
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
                discriptionTA.setText(selectedExercise.description);
                metL.setText(String.valueOf(selectedExercise.met));
                switch (selectedExercise.type) {
                    case CARDIO:
                        typeImageV.setImage(cardioImage);
                        break;
                    case BALANCE:
                        typeImageV.setImage(balanceImage);
                        break;
                    case STRENGTH:
                        typeImageV.setImage(strengthImage);
                        break;
                    case FLEXIBILITY:
                        typeImageV.setImage(flexibilityImage);
                }

                DisplayExercise(selectedExercise);
            }
        });

        exerciseEquipCCB.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends String> c) {
                System.out.println("test");
                UpdateExerciseList();
            }
        });

    }

    private void UpdateExerciseList() {
        ObservableList<Equipment> equipL = exerciseEquipCCB.getCheckModel().getCheckedItems();
        ArrayList<Exercise> filterdList = new ArrayList();
        for (int i = 0; i < exerciseList.size(); i++) {
            if (!exerciseList.get(i).equipment.getName().equals("0") && !equipL.contains(exerciseList.get(i).equipment)) {
              System.out.println("User doesnt have equipment");
            }
            else
                filterdList.add(exerciseList.get(i));
        }
        exerciseLV.setItems(FXCollections.observableList(filterdList));
    }

    public void SetCalories() {
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

    public void DisplayExercise(Exercise exercise) {
        SetCalories();
    }

    public void OpenHome() throws IOException {
        profileController.OpenExerciseHome();
    }

}
