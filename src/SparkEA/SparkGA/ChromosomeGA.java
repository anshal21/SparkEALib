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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class ChromosomeGA implements SparkEA.Chromosome{
    
    private GeneGA[] genes;
    private double mutationProb;
    private SParkGAAccessory access;
    public ChromosomeGA(int size, SParkGAAccessory sp) {
        try {
            genes = new GeneGA[size];
            for(int i=0; i<size; i++){
                genes[i] = new GeneGA();
                genes[i].setRandom();
            }
            this.access = (SParkGAAccessory)sp.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ChromosomeGA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ChromosomeGA(ChromosomeGA c){
        try {
            genes = new GeneGA[c.genes.length];
            for(int i=0; i<genes.length; i++){
                genes[i] = new GeneGA();
                genes[i].setGeneValue(c.genes[i].geneValue);
            }
            this.access = (SParkGAAccessory)c.access.clone();
            setMutationProbability(c.getMutationProbability());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ChromosomeGA.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.print("[");
        for(int i=0; i<genes.length; i++){
            System.out.print((int)genes[i].getGeneValue() + " ");
        }
        System.out.println("]");
    }
    
    @Override
    public int getLength(){
        return genes.length;
    }
    
    @Override
    public double getFitnessValue() {
        return access.fitnessFunction(this);
    }

    @Override
    public Gene getRandomGene() {
        return null;
    }

    @Override
    public Gene getGene(int index) {
        return genes[index];
    }


    public void setGene(int index, int value) {
        this.genes[index].setGeneValue(value);
    }
    
    public void mutate(){
        for(int i=0; i<genes.length; i++){
            genes[i].setRandom(this.mutationProb);
        }
    }
    
    public ArrayList<ChromosomeGA> uniformCrossover(ChromosomeGA chrome2){
        ArrayList<ChromosomeGA> children = new ArrayList<>();
        ChromosomeGA c1 = new ChromosomeGA(this);
        ChromosomeGA c2 = new ChromosomeGA(chrome2);
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
