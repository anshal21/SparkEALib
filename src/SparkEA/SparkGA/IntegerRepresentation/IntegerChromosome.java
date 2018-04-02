/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.IntegerRepresentation;

import SparkEA.Accessories;
import SparkEA.Chromosome;
import SparkEA.Gene;
import SparkEA.Utility;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class IntegerChromosome extends Chromosome{
    private IntegerGene genes[];
    private Accessories access;
    private Parameters params;
    
    
    public IntegerChromosome(int size, Accessories accessories){
        params = new Parameters();
        genes = new IntegerGene[size];
        for(int i=0; i<size; i++){
            genes[i] = new IntegerGene();   
        }
        this.access = (Accessories)accessories.clone();
    }
    
    public IntegerChromosome(int size, Accessories accessories, int geneLowerLimit, int geneUpperLimit){
        params = new Parameters();
        genes = new IntegerGene[size];
        for(int i=0; i<size; i++){
            genes[i] = new IntegerGene(geneLowerLimit, geneUpperLimit);
        }
        this.access = (Accessories)accessories.clone();
        
    }
    
    public IntegerChromosome(IntegerChromosome c){
        genes = new IntegerGene[c.getLength()];
        for(int i=0; i<genes.length; i++){
            genes[i] = c.genes[i].clone();
        }
        this.access = c.access.clone();
        this.params = (Parameters)c.params.clone();
    }
    
    @Override
    public void print() {
        System.out.print("[ ");
        for(int i=0; i<genes.length; i++){
            System.out.print((int)genes[i].getGeneValue() + " ");
        }
        System.out.println("]");
    }
    
    @Override
    public double getFitnessValue() {
        return access.fitnessFunction(this);
    }

    @Override
    public Gene getRandomGene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gene getGene(int index) {
        return genes[index];
    }

    @Override
    public int getLength() {
       return genes.length; 
    }

    @Override
    public int compareTo(Chromosome t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void RandomResetting(){
        for(int i=0; i<genes.length; i++){
            double prob = Utility.RandomProbability();
            if(prob <= params.getRandomResettingProbability())
                genes[i].setRandom();
        }
    }
    
    public ArrayList<IntegerChromosome> uniformCrossover(IntegerChromosome chrome2){
        ArrayList<IntegerChromosome> children = new ArrayList<>();
        IntegerChromosome c1 = new IntegerChromosome(this);
        IntegerChromosome c2 = new IntegerChromosome(chrome2);
        for(int i=0; i<genes.length; i++){
            if(Utility.RandomProbability() <= params.getCrossoverProbability()){
                IntegerGene tmp = c1.genes[i]; 
                c1.genes[i] = c2.genes[i];
                c2.genes[i] = tmp;
            }
        }
        children.add(c1);
        children.add(c2);
        return children;
    }
    
    public static IntegerChromosome combine(IntegerChromosome c1, IntegerChromosome c2){
        return ((c1.getFitnessValue() > c2.getFitnessValue())?c1:c2);
    }
    
}
