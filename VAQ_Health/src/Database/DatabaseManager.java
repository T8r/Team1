/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Exercise.Exercise;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import Profile.Profile;

/**
 *
 * @author ^.^
 */
public class DatabaseManager {
    
    static Connection myConnection;
    static Statement myStmt;
    static ResultSet myRs;
    
    
   
    
    public static void AddUser(String username, String password, String email)
    {        
        try {
            Connect();
            String hashedUsername = sha256(username);
            String hashedPassword = sha256(password);
            myRs = myStmt.executeQuery("SELECT COUNT(*) FROM user");
            myRs.next();
            int rowCount = myRs.getInt(1) + 1;
            String sql = "INSERT INTO User (ID, username, password) VALUES (?, ?, ?)";

            PreparedStatement statement = myConnection.prepareStatement(sql);
            statement.setInt(1, rowCount);
            statement.setString(2, hashedUsername);
            statement.setString(3, hashedPassword);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            Close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
      
    }
    public static boolean UsernameExists(String username) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        boolean found = false;
        String hashedUsername = sha256(username);
        
        Connect();
        try {
            myRs = myStmt.executeQuery("select* from user where username='"+hashedUsername+"'");
            // 4. Process the result set
            while (myRs.next()) {
             found = true;  
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        Close();
        return found;
    }
     public static boolean UserExists(String username,String password)
    {
        boolean found = false;
        String hashedUsername = "";
        String hashedPassword = "";
        try {
            hashedUsername = sha256(username);
            hashedPassword = sha256(password);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connect();
        try {
            myRs = myStmt.executeQuery("select* from user where username='"+hashedUsername+"' and password='"+hashedPassword+"'");
            // 4. Process the result set
            while (myRs.next()) {
             found = true;  
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        Close();
        return found;
    }
     
    public static  ArrayList<Exercise> GetExerciseTable()
    {
        ArrayList<Exercise> exerciseList = new ArrayList<>();
        
        Connect();
        try {
            myRs = myStmt.executeQuery("select* from exercise");

            // 4. Process the result set
            while (myRs.next()) {
                Exercise newExercise = new Exercise();
                newExercise.name = myRs.getString("Name");  
                newExercise.difficulty = myRs.getString("difficulty");
                newExercise.discription = myRs.getString("discription");
                newExercise.type = myRs.getString("type");
                newExercise.met = myRs.getInt("met");
                exerciseList.add(newExercise);
                
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        Close();
       return exerciseList;
    }
    
    static void Connect()
    {
          try {
            // 1. Get a connection to database
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaq_health", "root", "password");
             myStmt = myConnection.createStatement();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    static void Close()
    {
        try {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConnection != null) {
                myConnection.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void UpdateProfile(Profile profile)
    {
        String hashedUsername ="";
        
        Connect();
        
         try {
          hashedUsername = sha256(profile.username);
             PreparedStatement ps = myConnection.prepareStatement(
                     "UPDATE personal SET firstName = ?, lastName = ? WHERE userID="+profile.id);

             // set the preparedstatement parameters
             ps.setString(1, profile.personal.getFname());
             ps.setString(2, profile.personal.getlName());

             // call executeUpdate to execute our sql update statement
             ps.executeUpdate();
             ps.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        Close();  
    }
    
     public static Profile GetProfile(String username) {
        Profile profile = new Profile();
        String hashedUsername ="";
        
       
         try {
          Connect();
          hashedUsername = sha256(username);
          myRs = myStmt.executeQuery("select* from user where username='"+hashedUsername+"'");
          myRs.next();
          int userID = myRs.getInt("ID");
          profile.id = userID;
          myRs = myStmt.executeQuery("select* from personal where userID="+userID+"");
          
            // 4. Process the result set
            while (myRs.next()) {
                profile.personal.setFname(myRs.getString("firstName"));
                profile.personal.setlName(myRs.getString("lastName"));
                profile.personal.setAddress(myRs.getString("address"));
                profile.personal.setSex(myRs.getString("sex"));
                profile.personal.setState(myRs.getString("state"));
                profile.personal.setCity(myRs.getString("city"));
                profile.personal.setZipCode(myRs.getString("zipcode"));
                profile.personal.setEmail(myRs.getString("email"));
                profile.personal.setBirthday(myRs.getString("birthday"));
            }
            Close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
       
        
        return profile;
    }
    
    
    static private String sha256(String username) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(username.getBytes("UTF-8"));
        System.out.println(DatatypeConverter.printHexBinary(hash));
        return DatatypeConverter.printHexBinary(hash);
    }
    
    
}
