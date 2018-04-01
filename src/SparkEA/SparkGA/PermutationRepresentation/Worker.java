/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.PermutationRepresentation;

import SparkEA.Accessories;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public class Worker implements Serializable{
    ArrayList<PermutationChromosome> population;
    Solver solve;
    
    public Worker(Solver solve, Accessories access, int populationSize, int[] iniPermutation){
        population = new ArrayList<>();
        for(int i=0; i<populationSize; i++){
            PermutationChromosome ind = new PermutationChromosome(access, iniPermutation);
            ind.rearrange();
            population.add(ind);
        }
        this.solve = solve;
    }
    
    
    public Worker(Solver solve, ArrayList<PermutationChromosome> pop){
        population = new ArrayList<>();
        System.out.println(pop.size()+"::::::");
        for(int i=0; i<pop.size(); i++){
            this.population.add(pop.get(i));
        }
        System.out.println(this.population.size()+"XXXXX");
        this.solve = solve;
    }
    
    public PermutationChromosome Solver(){
        return solve.solver(population);
    }
    
    
    
    public List<Worker> fork(int slices){
        System.out.println("I am forking bitch");
        List<Worker> list = new ArrayList<>();
        for(int i=0; i<slices-1; i++){
            Worker work = clone();
            
            list.add(work);
        }
        list.add(this);
        return list;
    }
    
    public Worker clone(){
        ArrayList<PermutationChromosome> clonePopulation = new ArrayList<>();
        for(int i=0; i<population.size(); i++){
            System.out.println("Cloning bitch...");
            PermutationChromosome ind = new PermutationChromosome(population.get(i));
            clonePopulation.add(ind);
        }
        
        Solver nSolve = solve.clone();
        
        Worker work=new Worker(nSolve, clonePopulation);
        System.out.println(work.population.size()+"CCCC");
        return work;
    }
    
    public static PermutationChromosome getFittest(List<PermutationChromosome> population){
        if(population.size()==0)
            return null;
        PermutationChromosome best = population.get(0);
        double maxFitness = population.get(0).getFitnessValue();
        for(int i=1; i<population.size(); i++){
            if(maxFitness < population.get(i).getFitnessValue()){
                maxFitness = population.get(i).getFitnessValue();
                best = population.get(i);
            }
        }
        return best;
        
    }
    
    public PermutationChromosome getFittest(){
       if(population.isEmpty())
           return null;
       PermutationChromosome best = population.get(0);
       double maxFitness = population.get(0).getFitnessValue();
       for(int i=1; i<population.size(); i++){
           if(maxFitness < population.get(i).getFitnessValue()){
               maxFitness = population.get(i).getFitnessValue();
               best = population.get(i);
           }
       }
       return best;

   }
    
}
