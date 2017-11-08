package Profile.Personal1;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Profile.Data.Personal;
import Profile.ProfileController;
import vaq_health.*;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import vaq_health.VAQ_Health;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */
public class Profile_PersonalController implements Initializable {

    
    //Personal Fields
    ArrayList<String> states = new ArrayList<String>(Arrays.asList("Alabama","Texas"));
    
    @FXML
    private TextField fNameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField zipTF;
    @FXML
    private ComboBox sexCB;
    @FXML
    private TextField addressTF;
    @FXML
    private ComboBox stateCB;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField birthdayTF;
    
    
    //Medical Fields
    
    ProfileController profileController = new ProfileController();
    @FXML
    private Label label;
    @FXML
    private JFXTextField ageTF;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stateCB.setItems(FXCollections.observableList(states));
        sexCB.setItems(FXCollections.observableArrayList(new ArrayList<String>(Arrays.asList("Male","Female"))));
        stateCB.getSelectionModel().select(0);
        sexCB.getSelectionModel().select(0);
        
        FillPersonal();

    }    

    @FXML
    private void OpenMedical() throws IOException {
        profileController.OpenMedical();
    }
    @FXML
    private void OpenHome() throws IOException
    {
         profileController.OpenHome();
    }
    @FXML
    private void OpenAllergies(MouseEvent event) throws IOException {
        profileController.OpenAllergies();
    }
    
    @FXML
    public void SaveButton()
    {
        if (fNameTF.getText() != null)
            VAQ_Health.profile.personal.setFname(fNameTF.getText());
        if (lNameTF.getText() != null)
            VAQ_Health.profile.personal.setlName(lNameTF.getText());
        if (addressTF.getText() != null)
            VAQ_Health.profile.personal.setAddress(addressTF.getText());
        if (cityTF.getText() != null)
            VAQ_Health.profile.personal.setCity(cityTF.getText());
        if (stateCB.getSelectionModel().getSelectedItem().toString() != null)
            VAQ_Health.profile.personal.setState(stateCB.getSelectionModel().getSelectedItem().toString());
        if (zipTF.getText() != null)
            VAQ_Health.profile.personal.setZipCode(zipTF.getText());
        if (sexCB.getSelectionModel().getSelectedItem().toString() != null)
            VAQ_Health.profile.personal.setSex(sexCB.getSelectionModel().getSelectedItem().toString());
        if (emailTF.getText() != null)
            VAQ_Health.profile.personal.setEmail(emailTF.getText());
        if (ageTF.getText().equals(""))//Check if int
               VAQ_Health.profile.personal.setAge(0);
        else 
            VAQ_Health.profile.personal.setAge(Integer.parseInt(ageTF.getText()));
        if (birthdayTF.getText() != null)
            VAQ_Health.profile.personal.setBirthday(birthdayTF.getText());
         
        DatabaseManager.UpdateProfile(VAQ_Health.profile);
        System.out.println(VAQ_Health.profile);
        
    }

    private void FillPersonal() {
         if (VAQ_Health.profile.personal.getFname() != null)
         {
             fNameTF.setText(VAQ_Health.profile.personal.getFname());
         }
         if (VAQ_Health.profile.personal.getlName()!= null)
         {
             lNameTF.setText(VAQ_Health.profile.personal.getlName());
         }
         if (VAQ_Health.profile.personal.getAddress()!= null)
         {
             addressTF.setText(VAQ_Health.profile.personal.getAddress());
         }
         if (VAQ_Health.profile.personal.getCity()!= null)
         {
             cityTF.setText(VAQ_Health.profile.personal.getCity());
         }
         if (VAQ_Health.profile.personal.getState()!= null)
         {
             //stateTF.setText(VAQ_Health.profile.personal.getState());
         }
         if (VAQ_Health.profile.personal.getZipCode()!= null)
         {
             zipTF.setText(VAQ_Health.profile.personal.getZipCode());
         }
         if (VAQ_Health.profile.personal.getEmail()!= null)
         {
             emailTF.setText(VAQ_Health.profile.personal.getEmail());
         }
    }
    
}
