/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author anshal
 */
public class Worker implements Serializable{

   
    ArrayList<ChromosomeGA> population;
    Solver solve;
    
    
    public Worker(Solver solve, SParkGAAccessory access, int populationSize, int chromosomeLength){
        population = new ArrayList<>();
        for(int i=0; i<populationSize; i++){
            ChromosomeGA ind = new ChromosomeGA(chromosomeLength, access);
            population.add(ind);
        }
        this.solve = solve;
    }
    
    public Worker(Solver solve, ArrayList<ChromosomeGA> pop){
        population = new ArrayList<>();
        System.out.println(pop.size()+"::::::");
        for(int i=0; i<pop.size(); i++){
            this.population.add(pop.get(i));
        }
        System.out.println(this.population.size()+"XXXXX");
        this.solve = solve;
    }
    
    public ChromosomeGA Solver(){
        return solve.solver(population);
    }
    
    
    
    public List<Worker> fork(int slices){
        System.out.println("I am forking bitch");
        List<Worker> list = new ArrayList<>(slices);
        for(int i=0; i<slices-1; i++){
            Worker work = clone();
            
            list.add(work);
        }
        list.add(this);
        return list;
    }
    
    public Worker clone(){
        ArrayList<ChromosomeGA> clonePopulation = new ArrayList<>();
        for(int i=0; i<population.size(); i++){
            System.out.println("Cloning bitch...");
            ChromosomeGA ind = new ChromosomeGA(population.get(i));
            clonePopulation.add(ind);
        }
        
        Solver nSolve = solve.clone();
        
        Worker work=new Worker(nSolve, clonePopulation);
        System.out.println(work.population.size()+"CCCC");
        return work;
    }
    public static ChromosomeGA getFittest(List<ChromosomeGA> population){
        if(population.size()==0)
            return null;
        ChromosomeGA best = population.get(0);
        double maxFitness = population.get(0).getFitnessValue();
        for(int i=1; i<population.size(); i++){
            if(maxFitness < population.get(i).getFitnessValue()){
                maxFitness = population.get(i).getFitnessValue();
                best = population.get(i);
            }
        }
        return best;
        
    }
    
    public ChromosomeGA getFittest(){
       if(population.isEmpty())
           return null;
       ChromosomeGA best = population.get(0);
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
