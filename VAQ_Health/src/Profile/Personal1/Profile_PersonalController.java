package Profile.Personal1;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Database.DatabaseManager;
import Profile.ProfileController;
import static Utility.Utility.isValidDate;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
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
    private TextField birthdayMonthTF;
    @FXML
    private TextField birthdayDayTF;
    @FXML
    private TextField birthdayYearTF;
    
    
    //Medical Fields
    
    ProfileController profileController = new ProfileController();
    @FXML
    private Label label;
    @FXML 
    ImageView profileIV;
    @FXML
    Button profileUploadBTN;
    
    
    private File imageFile;
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
        profileController.OpenProfileExercise();
    }
    @FXML
    private void OpenExport(MouseEvent event) throws IOException {
        profileController.OpenProfileExport();
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
        if (isValidDate(birthdayYearTF.getText()+ "-" + birthdayMonthTF.getText()+ "-" + birthdayDayTF.getText()))
            VAQ_Health.profile.personal.setBirthday(java.sql.Date.valueOf(
                    birthdayYearTF.getText()
                    + "-" + birthdayMonthTF.getText()
                    + "-" + birthdayDayTF.getText()
            ));
         
      if (imageFile != null)
            VAQ_Health.profile.imagePath = imageFile.getAbsolutePath();
      
        DatabaseManager.UpdatePersonal(VAQ_Health.profile);
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
         
        if (VAQ_Health.profile.personal.getBirthday()!= null)
        {
            Date date = VAQ_Health.profile.personal.getBirthday();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            birthdayMonthTF.setText(Integer.toString(month));
            birthdayYearTF.setText(Integer.toString(year));
            birthdayDayTF.setText(Integer.toString(day));
        }
        
         
         if (VAQ_Health.profile.image != null)
         {
            profileIV.setImage(VAQ_Health.profile.image);
         }
    }
    
    public void UploadImage() {
            FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
                       
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                profileIV.setImage(image);
                imageFile = file;
            } catch (IOException ex) {
               // Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
    
}
