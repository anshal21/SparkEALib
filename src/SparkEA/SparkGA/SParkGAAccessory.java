/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

import java.io.Serializable;

/**
 *
 * @author anshal
 */
public class SParkGAAccessory implements Cloneable, Serializable{
     public  double fitnessFunction(ChromosomeGA c){return 0;};
     public SParkGAAccessory clone() throws CloneNotSupportedException{
         return (SParkGAAccessory)super.clone();
     }
}
