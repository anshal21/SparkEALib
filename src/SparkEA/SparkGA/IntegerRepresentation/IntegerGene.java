/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.IntegerRepresentation;

import SparkEA.Gene;
import SparkEA.Utility;
import static java.lang.Math.round;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class IntegerGene implements Gene, Cloneable{

    private int geneValue;
    private int lowerLimit = 0;
    private int upperLimit = 1000000000;
    
    public IntegerGene(){
        this.setRandom();
    }
    
    public IntegerGene(int lowerBound, int upperBound){
        setLowerBound(lowerBound);
        setUpperBound(upperBound);
        setRandom();
    }
    
    @Override
    public void setRandom() {
        this.geneValue = Utility.getRandomInt(lowerLimit, upperLimit);
    }

    @Override
    public double getGeneValue() {
        return this.geneValue;
    }

    @Override
    public double getLowerBound() {
        return this.lowerLimit;
    }

    @Override
    public double getUpperBound() {
       return this.upperLimit;
    }

    @Override
    public void setLowerBound(double value) {
        this.lowerLimit = (int)value;
    }

    @Override
    public void setUpperBound(double value) {
        this.upperLimit = (int)value;
    }
    
    public IntegerGene clone(){
        try {
            return (IntegerGene)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(IntegerGene.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void setGeneValue(double value) {
        int val = (int)round(value);
        if(Utility.inRange(val, lowerLimit, upperLimit))
            this.geneValue = val;
        else
            System.err.println("Attempt to set invalid gene value");
    }
    
}
