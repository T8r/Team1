/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;

/**
 *
 * @author Stephen
 */
public class Medical {
    /**
     * Add all values one can make medical inferences from 
     * that's not allergies
     * 
     * Maybe make into activation switches for more options?
     */
    public String drugAbuse;
    public String alcoholAbuse;
    public String heartProblems;
    public String digestiveDisorder;
    public String onMedication;// might want to make this a switch for 
                                //multiple strings of medications
    public String familyDiabetes;
    public String personalDiabetes;// maybe a switch to also require 
                                    //the severity?
    
    public Medical(String drugAbuse, String alcoholAbuse, 
            String heartProblems, String digestiveDisorder, 
            String onMedication, String familyDiabetes, 
            String personalDiabetes) {
        this.drugAbuse = drugAbuse;
        this.alcoholAbuse = alcoholAbuse;
        this.heartProblems = heartProblems;
        this.digestiveDisorder = digestiveDisorder;
        this.onMedication = onMedication;
        this.familyDiabetes = familyDiabetes;
        this.personalDiabetes = personalDiabetes;
    }
    
    public Medical() {
        this.drugAbuse = "No input";
        this.alcoholAbuse = "No input";
        this.heartProblems = "No input";
        this.digestiveDisorder = "No input";
        this.onMedication = "No input";
        this.familyDiabetes = "No input";
        this.personalDiabetes = "No input";
    }
    
    public String getDrugAbuse() {
        return drugAbuse;
    }

    public void setDrugAbuse(String drugAbuse) {
        this.drugAbuse = drugAbuse;
    }

    public String getAlcoholAbuse() {
        return alcoholAbuse;
    }

    public void setAlcoholAbuse(String alcoholAbuse) {
        this.alcoholAbuse = alcoholAbuse;
    }

    public String getHeartProblems() {
        return heartProblems;
    }

    public void setHeartProblems(String heartProblems) {
        this.heartProblems = heartProblems;
    }

    public String getDigestiveDisorder() {
        return digestiveDisorder;
    }

    public void setDigestiveDisorder(String digestiveDisorder) {
        this.digestiveDisorder = digestiveDisorder;
    }

    public String getOnMedication() {
        return onMedication;
    }

    public void setOnMedication(String onMedication) {
        this.onMedication = onMedication;
    }

    public String getFamilyDiabetes() {
        return familyDiabetes;
    }

    public void setFamilyDiabetes(String familyDiabetes) {
        this.familyDiabetes = familyDiabetes;
    }

    public String getPersonalDiabetes() {
        return personalDiabetes;
    }

    public void setPersonalDiabetes(String personalDiabetes) {
        this.personalDiabetes = personalDiabetes;
    }
    
    
    @Override
    public String toString(){
        return "\nMedical Issues: "+
                "Has Diabetes: "+personalDiabetes+
                "Family has history with diabetes: "+familyDiabetes+
                "Has HeartProblems: "+heartProblems+
                "Is currently on Medication: "+onMedication+
                "Has a digestive disorder: "+digestiveDisorder+
                "Is abusing drugs: "+drugAbuse+
                "Is abusing alcohol: "+alcoholAbuse;
    
    }
    
}
