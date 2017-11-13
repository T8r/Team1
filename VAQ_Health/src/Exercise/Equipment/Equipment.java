/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise.Equipment;

import Exercise.Exercise.ExerciseTypeE;

/**
 *
 * @author ^.^
 */
public class Equipment {

 

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public ExerciseTypeE getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ExerciseTypeE type) {
        this.type = type;
    }
    
    private String name;
    private ExerciseTypeE type;
    
    public Equipment(String n)
    {
        this.name = n;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
    
}
