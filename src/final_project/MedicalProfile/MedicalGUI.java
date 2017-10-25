/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/**
 *
 * @author MaxIII
 */
public class MedicalGUI {
    static public RadioButton drugAbuseRBy = new RadioButton("Yes");
    static public RadioButton drugAbuseRBn = new RadioButton("No");
    public static final ToggleGroup drugAbuseTG = new ToggleGroup();
    static public RadioButton alcoholRBy = new RadioButton("Yes");
    static public RadioButton alcoholRBn = new RadioButton("No");
    public static final ToggleGroup alcoholTG = new ToggleGroup();
    static public RadioButton heartProblemsRBy = new RadioButton("Yes");
    static public RadioButton heartProblemsRBn = new RadioButton("No");
    public static final ToggleGroup heartProblemsTG = new ToggleGroup();
    static public RadioButton digestiveDisorderRBy = new RadioButton("Yes");
    static public RadioButton digestiveDisorderRBn = new RadioButton("No");
    public static final ToggleGroup digestiveDisorderTG = new ToggleGroup(); 
    static public RadioButton onOtherMedsRBy = new RadioButton("Yes");//switch
    static public RadioButton onOtherMedsRBn = new RadioButton("No");
    public static final ToggleGroup onOtherMedsTG = new ToggleGroup();
    static public RadioButton familyDiabetesRBy = new RadioButton("Yes");
    static public RadioButton familyDiabetesRBn = new RadioButton("No");
    public static ToggleGroup familyDiabetesTG = new ToggleGroup();
    static public RadioButton personalDiabetesRBy = new RadioButton("Yes");
    static public RadioButton personalDiabetesRBn = new RadioButton("No");
    public static ToggleGroup personalDiabetesTG = new ToggleGroup();
    
    
    public static void setToggles(){
        drugAbuseRBy.setToggleGroup(drugAbuseTG);
        drugAbuseRBn.setToggleGroup(drugAbuseTG);
        alcoholRBy.setToggleGroup(alcoholTG);
        alcoholRBn.setToggleGroup(alcoholTG);
        heartProblemsRBy.setToggleGroup(heartProblemsTG);
        heartProblemsRBn.setToggleGroup(heartProblemsTG);
        digestiveDisorderRBy.setToggleGroup(digestiveDisorderTG);
        digestiveDisorderRBn.setToggleGroup(digestiveDisorderTG);
        onOtherMedsRBy.setToggleGroup(onOtherMedsTG);
        onOtherMedsRBn.setToggleGroup(onOtherMedsTG);
        familyDiabetesRBy.setToggleGroup(familyDiabetesTG);
        familyDiabetesRBn.setToggleGroup(familyDiabetesTG);
        personalDiabetesRBy.setToggleGroup(personalDiabetesTG);
        personalDiabetesRBn.setToggleGroup(personalDiabetesTG);
    }
    
    /**
     * Not working as intended, want to reset when confirmation is pushed
     */
    public static void resetMedical(){
        drugAbuseRBy.setSelected(false);
        drugAbuseRBn.setSelected(false);
        alcoholRBy.setSelected(false);
        alcoholRBn.setSelected(false);
        heartProblemsRBy.setSelected(false);
        heartProblemsRBn.setSelected(false);
        digestiveDisorderRBy.setSelected(false);
        digestiveDisorderRBn.setSelected(false);
        onOtherMedsRBy.setSelected(false);;
        onOtherMedsRBn.setSelected(false);
        familyDiabetesRBy.setSelected(false);
        familyDiabetesRBn.setSelected(false);
        personalDiabetesRBy.setSelected(false);
        personalDiabetesRBn.setSelected(false);
    
    }
    
    
}
