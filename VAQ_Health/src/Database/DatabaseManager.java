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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import static java.time.Instant.now;
import static java.time.OffsetTime.now;
import java.util.Calendar;
import javafx.scene.image.Image;

/**
 *
 * @author ^.^
 */
public class DatabaseManager {

    static Connection myConnection;
    static Statement myStmt;
    static ResultSet myRs;

    static void OpenConnection() {
        try {
            // 1. Get a connection to database
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaq_health", "root", "password");
            myStmt = myConnection.createStatement();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    static void CloseConnection() {
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

    public static void AddUser(String username, String password, String email) {
        
        try {
            OpenConnection();
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
            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public static boolean UsernameExists(String username) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean found = false;
        String hashedUsername = sha256(username);

        try {
            OpenConnection();
            myRs = myStmt.executeQuery("select* from user where username='" + hashedUsername + "'");
            // 4. Process the result set
            while (myRs.next()) {
                found = true;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        CloseConnection();
        return found;
    }

    public static boolean UserExists(String username, String password) {
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

        try {
            OpenConnection();
            myRs = myStmt.executeQuery("select* from user where username='" + hashedUsername + "' and password='" + hashedPassword + "'");
            // 4. Process the result set
            while (myRs.next()) {
                found = true;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        CloseConnection();
        return found;
    }

    public static ArrayList<String> GetExerEquipList() {
        ArrayList<String> equipList = new ArrayList<>();

        try {
            OpenConnection();

            myRs = myStmt.executeQuery("select* from exerciseequipment");
            // 4. Process the result set
            while (myRs.next()) {
                equipList.add(myRs.getString("name"));
            }
            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return equipList;
    }

    public static ArrayList<Exercise> GetExerciseTable() {
        ArrayList<Exercise> exerciseList = new ArrayList<>();

        try {
            OpenConnection();
            myRs = myStmt.executeQuery("select* from exercise");

            // 4. Process the result set
            while (myRs.next()) {
                Exercise newExercise = new Exercise();
                newExercise.name = myRs.getString("Name");
                newExercise.difficulty = myRs.getString("difficulty");
                newExercise.discription = myRs.getString("discription");
                newExercise.type = myRs.getString("type");
                newExercise.met = myRs.getInt("met");
                newExercise.equipment = Integer.toString(myRs.getInt("equipmentID"));
                exerciseList.add(newExercise);

            }
            for (Exercise exercise : exerciseList) {
                if (exercise.equipment.equals("0")) {
                    continue;
                }
                myRs = myStmt.executeQuery("select* from exerciseequipment where ID=" + exercise.equipment);
                myRs.next();
                exercise.equipment = myRs.getString("name");
                System.out.println(exercise.name + "   " + exercise.equipment);
            }

            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return exerciseList;
    }

    public static void UpdateProfile(Profile profile) {
        String hashedUsername = "";

        OpenConnection();

        try {
            hashedUsername = sha256(profile.username);
            PreparedStatement ps = myConnection.prepareStatement(
                    "UPDATE personal SET "
                            + "firstName = ?, "
                            + "lastName = ?, "
                            + "address = ?, "
                            + "city = ?, "
                            //+ "state = ?, "
                            + "zipcode = ?, "
                            + "birthday = ? "
                            + "WHERE userID=" + profile.id);

            // set the preparedstatement parameters
            ps.setString(1, profile.personal.getFname());
            ps.setString(2, profile.personal.getlName());
            ps.setString(3, profile.personal.getAddress());
            ps.setString(4, profile.personal.getCity());
            //ps.setString(5, profile.personal.getState());
            ps.setString(5, profile.personal.getZipCode());
            ps.setDate(6, java.sql.Date.valueOf(profile.personal.getBirthday()));
            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();

            Statement st = myConnection.createStatement();
            File imgfile = new File(profile.imagePath);

            FileInputStream fin = new FileInputStream(imgfile);

            PreparedStatement pre = myConnection.prepareStatement(
                            "UPDATE profilePicture SET image = ? WHERE userID=" + profile.id);
           
            pre.setBinaryStream(1, (InputStream) fin, (int) imgfile.length());
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public static Profile GetProfile(String username) {
        Profile profile = new Profile();
        String hashedUsername = "";

        try {
            OpenConnection();
            hashedUsername = sha256(username);
            
            //Get UserID
            myRs = myStmt.executeQuery("select* from user where username='" + hashedUsername + "'");
            myRs.next();
            int userID = myRs.getInt("ID");
            profile.id = userID;
            
            //Get Personal
            myRs = myStmt.executeQuery("select* from personal where userID=" + userID + "");
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
            
//            //Get Medical
//             myRs = myStmt.executeQuery("select* from disease where userID=" + userID + "");
//            while (myRs.next()) {
//                profile.medical.(myRs.getString("firstName"));
//                profile.personal.setlName(myRs.getString("lastName"));
//                profile.personal.setAddress(myRs.getString("address"));
//                profile.personal.setSex(myRs.getString("sex"));
//                profile.personal.setState(myRs.getString("state"));
//                profile.personal.setCity(myRs.getString("city"));
//                profile.personal.setZipCode(myRs.getString("zipcode"));
//                profile.personal.setEmail(myRs.getString("email"));
//                profile.personal.setBirthday(myRs.getString("birthday"));
//            }

            //Get Allergies
            myRs = myStmt.executeQuery("select* from allergy");
            ResultSetMetaData rsmd = myRs.getMetaData();
            while (myRs.next())
            {
                 profile.allergies.map.put(myRs.getString("discription"), false);
            }
            
            myRs = myStmt.executeQuery(""
                    + "Select* from allergy a Inner Join("
                        + "Select* from userAllergies where userID=" + userID + ""
                    +")AS t1 ON t1.allergyID =a.ID" 
            );
                 
            //myRs.next();
            while (myRs.next())
            {
                profile.allergies.map.replace(myRs.getString("discription"),true);
                System.out.println(myRs.getString("discription"));
            }
            rsmd = myRs.getMetaData();
            for (int i=1; i <= rsmd.getColumnCount(); i++)
            {
                 
            }
           
            //Get Profile Picture
            myRs = myStmt.executeQuery("select* from profilePicture where userID=" + userID + "");
            myRs.next();
            Blob blob = myRs.getBlob("image");
            byte[] byteImage = blob.getBytes(1,(int)blob.length());
            profile.image =  new Image(new ByteArrayInputStream(byteImage));   
            
            //Get Medical
            
            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return profile;
    }

    static private String sha256(String username) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(username.getBytes("UTF-8"));
        System.out.println(DatatypeConverter.printHexBinary(hash));
        return DatatypeConverter.printHexBinary(hash);
    }

    public static ArrayList<String> GetAllergyList() {
        ArrayList<String> allergyList = new ArrayList<>();

        try {
            OpenConnection();

            myRs = myStmt.executeQuery("select* from allergy");
            // 4. Process the result set
            while (myRs.next()) {
                allergyList.add(myRs.getString("discription"));
            }
            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return allergyList;
    }

    public static ArrayList<String> GetEquipmentList() {
        ArrayList<String> equipmentList = new ArrayList<>();

        try {
            OpenConnection();

            myRs = myStmt.executeQuery("select* from exerciseequipment");
            // 4. Process the result set
            while (myRs.next()) {
                equipmentList.add(myRs.getString("name"));
            }
            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return equipmentList;
    }

}
