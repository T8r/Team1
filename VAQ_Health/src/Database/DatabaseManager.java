/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Disease.Disease;
import Exercise.Exercise;
import Exercise.Exercise.ExerciseTypeE;
import Profile.Allergies.Allergy;
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
import static Utility.Utility.isValidDate;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    static private ArrayList<Allergy> allergyList = new ArrayList<>();
    static private ArrayList<Disease> diseaseList = new ArrayList<>();

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
                newExercise.description = myRs.getString("description");
                newExercise.type = ExerciseTypeE.valueOf(myRs.getString("type"));
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

    public static void UpdateMedical(Profile profile) {

        int userID, allergyID,diseaseID;
        try {
            OpenConnection();
            
           //Medical
           PreparedStatement ps = myConnection.prepareStatement(
                    "UPDATE medical SET "
                    + "weight = ?, "
                    + "height = ? "
           );
           ps.setInt(1, Integer.parseInt(profile.medical.getWeight()));
           ps.setInt(2, Integer.parseInt(profile.medical.getHeight()));
           ps.executeUpdate();
           
            //Allergies
            for (int i = 0; i < allergyList.size(); i++) {
                myRs = myStmt.executeQuery("select* from allergy where description='" + allergyList.get(i) + "'");
                myRs.next();
                allergyID = myRs.getInt("ID");
                Allergy allergy = allergyList.get(i);
                if (profile.medical.allergyList.contains(allergy)) {
                    myRs = myStmt.executeQuery("select* from userAllergies where userID=" + profile.id + " AND allergyID="+allergyID);                    
                    if (myRs.next()) {
                        System.out.println("User already has allergy listed");
                    } else {
                        System.out.println("Listing User: " + profile.username + " Allergy: " + allergyList.get(i));                      
                        String sql = "INSERT INTO userAllergies (userID,allergyID) VALUES (?, ?)";
                        PreparedStatement statement = myConnection.prepareStatement(sql);
                        statement.setInt(1,profile.id);
                        statement.setInt(2,allergyID);
                        statement.executeUpdate();
                    }
                }
                else
                {
                    myRs = myStmt.executeQuery("select* FROM userAllergies where userID=" + profile.id + " AND allergyID="+allergyID);
                    if (myRs.next())
                    {
                        System.out.println("Removing allergy from user in userAllergies Table");
                        String SQL = "DELETE FROM userAllergies WHERE userID = ? and allergyID = ? ";
                        PreparedStatement pstmt = null;
                        pstmt = myConnection.prepareStatement(SQL);
                        pstmt.setInt(1, profile.id);
                        pstmt.setInt(2, allergyID);
                        pstmt.executeUpdate();
                    }
                }
            }
            
           //Diseases
            for (int i = 0; i < diseaseList.size(); i++) {
                myRs = myStmt.executeQuery("select* from disease where name='" + diseaseList.get(i) + "'");
                myRs.next();
                diseaseID = myRs.getInt("ID");
                Disease disease = diseaseList.get(i);
                if (profile.medical.diseaseList.contains(disease)) {
                    myRs = myStmt.executeQuery("select* from userDiseases where userID=" + profile.id + " AND diseaseID="+diseaseID);                    
                    if (myRs.next()) {
                        System.out.println("User already has disease listed");
                    } else {
                        System.out.println("Listing User: " + profile.username + " Disease: " + diseaseList.get(i));                      
                        String sql = "INSERT INTO userDiseases (userID,diseaseID) VALUES (?, ?)";
                        PreparedStatement statement = myConnection.prepareStatement(sql);
                        statement.setInt(1,profile.id);
                        statement.setInt(2,diseaseID);
                        statement.executeUpdate();
                    }
                }
                else
                {
                    myRs = myStmt.executeQuery("select* FROM userDiseases where userID=" + profile.id + " AND diseaseID="+diseaseID);
                    if (myRs.next())
                    {
                        System.out.println("Removing disease from user in userAllergies Table");
                        String SQL = "DELETE FROM userDiseases WHERE userID = ? and diseaseID = ? ";
                        PreparedStatement pstmt = null;
                        pstmt = myConnection.prepareStatement(SQL);
                        pstmt.setInt(1, profile.id);
                        pstmt.setInt(2, diseaseID);
                        pstmt.executeUpdate();
                    }
                }
            }

           CloseConnection();
        } catch (Exception e) {
        }

    }

    public static void UpdatePersonal(Profile profile) {
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

            ps.setString(1, profile.personal.getFname());
            ps.setString(2, profile.personal.getlName());
            ps.setString(3, profile.personal.getAddress());
            ps.setString(4, profile.personal.getCity());
            ps.setString(5, profile.personal.getZipCode());
            if (isValidDate(profile.personal.getBirthday().toString()))
                ps.setDate(6,profile.personal.getBirthday());
            else
                ps.setDate(6, java.sql.Date.valueOf("2000-01-01"));
            ps.executeUpdate();
            ps.close();

            if (profile.imagePath != null)
            {
                File imgfile = new File(profile.imagePath);
                FileInputStream fin = new FileInputStream(imgfile);
                PreparedStatement pre = myConnection.prepareStatement(
                        "UPDATE profilePicture SET image = ? WHERE userID=" + profile.id);
                pre.setBinaryStream(1, (InputStream) fin, (int) imgfile.length());
                pre.executeUpdate();
                System.out.println("Successfully inserted the file into the database!");
            }
            
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
                profile.personal.setBirthday(myRs.getDate("birthday"));
            }

            //Get Medical
            myRs = myStmt.executeQuery("select* from medical where userID=" + userID + "");
            myRs.next();
            profile.medical.setHeight(myRs.getString("height"));
            profile.medical.setWeight(myRs.getString("weight"));   

            //Get Allergies
            myRs = myStmt.executeQuery(""
                    + "Select* from allergy a Inner Join("
                    + "Select* from userAllergies where userID=" + userID + ""
                    + ")AS t1 ON t1.allergyID =a.ID"
            );

            //myRs.next();
            while (myRs.next()) {
                Allergy allergy = new Allergy(myRs.getString("description"),myRs.getString("description"));
                profile.medical.allergyList.add(allergy);
                System.out.println(myRs.getString("description"));
            }
            
             //Get Diseases      
            myRs = myStmt.executeQuery(""
                    + "Select* from disease a Inner Join("
                    + "Select* from userDiseases where userID=" + userID + ""
                    + ")AS t1 ON t1.diseaseID =a.ID"
            );

            //myRs.next();
            while (myRs.next()) {
                Disease disease = new Disease(myRs.getString("name"),myRs.getString("description"));
                profile.medical.diseaseList.add(disease);
            }
        
            //Get Profile Picture
            myRs = myStmt.executeQuery("select* from profilePicture where userID=" + userID + "");
            myRs.next();
            Blob blob = myRs.getBlob("image");
            byte[] byteImage = blob.getBytes(1, (int) blob.length());
            profile.image = new Image(new ByteArrayInputStream(byteImage));

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

    public static ArrayList<Allergy> GetAllergyList() {

        allergyList.clear();
        try {
            OpenConnection();

            myRs = myStmt.executeQuery("select* from allergy");
            // 4. Process the result set
            while (myRs.next()) {
                Allergy allergy = new Allergy(myRs.getString("name"),myRs.getString("description"));
                allergyList.add(allergy);
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

    public static ArrayList<Disease> GetDiseaseList() {
          try {
            OpenConnection();
            diseaseList.clear();
            myRs = myStmt.executeQuery("select* from disease");       
            while (myRs.next()) {
                Disease disease = new Disease(myRs.getString("name"),myRs.getString("description"));
                diseaseList.add(disease);
            }
            CloseConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return diseaseList;
    }
    
   


}
