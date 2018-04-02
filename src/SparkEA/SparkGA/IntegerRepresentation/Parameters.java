/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.IntegerRepresentation;

import SparkEA.Params;
import java.io.Serializable;

/**
 *
 * @author anshal
 */
public class Parameters extends Params implements Serializable{
    private double RandomResettingProbability;
    private double crossoverProbability;
    
    public Parameters(){
        RandomResettingProbability = 0.5;
    }
    
    public double getRandomResettingProbability(){
        return RandomResettingProbability;
    }
    public void setRandomResettingProbability(double prob){
        if(prob>1 || prob<0 ){
            System.err.println("Attempt to set invalid mutation probability");
            return;
        }
        RandomResettingProbability = prob;
    }
    
    public double getCrossoverProbability(){
        return crossoverProbability;
    }
    public void setCrossoverProbability(double prob){
        if(prob>1 || prob<0 ){
            System.err.println("Attempt to set invalid mutation probability");
            return;
        }
        crossoverProbability = prob;
    }
    
}
