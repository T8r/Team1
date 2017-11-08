/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignIn;

import Profile.ProfileController;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.xml.bind.DatatypeConverter;
import vaq_health.DatabaseManager;
import vaq_health.VAQ_Health;

/**
 * FXML Controller class
 *
 * @author ^.^
 */


public class SignInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField usernameTF;
    @FXML
    TextField passwordTF;
    @FXML
    Label errorL;
    String password;
    
    ProfileController profileController = new ProfileController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        usernameTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        SignIn();
                    } catch (IOException ex) {
                        Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        passwordTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    try {
                        SignIn();
                    } catch (IOException ex) {
                        Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        passwordTF.setOnKeyTyped(event -> {  
            String p =  passwordTF.getText();
              if (p.length() == 0) {
                  password = "";
                return;
            }
              
    
                char[] c = p.toCharArray();
                password += c[p.length()-1];
                c[p.length()-1] = '*';  
                System.out.println(password);
               passwordTF.setText(String.valueOf(c));
               passwordTF.positionCaret(passwordTF.getText().length());
               
        });
    }  
    
    @FXML
    public void OpenCreateAccount() throws IOException
    {
        profileController.OpenCreateAccount();
    }
    
    @FXML
    private void SignIn() throws IOException, NoSuchAlgorithmException
    {
         if (usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty())
             return;
         
        if (DatabaseManager.UserExists(usernameTF.getText(),password))
        {
            System.out.println("User logged in");
            VAQ_Health.profile = DatabaseManager.GetProfile(usernameTF.getText());
            VAQ_Health.profile.username = usernameTF.getText();
            VAQ_Health.profile.password = password;
            profileController.OpenHome();
        }
        else
            errorL.setText("Incorrect username/password");
    }

    
}
