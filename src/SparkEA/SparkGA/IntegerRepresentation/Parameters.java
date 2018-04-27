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
    private double mpChangeRate=0;
    private double ucChangeRate=0;
    
    public Parameters(){
        RandomResettingProbability = 0.05;
        crossoverProbability = 0.05;
    }
      public Parameters(Parameters p){
        this.RandomResettingProbability = p.RandomResettingProbability;
        this.crossoverProbability = p.crossoverProbability;
        this.mpChangeRate = p.mpChangeRate;
        this.ucChangeRate = p.ucChangeRate;
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
        tmp.RandomResettingProbability = this.RandomResettingProbability+this.mpChangeRate;
        tmp.crossoverProbability = this.crossoverProbability+this.ucChangeRate;
        if(tmp.RandomResettingProbability > 1.0){
            tmp.RandomResettingProbability = 0.1;
        }
        if(tmp.crossoverProbability > 1.0){
            tmp.crossoverProbability= 0.1;
        }
        tmp.mpChangeRate = this.mpChangeRate;
        tmp.ucChangeRate = this.ucChangeRate;
        return tmp;
    }
    
    @Override
    public void print(){
        System.out.println("{");
        System.out.println("Mutation Probability : " + RandomResettingProbability);
        System.out.println("UniformCrossover Probability : " + crossoverProbability);
        System.out.println("Mutation Change Rate : " + mpChangeRate);
        System.out.println("UniformCrossover Change Rate : " + ucChangeRate);
        System.out.println("}");
    }
}
