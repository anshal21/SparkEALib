/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import SparkEA.Accessories;
import SparkEA.Chromosome;
import SparkEA.Gene;
import SparkEA.Params;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal
 */
public class BinaryChromosome extends SparkEA.Chromosome{
    
    private BinaryGene[] genes;
    private Accessories access;
    public Parameters params;
    
    public BinaryChromosome(int size, Accessories sp) {
        params = new Parameters();
        genes = new BinaryGene[size];
        for(int i=0; i<size; i++){
            genes[i] = new BinaryGene();
            genes[i].setRandom();
        }
        this.access = (Accessories)sp.clone();
    }
    public BinaryChromosome(BinaryChromosome c){
        genes = new BinaryGene[c.getLength()];
        for(int i=0; i<genes.length; i++){
            genes[i] = c.genes[i].clone();
        }
        this.access = (Accessories)c.access.clone();
        this.params = (Parameters)c.params.clone();
        
    }
     public BinaryChromosome(BinaryChromosome c, Params p){
        genes = new BinaryGene[c.getLength()];
        for(int i=0; i<genes.length; i++){
            genes[i] = c.genes[i].clone();
        }
        this.access = (Accessories)c.access.clone();
        this.params = (Parameters)p.clone();
        
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
            genes[i].setRandom(params.getMutationProbability());
        }
    }
    
    public ArrayList<BinaryChromosome> uniformCrossover(BinaryChromosome chrome2){
        ArrayList<BinaryChromosome> children = new ArrayList<>();
        BinaryChromosome c1 = new BinaryChromosome(this);
        BinaryChromosome c2 = new BinaryChromosome(chrome2);
        for(int i=0; i<genes.length; i++){
            if(Math.random() <= params.getUniformCrossoverProbability()){
                BinaryGene tmp = c1.genes[i]; 
                c1.genes[i] = c2.genes[i];
                c2.genes[i] = tmp;
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
    
    public static BinaryChromosome combine(BinaryChromosome c1, BinaryChromosome c2){
        return ((c1.getFitnessValue() > c2.getFitnessValue())?c1:c2);
    }
   
    public Chromosome merge(Chromosome c1, Chromosome c2){
        return ((c1.getFitnessValue() > c2.getFitnessValue())?c1:c2);
    }

    @Override
    public Params getParams() {
        return params;
    }
    
}
