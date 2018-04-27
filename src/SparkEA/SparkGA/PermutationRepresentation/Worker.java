/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.PermutationRepresentation;

import SparkEA.Work;
import SparkEA.Accessories;
import SparkEA.Chromosome;
import SparkEA.Params;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public class Worker implements Serializable,Work{
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
        for(int i=0; i<pop.size(); i++){
            this.population.add(pop.get(i));
        }
        this.solve = solve;
    }
    
    @Override
    public Chromosome solver(){
        return (Chromosome)solve.solver(population);
    }
    
    
    
    public List<Work> fork(int slices){
        List<Work> list = new ArrayList<>();
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
            PermutationChromosome ind = new PermutationChromosome(population.get(i));
            clonePopulation.add(ind);
        }
        
        Solver nSolve = solve.clone();
        
        Worker work=new Worker(nSolve, clonePopulation);
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

    @Override
    public List<Work> fork(int slices, ArrayList<Params> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Chromosome getPopulation(int index){
        return population.get(index);
    }
}
