/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project.MedicalProfile;
/**
 *
 * @author MaxIII
 */
public class Allergy {
    public String dairyA;
    public String soyA;
    public String eggsA;
    public String peanutsA;
    public String fishA;
    public String wheatA;
    public String sesameA;
    public String tree_nutsA;
    
    public String glutenI;
    public String lactoseI;
    public String fructoseI;
    public String sulfitesI;
    public String histaminesI;
    public String nitritesI;
    public String nightshadesI;
    public String fructansI;
    
    public Allergy(String dairyA, String soyA, String eggsA, String peanutsA, 
            String fishA, String wheatA, String sesameA, String tree_nutsA, 
            String glutenI, String lactoseI, String fructoseI, String 
                    sulfitesI, String histaminesI, String nitritesI, 
                    String nightshadesI, String fructansI) {
        this.dairyA = dairyA;
        this.soyA = soyA;
        this.eggsA = eggsA;
        this.peanutsA = peanutsA;
        this.fishA = fishA;
        this.wheatA = wheatA;
        this.sesameA = sesameA;
        this.tree_nutsA = tree_nutsA;
        this.glutenI = glutenI;
        this.lactoseI = lactoseI;
        this.fructoseI = fructoseI;
        this.sulfitesI = sulfitesI;
        this.histaminesI = histaminesI;
        this.nitritesI = nitritesI;
        this.nightshadesI = nightshadesI;
        this.fructansI = fructansI;
    }
    public Allergy() {
        this.dairyA = "Not selected";
        this.soyA = "Not selected";
        this.eggsA = "Not selected";
        this.peanutsA = "Not selected";
        this.fishA = "Not selected";
        this.wheatA = "Not selected";
        this.sesameA = "Not selected";
        this.tree_nutsA = "Not selected";
        this.glutenI = "Not selected";
        this.lactoseI = "Not selected";
        this.fructoseI = "Not selected";
        this.sulfitesI = "Not selected";
        this.histaminesI = "Not selected";
        this.nitritesI = "Not selected";
        this.nightshadesI = "Not selected";
        this.fructansI = "Not selected";
    }
    public String getDairyA() {
        return dairyA;
    }

    public void setDairyA(String dairyA) {
        this.dairyA = dairyA;
    }

    public String getSoyA() {
        return soyA;
    }

    public void setSoyA(String soyA) {
        this.soyA = soyA;
    }

    public String getEggsA() {
        return eggsA;
    }

    public void setEggsA(String eggsA) {
        this.eggsA = eggsA;
    }

    public String getPeanutsA() {
        return peanutsA;
    }

    public void setPeanutsA(String peanutsA) {
        this.peanutsA = peanutsA;
    }

    public String getFishA() {
        return fishA;
    }

    public void setFishA(String fishA) {
        this.fishA = fishA;
    }

    public String getWheatA() {
        return wheatA;
    }

    public void setWheatA(String wheatA) {
        this.wheatA = wheatA;
    }

    public String getSesameA() {
        return sesameA;
    }

    public void setSesameA(String sesameA) {
        this.sesameA = sesameA;
    }

    public String getTree_nutsA() {
        return tree_nutsA;
    }

    public void setTree_nutsA(String tree_nutsA) {
        this.tree_nutsA = tree_nutsA;
    }

    public String getGlutenI() {
        return glutenI;
    }

    public void setGlutenI(String glutenI) {
        this.glutenI = glutenI;
    }

    public String getLactoseI() {
        return lactoseI;
    }

    public void setLactoseI(String lactoseI) {
        this.lactoseI = lactoseI;
    }

    public String getFructoseI() {
        return fructoseI;
    }

    public void setFructoseI(String fructoseI) {
        this.fructoseI = fructoseI;
    }

    public String getSulfitesI() {
        return sulfitesI;
    }

    public void setSulfitesI(String sulfitesI) {
        this.sulfitesI = sulfitesI;
    }

    public String getHistaminesI() {
        return histaminesI;
    }

    public void setHistaminesI(String histaminesI) {
        this.histaminesI = histaminesI;
    }

    public String getNitritesI() {
        return nitritesI;
    }

    public void setNitritesI(String nitritesI) {
        this.nitritesI = nitritesI;
    }

    public String getNightshadesI() {
        return nightshadesI;
    }

    public void setNightshadesI(String nightshadesI) {
        this.nightshadesI = nightshadesI;
    }

    public String getFructansI() {
        return fructansI;
    }

    public void setFructansI(String fructansI) {
        this.fructansI = fructansI;
    }
    
    @Override
    public String toString(){
        return "\nFood allergic to:"+
                "\nDairy: "+dairyA+
                "\nSoy: "+soyA+
                "\nEggs: "+eggsA+
                "\nPeanuts: "+peanutsA+
                "\nFish: "+fishA+
                "\nWheat: "+wheatA+
                "\nSesame: "+sesameA+
                "\nTree Nuts: "+tree_nutsA+
                "\nFood Types Allergic to:"+
                "\nGluten: "+glutenI+
                "\nLactose: "+lactoseI+
                "\nFructose: "+fructoseI+
                "\nSulfites: "+sulfitesI+
                "\nHistamines: "+histaminesI+
                "\nNitrites"+nitritesI+
                "\nNightshades: "+nightshadesI+
                "\nFructans: "+fructansI;
    }
}