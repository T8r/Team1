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