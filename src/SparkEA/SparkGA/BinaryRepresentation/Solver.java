/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public abstract  class Solver implements Cloneable, Serializable{
    
    public abstract  BinaryChromosome solver(ArrayList<BinaryChromosome> population);
    
    @Override
    public Solver clone(){
        try {
            return (Solver)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Solver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
