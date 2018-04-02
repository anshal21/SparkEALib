/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.PermutationRepresentation;

import SparkEA.Accessories;
import SparkEA.Chromosome;
import SparkEA.Gene;
import SparkEA.Utility;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author anshal
 */
public class PermutationChromosome extends Chromosome{
   
    private PermutationGene genes[];
    private Accessories access;
    
    public PermutationChromosome(Accessories accessories, int[] permutation){
        genes = new PermutationGene[permutation.length];
        for(int i=0; i<permutation.length; i++){
            genes[i] = new PermutationGene(permutation[i]);            
        }
        access = (Accessories)accessories.clone();
    }
    
    public PermutationChromosome(PermutationChromosome c){
        genes = new PermutationGene[c.getLength()];
        for(int i=0; i<genes.length; i++){
            genes[i] = c.genes[i].clone();
        }
        this.access = c.access.clone();
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
    
    public void rearrange(){
        for(int i=genes.length-1; i>0; i--){
            int index = Utility.getRandomInt(i);
            PermutationGene tmp = genes[index];
            genes[index] = genes[i];
            genes[i] = tmp;
        }
    }
    
    public void swapMutation(){
        int index1 = Utility.getRandomInt(this.getLength()-1);
        int index2 = Utility.getRandomInt(this.getLength()-1);
        PermutationGene tmp = genes[index1];
        genes[index1] = genes[index2];
        genes[index2] = tmp;
    }
    
    public void scramblePermutation(){
        int index1 = Utility.getRandomInt(this.getLength()-1);
        int index2 = Utility.getRandomInt(this.getLength()-1);
        if(index2 < index1){
            int tmp = index1;
            index1 = index2;
            index2 = tmp;
        }
        for(int i=index2; i>=index1; i--){
            int randIndex = Utility.getRandomInt(index1, index2);
            PermutationGene tmp = genes[randIndex];
            genes[randIndex] = genes[i];
            genes[i] = tmp;
        }
    }
    
    public void inversionMutation(){
        int index1 = Utility.getRandomInt(this.getLength()-1);
        int index2 = Utility.getRandomInt(this.getLength()-1);
        if(index2 < index1){
            int tmp = index1;
            index1 = index2;
            index2 = tmp;
        }
        int i = index1, j = index2;
        while(i<j){
            PermutationGene tmp = genes[i];
            genes[i] = genes[j];
            genes[j] = tmp;
            i++;j--;
        }
    }
    
    public ArrayList<PermutationChromosome> PMX(PermutationChromosome mate){
        int index1 = Utility.getRandomInt(this.getLength()-1);
        int index2 = Utility.getRandomInt(this.getLength()-1);
        if(index2 < index1){
            int tmp = index1;
            index1 = index2;
            index2 = tmp;
        }
        PermutationChromosome c1 = PMXCore(this, mate, index1, index2);
        PermutationChromosome c2 = PMXCore(mate, this, index1, index2);
        
        ArrayList<PermutationChromosome> arr = new ArrayList<>();
        arr.add(c1);arr.add(c2);
        System.out.println(index1 + " " + index2);
        return arr;
        
        
        
        
        
    }
    
    private PermutationChromosome PMXCore(PermutationChromosome mate1, PermutationChromosome mate2, int index1, int index2){
        PermutationChromosome c1 = new PermutationChromosome(mate1);
         boolean isFilled[] = new boolean[getLength()];
        HashMap<Integer,Integer> valueToIndex = new HashMap<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i=0; i<genes.length; i++){
            int val = (int)mate2.getGene(i).getGeneValue();
            hash.put((int)mate1.genes[i].getGeneValue(), 0);
            valueToIndex. put(val, i);
        }
        
        for(int i=index1; i<=index2; i++){
            isFilled[i] = true;
            hash.put((int)mate1.genes[i].getGeneValue(), 1);
        }
        
        for(int i=index1; i<=index2; i++){
            if(hash.get((int)mate2.getGene(i).getGeneValue())==1){
                continue;
            }
            PermutationGene tmp = ((PermutationGene)mate2.getGene(i)).clone();
            int tmpIndex = i;
            while(true){
                if(isFilled[tmpIndex]){
                    tmpIndex = valueToIndex.get((int)c1.getGene(tmpIndex).getGeneValue());
                }
                else{
                    isFilled[tmpIndex] = true;
                    hash.put((int)tmp.getGeneValue(),1);
                    c1.genes[tmpIndex] = tmp;
                    break;
                }
            }
        }
        
        for(int i=0; i<genes.length; i++){
            if(!isFilled[i]){
                c1.genes[i] = mate2.genes[i].clone();
            }
        }
        return c1;
    }
    
    public static PermutationChromosome combine(PermutationChromosome c1, PermutationChromosome c2){
        return ((c1.getFitnessValue() > c2.getFitnessValue())?c1:c2);
    }

    public Chromosome merge(Chromosome c1, Chromosome c2){
        return ((c1.getFitnessValue() > c2.getFitnessValue())?c1:c2);
    }
    
    
}
