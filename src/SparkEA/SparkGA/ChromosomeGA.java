/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

import SparkEA.Gene;

/**
 *
 * @author anshal
 */
public class ChromosomeGA implements SparkEA.Chromosome{
    
    private GeneGA[] genes;
    private double mutationProb;
    
    public ChromosomeGA(int size){
        genes = new GeneGA[size];
        for(int i=0; i<size; i++){
            genes[i].setRandom();
        }
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
        return 0;
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
    
    public void crossOver(){
        
    }
   
}
