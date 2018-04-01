/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class Params implements Cloneable{
    @Override
    public Params clone(){
        try {
            return (Params)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Params.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
}
