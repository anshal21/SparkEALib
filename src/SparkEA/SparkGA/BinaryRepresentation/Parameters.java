/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import SparkEA.Params;
import java.io.Serializable;

/**
 *
 * @author anshal
 */
public class Parameters extends Params implements Serializable{
    private double mutationProbability;
    private double uniformCrossoverProbability;
    private double mpChangeRate=0;
    private double ucChangeRate=0;
    
    
    public Parameters(){
        mutationProbability = 0.5;
        uniformCrossoverProbability = 0.5;
    }
    public Parameters(Parameters p){
        this.mutationProbability = p.mutationProbability;
        this.uniformCrossoverProbability = p.uniformCrossoverProbability;
        this.mpChangeRate = p.mpChangeRate;
        this.ucChangeRate = p.ucChangeRate;
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

    public void setMutationChangeRate(double prob){
         if(prob>1 || prob<0 ){
            System.err.println("Attempt to set invalid uniformCrossover probability");
            return;
        }
        mpChangeRate = prob;
    }
    
    public void setUniformCrossoverChangeRate(double prob){
         if(prob>1 || prob<0 ){
            System.err.println("Attempt to set invalid uniformCrossover probability");
            return;
        }
        ucChangeRate = prob;
    }
    
    @Override
    public Params upgrade() {
        Parameters tmp = new Parameters(this);
        tmp.mutationProbability = this.mutationProbability+this.mpChangeRate;
        tmp.uniformCrossoverProbability = this.uniformCrossoverProbability+this.ucChangeRate;
        if(tmp.mutationProbability > 1.0){
            tmp.mutationProbability = 0.1;
        }
        if(tmp.uniformCrossoverProbability > 1.0){
            tmp.uniformCrossoverProbability = 0.1;
        }
        tmp.mpChangeRate = this.mpChangeRate;
        tmp.ucChangeRate = this.ucChangeRate;
        return tmp;
    }
    
    @Override
    public void print(){
        System.out.println("{");
        System.out.println("Mutation Probability : " + mutationProbability);
        System.out.println("UniformCrossover Probability : " + uniformCrossoverProbability);
        System.out.println("Mutation Change Rate : " + mpChangeRate);
        System.out.println("UniformCrossover Change Rate : " + ucChangeRate);
        System.out.println("}");
    }
    
   
}
