/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;

/**
 *
 * @author ^.^
 */
public class Exercise {
    public String name;
    public String difficulty;
    public String workOutTime;
    public String discription;
    public String type;
    public int met;
    @Override
    public String toString()
    {
        return name;
    }
    
    // met = metabolic equivalent
    public static double CaloriesBurned(int met, double hrs,double weightKG)
    {
        if (hrs < 1)
            return met * weightKG*hrs;
        else
            return met * weightKG/hrs;

        
    }
    
    public double PoundsToKG(double lb)
    {
       return lb/100; 
    }
}
