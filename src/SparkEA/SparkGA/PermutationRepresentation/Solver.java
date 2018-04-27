/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.PermutationRepresentation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author anshal
 */
public abstract class Solver implements Cloneable, Serializable{
    
    public abstract PermutationChromosome solver(ArrayList<PermutationChromosome> population);
    
    @Override
    public Solver clone(){
        try {
            return (Solver)super.clone();
        } catch (CloneNotSupportedException ex) {
           
        }
        return null;
    }
   
    
}