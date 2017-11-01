/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaq_health;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author Stephen
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        TranslateTransition t = new TranslateTransition();
        t.setDuration(Duration.seconds(2));
        t.setNode((Node) event.getSource());
        t.setToX(-100);
        t.rateProperty().set(4);
        t.setToY(0);
        t.setAutoReverse(true);
        t.setCycleCount(1);
        t.play();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
