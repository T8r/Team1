/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoutineHome;

import Exercise.Exercise;
import Routine.ExerciseRoutine;
import RoutineExerciseSlot.RoutineExerciseSlotController;
import RoutinePieChart.RoutinePieChart;
import TabManager.TabManager;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import vaq_health.VAQ_Health;

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
    VBox tuesdayVBox = new VBox();
    @FXML
    VBox wednesDayVBox = new VBox();
    @FXML
    VBox thursdayVBox = new VBox();
    @FXML
    VBox fridayVBox = new VBox();
    @FXML
    VBox saturdayVBox = new VBox();
    @FXML
    VBox sundayVBox = new VBox();
    @FXML
    AnchorPane exerciseSlotTemplate;
    @FXML
    Label WeeklyRoutineNameL;
    @FXML
    Label currentDayL;
    @FXML
    AnchorPane pieChartPane;
    TabManager profileController = new TabManager();
    boolean isMondayOpen, isTuesdayOpen, isThursdayOpen, isWednesDayOpen, isFridayOpen, isSaturdayOpen, isSundayOpen;
    @FXML
    ProgressIndicator mondayProgressIndicator;
    @FXML
    ProgressIndicator tuesdayProgressIndicator;
    @FXML
    ProgressIndicator wednesdayProgressIndicator;
    @FXML
    ProgressIndicator thursdayProgressIndicator;
    @FXML
    ProgressIndicator fridayProgressIndicator;
    @FXML
    ProgressIndicator saturdayProgressIndicator;
    @FXML
    ProgressIndicator sundayProgressIndicator;
    @FXML
    Label caloriesBurnedL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mondayVBox.setSpacing(5);
        WeeklyRoutineNameL.setText(VAQ_Health.profile.currentWeeklyRoutine.getName());
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        currentDayL.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
        UpdateProgressIndicators();
       
        pieChartPane.getChildren().add(new RoutinePieChart(VAQ_Health.profile.currentWeeklyRoutine.monday,300,300));
        UpdateCaloriesBurned();

    }

    @FXML
    private void ViewSunday() {
        if (!isSundayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {

            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.sunday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    sundayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sundayVBox.getChildren().remove(1, sundayVBox.getChildren().size());
        }
        isSundayOpen = !isSundayOpen;
        
        
    }

    @FXML
    private void ViewSaturday() {
        if (!isSaturdayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.saturday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    saturdayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            saturdayVBox.getChildren().remove(1, saturdayVBox.getChildren().size());
        }
        isSaturdayOpen = !isSaturdayOpen;
    }

    @FXML
    private void ViewFriday() {
        if (!isFridayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.friday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    fridayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            fridayVBox.getChildren().remove(1, fridayVBox.getChildren().size());
        }
        isFridayOpen = !isFridayOpen;
    }

    @FXML
    private void ViewThursday() {
        if (!isThursdayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.thursday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    thursdayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            thursdayVBox.getChildren().remove(1, thursdayVBox.getChildren().size());
        }
        isThursdayOpen = !isThursdayOpen;
    }

    @FXML
    private void ViewWednesday() {
        if (!isWednesDayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.wednesday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    wednesDayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            wednesDayVBox.getChildren().remove(1, wednesDayVBox.getChildren().size());
        }
        isWednesDayOpen = !isWednesDayOpen;
    }

    @FXML
    private void ViewTuesday() {
        if (!isTuesdayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.tuesday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    tuesdayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tuesdayVBox.getChildren().remove(1, tuesdayVBox.getChildren().size());
        }
        isTuesdayOpen = !isTuesdayOpen;
    }

    @FXML
    private void ViewMonday() {
        if (!isMondayOpen && VAQ_Health.profile.currentWeeklyRoutine != null) {
            try {
                int nCompletedExercises = 0;
                for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.monday) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/RoutineExerciseSlot/RoutineExerciseSlot.fxml"));
                    Parent root = loader.load();
                    RoutineExerciseSlotController controller = (RoutineExerciseSlotController) loader.getController();
                    controller.SetExercise(exerciseRoutine);
                    if (exerciseRoutine.isCompleted)
                        controller.Done();
                    controller.completeButton.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            controller.Done();
                            exerciseRoutine.isCompleted = true;
                            UpdateProgressIndicators();
                        }
                    });
                    mondayVBox.getChildren().add(root);
                }

            } catch (IOException ex) {
                Logger.getLogger(RoutineHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            mondayVBox.getChildren().remove(1, mondayVBox.getChildren().size());
        }
        isMondayOpen = !isMondayOpen;

    }

    @FXML
    private void OpenHome() throws IOException {
        profileController.OpenHome();
    }

    @FXML
    private void OpenCreator() throws IOException {
        profileController.OpenRoutineCreator();
    }

    @FXML
    private void OpenManager() throws IOException {
        profileController.OpenRoutineManger();
    }

    private void UpdateProgressIndicators() {

        double nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.monday) {
            if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        mondayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.monday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.tuesday) {
            if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        tuesdayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.tuesday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.wednesday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        wednesdayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.wednesday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.thursday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        thursdayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.thursday.size());

        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.friday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        fridayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.friday.size());
        
        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.saturday) {
            if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        saturdayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.saturday.size());
        
        nCompletedExercises = 0;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.sunday) {
           if (exerciseRoutine.isCompleted)
                nCompletedExercises += 1;
        }
        sundayProgressIndicator.setProgress(nCompletedExercises / VAQ_Health.profile.currentWeeklyRoutine.sunday.size());
        UpdateCaloriesBurned();
        

    }

    private void UpdateCaloriesBurned() {
        double caloriesBurned = 0;
        double userWeight = 100;
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.monday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.tuesday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.wednesday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.thursday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.friday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.saturday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.sunday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        for (ExerciseRoutine exerciseRoutine : VAQ_Health.profile.currentWeeklyRoutine.monday) {
            if (exerciseRoutine.isCompleted)
                caloriesBurned += Exercise.CaloriesBurned(exerciseRoutine.exercise.getMet(), exerciseRoutine.workOutTime, userWeight);
        }
        caloriesBurnedL.setText(Double.toString(caloriesBurned));
    }

}
