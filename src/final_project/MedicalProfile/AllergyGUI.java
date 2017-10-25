/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;
import javafx.scene.control.CheckBox;
/**
 *
 * @author MaxIII
 */
public class AllergyGUI {
    
    static public CheckBox cbA1 = new CheckBox("Dairy");
    static public CheckBox cbA2 = new CheckBox("Soy");
    static public CheckBox cbA3 = new CheckBox("Eggs");
    static public CheckBox cbA4 = new CheckBox("Peanuts");
    static public CheckBox cbA5 = new CheckBox("Fish");
    static public CheckBox cbA6 = new CheckBox("Wheat");
    static public CheckBox cbA7 = new CheckBox("Sesame");
    static public CheckBox cbA8 = new CheckBox("Tree Nuts");
    
    static public CheckBox cbI1 = new CheckBox("Gluten");
    static public CheckBox cbI2 = new CheckBox("Lactose");
    static public CheckBox cbI3 = new CheckBox("Fructose");
    static public CheckBox cbI4 = new CheckBox("Sulfites");
    static public CheckBox cbI5 = new CheckBox("Histamines");
    static public CheckBox cbI6 = new CheckBox("Nitrites");
    static public CheckBox cbI7 = new CheckBox("Nightshades");
    static public CheckBox cbI8 = new CheckBox("Fructans");
    
    
    public static void resetCheckboxes(){
        cbA1.setSelected(false);
        cbA2.setSelected(false);
        cbA3.setSelected(false);
        cbA4.setSelected(false);
        cbA5.setSelected(false);
        cbA6.setSelected(false);
        cbA7.setSelected(false);
        cbA8.setSelected(false);
        
        cbI1.setSelected(false);
        cbI2.setSelected(false);
        cbI3.setSelected(false);
        cbI4.setSelected(false);
        cbI5.setSelected(false);
        cbI6.setSelected(false);
        cbI7.setSelected(false);
        cbI8.setSelected(false);
    }
    
    
}
