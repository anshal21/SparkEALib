/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import SparkEA.Chromosome;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class Accessories implements Cloneable, Serializable{
     public  double fitnessFunction(Chromosome c){return 0;};
     public Accessories clone(){
         try {
             return (Accessories)super.clone();
         } catch (CloneNotSupportedException ex) {
             Logger.getLogger(Accessories.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     }
}
