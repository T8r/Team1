/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.DataClasses;

/**
 *
 * @author ^.^
 */
public class Allergy {
    public Boolean dairyA;
    public Boolean soyA;
    public Boolean eggsA;
    public Boolean peanutsA;
    public Boolean fishA;
    public Boolean wheatA;
    public Boolean sesameA;
    
    public Boolean glutenI;
    public Boolean lactoseI;
    public Boolean fructoseI;
    public Boolean sulfitesI;
    public Boolean histaminesI;
    public Boolean nitritesI;
    public Boolean nightshadesI;
    public Boolean fructansI;


   
    
    
    public Boolean getDairyA() {
        return dairyA;
    }

    public void setDairyA(Boolean dairyA) {
        this.dairyA = dairyA;
    }

    public Boolean getSoyA() {
        return soyA;
    }

    public void setSoyA(Boolean soyA) {
        this.soyA = soyA;
    }

    public Boolean getEggsA() {
        return eggsA;
    }

    public void setEggsA(Boolean eggsA) {
        this.eggsA = eggsA;
    }

    public Boolean getPeanutsA() {
        return peanutsA;
    }

    public void setPeanutsA(Boolean peanutsA) {
        this.peanutsA = peanutsA;
    }

    public Boolean getFishA() {
        return fishA;
    }

    public void setFishA(Boolean fishA) {
        this.fishA = fishA;
    }

    public Boolean getWheatA() {
        return wheatA;
    }

    public void setWheatA(Boolean wheatA) {
        this.wheatA = wheatA;
    }

    public Boolean getSesameA() {
        return sesameA;
    }

    public void setSesameA(Boolean sesameA) {
        this.sesameA = sesameA;
    }

    public Boolean getGlutenI() {
        return glutenI;
    }

    public void setGlutenI(Boolean glutenI) {
        this.glutenI = glutenI;
    }

    public Boolean getLactoseI() {
        return lactoseI;
    }

    public void setLactoseI(Boolean lactoseI) {
        this.lactoseI = lactoseI;
    }

    public Boolean getFructoseI() {
        return fructoseI;
    }

    public void setFructoseI(Boolean fructoseI) {
        this.fructoseI = fructoseI;
    }

    public Boolean getSulfitesI() {
        return sulfitesI;
    }

    public void setSulfitesI(Boolean sulfitesI) {
        this.sulfitesI = sulfitesI;
    }

    public Boolean getHistaminesI() {
        return histaminesI;
    }

    public void setHistaminesI(Boolean histaminesI) {
        this.histaminesI = histaminesI;
    }

    public Boolean getNitritesI() {
        return nitritesI;
    }

    public void setNitritesI(Boolean nitritesI) {
        this.nitritesI = nitritesI;
    }

    public Boolean getNightshadesI() {
        return nightshadesI;
    }

    public void setNightshadesI(Boolean nightshadesI) {
        this.nightshadesI = nightshadesI;
    }

    public Boolean getFructansI() {
        return fructansI;
    }

    public void setFructansI(Boolean fructansI) {
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