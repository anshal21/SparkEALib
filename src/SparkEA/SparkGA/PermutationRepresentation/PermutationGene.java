/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.PermutationRepresentation;

import SparkEA.Gene;
import SparkEA.Utility;
import static java.lang.Math.round;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class PermutationGene implements Gene, Cloneable {
    
    private int geneValue;
    
    public PermutationGene(double val){
        setGeneValue(val);
    }
    public PermutationGene(){
        
    }
    
    @Override
    public void setRandom() {
        
    }

    @Override
    public double getGeneValue() {
        return geneValue;
    }
    

    @Override
    public double getLowerBound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getUpperBound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLowerBound(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpperBound(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setGeneValue(double value) {
        int val = (int)round(value);
        this.geneValue = val;
    }
    
    public PermutationGene clone(){
        try {
            return (PermutationGene)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PermutationGene.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
