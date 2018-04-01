/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import SparkEA.Utility;
import static java.lang.Math.round;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class BinaryGene implements SparkEA.Gene, Cloneable {
    
    public int geneValue;
    
    @Override
    public void setRandom() {
        this.geneValue = ((int)(10*Math.random()))%2;
    }
    
    public void setRandom(double prob){
        double token = Math.random();
        if(token<=prob)
            this.geneValue = 1-this.geneValue;
    }
    
    public void setGeneValue(int value){
        this.geneValue = value;
    }
    @Override
    public double getGeneValue(){
        return geneValue;
    }

    @Override
    public double getLowerBound() {
        return 0;
    }

    @Override
    public double getUpperBound() {
        return 1;
    }

    @Override
    public void setLowerBound(double value) {
        
    }

    @Override
    public void setUpperBound(double value) {
       
    }
    
    public BinaryGene clone(){
        try {
            return (BinaryGene)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(BinaryGene.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setGeneValue(double value) {
        int val = (int)round(value);
        if(Utility.inRange(val, 0, 1))
            this.geneValue = val;
        else
            System.err.println("Attempt to set invalid gene value");
    }
    
}
