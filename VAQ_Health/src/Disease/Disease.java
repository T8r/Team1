/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Disease;

/**
 *
 * @author ^.^
 */
public class Disease {

    
    private String name;
    private boolean has;
    
    public Disease(String n, boolean h)
    {
        this.name = n;
        this.has = h;
    }
    
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
     * @return the has
     */
    public boolean isHas() {
        return has;
    }

    /**
     * @param has the has to set
     */
    public void setHas(boolean has) {
        this.has = has;
    }
    
}
