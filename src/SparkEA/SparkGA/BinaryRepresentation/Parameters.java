/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import SparkEA.Params;

/**
 *
 * @author anshal
 */
public class Parameters extends Params{
    private double mutationProbability;
    private double uniformCrossoverProbability;
    
    public Parameters(){
        mutationProbability = 0.5;
        uniformCrossoverProbability = 0.5;
    }
    
    public double getMutationProbability(){
        return mutationProbability;
    }
    
    public void setMutationProbability(double prob){
        if(prob>1 || prob<0 ){
            System.err.println("Attempt to set invalid mutation probability");
            return;
        }
        mutationProbability = prob;
    }
    
    public double getUniformCrossoverProbability(){
        return uniformCrossoverProbability;
    }
    
    public void setUniformCrossoverProbability(double prob){
        if(prob>1 || prob<0 ){
            System.err.println("Attempt to set invalid uniformCrossover probability");
            return;
        }
        uniformCrossoverProbability = prob;
    }
}
