/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.Binary;

import SparkEA.SparkGA.BinaryRepresentation.BinaryChromosome;
import java.util.ArrayList;

/**
 *
 * @author anshal
 */
public class Solver extends SparkEA.SparkGA.BinaryRepresentation.Solver {

    @Override
    public BinaryChromosome solver(ArrayList<BinaryChromosome> population) {
        
        int popSize = population.size();
        BinaryChromosome best = population.get(0);
        for(int i=0; i<1000; i++){
            
            BinaryChromosome tmp = SparkEA.SparkGA.BinaryRepresentation.Worker.getFittest(population);
           
            if(tmp.getFitnessValue() > best.getFitnessValue()){
                best = tmp;
            }
            for(int j=0; j<popSize; j++){
                population.get(j).mutate();
            }
            ArrayList<BinaryChromosome> parents = SparkEA.SparkGA.BinaryRepresentation.ParentSlection.RouletteWheelSelection(population, popSize);
            ArrayList<BinaryChromosome> offSpring = new ArrayList<>();
            for(int j=0; j<parents.size()-1; j+=2){
                offSpring.addAll(parents.get(j).uniformCrossover(parents.get(j+1)));
            }
            
            population = SparkEA.SparkGA.BinaryRepresentation.SurvivorSelection.RouletteWheelSelection(population, offSpring);
            
        }
        BinaryChromosome tmp = SparkEA.SparkGA.BinaryRepresentation.Worker.getFittest(population);
        if(tmp.getFitnessValue() > best.getFitnessValue()){
            best = tmp;
        }
        best.print();
        return best;
    }
    
}
