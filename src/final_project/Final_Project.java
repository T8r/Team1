/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import final_project.MedicalProfile.Personal;
import final_project.MedicalProfile.ProfilePage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Stephen
 */
public class Final_Project extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TabPane tabPane = new TabPane();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(200,50,10,200));
        tabPane.getTabs().add(ProfilePage.CreateProfilePage());
        root.setCenter(tabPane);
        root.setTop(new Label("PROFILE"));
        
        Scene scene = new Scene(root, 1000, 1000);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
