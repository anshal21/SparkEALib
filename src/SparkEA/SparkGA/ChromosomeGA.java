/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

import SparkEA.Chromosome;
import SparkEA.Gene;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author anshal
 */
public class ChromosomeGA implements SparkEA.Chromosome{
    
    private GeneGA[] genes;
    private double mutationProb;
    private GAUtils gaUtils;
    
    public ChromosomeGA(int size, GAUtils gaUtils){
        genes = new GeneGA[size];
        for(int i=0; i<size; i++){
            genes[i].setRandom();
        }
        this.gaUtils = gaUtils;
        
    }
    public ChromosomeGA(ChromosomeGA c, GAUtils gaUtils){
        genes = new GeneGA[c.genes.length];
        for(int i=0; i<genes.length; i++){
            genes[i] = c.genes[i];
        }
        this.gaUtils = gaUtils;
        
    }
    
    public void setMutationProbability(double prob){
        this.mutationProb = prob;
    }
    
    public double getMutationProbability(){
           return this.mutationProb;
    }
    
    @Override
    public void print() {
        
    }
    
    @Override
    public double getFitnessValue() {
        return gaUtils.fitnessFunction(this);
    }

    @Override
    public Gene getRandomGene() {
        return null;
    }

    @Override
    public Gene getGene(int index) {
        return null;
    }


    public void setGene(int index, GeneGA gene) {
        this.genes[index] = gene;
    }
    
    public void mutate(){
        for(int i=0; i<genes.length; i++){
            genes[i].setRandom(this.mutationProb);
        }
    }
    
    public ArrayList<ChromosomeGA> uniformCrossover(ChromosomeGA chrome2){
        ArrayList<ChromosomeGA> children = new ArrayList<>();
        ChromosomeGA c1 = new ChromosomeGA(this, gaUtils);
        ChromosomeGA c2 = new ChromosomeGA(chrome2, gaUtils);
        for(int i=0; i<genes.length; i++){
            if(Math.random() > 0.5){
                c1.genes[i] = chrome2.genes[i];
                c2.genes[i] = this.genes[i];
            }
        }
        children.add(c1);
        children.add(c2);
        return children;
    } 
    

    @Override
    public int compareTo(Chromosome t) {
        if(this.getFitnessValue() <= t.getFitnessValue()){
            return -1;
        }
        return 1;
    }
   
}
