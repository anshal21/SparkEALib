/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.Permutation;

import SparkEA.SparkGA.PermutationRepresentation.PermutationChromosome;
import java.util.ArrayList;


/**
 *
 * @author anshal
 */
public class Solver extends SparkEA.SparkGA.PermutationRepresentation.Solver{
     public  PermutationChromosome solver(ArrayList<PermutationChromosome> population){
        
        int popSize = population.size();
        PermutationChromosome best = population.get(0);
        for(int i=0; i<1000; i++){
            
            
            PermutationChromosome tmp = SparkEA.SparkGA.PermutationRepresentation.Worker.getFittest(population);
            System.out.println("Best chromosome in iteration: " + tmp.getFitnessValue());
            if(tmp.getFitnessValue() > best.getFitnessValue()){
                best = tmp;
            }
            ArrayList<PermutationChromosome> ancestors = new ArrayList<>();
            for(int j=0; j<popSize; j++){
                ancestors.add(new PermutationChromosome(population.get(j)));
            }
            for(int j=0; j<popSize; j++){
                population.get(j).swapMutation();
            }
            ArrayList<PermutationChromosome> parents = SparkEA.SparkGA.PermutationRepresentation.ParentSelection.RouletteWheelSelection(population, popSize);
            ArrayList<PermutationChromosome> offSpring = new ArrayList<>();
            for(int j=0; j<parents.size()-1; j+=2){
                offSpring.addAll(parents.get(j).PMX(parents.get(j+1)));
            }
            
            population = SparkEA.SparkGA.PermutationRepresentation.SurvivorSelection.RouletteWheelSelection(population, offSpring);
            
        }
        PermutationChromosome tmp = SparkEA.SparkGA.PermutationRepresentation.Worker.getFittest(population);
        if(tmp.getFitnessValue() > best.getFitnessValue()){
            best = tmp;
        }
        best.print();
        return best;
         
     }
    
    
}
