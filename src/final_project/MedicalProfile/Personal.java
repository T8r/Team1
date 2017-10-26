/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Stephen
 */
public class Personal {
    
    public String fname;
    public String lName;
    public String sex;
    public Integer age;
    public String address;
    public String state;
    public String city;
    public String email;
    
    public Personal(String fname, String lName, String sex, int age, 
            String address, String state, String city, String email) {
        this.fname = fname;
        this.lName = lName;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.state = state;
        this.city = city;
        this.email = email;
    }

    public Personal() {
        this.fname = "No input";
        this.lName = "No input";
        this.sex = "No input";
        this.age = 0;
        this.address = "No input";
        this.state = "No input";
        this.city = "No input";
        this.email = "No input";
    }
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    @Override
    public String toString(){
        return "\nPersonal Information:"+
               "\nFirst Name: "+fname+
                "\nLast Neme: "+lName+
                "\nSex: "+sex+
                "\nAddress: "+address+
                "\nState: "+state+
                "\nCity: "+city+
                "\nEmail: "+email;
    }
    
}
