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
    
    private Gene[] genes;
    
    public ChromosomeGA(int size){
        genes = new GeneGA[size];
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

    @Override
    public void setGene(int index, Gene gene) {
        
    }
    
   
}
